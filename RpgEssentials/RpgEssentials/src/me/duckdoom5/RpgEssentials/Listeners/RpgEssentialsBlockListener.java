package me.duckdoom5.RpgEssentials.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.items.tools.CustomTool;
import me.duckdoom5.RpgEssentials.util.Methods;
import me.duckdoom5.RpgEssentials.util.ToolType;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.material.item.GenericCustomTool;
import org.getspout.spoutapi.player.SpoutPlayer;

public class RpgEssentialsBlockListener implements Listener{

	public static RpgEssentials plugin;
	
	public RpgEssentialsBlockListener(RpgEssentials instance) {
        plugin = instance; 
    }

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) throws Exception{
		Block block = event.getBlock();
		Player player = event.getPlayer();
		World world = player.getWorld();
		for(GenericCustomBlock s:RpgEssentials.mm.getStairs()){
			if(player.getItemInHand().getDurability() == s.getCustomId()){
				String dir = Methods.getdir(player, false);
				if(dir.equals("North")){
					block.setData((byte)3);
				}else if(dir.equals("East")){
					block.setData((byte)0);
				}else if(dir.equals("South")){
					block.setData((byte)2);
				}else{
					block.setData((byte)1);
				}
			}
		}
	}
	
	@EventHandler
    public void onBlockBreak(BlockBreakEvent event){
		Block block = event.getBlock();
		Player player = event.getPlayer();
		ItemStack is = player.getItemInHand();
		CustomTool tool = RpgEssentials.mm.getTool(is);
        if(tool != null){
        	if(tool.getToolType().equals(ToolType.SHOVEL) || tool.getToolType().equals(ToolType.PICKAXE) || tool.getToolType().equals(ToolType.AXE)){
        		
        		SpoutItemStack inhand = new SpoutItemStack(player.getItemInHand());
        		int durability = GenericCustomTool.getDurability(inhand);
        		
        		if((durability + 1) > tool.getMaxDurability()){
        			SpoutPlayer splayer = (SpoutPlayer)player;
        			//SpoutManager.getSoundManager().playSoundEffect(splayer, SoundEffect.); break sound
        			if(inhand.getAmount() > 1){
        				SpoutItemStack newstack = new SpoutItemStack(tool, (inhand.getAmount()-1));
        				player.setItemInHand(newstack);
        			} else {
        				ItemStack newstack = new ItemStack(Material.AIR);
        				player.setItemInHand(newstack);
        			}
        		}else{
        			GenericCustomTool.setDurability(inhand, (short) (durability + 1));
        			player.setItemInHand(inhand);
        		}
        		
        	}
        }
	}
	
	/*@EventHandler
    public void onBlockDamage(BlockDamageEvent event){
        Player player = event.getPlayer();
        Block block = event.getBlock();
        ItemStack inhand = event.getItemInHand();
        
        if(player.getGameMode().equals(GameMode.SURVIVAL)){
	        CustomTool tool = RpgEssentials.mm.getTool(inhand);
	        if(tool != null){
	        	if(block.getType().equals(Material.DIRT) || block.getType().equals(Material.SAND) || block.getType().equals(Material.CLAY)){
			        if(tool.getToolType().equals(ToolType.SHOVEL)){
			        	
			        	//tool.setStrengthModifier((org.getspout.spoutapi.material.Block) block, 2.0F);
			        }
	        	}else if(block.getType().equals(Material.STONE)){
	        		if(tool.getToolType().equals(ToolType.PICKAXE)){
			        	//tool.setStrengthModifier((org.getspout.spoutapi.material.Block) block, 0.5F);
			        }
	        	}
	        }
		}
	}*/
}
