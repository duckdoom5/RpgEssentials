package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import java.util.Iterator;
import java.util.List;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevel;

import org.bukkit.Material;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Ranged extends Skill {
    public static Ranged instance;
    
    static {
        instance = new Ranged();
    }
    
    public boolean canUse(RpgPlayerLevel player, String crossbow) {
        if (crossbow != null && isEnabled(SkillType.RANGED)) {
            final int currentlvl = player.getLvl(SkillType.RANGED);
            final int level = me.duckdoom5.RpgEssentials.config.Configuration.items.getInt("Custom Tools." + crossbow + ".level");
            if (currentlvl < level) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static String[] getRequiredBolts(String crossbow) {
        if (me.duckdoom5.RpgEssentials.config.Configuration.items.contains("Custom Tools." + crossbow + ".required bolts")) {
            final String[] bolts = new String[50];
            final List<?> list = me.duckdoom5.RpgEssentials.config.Configuration.items.getList("Custom Tools." + crossbow + ".required bolts");
            final Iterator<?> keys = list.iterator();
            int i = 0;
            while (keys.hasNext()) {
                bolts[i] = keys.next().toString();
                i = i + 1;
            }
            return bolts;
        }
        RpgEssentials.getLog().warning("ERROR: " + crossbow + " has no required bolts!");
        return null;
    }

    @SuppressWarnings ("unused")
    private static boolean hasRequiredBolt(SpoutPlayer player, String bolt) {
        // for(ItemStack item:player.getInventory().getContents()){
        // if(item.getDurability() ==
        // RpgeManager.getInstance().getMaterialManager().custombolts.get(bolt).getCustomId()){
        // return true;
        // }
        // }
        return false;
    }

    public static String getBestBolt(SpoutPlayer player, String[] bolts) {
        int prevdamage = 0;
        String boltname = null;
        for (final String bolt : bolts) {
            final int newdamage = me.duckdoom5.RpgEssentials.config.Configuration.items.getInt("Custom Item." + bolt + ".damage");
            if (prevdamage < newdamage) {
                if (hasRequiredBolt(player, bolt)) {
                    prevdamage = newdamage;
                    boltname = bolt;
                }
            }
        }

        return boltname;
    }

    @SuppressWarnings ("unused")
    public static String getCrossbow(SpoutPlayer player) {
        // ItemStack inHand = player.getItemInHand();
        /*
         * for(GenericCustomTool crossbow :MaterialManager.customcrossbows){
         * if(inHand.getDurability() == crossbow.getCustomId()){ return
         * crossbow.getName(); } }
         */
        return null;
    }

    @Override
    public Material getIcon() {
        return Material.BOW;
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.RANGED;
    }
}
