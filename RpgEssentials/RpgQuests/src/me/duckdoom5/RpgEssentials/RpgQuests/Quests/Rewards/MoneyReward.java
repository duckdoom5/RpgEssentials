package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards;

import com.topcat.npclib.entity.NPC;

public class MoneyReward extends Reward{
	private static final long serialVersionUID = -1593400233888191039L;

	public MoneyReward(int amount, NPC rewardGiver) {
		super(RewardType.MONEY, rewardGiver, amount);
	}
	
}
