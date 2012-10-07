package me.duckdoom5.RpgEssentials.customblocks;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.StorageMinecart;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.getspout.spout.block.SpoutCraftBlock;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.sound.SoundEffect;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.util.Methods;

public class LoaderRail extends Rail {
	private RpgEssentials plugin;
	public LoaderRail(RpgEssentials plugin, String name, int[] textureids) {
		super(plugin, 27, true, name, textureids);
		this.plugin = plugin;
	}
	
	@Override
	public void onEntityMoveAt(final World world, final int x, final int y, final int z, Entity entity){
		if(entity instanceof StorageMinecart){
			StorageMinecart minecart = (StorageMinecart)entity;
			final SpoutCraftBlock block = (SpoutCraftBlock) world.getBlockAt(x, y, z);
			Vector velocity = minecart.getVelocity();
			if(Configuration.tracks.getBoolean(x + "," + y + "," + z + ".waitTillFull", true)){
				if(canLoad(minecart, block)){
					load(minecart, block, velocity);
				}else{
					sendSignal(minecart, block, velocity);
					Bukkit.broadcastMessage("can't load");
				}
			}else{
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				    public void run() {
						block.setBlockPowered(true);
						SpoutManager.getSoundManager().playGlobalSoundEffect(SoundEffect.CLICK, new Location(world,x,y,z));
						
						plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
						    public void run() {
						    	block.resetBlockPower();
						    }
						}, 40L);
				    }
				}, Configuration.tracks.getInt(x + "," + y + "," + z + ".waitTime", 10) * 20);
			}
		}
	}
	private List<Chest> chests = new ArrayList<Chest>();
	
	private boolean canLoad(StorageMinecart minecart, SpoutCraftBlock block) {
		chests.clear();
		if(Methods.isInventoryFull(minecart.getInventory().getContents())){
			return false;
		}
		Block[] ba ={
			block.getRelative(0, 1, 0), //up
			block.getRelative(0, 1, 1),
			block.getRelative(0, 1, -1),
			block.getRelative(1, 1, 0),
			block.getRelative(1, 1, 1),
			block.getRelative(1, 1, -1),
			block.getRelative(-1, 1, 0),
			block.getRelative(-1, 1, 1),
			block.getRelative(-1, 1, -1),
			
			//center
			block.getRelative(0, 0, 1),
			block.getRelative(0, 0, -1),
			block.getRelative(1, 0, 0),
			block.getRelative(1, 0, 1),
			block.getRelative(1, 0, -1),
			block.getRelative(-1, 0, 0),
			block.getRelative(-1, 0, 1),
			block.getRelative(-1, 0, -1),
			
			block.getRelative(0, -1, 0), //down
			block.getRelative(0, -1, 1),
			block.getRelative(0, -1, -1),
			block.getRelative(1, -1, 0),
			block.getRelative(1, -1, 1),
			block.getRelative(1, -1, -1),
			block.getRelative(-1, -1, 0),
			block.getRelative(-1, -1, 1),
			block.getRelative(-1, -1, -1),
		};
		
		for(Block rblock: ba){
			if(rblock.getType().equals(Material.CHEST)){
				Chest chest = (Chest)rblock.getState();
				if(!Methods.isInventoryEmpty(chest.getInventory().getContents())){
					chests.add(chest);
					Bukkit.broadcastMessage("chest added");
				}
			}
		}
		if(chests.isEmpty()){
			return false;
		}
		
		return true;
	}
	
	private int count;
	
	private void load(final StorageMinecart minecart, final SpoutCraftBlock block, final Vector velocity) { //load minecart
		count = 0;
		for(final Chest chest:chests){
			if(!Methods.isInventoryFull(minecart.getInventory().getContents())){
				count = 0;
				final ItemStack[] contents = chest.getInventory().getContents();
				final int taskid = plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
				    public void run() {
				    	if(count != contents.length){
					    	if(!Methods.isInventoryFull(minecart.getInventory().getContents())){
						    	chest.getInventory().remove(count);
						    	minecart.getInventory().setItem(minecart.getInventory().firstEmpty(), contents[count]);
						    	chest.update();
						    	Bukkit.broadcastMessage("add");
					    	}
					    	count++;
				    	}
				    	
				    }
				},0L, 20L);//add config value
				
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				    public void run() {
				    	plugin.getServer().getScheduler().cancelTask(taskid);
				    	sendSignal(minecart, block, velocity);
				    }
				}, contents.length * 20);//add config value
			}else{
				sendSignal(minecart, block, velocity);
				Bukkit.broadcastMessage("full");
				break;
			}
		}
	}
	
	public void sendSignal(StorageMinecart minecart, final SpoutCraftBlock block, Vector velocity){
		Bukkit.broadcastMessage("send");
		block.setBlockPowered(true);
		minecart.setVelocity(velocity);
		SpoutManager.getSoundManager().playGlobalSoundEffect(SoundEffect.CLICK, new Location(block.getWorld(), block.getX(), block.getY(), block.getZ()));
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
		    public void run() {
		    	block.setBlockPowered(false);
		    }
		}, 40L);
	}
	
	@Override
	public void onBlockPlace(org.bukkit.World world, int x, int y, int z, org.bukkit.entity.LivingEntity living){
		Configuration.tracks.set(x + "," + y + "," + z + ".waitTillFull", true);
		Configuration.tracks.set(x + "," + y + "," + z + ".waitTime", 10);
	}
	
	@Override
	public void onBlockDestroyed(World world, int x, int y, int z){
		Configuration.tracks.set(x + "," + y + "," + z, null);
	}
}
