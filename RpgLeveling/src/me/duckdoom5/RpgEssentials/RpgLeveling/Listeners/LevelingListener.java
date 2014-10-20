package me.duckdoom5.RpgEssentials.RpgLeveling.Listeners;

import me.duckdoom5.RpgEssentials.RpgLeveling.RpgLeveling;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevelManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Events.PlayerExpGainEvent;
import me.duckdoom5.RpgEssentials.RpgLeveling.Events.PlayerFireBoltEvent;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Skill;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.SkillType;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.massivecraft.factions.listeners.FactionsListenerMain;
import com.massivecraft.mcore.ps.PS;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.flags.DefaultFlag;

public class LevelingListener implements Listener {
    private RpgLeveling plugin;
    private boolean factionsEnabled, wgEnabled;
    private final WorldGuardPlugin worldguard;
    
    public LevelingListener(RpgLeveling rpgLeveling) {
        plugin = rpgLeveling;
        factionsEnabled = Bukkit.getPluginManager().isPluginEnabled(Bukkit.getPluginManager().getPlugin("Factions"));
        wgEnabled = Bukkit.getPluginManager().isPluginEnabled(Bukkit.getPluginManager().getPlugin("WorldGuard"));
        if(wgEnabled){
            worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
        }else{
            worldguard = null;
        }
    }

    @EventHandler (priority = EventPriority.LOWEST)
    public void onPlayerExpGain(PlayerExpGainEvent event) {
        if (event.isCancelled()) {
            return;
        }
        final Player player = event.getPlayer();
        boolean god = false, pvp, build = true, bbreak = true;
        
        if(wgEnabled){
            god = worldguard.getGlobalStateManager().hasGodMode(player);
            pvp = worldguard.getRegionManager(player.getWorld()).getApplicableRegions(player.getLocation()).allows(DefaultFlag.PVP);
            build = worldguard.canBuild(player, player.getLocation());
        } else {
            pvp = player.getWorld().getPVP();
        }

        if (factionsEnabled) {
            if (!FactionsListenerMain.canPlayerBuildAt(event.getPlayer(), PS.valueOf(player.getLocation()), false)) {
                build = false;
                bbreak = false;
            }
        }
        final SkillType skill = event.getSkill();

        if (Configuration.level.getBoolean("Survival Gamemode Required")) {
            if (player.getGameMode().equals(GameMode.SURVIVAL)) {
                if (canGainExp(skill, god, pvp, build, bbreak)) {
                    final int exp = event.getExp();
                    Skill.addexp(plugin, RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(player.getName()), exp, skill);
                }
            }
        } else if (canGainExp(event.getSkill(), god, pvp, build, bbreak)) {
            final int exp = event.getExp();
            Skill.addexp(plugin, RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(player.getName()), exp, skill);
        }

    }

    public boolean canGainExp(SkillType skill, boolean god, boolean pvp, boolean build, boolean bbreak) {
        if ((skill.equals(SkillType.ATTACK) || skill.equals(SkillType.DEFENSE) || skill.equals(SkillType.RANGED)) && !god && pvp) {
            return true;
        } else if ((skill.equals(SkillType.CONSTRUCTION) || skill.equals(SkillType.FIREMAKING)) && build) {
            return true;
        } else if (skill.equals(SkillType.FARMING) && build && bbreak) {
            return true;
        } else if ((skill.equals(SkillType.EXCAVATION) || skill.equals(SkillType.MINING) || skill.equals(SkillType.WOODCUTTING)) && bbreak) {
            return true;
        } else if ((skill.equals(SkillType.COOKING) || skill.equals(SkillType.SMITHING))) {
            return true;
        }
        return false;
    }

    @EventHandler
    public void onPlayerFireBolt(PlayerFireBoltEvent event) {
        final Player player = event.getPlayer();
        final String bolt = event.getBoltType();
        final int exp = me.duckdoom5.RpgEssentials.config.Configuration.items.getInt("Custom Item." + bolt + ".xp");
        final PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, SkillType.RANGED, exp);
        Bukkit.getServer().getPluginManager().callEvent(callevent);
    }
}
