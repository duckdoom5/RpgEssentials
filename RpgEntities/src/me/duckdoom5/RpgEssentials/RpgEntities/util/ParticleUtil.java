package me.duckdoom5.RpgEssentials.RpgEntities.util;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.getspout.spoutapi.particle.Particle;
import org.getspout.spoutapi.particle.Particle.ParticleType;

public class ParticleUtil {
    private static Random r = new Random();
    
    public static void spawnHearts(Location location) {
        Location l = location.add(0, 1, 0);
        for(int x = 0; x < 5 + r.nextInt(5); x++){
            Particle p = new Particle(ParticleType.HEART, l, new Vector());
            p.setAmount(1);
            p.setMaxAge(20);
            p.setGravity(0);
            p.setScale(1);
            p.spawn();
        }
    }
    
    public static void spawnSmoke(Location location) {
        Location l = location.add(0, 1, 0);
        for(int x = 0; x < 5 + r.nextInt(5); x++){
            Particle p = new Particle(ParticleType.SMOKE, l.add(r.nextGaussian(), r.nextGaussian(), r.nextGaussian()), new Vector());
            p.setAmount(1);
            p.setMaxAge(20);
            p.setGravity(0);
            p.setScale(1);
            p.spawn();
        }
    }
}
