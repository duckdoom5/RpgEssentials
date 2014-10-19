package me.duckdoom5.RpgEssentials.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import net.minecraft.server.v1_6_R3.StructureBoundingBox;
import net.minecraft.server.v1_6_R3.StructurePiece;
import net.minecraft.server.v1_6_R3.StructureStart;
import net.minecraft.server.v1_6_R3.World;
import net.minecraft.server.v1_6_R3.WorldGenLargeFeature;
import net.minecraft.server.v1_6_R3.WorldGenStronghold;
import net.minecraft.server.v1_6_R3.WorldGenVillagePieces;
import net.minecraft.server.v1_6_R3.WorldGenVillageRoadPiece;
import net.minecraft.server.v1_6_R3.WorldGenVillageStartPiece;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_6_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Generator {
	public static void command(String[] args, Player player, SpoutPlayer splayer, CommandSender sender){
		if(args.length == 1){
			player.sendMessage(ChatColor.RED + "Not enough arguments!");
			player.sendMessage(ChatColor.AQUA + "Usage: /rpg gen " + ChatColor.RED + "vill/strong/pyramids");
		}else{
			// Setup shared vars
			final Player user=(Player)sender;
			org.bukkit.World w = user.getWorld();
			Random rand = new Random(w.getSeed());
	        World world=((CraftWorld) w).getHandle();
	        Block block = player.getLocation().getBlock();
	        int x = (block.getChunk().getX() << 4) + 8;
	        int z = (block.getChunk().getZ() << 4) + 8;
	        
			if (args[1].equals("vill")) {
				// generate village in chunk (only works if allowed)
				try {
		            
					// TODO Messy code will need cleanup
					
	                //WorldGenVillage villageGen = new WorldGenVillage(0);
	                //villageGen.a(world, new Random(), user.getLocation().getChunk().getX(), user.getLocation().getChunk().getZ());
	                
	                class VillageBuilder extends StructureStart {
	
	                    private boolean c = false;
	
	                    public VillageBuilder(World world, Random random, int i, int j, int k) {
	                        ArrayList<?> arraylist = (ArrayList<?>) WorldGenVillagePieces.a(random, k);
	                        WorldGenVillageStartPiece worldgenvillagestartpiece = new WorldGenVillageStartPiece(world.getWorldChunkManager(), 0, random, (i << 4) + 2, (j << 4) + 2, arraylist, k);
	                        this.a.add(worldgenvillagestartpiece);
	                        worldgenvillagestartpiece.a(worldgenvillagestartpiece, this.a, random);
	                        ArrayList<?> arraylist1 = (ArrayList<?>) worldgenvillagestartpiece.j;
	                        ArrayList<?> arraylist2 = (ArrayList<?>) worldgenvillagestartpiece.i;
	
	                        int l;
	
	                        while (!arraylist1.isEmpty() || !arraylist2.isEmpty()) {
	                            StructurePiece structurepiece;
	                            
	                            if (arraylist1.isEmpty()) {
	                                l = random.nextInt(arraylist2.size());
	                                structurepiece = (StructurePiece) arraylist2.remove(l);
	                                structurepiece.a(worldgenvillagestartpiece, this.a, random);
	                            } else {
	                                l = random.nextInt(arraylist1.size());
	                                structurepiece = (StructurePiece) arraylist1.remove(l);
	                                structurepiece.a(worldgenvillagestartpiece, this.a, random);
	                            }
	                        }
	                        this.c();
	                        l = 0;
	                        Iterator<WorldGenVillageStartPiece> iterator = this.a.iterator();
	
	                        while (iterator.hasNext()) {
	                            StructurePiece structurepiece1 = iterator.next();
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
		            int radius = 200;
		            VillageBuilder l = new VillageBuilder(world, rand, user.getLocation().getChunk().getX(), user.getLocation().getChunk().getZ(), 1);
	                l.a(world, new Random(), new StructureBoundingBox(x-radius, z-radius, x+radius, z+radius));
	                user.sendMessage("Done... " + l.d());
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			} else if (args[1].equals("strong")) {
				WorldGenStronghold strongholdGen = new WorldGenStronghold();
	            //strongholdGen.a(null, world, x, z, chunkArray);
				user.sendMessage("Done... " + strongholdGen.a(world, rand, x, z));
			} else if (args[1].equals("pyramids")) {
				WorldGenLargeFeature PyramidsGen = new WorldGenLargeFeature();
	        	//PyramidsGen.a(null, world, x, z, chunkArray);
				user.sendMessage("Done... " + PyramidsGen.a(world, rand, x, z));
			} else {
				player.sendMessage(ChatColor.RED + "Not a valid argument!");
				player.sendMessage(ChatColor.AQUA + "Usage: /rpg gen " + ChatColor.RED + "vill/strong/pyramids");
			}
		}
	}
}
