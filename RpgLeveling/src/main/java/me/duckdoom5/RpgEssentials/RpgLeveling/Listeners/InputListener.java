package me.duckdoom5.RpgEssentials.RpgLeveling.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgLeveling.RpgLeveling;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgLeveling.Gui.LevelGui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.event.input.KeyPressedEvent;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.keyboard.Keyboard;
import org.getspout.spoutapi.player.SpoutPlayer;

public class InputListener implements Listener{
	public RpgLeveling plugin;
	public Keyboard key;
	
	public InputListener(RpgLeveling rpgLeveling) {
		this.plugin = rpgLeveling;
	}

	@EventHandler
	public void onKeyPressedEvent(KeyPressedEvent event) {
		Keyboard key = event.getKey();
		SpoutPlayer splayer = event.getPlayer();
		
		if(RpgEssentials.wl.worlds.get(event.getPlayer().getWorld())){
			
			String lkey = Configuration.config.getString("Key").toUpperCase();
			if(key.toString().equals("KEY_" + lkey) && splayer.getActiveScreen() == ScreenType.GAME_SCREEN && Configuration.config.getBoolean("Allow key")){
				LevelGui gui = new LevelGui(plugin, null, splayer);
			}
			/*if(key.equals(Keyboard.MOUSE_RIGHT)){
				String crossbow = Ranged.getCrossbow(splayer);
				splayer.sendMessage(crossbow);
				if(Ranged.canUse(RpgEssentials.pm.getRpgPlayer(splayer.getName()), crossbow)){
					String[] bolts = Ranged.getRequiredBolts(crossbow);
					String bolt = Ranged.getBestBolt(splayer, bolts);
					splayer.sendMessage(bolt);
					if(bolt != null){
						Arrow arrow = splayer.launchProjectile(Arrow.class);
						arrow.setMetadata("Custom", new FixedMetadataValue(plugin, bolt));
						//arrow.setVelocity(new Vector(0, 0, 0));
						//set arrow options
						
						PlayerFireBoltEvent callevent = new PlayerFireBoltEvent(splayer, arrow, bolt);
						Bukkit.getServer().getPluginManager().callEvent(callevent);
					}
				}
			}*/
		}
    }
	
	/*@EventHandler
	public void onKeyReleasedEvent(KeyReleasedEvent event) {
		if(RpgEssentialsWorldListener.worlds.get(event.getPlayer().getWorld())){
			SpoutPlayer splayer = event.getPlayer();
			Keyboard key = event.getKey();
			if(key.equals(Keyboard.MOUSE_RIGHT)){
				
			}
		}
	}*/
}
