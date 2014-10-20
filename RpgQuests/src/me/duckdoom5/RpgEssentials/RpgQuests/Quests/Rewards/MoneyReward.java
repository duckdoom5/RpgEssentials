package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards;

public class MoneyReward extends Reward {
    private static final long serialVersionUID = -1593400233888191039L;

    public MoneyReward(int amount, String rewardGiver) {
        super(RewardType.MONEY, rewardGiver, amount);
    }

}
