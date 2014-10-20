package me.duckdoom5.RpgEssentials.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.items.tools.CustomTool;
import me.duckdoom5.RpgEssentials.util.ToolType;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.item.GenericCustomItem;
import org.getspout.spoutapi.material.item.GenericCustomTool;

public class RpgEssentialsBlockListener implements Listener {

    public RpgEssentials plugin;

    public RpgEssentialsBlockListener(RpgEssentials instance) {
        plugin = instance;
    }

    /*
     * @EventHandler public void onBlockPlace(BlockPlaceEvent event) throws
     * Exception{ Block block = event.getBlock(); Player player =
     * event.getPlayer(); for(GenericCustomBlock
     * s:RpgEssentials.mm.getStairs()){
     * if(player.getItemInHand().getDurability() == s.getCustomId()){ Direction
     * dir = Methods.getdir(player, false); switch(dir){ case NORTH:
     * block.setData((byte)3); case EAST: block.setData((byte)0); case SOUTH:
     * block.setData((byte)2); case WEST: block.setData((byte)1); break; }
     * break; } } }
     */

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        final Player player = event.getPlayer();
        final ItemStack is = player.getItemInHand();
        final SpoutItemStack sis = new SpoutItemStack(is);
        if (sis.isCustomItem()) {
            if (RpgeManager.getInstance().getMaterialManager().isTool((GenericCustomItem) sis.getMaterial())) {
                final CustomTool tool = RpgeManager.getInstance().getMaterialManager().getTool(is);
                if (tool != null) {
                    if (tool.getToolType().equals(ToolType.SHOVEL) || tool.getToolType().equals(ToolType.PICKAXE) || tool.getToolType().equals(ToolType.AXE)) {
                        final SpoutItemStack inhand = new SpoutItemStack(
                                player.getItemInHand());
                        final int durability = GenericCustomTool.getDurability(inhand);

                        if ((durability + 1) > tool.getMaxDurability()) {
                            // TODO
                            // SpoutManager.getSoundManager().playSoundEffect(splayer,
                            // SoundEffect.); break sound
                            if (inhand.getAmount() > 1) {
                                final SpoutItemStack newstack = new SpoutItemStack(
                                        tool, (inhand.getAmount() - 1));
                                player.setItemInHand(newstack);
                            } else {
                                final ItemStack newstack = new ItemStack(
                                        Material.AIR);
                                player.setItemInHand(newstack);
                            }
                        } else {
                            GenericCustomTool.setDurability(inhand,
                                    (short) (durability + 1));
                            player.setItemInHand(inhand);
                        }

                    }
                }
            }
        }
    }
}
