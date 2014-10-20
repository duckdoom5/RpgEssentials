package me.duckdoom5.RpgEssentials.RpgLeveling.Config;

import java.io.Serializable;

import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.SkillType;

public class RpgPlayerLevel implements Serializable {
    private static final long serialVersionUID = 85842654425930259L;

    private final RpgPlayer rpgPlayer;

    private int attackExp, attackLvl;
    private int combatLvl;
    private int constructionExp, constructionLvl;
    private int cookingExp, cookingLvl;
    private int defenseExp, defenseLvl;
    private int excavationExp, excavationLvl;
    private int farmingExp, farmingLvl;
    private int firemakingExp, firemakingLvl;
    private int fishingExp, fishingLvl;
    private int miningExp, miningLvl;
    private int questingExp, questingLvl;
    private int rangedExp, rangedLvl;
    private int smithingExp, smithingLvl;
    private int tamingExp, tamingLvl;
    private int woodcuttingExp, woodcuttingLvl;

    private int SP;

    public RpgPlayerLevel(RpgPlayer rpgPlayer) {
        this.rpgPlayer = rpgPlayer;

        attackLvl = 1;
        combatLvl = 3;
        constructionLvl = 1;
        cookingLvl = 1;
        defenseLvl = 1;
        excavationLvl = 1;
        farmingLvl = 1;
        firemakingLvl = 1;
        fishingLvl = 1;
        miningLvl = 1;
        questingLvl = 1;
        rangedLvl = 1;
        smithingLvl = 1;
        tamingLvl = 1;
        woodcuttingLvl = 1;

        SP = 0;
    }

    public RpgPlayer getRpgPlayer() {
        return rpgPlayer;
    }

    public int getSkillPoints() {
        return SP;
    }

    public void setSkillPoints(int SP) {
        this.SP = SP;
        save();
    }

    public int getLvl(SkillType type) {
        switch (type) {
            case ATTACK:
                return attackLvl;
            case COMBAT:
                return combatLvl;
            case CONSTRUCTION:
                return constructionLvl;
            case COOKING:
                return cookingLvl;
            case DEFENSE:
                return defenseLvl;
            case EXCAVATION:
                return excavationLvl;
            case FARMING:
                return farmingLvl;
            case FIREMAKING:
                return firemakingLvl;
            case FISHING:
                return fishingLvl;
            case MINING:
                return miningLvl;
            case QUESTING:
                return questingLvl;
            case RANGED:
                return rangedLvl;
            case SMITHING:
                return smithingLvl;
            case TAMING:
                return tamingLvl;
            case WOODCUTTING:
                return woodcuttingLvl;
            default:
                return 0;
        }
    }

    public void setLvl(SkillType skill, int lvl) {
        switch (skill) {
            case ATTACK:
                attackLvl = lvl;
                break;
            case COMBAT:
                combatLvl = lvl;
                break;
            case CONSTRUCTION:
                constructionLvl = lvl;
                break;
            case COOKING:
                cookingLvl = lvl;
                break;
            case DEFENSE:
                defenseLvl = lvl;
                break;
            case EXCAVATION:
                excavationLvl = lvl;
                break;
            case FARMING:
                farmingLvl = lvl;
                break;
            case FIREMAKING:
                firemakingLvl = lvl;
                break;
            case FISHING:
                fishingLvl = lvl;
                break;
            case MINING:
                miningLvl = lvl;
                break;
            case QUESTING:
                questingLvl = lvl;
                break;
            case RANGED:
                rangedLvl = lvl;
                break;
            case SMITHING:
                smithingLvl = lvl;
                break;
            case TAMING:
                tamingLvl = lvl;
                break;
            case WOODCUTTING:
                woodcuttingLvl = lvl;
                break;
            default:
                break;
        }
        save();
    }

    public int getExp(SkillType skill) {
        switch (skill) {
            case ATTACK:
                return attackExp;
            case CONSTRUCTION:
                return constructionExp;
            case COOKING:
                return cookingExp;
            case DEFENSE:
                return defenseExp;
            case EXCAVATION:
                return excavationExp;
            case FARMING:
                return farmingExp;
            case FIREMAKING:
                return firemakingExp;
            case FISHING:
                return fishingExp;
            case MINING:
                return miningExp;
            case QUESTING:
                return questingExp;
            case RANGED:
                return rangedExp;
            case SMITHING:
                return smithingExp;
            case WOODCUTTING:
                return woodcuttingExp;
            case TAMING:
                return tamingExp;
            default:
                return 0;
        }
    }

    public void setExp(SkillType skill, int exp) {
        switch (skill) {
            case ATTACK:
                attackExp = exp;
                break;
            case CONSTRUCTION:
                constructionExp = exp;
                break;
            case COOKING:
                cookingExp = exp;
                break;
            case DEFENSE:
                defenseExp = exp;
                break;
            case EXCAVATION:
                excavationExp = exp;
                break;
            case FARMING:
                farmingExp = exp;
                break;
            case FIREMAKING:
                firemakingExp = exp;
                break;
            case FISHING:
                fishingExp = exp;
                break;
            case MINING:
                miningExp = exp;
                break;
            case QUESTING:
                questingExp = exp;
                break;
            case RANGED:
                rangedExp = exp;
                break;
            case SMITHING:
                smithingExp = exp;
                break;
            case TAMING:
                tamingExp = exp;
                break;
            case WOODCUTTING:
                woodcuttingExp = exp;
                break;
            default:
                break;
        }
        save();
    }

    private void save() {
        RpgPlayerLevelManager.getInstance().saveRpgPlayerLevel(this);
    }
}
