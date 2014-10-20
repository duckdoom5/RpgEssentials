package me.duckdoom5.RpgEssentials.RpgBanks.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.RpgBanks.Bank;
import me.duckdoom5.RpgEssentials.RpgBanks.RpgBanks;
import me.duckdoom5.RpgEssentials.config.Configuration;

public class RpgBankManager {
    private final HashMap<String, Bank> banks = new LinkedHashMap<>();
    private static RpgBankManager instance;

    public static RpgBankManager getInstance() {
        if (instance == null) {
            instance = new RpgBankManager();
        }
        return instance;
    }

    public void loadBanks() {
        final File dir = new File("plugins/RpgBanks/Temp/Banks/");
        final String[] names = dir.list();
        if (names != null) {
            for (final String name : names) {
                try {
                    final Bank bank = (Bank) Configuration.load("plugins/RpgBanks/Temp/Banks/" + name);
                    addBank(bank.getOwner().getName(), bank);
                } catch (final FileNotFoundException e) {
                    RpgBanks.plugin.getLogger().warning(name + " was not found.");
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void saveBank(Bank bank) {
        try {
            final File file = new File("plugins/RpgBanks/Temp/Banks");
            if (!file.exists()) {
                file.mkdirs();
            }
            Configuration.save(bank, "plugins/RpgBanks/Temp/Banks/" + bank.getOwner().getName() + ".bank");
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public void saveBanks() {
        for (final Bank bank : banks.values()) {
            saveBank(bank);
        }
    }

    public void deleteBank(String playername) {
        banks.remove(playername);
    }

    public Bank getBank(String playername) {
        if (banks.get(playername) == null) {
            banks.put(playername, new Bank(RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(playername)));
        }
        return banks.get(playername);
    }

    public void addBank(String name, Bank bank) {
        banks.put(name, bank);
    }
}
