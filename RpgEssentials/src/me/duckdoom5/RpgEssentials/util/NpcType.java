package me.duckdoom5.RpgEssentials.util;

public enum NpcType {
    DEFAULT, BANKER, MERCHANT, QUESTER;

    public static boolean contains(String s) {
        for (final NpcType name : values()) {
            if (name.name().equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }
}
