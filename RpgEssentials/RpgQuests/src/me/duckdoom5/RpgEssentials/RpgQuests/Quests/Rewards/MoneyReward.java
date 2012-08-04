package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards;

import com.topcat.npclib.entity.NPC;

public class MoneyReward extends Reward{
	private int amount;
	
	public MoneyReward(int amount, NPC rewardGiver) {
		super(RewardType.MONEY, rewardGiver);
		
		this.amount = amount;
	}
	
	public int getAmount(){
		return amount;
	}
}
