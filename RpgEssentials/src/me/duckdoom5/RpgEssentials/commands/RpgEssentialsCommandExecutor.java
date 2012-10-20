package me.duckdoom5.RpgEssentials.commands;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

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
    		
    		if(args.length < 1 || args == null){//rpg
    			if(plugin.hasPermission(player, "rpgessentials.rpg.help")){
    				Help.method(sender, 1);
	    			return true;
    			}
				permissions(player);
    		}
    		if(args[0].equals("help") || args[0].equals("?")){
    			Help.command(args, player, sender);
    			return true;
    		}else if(args[0].equals("test")){
    			RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(player);
    			String url = Configuration.texture.getString(player.getWorld().getName() + "." + rpgplayer.getTexturepack(player.getWorld()) + ".url");
    			player.sendMessage(url);
    			return true;
    		}else if(args[0].equals("reload")){
				Reload.command(args, player, splayer, sender);
				return true;
			}else if(args[0].equals("cape")){
				Cape.command(args, player, splayer, sender);
				return true;
			}else if(args[0].equals("accessory")){
				Accessory.command(args, player, splayer, sender);
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
    		}else if(args[0].equals("mail")){//rpg mail
    			Mail.command(args, player, splayer, sender);
    			return true;
    		} else if (args[0].equals("gen")) {
    			Generator.command(args, player, splayer, sender);
    			return true;
    		} 
    	}else if(cmd.getName().equalsIgnoreCase("rnpc")){
    		if(args.length < 1){//rpg
    			if(plugin.hasPermission(player, "rpgessentials.rpg.help")){
    				Help.method(sender, 2);
	    			return true;
    			}
    			permissions(player);
    		}
    		
    		if(player != null){
	    		if(args[0].equals("help") || args[0].equals("?")){
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
	    		}else if(args[0].equals("select")){
					NpcSelect.command(args, player, splayer, sender);
					return true;
	    		}else if(args[0].equals("armor")){
					NpcArmor.command(args, player, splayer, sender);
					return true;
	    		}else if(args[0].equals("item")){
					NpcItem.command(args, player, splayer, sender);
					return true;
	    		}else if(args[0].equals("owner")){
					NpcOwner.command(args, player, splayer, sender);
					return true;
	    		}else if(args[0].equals("text")){
					NpcText.command(args, player, splayer, sender);
					return true;
	    		}else if(args[0].equals("type")){
					NpcType.command(args, player, splayer, sender);
					return true;
	    		}else if(args[0].equals("wand")){
					NpcWand.command(args, player, splayer, sender);
					return true;
	    		}
    		}else{
    			console(sender);
    		}
    	}
    	if(plugin.hasPermission(player, "rpgessentials.rpg.help")){
    		Help.method(player, 1);
    	}
    	return true;
    }
	
	public static void permissions(Player player){
		player.sendMessage(ChatColor.RED + "You don't have permissions !");	
	}
	
	public static void console(CommandSender sender){
		sender.sendMessage(ChatColor.RED + "You can't use this command from the console !");	
	}
}
