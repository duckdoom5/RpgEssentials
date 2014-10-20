package me.duckdoom5.RpgEssentials.RpgQuests.Listeners;

import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.Task.TaskType;
import me.duckdoom5.RpgEssentials.util.Methods;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener {
    @EventHandler
    public static void InventoryClick(InventoryClickEvent event) {
        final boolean run2 = false;
        final Player player = (Player) event.getWhoClicked();
        final SlotType slottype = event.getSlotType();
        final ItemStack cursor = event.getCursor();
        final ItemStack result = event.getCurrentItem();
        if (slottype == SlotType.RESULT) {
            if (result != null) {
                final int amount = result.getAmount();
                try {
                    if (!Methods.isTool(cursor.getType())) {
                        if (!(cursor.getAmount() == 64)) {
                            try {
                                final String skill = getSkill(result);
                                if (skill == "craft") {
                                    for (int count = 0; count < amount; count++) {
                                        final RpgPlayer rpgplayer = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player);
                                        RpgQuests.qh.startQuestCheck(rpgplayer,
                                                TaskType.CRAFT, event);

                                        // QuestOld.run(player, "craft",
                                        // result.getType());
                                    }
                                } else if (skill == "smelt") {
                                    for (int count = 0; count < amount; count++) {
                                        final RpgPlayer rpgplayer = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player);
                                        RpgQuests.qh.startQuestCheck(rpgplayer,
                                                TaskType.SMELT, event);

                                        // QuestOld.run(player, "smelt",
                                        // result.getType());
                                    }
                                }
                            } catch (final Exception e) {
                            }
                        }
                    }
                } catch (final Exception e) {
                    try {
                        final String skill = getSkill(result);
                        if (skill == "craft") {
                            for (int count = 0; count < amount; count++) {
                                final RpgPlayer rpgplayer = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player);
                                RpgQuests.qh.startQuestCheck(rpgplayer,
                                        TaskType.CRAFT, event);

                                // QuestOld.run(player, "craft",
                                // result.getType());
                            }
                        } else if (skill == "smelt") {
                            for (int count = 0; count < amount; count++) {
                                final RpgPlayer rpgplayer = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player);
                                RpgQuests.qh.startQuestCheck(rpgplayer,
                                        TaskType.SMELT, event);

                                // QuestOld.run(player, "smelt",
                                // result.getType());
                            }
                        }
                    } catch (final Exception ex) {
                    }
                }
            }
        }
        if (run2) {

        }
    }

    private static String getSkill(ItemStack result) {
        String skilltype = null;
        if ((result.getType() == Material.IRON_INGOT) || (result.getType() == Material.CLAY_BRICK) || (result.getType() == Material.GOLD_INGOT)) {
            skilltype = "smelt";
        } else {
            skilltype = "craft";
        }
        return skilltype;
    }
}
