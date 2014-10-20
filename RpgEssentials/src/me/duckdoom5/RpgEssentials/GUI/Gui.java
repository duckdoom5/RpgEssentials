package me.duckdoom5.RpgEssentials.GUI;

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.player.SpoutPlayer;

public abstract class Gui {
    protected Plugin plugin;
    protected SpoutPlayer splayer;
    protected GenericPopup popup;
    protected int page = 0, maxPage = 1;

    public Gui(Plugin plugin, SpoutPlayer splayer) {
        this.plugin = plugin;
        this.splayer = splayer;
    }

    protected abstract void createPopup(boolean attach, boolean remove);

    public void nextPage() {
        popup.removeWidgets(plugin);
        page++;
        if (page > maxPage) {
            page = maxPage;
        }
        createPopup(false, true);
    }

    public void prevPage() {
        popup.removeWidgets(plugin);
        page--;
        if (page < 0) {
            page = 0;
        }
        createPopup(false, true);
    }

    public int getPage() {
        return page;
    }

    public void back() {
    }

    public void save() {
    }

    public GenericPopup getPopup() {
        return popup;
    }
}
