package me.duckdoom5.RpgEssentials.Listeners;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.GUI.LevelMenu;

import org.getspout.spoutapi.event.input.InputListener;
import org.getspout.spoutapi.event.input.KeyPressedEvent;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.keyboard.Keyboard;
import org.getspout.spoutapi.player.SpoutPlayer;

public class RpgEssentialsInputListener extends InputListener{
	public static RpgEssentials plugin;
	public static Keyboard key;
	
	public RpgEssentialsInputListener(RpgEssentials instance) {
		this.plugin = instance;
	}

	@Override
    public void onKeyPressedEvent(KeyPressedEvent event) {
		SpoutPlayer splayer = event.getPlayer();
		Keyboard key = event.getKey();
		if(key.equals(Keyboard.KEY_L) && splayer.getActiveScreen() != ScreenType.CHAT_SCREEN){
			LevelMenu.open(plugin, splayer);
		}
    }
}
