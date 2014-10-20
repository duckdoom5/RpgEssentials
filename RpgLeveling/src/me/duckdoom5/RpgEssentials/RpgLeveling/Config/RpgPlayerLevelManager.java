package me.duckdoom5.RpgEssentials.RpgLeveling.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.RpgLeveling;
import me.duckdoom5.RpgEssentials.config.Configuration;

public class RpgPlayerLevelManager {
    private final HashMap<String, RpgPlayerLevel> rpgpls = new LinkedHashMap<>();
    private static RpgPlayerLevelManager instance;

    public static RpgPlayerLevelManager getInstance() {
        if (instance == null) {
            instance = new RpgPlayerLevelManager();
        }
        return instance;
    }

    public void loadRpgPlayerLevels() {
        final File dir = new File("plugins/RpgLeveling/Temp/Players");
        final String[] names = dir.list();
        if (names != null) {
            for (final String name : names) {
                try {
                    final RpgPlayerLevel rpgpl = (RpgPlayerLevel) Configuration.load("plugins/RpgLeveling/Temp/Players/" + name);
                    addRpgPlayerLevel(rpgpl.getRpgPlayer().getName(), rpgpl);
                } catch (final FileNotFoundException e) {
                    RpgLeveling.plugin.getLogger().warning(name + " was not found.");
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void saveRpgPlayerLevel(RpgPlayerLevel rpgpl) {
        try {
            final File file = new File("plugins/RpgLeveling/Temp/Players");
            if (!file.exists()) {
                file.mkdirs();
            }
            Configuration.save(rpgpl, "plugins/RpgLeveling/Temp/Players/" + rpgpl.getRpgPlayer().getName() + ".lvl");
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public void saveRpgPlayerLevels() {
        for (final RpgPlayerLevel rpgpl : rpgpls.values()) {
            saveRpgPlayerLevel(rpgpl);
        }
    }

    public void deleteRpgPlayerLevels(String playername) {
        rpgpls.remove(playername);
    }

    public RpgPlayerLevel getRpgPlayerLevel(String playername) {
        if (rpgpls.get(playername) == null) {
            rpgpls.put(playername, new RpgPlayerLevel(RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(playername)));
        }
        return rpgpls.get(playername);
    }

    public void addRpgPlayerLevel(String name, RpgPlayerLevel rpgpl) {
        rpgpls.put(name, rpgpl);
    }
}
