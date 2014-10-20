package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import me.duckdoom5.RpgEssentials.RpgLeveling.RpgLeveling;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevel;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevelManager;
import me.duckdoom5.RpgEssentials.util.StringUtils;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;
import org.getspout.spoutapi.Spout;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.Widget;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.gui.WidgetAnim;
import org.getspout.spoutapi.player.SpoutPlayer;

public abstract class Skill {
    private static final double exponent = Configuration.level.getDouble("Level exponent");
    
    private static void showAnimation(RpgLeveling plugin, final SpoutPlayer splayer, int amount){
        final Widget exp = new GenericLabel("+" + Integer.toString(amount) + " exp").setTextColor(new Color(1.0F, 1.0F, 0, 1.0F)).setHeight(10).setWidth(20).setAnchor(WidgetAnchor.CENTER_CENTER).shiftXPos(-5).shiftYPos(-10).animate(WidgetAnim.POS_Y, -1F, (short) 20, (short) 2, false, false).animateStart();
        
        splayer.getMainScreen().attachWidget(plugin, exp);
                
        plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                splayer.getMainScreen().removeWidget(exp);
            }
        }, 20L);
    }
    
    private static void showLevelTag(RpgPlayerLevel levelPlayer, int combatlvl){
        final SpoutPlayer splayer = (SpoutPlayer) levelPlayer.getRpgPlayer().getPlayer();
        final SpoutPlayer[] onplayers = Spout.getServer().getOnlinePlayers();
        
        ChatColor colorme = ChatColor.YELLOW;
        ChatColor colorother = ChatColor.YELLOW;
        
        for (final SpoutPlayer on : onplayers) {
            final RpgPlayerLevel otherrpgplayer = RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(on.getName());

            final int combatlvlother = otherrpgplayer.getLvl(SkillType.COMBAT);
            if (combatlvl > combatlvlother) {
                if (combatlvl - combatlvlother <= 5) {
                    colorme = ChatColor.RED;
                    colorother = ChatColor.GREEN;
                } else {
                    colorme = ChatColor.DARK_RED;
                    colorother = ChatColor.DARK_GREEN;
                }
            } else if (combatlvl < combatlvlother) {
                if (combatlvlother - combatlvl <= 5) {
                    colorme = ChatColor.GREEN;
                    colorother = ChatColor.RED;
                } else {
                    colorme = ChatColor.DARK_GREEN;
                    colorother = ChatColor.DARK_RED;
                }
            }
            
            splayer.setTitleFor(on, colorme + "duckdoom5" + " [lvl: " + combatlvl + "]");
            on.setTitleFor(splayer, colorother + "jillatheking" + " [lvl: " + combatlvlother + "]");
        }
    }
    
    public static void addexp(RpgLeveling plugin, RpgPlayerLevel levelPlayer, int amount, SkillType skill) {
        final OfflinePlayer p = levelPlayer.getRpgPlayer().getPlayer();
        if(p.isOnline()){
            final SpoutPlayer splayer = (SpoutPlayer) p;
            showAnimation(plugin, splayer, amount);
        }
        
        int newexp = levelPlayer.getExp(skill) + amount;
        levelPlayer.setExp(skill, newexp);
        checknewlvl(levelPlayer, skill, plugin);
    }
    
    public static int getExpRequired(RpgPlayerLevel levelPlayer, SkillType skill) {
        final int currentlevel = levelPlayer.getLvl(skill);
        int xptolvl = 0;
        
        if(currentlevel < 100){
            for (int level = 0; level <= currentlevel; level++) {
                xptolvl += (int) Math.floor(Math.floor((Math.pow(2.0, (level / exponent)) * (level + 300))) / 4);
            }
        }
        return xptolvl;
    }
    
    public static int getExpLeft(RpgPlayerLevel levelPlayer, SkillType skill) {
        final int currentlevel = levelPlayer.getLvl(skill);
        int xptolvl = 0;
        
        if(currentlevel < 100){
            for (int level = 0; level <= currentlevel; level++) {
                xptolvl += (int) Math.floor(Math.floor((Math.pow(2.0, (level / exponent)) * (level + 300))) / 4);
            }
        }
        return (xptolvl - levelPlayer.getExp(skill));
    }
    
    public int getExpEarned(Material material, int amount, SkillType skill){
        if (isEnabled(skill)) {
            return Configuration.level.getInt("Exp." + skill.toString().toLowerCase() + "." + material.toString().toLowerCase().replace("_", " ")) * amount;
        }
        return 0;
    }
    
    private static void checknewlvl(RpgPlayerLevel levelPlayer, SkillType skill, RpgLeveling plugin) {        
        if (getExpLeft(levelPlayer, skill) <= 0) {
            final SpoutPlayer splayer = (SpoutPlayer) levelPlayer.getRpgPlayer().getPlayer();
            int newlevel = levelPlayer.getLvl(skill) + 1;
            SpoutManager.getSoundManager().playCustomSoundEffect(plugin, splayer, Configuration.level.getString("level-up sound"), false);
            splayer.sendNotification(StringUtils.UCFirst(skill.toString().toLowerCase()) + " level up!", "Your level is now: " + newlevel, skill.getInstance().getIcon());
            levelPlayer.setLvl(skill, newlevel);
        }
        
        checknewcombat(levelPlayer, plugin);
    }
    
    public static boolean isCombatSkill(SkillType skill){
        return (skill.equals(SkillType.ATTACK) || skill.equals(SkillType.DEFENSE) || skill.equals(SkillType.RANGED));
    }
    
    public static void checknewcombat(RpgPlayerLevel levelPlayer, RpgLeveling plugin) {
        final int att = levelPlayer.getLvl(SkillType.ATTACK);
        final int def = levelPlayer.getLvl(SkillType.DEFENSE);
        final int ran = levelPlayer.getLvl(SkillType.RANGED);
        final int mag = 1;
        final int pra = 1;
        final int con = 1;
        final int str = 1;

        final int combatlvl = (int) Math.floor(1 / 4.0 * (13 / 10.0 * (att + str + (3 / 2.0 * mag) + (3 / 2.0 * ran)) + def + con + (1 / 2.0 * pra)));
        if (levelPlayer.getLvl(SkillType.COMBAT) < combatlvl) {
            final SpoutPlayer splayer = (SpoutPlayer) levelPlayer.getRpgPlayer().getPlayer();
            SpoutManager.getSoundManager().playCustomSoundEffect(plugin, splayer, Configuration.level.getString("combat level-up sound"), false);
            splayer.sendNotification("Combat level up!", "Your level is now: " + combatlvl, Combat.instance.getIcon());
            levelPlayer.setLvl(SkillType.COMBAT, combatlvl);
            
            showLevelTag(levelPlayer, combatlvl);
        }
    }
    
    public boolean canUse(RpgPlayerLevel levelPlayer, Material toCheck, SkillType skill) {
        Player player = ((Player) levelPlayer.getRpgPlayer().getPlayer());
        
        if (player.getGameMode().equals(GameMode.SURVIVAL) && isEnabled(skill)) {
            final int currentlevel = levelPlayer.getLvl(skill);
            
            if(!this.contains(getUnlockableMaterials(), toCheck))
                return true;
            
            for(Material m : getUnlockableMaterials()){
                if(toCheck.equals(m) && currentlevel >= getUnlockLevel(skill, m)){
                    return true;
                }
            }
            
            player.sendMessage(ChatColor.RED + "You need to be level " + getUnlockLevel(skill, toCheck) + " to be able to use this item");
            player.getItemInHand().setDurability((short) (player.getItemInHand().getDurability() + 1));
            return false;
        }
        return true;
    }
    
    public abstract Material getIcon(); 
    
    public abstract SkillType getSkillType(); 
    
    public boolean hasUnlockableMaterialData(){
        return false;
    }
    
    public MaterialData[] getUnlockableMaterialData(){
        return new MaterialData[] { };
    }
    
    public Material[] getUnlockableMaterials(){
        return new Material[] { };
    }
    
    public static int getUnlockLevel(SkillType skill, Material material){
        if(isEnabled(skill)){
            return Configuration.level.getInt("UnlockLevel." + skill.toString().toLowerCase() + "." + material.toString().toLowerCase().replace("_", " "));
        }
        return 1;
    }
    
    public int getUnlockLevel(SkillType skill, MaterialData material){
        if(isEnabled(skill)){
            return Configuration.level.getInt("UnlockLevel." + skill.toString().toLowerCase() + "." + material.toString().toLowerCase().replace("_", " "));
        }
        return 1;
    }
    
    public static int getUnlockLevel(SkillType skill, org.getspout.spoutapi.material.Material material){
        if(isEnabled(skill)){
            return Configuration.level.getInt("UnlockLevel." + skill.toString().toLowerCase() + "." + material.getName());
        }
        return 1;
    }
    
    public static boolean isEnabled(SkillType type){
        return Configuration.level.getBoolean("Enabled." + type.toString());
    }
    
    public <T> boolean contains( final T[] array, final T v ) {
        for ( final T e : array )
            if ( e == v || v != null && v.equals( e ) )
                return true;

        return false;
    }
}
