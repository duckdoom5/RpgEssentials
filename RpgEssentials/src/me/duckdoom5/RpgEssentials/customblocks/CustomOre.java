package me.duckdoom5.RpgEssentials.customblocks;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.block.GenericCustomBlock;

public class CustomOre extends GenericCustomBlock {
    private int minY = 2, maxY = 128, freq = 0, size = 4;
    float hard = 1, friction = 0;

    public CustomOre(RpgEssentials plugin, String name, int textureid,
            int freq, int minY, int maxY, int size,
            org.getspout.spoutapi.material.Material drop, float hard,
            int light, int amount, int base) {
        super(plugin, name, base, new GenericCubeBlockDesign(plugin,
                RpgeManager.getInstance().ores, textureid));
        this.minY = minY;
        this.maxY = maxY;
        this.freq = freq;
        this.hard = hard;
        // this.friction = friction;
        this.size = size;
        setHardness(hard);
        setLightLevel(light);
        // this.setFriction(friction);
        // If a drop was specified then use it or default to flint
        if (drop != null) {
            setItemDrop(new SpoutItemStack(drop, amount > 1 ? amount : 1));
        } else {
            setItemDrop(new ItemStack(Material.FLINT, 1));
        }
    }

    public CustomOre(RpgEssentials plugin, String name, int textureid,
            int freq, int minY, int maxY, int size, Material drop, float hard,
            int light, int amount, int base) {
        super(plugin, name, base, new GenericCubeBlockDesign(plugin,
                RpgeManager.getInstance().ores, textureid));
        this.minY = minY;
        this.maxY = maxY;
        this.freq = freq;
        this.hard = hard;
        // this.friction = friction;
        this.size = size;
        setHardness(hard);
        setLightLevel(light);
        // this.setFriction(friction);
        // If a drop was specified then use it or default to flint
        if (drop != null) {
            setItemDrop(new ItemStack(drop, amount));
        } else {
            setItemDrop(new ItemStack(Material.FLINT, 1));
        }
    }

    public int getFreq() {
        return freq;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxY() {
        return maxY;
    }

    @Override
    public float getHardness() {
        return hard;
    }

    public int getSize() {
        return size;
    }
}