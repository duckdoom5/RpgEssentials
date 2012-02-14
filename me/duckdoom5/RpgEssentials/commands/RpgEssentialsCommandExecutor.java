package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.flags.DefaultFlag;

public class RpgEssentialsCommandExecutor implements CommandExecutor{
	
	public static RpgEssentials plugin;
	
	public RpgEssentialsCommandExecutor(RpgEssentials instance) {
        plugin = instance;  
    }
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		SpoutPlayer splayer = null;
		Player player = null;
    	if (sender instanceof Player) {
    		player = (Player) sender;
    		splayer =  SpoutManager.getPlayer(player);
    	}
     
    	if(cmd.getName().equalsIgnoreCase("rpg")){
    		
    		if(args.length < 1){//rpg
    			if(player.hasPermission("rpg.help")){
    				Help.method(sender, 1);
	    			return true;
    			} else {
    				permissions(player);
    			}
    		}
    		if(args[0].equals("help")){
    			Help.command(args, player, sender);
    			return true;
    		}else if(args[0].equals("test")){
    			WorldGuardPlugin worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
    			boolean pvp = worldguard.getRegionManager(player.getWorld()).getApplicableRegions(player.getLocation()).allows(DefaultFlag.PVP);
    			player.sendMessage(Boolean.toString(pvp));
    			return true;
			}else if(args[0].equals("cape")){
				Cape.command(args, player, splayer, sender);
				return true;
    		} else if(args[0].equals("title")){
    			Title.command(args, player, splayer, sender);
    			return true;
    		} else if(args[0].equals("speed")){//rpg speed
    			Speed.command(args, player, splayer, sender);
    			return true;
    		} else if(args[0].equals("texturepack")){
    			Texturepack.command(args, player, splayer, sender);
    			return true;
    		} else if(args[0].equals("skin")){
    			Skin.command(args, player, splayer, sender);
    			return true;
    		} else if(args[0].equals("jump")){//rpg jump
    			Jump.command(args, player, splayer, sender);
    			return true;
    		} else if(args[0].equals("time")){//rpg time [world] [time]
    			Time.command(args, player, splayer, sender);
    			return true;
    		} else if(args[0].equals("weather")){//rpg weather [world] [weather]
    			Weather.command(args, player, splayer, sender);
    			return true;
    		} else if(args[0].equals("feed")){//rpg feed
    			Feed.command(args, player, splayer, sender);
    			return true;
    		} else if(args[0].equals("heal")){//rpg heal
    			Heal.command(args, player, splayer, sender);
    			return true;
    		}else if(args[0].equals("money")){//rpg money
    			Money.command(args, player, splayer, sender);
    			return true;
    		}
    	}else if(cmd.getName().equalsIgnoreCase("npc")){
    		if(args.length < 1){//rpg
    			if(player.hasPermission("rpg.help")){
    				Help.method(sender, 1);
	    			return true;
    			} else {
    				permissions(player);
    			}
    		}
    		if(args[0].equals("help")){
    			Help.command(args, player, sender);
    			return true;
    		}else if(args[0].equals("create")){
				NpcCreate.command(args, player, splayer, sender);
				return true;
    		}else if(args[0].equals("remove")){
				NpcRemove.command(args, player, splayer, sender);
				return true;
    		}else if(args[0].equals("rename")){
				NpcRename.command(args, player, splayer, sender);
				return true;
    		}else if(args[0].equals("walkto") || args[0].equals("moveto") || args[0].equals("move") || args[0].equals("walk") || args[0].equals("tpto")){
				NpcMove.command(args, player, splayer, sender);
				return true;
    		}else if(args[0].equals("cape")){
				NpcCape.command(args, player, splayer, sender);
				return true;
    		}else if(args[0].equals("skin")){
				NpcSkin.command(args, player, splayer, sender);
				return true;
    		}
    	}
    	Help.method(player, 1);
    	return true;
    }
	
	public static void permissions(Player player){
		player.sendMessage(ChatColor.RED + "You don't have permissions !");	
	}
}
