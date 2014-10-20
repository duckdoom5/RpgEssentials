package me.duckdoom5.RpgEssentials.Entity;

import java.io.Serializable;
import java.util.HashMap;

import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.config.Config;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;
import org.getspout.spoutapi.player.accessories.AccessoryType;

public class RpgPlayer implements Serializable {
    private static final long serialVersionUID = 786344759340289923L;

    private final HashMap<AccessoryType, String> accessorys = new HashMap<>();
    private final HashMap<String, String> texturepack = new HashMap<>();
    private final String playername;
    private String title;
    private Boolean hideTitle;
    private String cape;
    private String skin;
    private double jumpMod = 1;
    private double gravityMod = 1;
    private double speed = 1;
    private double money;

    public RpgPlayer(Player player) {
        playername = player.getName();
        title = null;
        money = Configuration.config.getDouble("currency.starting money");

        for (final World world : Bukkit.getWorlds()) {
            if (texturepack.get(world.getName()) == null) {
                texturepack.put(world.getName(), "null");
            }
        }

        RpgeManager.getInstance().getRpgPlayerManager().addPlayer(playername, this);
    }

    public void initialize() {
        getSpoutPlayer().setCustomName(title);
        if (cape != null && cape.contains(".png")) {
            getSpoutPlayer().setCape(cape);
        }
        if (skin != null && skin.contains(".png")) {
            getSpoutPlayer().setSkin(skin);
        }
        if (gravityMod != 1) {
            getSpoutPlayer().setGravityMultiplier(gravityMod);
        }
        if (jumpMod != 1) {
            getSpoutPlayer().setJumpingMultiplier(jumpMod);
        }
        if (speed != 1) {
            getSpoutPlayer().setAirSpeedMultiplier(speed);
            getSpoutPlayer().setWalkingMultiplier(speed);
            getSpoutPlayer().setSwimmingMultiplier(speed);
        }

        loadTexturePack();
    }

    public String getCustomName() {
        return title;
    }

    public void setCustomName(String customName) {
        title = customName;
        getSpoutPlayer().setCustomName(title);
        save();
    }

    public void hidetitle(boolean hide) {
        hideTitle = hide;
        if (hide) {
            getSpoutPlayer().hideTitle();
        } else {
            getSpoutPlayer().resetTitle();
        }
        save();
    }

    public Boolean isHideTitle() {
        return hideTitle;
    }

    public void setCape(String url) {
        if (url != null && url.contains(".png")) {
            getSpoutPlayer().setCape(url);
            cape = url;
            save();
        }
    }

    public void removeCape() {
        getSpoutPlayer().resetCape();
        cape = null;
        save();
    }

    public String getCapeUrl() {
        return cape;
    }

    public void setSpeed(double speed) {
        getSpoutPlayer().setAirSpeedMultiplier(speed);
        getSpoutPlayer().setWalkingMultiplier(speed);
        getSpoutPlayer().setSwimmingMultiplier(speed);
        this.speed = speed;
        save();
    }

    public double getSpeed() {
        return speed;
    }

    public void setSkin(String url) {
        if (url != null && url.contains(".png")) {
            getSpoutPlayer().setSkin(url);
            skin = url;
            save();
        }
    }

    public void removeSkin() {
        getSpoutPlayer().resetSkin();
        skin = null;
    }

    public String getSkinUrl() {
        return skin;
    }

    public void setJump(double height) {
        jumpMod = height;
        getSpoutPlayer().setJumpingMultiplier(height);
        save();
    }

    public double getJump() {
        return jumpMod;
    }

    public void setGravity(double gravity) {
        gravityMod = gravity;
        getSpoutPlayer().setGravityMultiplier(gravity);
        save();
    }

    public double getGravity() {
        return gravityMod;
    }

    public void addAccessory(AccessoryType type, String url) {
        if (url != null && url.contains(".png")) {
            accessorys.put(type, url);
            getSpoutPlayer().addAccessory(type, url);
            save();
        }
    }

    public void removeAccessory(AccessoryType type) {
        accessorys.remove(type);
        getSpoutPlayer().removeAccessory(type);
        save();
    }

    public String getAccessoryUrl(AccessoryType type) {
        return accessorys.get(type);
    }

    public double getMoney() {
        if (Config.economy != null)
            return Config.economy.getBalance(playername);
        return money;
    }

    public void setMoney(double m) {
        if (Config.economy == null) {
            money = m;
            save();
        } else {
            final double newm = m - getMoney();
            if (m < getMoney())
                Config.economy.withdrawPlayer(playername, Math.abs(newm));
            else
                Config.economy.depositPlayer(playername, newm);
        }
    }

    public OfflinePlayer getPlayer() {
        return Bukkit.getOfflinePlayer(playername);
    }

    public SpoutPlayer getSpoutPlayer() {
        if (getPlayer().isOnline()) {
            return SpoutManager.getPlayer((Player) getPlayer());
        }
        return null;
    }

    public String getName() {
        return playername;
    }

    public String getTexturepack(World world) {
        return texturepack.get(world.getName());
    }

    public void setTexturepack(World world, String texturepack) {
        this.texturepack.put(world.getName(), texturepack);
        loadTexturePack();
        save();
    }

    private void loadTexturePack() {
        if (getPlayer().isOnline()) {
            final String url = texturepack.get(getPlayer().getPlayer().getWorld());
            if (url != null && url.contains(".zip")) {
                getSpoutPlayer().setTexturePack(url);
            }
        }
    }

    private void save() {
        RpgeManager.getInstance().getRpgPlayerManager().savePlayer(this);
    }
}
