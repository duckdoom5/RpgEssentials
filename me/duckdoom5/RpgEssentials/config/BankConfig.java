package me.duckdoom5.RpgEssentials.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.bukkit.configuration.file.YamlConfiguration;

public class BankConfig {

	public static void set(){
		
		if(!Configuration.bank.contains("Bank.example player.items")){
			Configuration.bank.set("Bank.example player.items", Arrays.asList("1:0:1","2:0:1","3:0:1"));
		}
		if(!Configuration.bank.contains("Bank.example player.size")){
			Configuration.bank.set("Bank.example player.size", 9);
		}

	}
}
