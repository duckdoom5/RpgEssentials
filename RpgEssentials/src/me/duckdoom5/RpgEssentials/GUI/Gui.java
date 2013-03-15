package me.duckdoom5.RpgEssentials.GUI;

import org.getspout.spoutapi.gui.GenericPopup;

public abstract class Gui {
	public abstract GenericPopup getPopup();
	
	public abstract void nextPage();
	
	public abstract void prevPage();
	
	public abstract Integer getPage();
	
	public abstract void back();
	
	public void save() {
	}
}
