package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards;

import com.topcat.npclib.entity.NPC;

import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;

public class XpReward extends Reward{
	private static final long serialVersionUID = -5847247369819152715L;
	private Skill skill;
	
	public XpReward(Skill skill, int amount, NPC rewardGiver) {
		super(RewardType.XP, rewardGiver, amount);
		
		this.skill = skill;
	}
	
	public Skill getSkill(){
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
}
