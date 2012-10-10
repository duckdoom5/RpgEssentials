package me.duckdoom5.RpgEssentials.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.config.Configuration;
import net.minecraft.server.*;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.CraftWorld;
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
    		} else if (args[0].equals("vill")) {// generate village in chunk (only works if allowed)
    			try {
    	            
    				// TODO Messy code will need cleanup
    				final Player user=(Player)sender;
                    //WorldGenVillage villageGen = new WorldGenVillage(0);
                    org.bukkit.World w = user.getWorld();
                    World world=((CraftWorld) w).getHandle();
                    //villageGen.a(world, new Random(), user.getLocation().getChunk().getX(), user.getLocation().getChunk().getZ());
                    
                    class VillageBuilder extends StructureStart {

                        private boolean c = false;

                        public VillageBuilder(World world, Random random, int i, int j, int k) {
                            ArrayList arraylist = WorldGenVillagePieces.a(random, k);
                            WorldGenVillageStartPiece worldgenvillagestartpiece = new WorldGenVillageStartPiece(world.getWorldChunkManager(), 0, random, (i << 4) + 2, (j << 4) + 2, arraylist, k);
                            this.a.add(worldgenvillagestartpiece);
                            worldgenvillagestartpiece.a(worldgenvillagestartpiece, this.a, random);
                            ArrayList arraylist1 = worldgenvillagestartpiece.j;
                            ArrayList arraylist2 = worldgenvillagestartpiece.i;

                            int l;

                            while (!arraylist1.isEmpty() || !arraylist2.isEmpty()) {
                                StructurePiece structurepiece;
                                
                                if (arraylist1.isEmpty()) {
                                    l = random.nextInt(arraylist2.size());
                                    structurepiece = (StructurePiece) arraylist2.remove(l);
                                    structurepiece.a((StructurePiece) worldgenvillagestartpiece, (List) this.a, random);
                                } else {
                                    l = random.nextInt(arraylist1.size());
                                    structurepiece = (StructurePiece) arraylist1.remove(l);
                                    structurepiece.a((StructurePiece) worldgenvillagestartpiece, (List) this.a, random);
                                }
                            }

                            this.c();
                            l = 0;
                            Iterator iterator = this.a.iterator();

                            while (iterator.hasNext()) {
                                StructurePiece structurepiece1 = (StructurePiece) iterator.next();
                                user.sendMessage("adding components" + structurepiece1.getClass().toString());
                                if (!(structurepiece1 instanceof WorldGenVillageRoadPiece)) {
                                    ++l;
                                }
                            }

                            this.c = l > 2;
                            user.sendMessage("last " + this.c);
                        }

                        public boolean d() {
                            return this.c;
                        }
                    }
                    Block block = player.getLocation().getBlock();
                    int i = (block.getChunk().getX() << 4) + 8;
    	            int j = (block.getChunk().getZ() << 4) + 8;
    	            int radius = 200;
    	            VillageBuilder l = new VillageBuilder(world, new Random(), user.getLocation().getChunk().getX(), user.getLocation().getChunk().getZ(), 1);
                    l.a(world, new Random(), new StructureBoundingBox(i-radius, j-radius, i+radius, j+radius));
                    user.sendMessage("Done..." + l.d());
    	            return true;
    	        } catch (Exception e) {
    	            e.printStackTrace();
    	        }
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
	    		}else if(args[0].equals("quest")){
					NpcQuest.command(args, player, splayer, sender);
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
