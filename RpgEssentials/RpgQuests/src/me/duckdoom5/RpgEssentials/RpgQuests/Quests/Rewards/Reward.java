package me.duckdoom5.RpgEssentials.RpgQuests.Quests.Rewards;

import java.io.Serializable;

import com.topcat.npclib.entity.NPC;

public class Reward implements Serializable{
	private static final long serialVersionUID = 3212785403639085731L;
	private RewardType type;
	private NPC rewardGiver;
	private int amount;
	
	public Reward(RewardType type, NPC rewardGiver, int amount){
		this.type = type;
		this.rewardGiver = rewardGiver;
		this.amount = amount;
	}
	
	public NPC getRewardGiver(){
		return rewardGiver;
	}
	
	public void setRewardGiver(NPC rewardGiver){
		this.rewardGiver = rewardGiver;
	}
	
	public RewardType getType(){
		return type;
	}
	
	public enum RewardType{
		XP, MONEY, MATERIAL;
	}

	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount){
		this.amount = amount;
	}
}
