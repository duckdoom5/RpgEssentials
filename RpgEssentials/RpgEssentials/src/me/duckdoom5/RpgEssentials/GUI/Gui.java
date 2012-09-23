package me.duckdoom5.RpgEssentials.GUI;

import org.getspout.spoutapi.gui.GenericPopup;

public interface Gui {
	public GenericPopup getPopup();
	
	public void nextPage();
	
	public void prevPage();
	
	public Integer getPage();
	
	public void back();
	
	public void save();
}
