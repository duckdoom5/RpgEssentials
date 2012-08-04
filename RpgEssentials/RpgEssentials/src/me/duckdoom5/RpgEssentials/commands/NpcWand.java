package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.player.SpoutPlayer;

public class NpcWand extends RpgEssentialsCommandExecutor{
	
	public NpcWand(RpgEssentials instance) {
		super(instance);
	}
	
	public static void command(String args[], Player player, SpoutPlayer splayer, CommandSender sender){
		if(player == null){
			sender.sendMessage(ChatColor.RED + "You can only use this command in game!");
		}else{
			if(args.length == 1){//npc wand
				if(plugin.hasPermission(player, "rpgessentials.npc.wand") || plugin.hasPermission(player, "rpgessentials.npc.admin")){
					player.getInventory().addItem(new ItemStack(Material.FLINT, 1, (short) RpgEssentials.mm.getItemByName("NPC Wand").getCustomId()));
				}else{
					permissions(player);
				}
			}else{
				player.sendMessage(ChatColor.RED + "Too many arguments !");
				player.sendMessage(ChatColor.AQUA + "Usage: /npc wand");
			}
		}
	}
}
