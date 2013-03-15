package me.duckdoom5.RpgEssentials.Entity;

import me.duckdoom5.RpgEssentials.RpgBanks.Bank;

import org.bukkit.entity.Player;


public class RpgPlayerBank extends RpgPlayer{
	private static final long serialVersionUID = 5098101117209323229L;
	
	private Bank bank;
	
	public RpgPlayerBank(Player player) {
		super(player);
		this.bank = new Bank(this);
	}
	
	public Bank getBank(){
		return bank;
	}

}
