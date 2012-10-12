package me.duckdoom5.RpgEssentials.Generator;

import java.util.Random;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.spout.api.util.cuboid.CuboidShortBuffer;
import org.spout.vanilla.world.generator.normal.NormalGenerator;

public class SpoutGenerator extends ChunkGenerator {
	public SpoutGenerator(RpgEssentials rpgEssentials) {
	}
	
	public short[][] generateExtBlockSections(World world, Random random, int chunkX, int chunkZ, BiomeGrid biomes) {
		short[][] result = new short[world.getMaxHeight() / 16 + 1][];
		CuboidShortBuffer buffer = new CuboidShortBuffer(chunkX, 0, chunkZ, chunkX * 16, world.getMaxHeight(), chunkZ * 16);
		NormalGenerator gen = new NormalGenerator();
		gen.generate(buffer, chunkX, world.getMaxHeight(), chunkZ);
		// TODO actual code LOL		
		return result;
	}
}
