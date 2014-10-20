package me.duckdoom5.RpgEssentials.handelers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Music {
    public static HashMap<SpoutPlayer, Boolean> music = new LinkedHashMap<>();
    public static HashMap<UUID, SpoutPlayer> inbattle = new LinkedHashMap<>();
    public static HashMap<SpoutPlayer, Timer> repeater = new LinkedHashMap<>();

    private static boolean isBattling(SpoutPlayer splayer) {
        if (!music.containsKey(splayer)) {
            music.put(splayer, false);
            return false;
        }
        if (music.get(splayer) == false) {
            return false;
        }
        return true;
    }

    public static void stopBattle(RpgEssentials plugin, UUID id) {
        if (inbattle.containsKey(id)) {
            final SpoutPlayer splayer = inbattle.get(id);
            SpoutManager.getSoundManager().stopMusic(splayer, false, 1000);
            inbattle.remove(id);

            plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        @Override
                        public void run() {
                            music.put(splayer, false);
                        }
                    }, 60L);
        }
    }

    public static void forceStopBattle(RpgEssentials plugin,
            final SpoutPlayer splayer) {
        SpoutManager.getSoundManager().stopMusic(splayer);
        plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        music.put(splayer, false);
                    }
                }, 60L);
    }

    public static void startBattle(RpgEssentials plugin, UUID id,
            SpoutPlayer splayer) {
        if (!Music.isBattling(splayer)) {
            inbattle.put(id, splayer);
            SpoutManager.getSoundManager().playCustomMusic(
                            plugin,
                            splayer, "http://www.dl.lynxdragon.com/rpgessentials/music/battle/11-battle.wav",
                            false);
            music.put(splayer, true);
        }
    }

    public static void stop(SpoutPlayer splayer) {
        SpoutManager.getSoundManager().stopMusic(splayer);
        if (repeater.containsKey(splayer)) {
            final Timer timer = repeater.get(splayer);
            timer.cancel();
        }
    }

    public static void start(RpgEssentials plugin, String url,
            SpoutPlayer splayer) {
        SpoutManager.getSoundManager().stopMusic(splayer);
        SpoutManager.getSoundManager().playCustomMusic(plugin, splayer, url,
                false);
    }

    public static void fadeOut(SpoutPlayer splayer, int fadeOutTime) {
        SpoutManager.getSoundManager().stopMusic(splayer, false, fadeOutTime);
        if (repeater.containsKey(splayer)) {
            final Timer timer = repeater.get(splayer);
            timer.cancel();
        }
    }

    public static void repeat(final RpgEssentials plugin, final String url,
            final SpoutPlayer splayer, int stime) {
        final long delay = 0; // delay for 3 sec.
        final long period = stime * 1000; // repeat every stime.
        final Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                start(plugin, url, splayer);
            }
        }, delay, period);

        repeater.put(splayer, timer);
    }
}
