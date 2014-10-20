package me.duckdoom5.RpgEssentials.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.util.FurnaceRecipes;

import org.bukkit.Material;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.ItemStack;

public class RpgEssentialsInventoryListener implements Listener {

    public RpgEssentials plugin;

    public RpgEssentialsInventoryListener(RpgEssentials instance) {
        plugin = instance;
    }

    @EventHandler
    public void onFurnaceBurn(FurnaceBurnEvent event) {
        final Furnace furnace = (Furnace) event.getBlock().getState();
        final ItemStack smelting = furnace.getInventory().getSmelting();

        if (FurnaceRecipes.customrecipes.containsKey(smelting.getDurability())) {
            FurnaceRecipes.customrecipes.get(smelting.getDurability());
        } else if (smelting.getType().equals(Material.FLINT)) {
            if (event.isBurning()) {
                event.setBurning(false);
                event.setCancelled(true);
            } else {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onFurnaceSmelt(FurnaceSmeltEvent event) {
        final ItemStack source = event.getSource();

        if (FurnaceRecipes.customrecipes.containsKey(source.getDurability())) {
            final ItemStack r = FurnaceRecipes.customrecipes.get(source.getDurability());
            event.setResult(r);
        } else if (source.getType().equals(Material.FLINT)) {
            event.setCancelled(true);
        }
    }

    /*
     * @EventHandler public void onScreenOpen(ScreenOpenEvent event) {
     * SpoutPlayer splayer = event.getPlayer();
     * if(event.getScreenType().equals(ScreenType.PLAYER_INVENTORY) &&
     * !splayer.getGameMode().equals(GameMode.CREATIVE)){
     * event.setCancelled(true); splayer.sendMessage("true");
     * splayer.getCurrentScreen().attachWidget(plugin, new
     * GenericSlot().setWidth
     * (50).setHeight(50).setX(0).setY(0).setAnchor(WidgetAnchor.TOP_LEFT));
     * splayer.getCurrentScreen().attachWidget(plugin, new
     * GenericButton("test").
     * setWidth(50).setHeight(50).setX(50).setY(0).setAnchor
     * (WidgetAnchor.TOP_LEFT)); splayer.getMainScreen.attachPopup(popup); } }
     */
}
