package me.duckdoom5.RpgEssentials.items.food;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.material.item.GenericCustomFood;
import org.getspout.spoutapi.player.SpoutPlayer;

public class CustomFood extends GenericCustomFood{

	int restore;
	int heal;
	String name;
	
	public CustomFood(Plugin plugin, String name, String texture, int restore, int heal) {
		super(plugin, name, texture, restore);
		this.restore = restore;
		this.heal = heal;
		this.name = name;
		SpoutManager.getFileManager().addToPreLoginCache(plugin, texture);
	}
	
	public boolean onItemInteract(SpoutPlayer player, SpoutBlock block, org.bukkit.block.BlockFace face){
		player.getInventory().removeItem(new ItemStack(player.getItemInHand().getType(),1,player.getItemInHand().getDurability()));
		player.setFoodLevel(player.getFoodLevel() + restore);
		player.setHealth(player.getHealth() + heal);
		return true;
	}
}
