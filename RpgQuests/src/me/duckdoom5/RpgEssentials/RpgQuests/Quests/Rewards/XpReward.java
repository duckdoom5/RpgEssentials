package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards;

import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.SkillType;

public class XpReward extends Reward {
    private static final long serialVersionUID = -5847247369819152715L;
    private SkillType skill;

    public XpReward(SkillType skill, int amount, String rewardGiver) {
        super(RewardType.XP, rewardGiver, amount);

        this.skill = skill;
    }

    public SkillType getSkill() {
        return skill;
    }

    public void setSkill(SkillType skill) {
        this.skill = skill;
    }
}
