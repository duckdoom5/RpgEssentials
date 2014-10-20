package me.duckdoom5.RpgEssentials.RpgEntities.Listeners;

import me.duckdoom5.RpgEssentials.RpgEntities.RpgEntities;
import me.duckdoom5.RpgEssentials.RpgEntities.GUI.EntityGui;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.EntityRpg;

import org.bukkit.craftbukkit.v1_6_R3.entity.CraftLivingEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class EntityListener implements Listener {
    
    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent e){
        if(e.getRightClicked() instanceof LivingEntity){
            final SpoutPlayer splayer = SpoutManager.getPlayer(e.getPlayer());
            final LivingEntity entity = (LivingEntity) e.getRightClicked();
            if(((EntityRpg)((CraftLivingEntity)entity).getHandle()).isTamed()){
                new EntityGui(RpgEntities.plugin, null, splayer, entity);
            }
        }
    }
}
