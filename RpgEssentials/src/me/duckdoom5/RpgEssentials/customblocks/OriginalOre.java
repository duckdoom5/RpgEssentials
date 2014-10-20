package me.duckdoom5.RpgEssentials.customblocks;

import org.bukkit.Material;

public class OriginalOre {
    private int minY = 2, maxY = 128, freq = 0, size = 4;
    Material material;

    public OriginalOre(Material material, int freq, int size, int minY, int maxY) {
        this.minY = minY;
        this.maxY = maxY;
        this.freq = freq;
        this.size = size;
        this.material = material;
    }

    public int getfreq() {
        return freq;
    }

    public Material getmaterial() {
        return material;
    }

    public int getminY() {
        return minY;
    }

    public int getmaxY() {
        return maxY;
    }

    public int getSize() {
        return size;
    }
}
