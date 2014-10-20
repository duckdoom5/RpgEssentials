package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

public enum SkillType {
    ATTACK, COMBAT, CONSTRUCTION, COOKING, DEFENSE, EXCAVATION, FARMING, FIREMAKING, FISHING, MINING, QUESTING, RANGED, SMITHING, TAMING, WOODCUTTING;
    
    public Skill getInstance(){
        switch(this){
            case ATTACK:
                return Attack.instance;
            case COMBAT:
                return Combat.instance;
            case CONSTRUCTION:
                return Construction.instance;
            case COOKING:
                return Cooking.instance;
            case DEFENSE:
                return Defense.instance;
            case EXCAVATION:
                return Excavation.instance;
            case FARMING:
                return Farming.instance;
            case FIREMAKING:
                return Firemaking.instance;
            case FISHING:
                return Fishing.instance;
            case MINING:
                return Mining.instance;
            case QUESTING:
                return Questing.instance;
            case RANGED:
                return Ranged.instance;
            case SMITHING:
                return Smithing.instance;
            case TAMING:
                return Taming.instance;
            case WOODCUTTING:
                return Woodcutting.instance;
            default:
                return null;
        }
    }
    
    public boolean hasUnlockables(){
        switch(this){
            case ATTACK:
            case DEFENSE:
            case EXCAVATION:
            case FARMING:
            case FISHING:
            case MINING:
            case TAMING:
            case WOODCUTTING:
                if(Skill.isEnabled(this)){
                    return true;
                }
                return false;
            default:
                return false;
        }
    }
}
