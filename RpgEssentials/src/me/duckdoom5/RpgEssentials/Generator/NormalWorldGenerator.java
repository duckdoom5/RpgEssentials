package me.duckdoom5.RpgEssentials.Generator;

import java.util.Random;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import net.minecraft.server.*;

import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

public class NormalWorldGenerator extends ChunkGenerator {
	
	private NoiseGeneratorOctaves l;
    private NoiseGeneratorOctaves m;
    private NoiseGeneratorOctaves n;
    private NoiseGeneratorOctaves o;
    public NoiseGeneratorOctaves a;
    public NoiseGeneratorOctaves b;
    public NoiseGeneratorOctaves c;
    
    private WorldGenBase t = new WorldGenCaves();
    private WorldGenStronghold u = new WorldGenStronghold();
    private WorldGenVillage v = new WorldGenVillage(0);
    private WorldGenMineshaft w = new WorldGenMineshaft();
    private WorldGenLargeFeature x = new WorldGenLargeFeature();
    private WorldGenBase y = new WorldGenCanyon();
    
    private net.minecraft.server.World p;
    
    //private BiomeBase[] z;
    
    double[] d;
    double[] e;
    double[] f;
    double[] g;
    double[] h;
    float[] i;
    
    public NormalWorldGenerator() {
	}
	
//	public NormalWorldGenerator(net.minecraft.server.World world) {
//		this.p = world;
//	}
	
	@Override
	public short[][] generateExtBlockSections(World world, Random random, int chunkX, int chunkZ, BiomeGrid biomes) {
		
		RpgEssentials.log.info("Loading gen ext");
		
		//this.z = this.p.getWorldChunkManager().getBiomes(this.z, chunkX * 4 - 2, chunkZ * 4 - 2, 10, 10);;
		
		short[][] newSection = new short[world.getMaxHeight() / 16 + 1][];
		
		this.l = new NoiseGeneratorOctaves(random, 16);
        this.m = new NoiseGeneratorOctaves(random, 16);
        this.n = new NoiseGeneratorOctaves(random, 8);
        this.o = new NoiseGeneratorOctaves(random, 4);
        this.a = new NoiseGeneratorOctaves(random, 10);
        this.b = new NoiseGeneratorOctaves(random, 16);
        this.c = new NoiseGeneratorOctaves(random, 8);
		
		
		//int i1 = 4;
        //int i2 = world.getMaxHeight() / 8;

        //int i4 = i1 + 1;
        //int i5 = world.getMaxHeight() / 8 + 1;
        //int i6 = i1 + 1;
        
        //double d001 = 0.03125D;
        
        //int heightBits = 8;
        
        double[] u = null;
        
        //this.BiomeArray = this.localWorld.getBiomesUnZoomed(this.BiomeArray, chunkX * 4 - 2, chunkZ * 4 - 2, i4 + 5, i6 + 5);

        u = GenerateNoiseArray(u, chunkX * 4, 0, chunkZ * 4, 5, 17, 5);
        RpgEssentials.log.info(u.length + u.toString());
        //this.BiomeArray = this.localWorld.getBiomes(this.BiomeArray, chunkX * 16, chunkZ * 16, ChunkMaxX, ChunkMaxZ);

        double d0 = 0.125D;
        byte b2 = 63;
    	int b3 = 17;
    	int l = (int)(d0 + 1);
        
        byte b0 = 4;
        byte b1 = 16;

        for (int x = 0; x < b0; x++) {
            for (int z = 0; z < b0; z++) {
                for (int y = 0; y < b1; y++) {
                    double d1 = u[((x + 0) * l + z + 0) * b3 + y + 0];
                    double d2 = u[((x + 0) * l + z + 1) * b3 + y + 0];
                    double d3 = u[((x + 1) * l + z + 0) * b3 + y + 0];
                    double d4 = u[((x + 1) * l + z + 1) * b3 + y + 0];
                    double d5 = (u[((x + 0) * l + z + 0) * b3 + y + 1] - d1) * d0;
                    double d6 = (u[((x + 0) * l + z + 1) * b3 + y + 1] - d2) * d0;
                    double d7 = (u[((x + 1) * l + z + 0) * b3 + y + 1] - d3) * d0;
                    double d8 = (u[((x + 1) * l + z + 1) * b3 + y + 1] - d4) * d0;

                    for (int l1 = 0; l1 < 8; ++l1) {
                        double d9 = 0.25D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;

                        for (int i2 = 0; i2 < 4; ++i2) {
                            //int j2 = i2 + x * 4 << 11 | 0 + z * 4 << 7 | y * 8 + l1;
                            //short short1 = 128;

                            //j2 -= short1;
                            double d14 = 0.25D;
                            double d15 = (d11 - d10) * d14;
                            double d16 = d10 - d15;

                            for (int k2 = 0; k2 < 4; ++k2) {
                                if ((d16 += d15) > 0.0D) {
                                	setBlock(newSection, x, y, z, (short) Block.STONE.id);
                                	//abyte[j2 += short1] = (byte) Block.STONE.id;
                                } else if (y * 8 + l1 < b2) {
                                	setBlock(newSection, x, y, z, (short) Block.STATIONARY_WATER.id);
                                	//abyte[j2 += short1] = (byte) Block.STATIONARY_WATER.id;
                                } else {
                                	setBlock(newSection, x, y, z, (short) 0);
                                    //abyte[j2 += short1] = 0;
                                }
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
		
		//return super.generateExtBlockSections(world, random, chunkX, chunkZ, biomes);
        return newSection;
		
	}
	
	private double[] GenerateNoiseArray(double[] outArray, int i, int j, int k, int l, int i1, int j1)
    {
        if (outArray == null)
        {
            outArray = new double[l * i1 * j1];
        }
        if (this.i == null) {
            this.i = new float[25];

            for (int k1 = -2; k1 <= 2; ++k1) {
                for (int l1 = -2; l1 <= 2; ++l1) {
                    float f = 10.0F / MathHelper.c((float) (k1 * k1 + l1 * l1) + 0.2F);

                    this.i[k1 + 2 + (l1 + 2) * 5] = f;
                }
            }
        }

        double d0 = 684.412D;
        double d1 = 684.412D;

        this.g = this.a.a(this.g, i, k, l, j1, 1.121D, 1.121D, 0.5D);
        this.h = this.b.a(this.h, i, k, l, j1, 200.0D, 200.0D, 0.5D);
        this.d = this.n.a(this.d, i, j, k, l, i1, j1, d0 / 80.0D, d1 / 160.0D, d0 / 80.0D);
        this.e = this.l.a(this.e, i, j, k, l, i1, j1, d0, d1, d0);
        this.f = this.m.a(this.f, i, j, k, l, i1, j1, d0, d1, d0);
        int i2 = 0;
        int j2 = 0;

        for (int k2 = 0; k2 < l; ++k2) {
            for (int l2 = 0; l2 < j1; ++l2) {
                float f1 = 0.0F;
                float f2 = 0.0F;
                float f3 = 0.0F;
                byte b0 = 2;
                //BiomeBase biomebase = this.z[k2 + 2 + (l2 + 2) * (l + 5)];

                for (int i3 = -b0; i3 <= b0; ++i3) {
                    for (int j3 = -b0; j3 <= b0; ++j3) {
                        //BiomeBase biomebase1 = this.z[k2 + i3 + 2 + (l2 + j3 + 2) * (l + 5)];
                        float f4 = this.i[i3 + 2 + (j3 + 2) * 5] / (0.1F + 2.0F);

//                        if (0.1F > 0.1F) {
//                            f4 /= 2.0F;
//                        }

                        f1 += 0.3F * f4;
                        f2 += 0.1F * f4;
                        f3 += f4;
                    }
                }

                f1 /= f3;
                f2 /= f3;
                f1 = f1 * 0.9F + 0.1F;
                f2 = (f2 * 4.0F - 1.0F) / 8.0F;
                double d2 = this.h[j2] / 8000.0D;

                if (d2 < 0.0D) {
                    d2 = -d2 * 0.3D;
                }

                d2 = d2 * 3.0D - 2.0D;
                if (d2 < 0.0D) {
                    d2 /= 2.0D;
                    if (d2 < -1.0D) {
                        d2 = -1.0D;
                    }

                    d2 /= 1.4D;
                    d2 /= 2.0D;
                } else {
                    if (d2 > 1.0D) {
                        d2 = 1.0D;
                    }

                    d2 /= 8.0D;
                }

                ++j2;

                for (int k3 = 0; k3 < i1; ++k3) {
                    double d3 = (double) f2;
                    double d4 = (double) f1;

                    d3 += d2 * 0.2D;
                    d3 = d3 * (double) i1 / 16.0D;
                    double d5 = (double) i1 / 2.0D + d3 * 4.0D;
                    double d6 = 0.0D;
                    double d7 = ((double) k3 - d5) * 12.0D * 128.0D / 128.0D / d4;

                    if (d7 < 0.0D) {
                        d7 *= 4.0D;
                    }

                    double d8 = this.e[i2] / 512.0D;
                    double d9 = this.f[i2] / 512.0D;
                    double d10 = (this.d[i2] / 10.0D + 1.0D) / 2.0D;

                    if (d10 < 0.0D) {
                        d6 = d8;
                    } else if (d10 > 1.0D) {
                        d6 = d9;
                    } else {
                        d6 = d8 + (d9 - d8) * d10;
                    }

                    d6 -= d7;
                    if (k3 > i1 - 4) {
                        double d11 = (double) ((float) (k3 - (i1 - 4)) / 3.0F);

                        d6 = d6 * (1.0D - d11) + -10.0D * d11;
                    }

                    outArray[i2] = d6;
                    ++i2;
                }
            }
        }
        return outArray;
    }
	
	private void setBlock(short[][] result, int x, int y, int z, short blkid) {
        if (result[y >> 4] == null) {
            result[y >> 4] = new short[4096];
        }
        result[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = blkid;
    }
	
	private short getBlock(short[][] result, int x, int y, int z) {
        if (result[y >> 4] == null) {
            return (short)0;
        }
        return result[y >> 4][((y & 0xF) << 8) | (z << 4) | x];
    }
}
