package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards;

import com.topcat.npclib.entity.NPC;

import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;

public class XpReward extends Reward{
	private int amount;
	private Skill skill;
	
	public XpReward(Skill skill, int amount, NPC rewardGiver) {
		super(RewardType.XP, rewardGiver);
		
		this.amount = amount;
		this.skill = skill;
	}
	
	public int getAmount(){
		return amount;
	}
	
	public Skill getSkill(){
		return skill;
	}
}
