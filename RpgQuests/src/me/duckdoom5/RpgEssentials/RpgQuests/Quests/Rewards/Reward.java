package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards;

import java.io.Serializable;

public class Reward implements Serializable {
    private static final long serialVersionUID = 3212785403639085731L;
    private final RewardType type;
    private String rewardGiver;
    private int amount;

    public Reward(RewardType type, String rewardGiver, int amount) {
        this.type = type;
        this.rewardGiver = rewardGiver;
        this.amount = amount;
    }

    public String getRewardGiver() {
        return rewardGiver;
    }

    public void setRewardGiver(String rewardGiver) {
        this.rewardGiver = rewardGiver;
    }

    public RewardType getType() {
        return type;
    }

    public enum RewardType {
        XP, MONEY, MATERIAL;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
