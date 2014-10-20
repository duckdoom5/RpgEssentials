package me.duckdoom5.RpgEssentials.util;

public enum AddonType {
    BANKS("RpgBanks"),
    DEATHS("RpgDeaths"),
    ENTITIES("RpgEntities"),
    LEVELING("RpgLeveling"),
    QUESTS("RpgQuests"),
    REGIONS("RpgRegions"),
    STORES("RpgStores");

    private String name;
    
    private AddonType(String name){
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
