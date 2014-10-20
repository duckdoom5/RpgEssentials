package me.duckdoom5.RpgEssentials.commands;

import java.util.Iterator;
import java.util.List;
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

public class Generator {
    public static void command(String[] args, Player player, CommandSender sender) {
        if (args.length == 1) {
            player.sendMessage(ChatColor.RED + "Not enough arguments!");
            player.sendMessage(ChatColor.AQUA + "Usage: /rpg gen " + ChatColor.RED + "vill/strong/pyramids");
        } else {
            // Setup shared vars
            final Player user = (Player) sender;
            final org.bukkit.World w = user.getWorld();
            final Random rand = new Random(w.getSeed());
            final World world = ((CraftWorld) w).getHandle();
            final Block block = player.getLocation().getBlock();
            final int x = (block.getChunk().getX() << 4) + 8;
            final int z = (block.getChunk().getZ() << 4) + 8;

            if (args[1].equals("vill")) {
                // generate village in chunk (only works if allowed)
                try {

                    // TODO Messy code will need cleanup

                    // WorldGenVillage villageGen = new WorldGenVillage(0);
                    // villageGen.a(world, new Random(),
                    // user.getLocation().getChunk().getX(),
                    // user.getLocation().getChunk().getZ());

                    class VillageBuilder extends StructureStart {

                        private boolean c = false;

                        @SuppressWarnings ("unchecked")
                        public VillageBuilder(World world, Random random, int i, int j, int k) {
                            final List<?> arraylist = WorldGenVillagePieces.a(random, k);
                            final WorldGenVillageStartPiece worldgenvillagestartpiece = new WorldGenVillageStartPiece(world.getWorldChunkManager(), 0, random, (i << 4) + 2, (j << 4) + 2, arraylist, k);
                            a.add(worldgenvillagestartpiece);
                            worldgenvillagestartpiece.a(worldgenvillagestartpiece, a, random);
                            final List<?> arraylist1 = worldgenvillagestartpiece.j;
                            final List<?> arraylist2 = worldgenvillagestartpiece.i;

                            int l;

                            while (!arraylist1.isEmpty() || !arraylist2.isEmpty()) {
                                StructurePiece structurepiece;

                                if (arraylist1.isEmpty()) {
                                    l = random.nextInt(arraylist2.size());
                                    structurepiece = (StructurePiece) arraylist2.remove(l);
                                    structurepiece.a(worldgenvillagestartpiece, a, random);
                                } else {
                                    l = random.nextInt(arraylist1.size());
                                    structurepiece = (StructurePiece) arraylist1.remove(l);
                                    structurepiece.a(worldgenvillagestartpiece, a, random);
                                }
                            }
                            c();
                            l = 0;
                            final Iterator<WorldGenVillageStartPiece> iterator = a.iterator();

                            while (iterator.hasNext()) {
                                final StructurePiece structurepiece1 = iterator.next();
                                user.sendMessage("adding components" + structurepiece1.getClass().toString());
                                if (!(structurepiece1 instanceof WorldGenVillageRoadPiece)) {
                                    ++l;
                                }
                            }

                            c = l > 2;
                            user.sendMessage("last " + c);
                        }

                        @Override
                        public boolean d() {
                            return c;
                        }
                    }
                    final int radius = 200;
                    final VillageBuilder l = new VillageBuilder(world, rand, user.getLocation().getChunk().getX(), user.getLocation().getChunk().getZ(), 1);
                    l.a(world, new Random(), new StructureBoundingBox(x - radius, z - radius, x + radius, z + radius));
                    user.sendMessage("Done... " + l.d());
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            } else if (args[1].equals("strong")) {
                final WorldGenStronghold strongholdGen = new WorldGenStronghold();
                // strongholdGen.a(null, world, x, z, chunkArray);
                user.sendMessage("Done... " + strongholdGen.a(world, rand, x, z));
            } else if (args[1].equals("pyramids")) {
                final WorldGenLargeFeature PyramidsGen = new WorldGenLargeFeature();
                // PyramidsGen.a(null, world, x, z, chunkArray);
                user.sendMessage("Done... " + PyramidsGen.a(world, rand, x, z));
            } else {
                player.sendMessage(ChatColor.RED + "Not a valid argument!");
                player.sendMessage(ChatColor.AQUA + "Usage: /rpg gen " + ChatColor.RED + "vill/strong/pyramids");
            }
        }
    }
}
