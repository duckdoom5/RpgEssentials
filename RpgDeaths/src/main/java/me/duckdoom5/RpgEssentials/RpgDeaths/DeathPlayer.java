package me.duckdoom5.RpgEssentials.RpgDeaths;

import me.duckdoom5.RpgEssentials.RpgDeaths.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgDeaths.Listeners.BlockListener;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.Widget;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class DeathPlayer {
	private Material old;
	private String playername;
	private RpgDeaths plugin;
	
	private Location droplocation;
	private Location droplocation2;
	private static BlockFace[] faces = { BlockFace.NORTH, BlockFace.SOUTH, BlockFace.EAST, BlockFace.WEST };
	
	private int timeleft;
	private Widget timerwidget;
	private int updateT;
	private int removeProtectionT;
	
	public DeathPlayer(String playername, RpgDeaths plugin) {
		this.playername = playername;
		this.plugin = plugin;
		
		DeathChests.deathplayers.put(playername, this);
		
		place();
	}
	
	
	private void place(){
		Player player = plugin.getServer().getPlayer(playername);
		//make sure to place the chest on the ground
		int x = player.getLocation().getBlockX();
		int y;
		int z = player.getLocation().getBlockZ();
		for (y = player.getLocation().getBlockY(); player.getWorld().getBlockAt(x,y,z).getType() == Material.AIR; --y);
		
		//place the chest
		droplocation = new Location(player.getWorld(), x, y + 1, z);
		droplocation.getBlock().setType(Material.CHEST);
		
		BlockListener.protect.put(droplocation, playername);
		
		Location temp = null;
		//place the second chest
    	for(BlockFace face : faces){
			if(droplocation.getBlock().getRelative(face).getType().equals(Material.AIR)){
				old = droplocation.getBlock().getRelative(BlockFace.NORTH).getType();
				temp = droplocation.getBlock().getRelative(face).getLocation();
			}
    	}
    	if(temp == null){
    		//There is no place for another chest, (place it in a wall for now)
    		old = droplocation.getBlock().getRelative(BlockFace.NORTH).getType();
    		temp = droplocation.getBlock().getRelative(BlockFace.NORTH).getLocation();
    	}
    	
    	droplocation2 = temp;
        
    	droplocation2.getBlock().setType(Material.CHEST);
    	BlockListener.protect.put(droplocation2, playername);
    	
    	fill();
	}
	
	private void fill(){
		Player player = plugin.getServer().getPlayer(playername);
		Chest c = (Chest) droplocation.getBlock().getState();
		DoubleChestInventory chest = (DoubleChestInventory) c.getInventory();
		
		ItemStack[] toadd = player.getInventory().getContents();
    	ItemStack[] armour = player.getInventory().getArmorContents();
    	
    	for(int i = 0; i < toadd.length; i++){
    		if(toadd[i] != null){
    			chest.setItem(i, toadd[i]);
    		}
    	}
    	
    	
		for(int i = 0; i < armour.length; i++){
    		if(armour[i] != null){
    			chest.addItem(armour[i]);
    		}
    	}
    	
    	c.update(true);
    	
    	startTimer();
	}
	
	public void removeChest(){
		Player player = plugin.getServer().getPlayer(playername);
		SpoutPlayer splayer = SpoutManager.getPlayer(player);
		plugin.getServer().getScheduler().cancelTask(updateT);
		plugin.getServer().getScheduler().cancelTask(removeProtectionT);
		Chest c = (Chest)droplocation.getBlock().getState();
    	DoubleChestInventory chest = (DoubleChestInventory) c.getInventory();
    	
    	chest.clear();
    	
    	droplocation.getBlock().setType(Material.AIR);
    	droplocation2.getBlock().setType(old);
    	
    	BlockListener.protect.remove(droplocation);
    	BlockListener.protect.remove(droplocation2);
    	
    	splayer.getMainScreen().removeWidget(timerwidget);
    	timeleft = 0;
    	
    	player.sendMessage(ChatColor.RED + "Your chest has disappeared!");
	}
	
	private void removeProtection(){
		Player player = plugin.getServer().getPlayer(playername);
		BlockListener.protect.remove(droplocation);
		BlockListener.protect.remove(droplocation2);
    	player.sendMessage(ChatColor.RED + "Your chest is no longer protected!");
	}
	
	private void startTimer(){
		final Player player = plugin.getServer().getPlayer(playername);
		SpoutPlayer splayer = SpoutManager.getPlayer(player);
		int protecttime = Configuration.config.getInt("deathchest.protect time in minutes");
		int unprotecttime = Configuration.config.getInt("deathchest.unprotect time in minutes");
		
		Long protime = (long) ((protecttime * 60) * 20);
		Long unprotime = (long) ((unprotecttime * 60) * 20);
		Long totaltime = protime + unprotime;
		
		int protimeleft = protecttime * 60;
		int unprotimeleft = unprotecttime * 60;
		int totaltimeleft = protimeleft + unprotimeleft;
		
		timeleft = totaltimeleft;
		
		//update timer
		updateT = plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
		    public void run() {
		    	if(timeleft <= 0){
		    		timeleft= 0;
		    	}else{
		    		timeleft--;
		    	}
		    	updateTimer();
		    }
		}, 20L, 20L);
		
		//remove protection
		removeProtectionT = plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
		    public void run() {
		    	removeProtection();
		    }
		}, protime);
	}
	
	private void updateTimer(){
		Player player = plugin.getServer().getPlayer(playername);
		SpoutPlayer splayer = SpoutManager.getPlayer(player);
		int time = timeleft;
		
		int min = time / 60;
		int sec = time % 60;
		
    	if(time == 0){
    		sec = 0;
    	}
		
		if(min == 0 && sec == 0){
			removeTimer();
		}
		
		int protecttime = Configuration.config.getInt("deathchest.protect time in minutes");
		
		if(timerwidget == null){
			timerwidget = new GenericLabel("Time left: " + min + ":" + sec).setTextColor(new Color(1.0F, 1.0F, 0, 1.0F)).setHeight(10).setWidth(20).setAnchor(WidgetAnchor.TOP_RIGHT).shiftXPos(-75).shiftYPos(+10);
		}else{
			if(min < protecttime){
				if(sec < 10){
					((GenericLabel) timerwidget).setText("Time left: " + min + ":0" + sec).setTextColor(new Color(1.0F, 0, 0, 1.0F));
				}else{
					((GenericLabel) timerwidget).setText("Time left: " + min + ":" + sec).setTextColor(new Color(1.0F, 0, 0, 1.0F));
				}
			}else{
				if(sec < 10){
					((GenericLabel) timerwidget).setText("Time left: " + min + ":0" + sec);
				}else{
					((GenericLabel) timerwidget).setText("Time left: " + min + ":" + sec);
				}
			}
		}
		
		splayer.getMainScreen().attachWidget(plugin, timerwidget);
	}
	
	private void removeTimer(){
		Player player = plugin.getServer().getPlayer(playername);
    	removeChest();
    }
}
