package me.duckdoom5.RpgEssentials.RpgLeveling.Listeners;

import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevelManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Events.PlayerExpGainEvent;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Cooking;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Defense;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.SkillType;
import me.duckdoom5.RpgEssentials.RpgLeveling.Levels.Smithing;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class InventoryListener implements Listener {

    @EventHandler
    public void onCraftItem(CraftItemEvent event) {
        System.out.println(event.getCurrentItem() + " crafted");
        final Player player = (Player) event.getWhoClicked();
        final ItemStack result = event.getCurrentItem();
        final SkillType skill = getSkill(result);
        final int amount = result.getAmount();
        if (skill == SkillType.COOKING) {
            final int exp = Cooking.instance.getXp(result, amount);
            final PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, skill, exp);
            Bukkit.getServer().getPluginManager().callEvent(callevent);
        } else if (skill == SkillType.SMITHING) {
            final int exp = Smithing.instance.getXp(result, amount);
            final PlayerExpGainEvent callevent = new PlayerExpGainEvent(player, skill, exp);
            Bukkit.getServer().getPluginManager().callEvent(callevent);
        }
    }
    
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        final Player player = (Player) event.getWhoClicked();
        final SpoutPlayer splayer = SpoutManager.getPlayer(player);
        // if(RpgEssentials.wl.worlds.get(player.getWorld())){
        final SlotType slottype = event.getSlotType();
        final ItemStack cursor = event.getCursor();
        if (slottype == SlotType.ARMOR) {
            if (!Defense.instance.canUse(RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(player.getName()), cursor.getType())) {
                splayer.sendNotification("Error!", "Check your chat box", cursor.getType());
                player.sendMessage(ChatColor.RED + "You can only wear " + cursor.getType().toString().toLowerCase().replace("_", " ") + " on level " + me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.level.getInt("UnlockLevel." + cursor.getType().toString().toLowerCase().replace("_", " ")));
                event.setCancelled(true);
            }
        }
        // }
    }

    public static SkillType getSkill(ItemStack result) {
        if ((result.getType() == Material.GOLDEN_APPLE) || (result.getType() == Material.BREAD) || (result.getType() == Material.MUSHROOM_SOUP) || (result.getType() == Material.CAKE) || (result.getType() == Material.COOKED_BEEF) || (result.getType() == Material.COOKED_CHICKEN) || (result.getType() == Material.COOKED_FISH) || (result.getType() == Material.GRILLED_PORK)) {
            return SkillType.COOKING;
        } else if ((result.getType() == Material.WOOD_AXE) || (result.getType() == Material.WOOD_HOE) || (result.getType() == Material.WOOD_PICKAXE) || (result.getType() == Material.WOOD_SPADE) || (result.getType() == Material.WOOD_SWORD) || (result.getType() == Material.STONE_AXE) || (result.getType() == Material.STONE_HOE) || (result.getType() == Material.STONE_PICKAXE) || (result.getType() == Material.STONE_SPADE) || (result.getType() == Material.STONE_SWORD) || (result.getType() == Material.IRON_AXE) || (result.getType() == Material.IRON_HOE) || (result.getType() == Material.IRON_PICKAXE) || (result.getType() == Material.IRON_SPADE) || (result.getType() == Material.IRON_SWORD) || (result.getType() == Material.GOLD_AXE) || (result.getType() == Material.GOLD_HOE) || (result.getType() == Material.GOLD_PICKAXE) || (result.getType() == Material.GOLD_SPADE) || (result.getType() == Material.GOLD_SWORD) || (result.getType() == Material.DIAMOND_AXE) || (result.getType() == Material.DIAMOND_HOE) || (result.getType() == Material.DIAMOND_PICKAXE) || (result.getType() == Material.DIAMOND_SPADE) || (result.getType() == Material.DIAMOND_SWORD) || (result.getType() == Material.IRON_INGOT) || (result.getType() == Material.CLAY_BRICK) || (result.getType() == Material.GOLD_INGOT)) {
            return SkillType.SMITHING;
        }
        return null;
    }
}
