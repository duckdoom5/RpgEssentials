package me.duckdoom5.RpgEssentials.Entity;

import java.io.Serializable;

import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.util.CustomItemStack;
import me.duckdoom5.RpgEssentials.util.NpcType;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

import com.topcat.npclib.entity.HumanNPC;
import com.topcat.npclib.entity.NPC;

public class RpgNpc implements Serializable {
    private static final long serialVersionUID = -785120291989570254L;

    private NpcType type = NpcType.DEFAULT;
    private String name = "NPC";
    private String owner = "";
    private String worldname;
    private final String id;
    private double x, y, z;
    private float pitch, yaw;

    private String capeUrl, skinUrl;
    private String dialogMessage = "Hello, have a nice day!";

    private CustomItemStack inHand = new CustomItemStack(new ItemStack(
            Material.AIR, 0, (short) -1));
    private CustomItemStack helmet = new CustomItemStack(new ItemStack(
            Material.AIR, 0, (short) -1));
    private CustomItemStack chestplate = new CustomItemStack(new ItemStack(
            Material.AIR, 0, (short) -1));
    private CustomItemStack leggings = new CustomItemStack(new ItemStack(
            Material.AIR, 0, (short) -1));
    private CustomItemStack boots = new CustomItemStack(new ItemStack(
            Material.AIR, 0, (short) -1));

    public RpgNpc(NPC npc, OfflinePlayer owner) {
        id = RpgeManager.getInstance().getRpgNpcManager().getNPCManager().getNPCIdFromEntity(npc.getBukkitEntity());
        this.owner = owner.getName();
        name = getHumanNPC().getName();
        final Location l = npc.getBukkitEntity().getLocation();
        x = l.getX();
        y = l.getY();
        z = l.getZ();
        pitch = l.getPitch();
        yaw = l.getYaw();
        worldname = l.getWorld().getName();

        save();
    }

    public void initialize() {
        getHumanNPC().getInventory().setArmorContents(
                new ItemStack[] { helmet.getItemStack(),
                        chestplate.getItemStack(), leggings.getItemStack(),
                        boots.getItemStack() });
        setItemInHand(inHand.getItemStack());
        setCape(capeUrl);
        setSkin(skinUrl);
    }

    public String getDialogMessage() {
        return dialogMessage;
    }

    public void setDialogMessage(String dialogMessage) {
        this.dialogMessage = dialogMessage;
        save();
    }

    public NpcType getNpcType() {
        return type;
    }

    public void setNpcType(NpcType type) {
        this.type = type;
        save();
    }

    public ItemStack getItemInHand() {
        return inHand.getItemStack();
    }

    public void setItemInHand(ItemStack stack) {
        if (stack == null) {
            stack = new ItemStack(Material.AIR, 0, (short) -1);
        }
        inHand = new CustomItemStack(stack);
        save();
    }

    public void setArmor(int slotId, ItemStack stack) {
        if (stack == null) {
            stack = new ItemStack(Material.AIR, 0, (short) -1);
        }
        switch (slotId) {
            case 0:
                helmet = new CustomItemStack(stack);
                break;
            case 1:
                chestplate = new CustomItemStack(stack);
                break;
            case 2:
                leggings = new CustomItemStack(stack);
                break;
            case 3:
                boots = new CustomItemStack(stack);
                break;
            default:
                helmet = new CustomItemStack(stack);
                break;
        }

        if (getHumanNPC() != null) {
            getHumanNPC().getInventory().setArmorContents(
                    new ItemStack[] { helmet.getItemStack(),
                            chestplate.getItemStack(), leggings.getItemStack(),
                            boots.getItemStack() });
        }
        save();
    }

    public ItemStack getArmor(int slotId) {
        switch (slotId) {
            case 0:
                return helmet.getItemStack();
            case 1:
                return chestplate.getItemStack();
            case 2:
                return leggings.getItemStack();
            case 3:
                return boots.getItemStack();
            default:
                return helmet.getItemStack();
        }
    }

    public void setSkin(String skinUrl) {
        this.skinUrl = skinUrl;
        if (skinUrl == null) {
            getHumanNPC().getSpoutPlayer().resetSkin();
        } else if (skinUrl.contains(".png")) {
            getHumanNPC().getSpoutPlayer().setSkin(skinUrl);
        }
        save();
    }

    public String getSkin() {
        return skinUrl;
    }

    public void setCape(String capeUrl) {
        this.capeUrl = capeUrl;
        if (capeUrl == null) {
            getHumanNPC().getSpoutPlayer().resetCape();
        } else if (capeUrl.contains(".png")) {
            getHumanNPC().getSpoutPlayer().setCape(capeUrl);
        }
        save();
    }

    public String getCape() {
        return capeUrl;
    }

    public void setOwner(OfflinePlayer owner) {
        this.owner = owner.getName();
        save();
    }

    public OfflinePlayer getOwner() {
        return Bukkit.getOfflinePlayer(owner);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        if (RpgeManager.getInstance().getRpgNpcManager().getNPCManager().containsNPC(id)) {
            RpgeManager.getInstance().getRpgNpcManager().getNPCManager().rename(id, name);
        }
        save();
    }

    public World getWorld() {
        return Bukkit.getWorld(worldname);
    }

    public Location getLocation() {
        return new Location(getWorld(), x, y, z, yaw, pitch);
    }

    private void setLocation(Location l) {
        x = l.getX();
        y = l.getY();
        z = l.getZ();
        pitch = l.getPitch();
        yaw = l.getYaw();
        worldname = l.getWorld().getName();
        save();
    }

    public void lookAtPoint(Location l) {

        if (getHumanNPC() != null) {
            getHumanNPC().lookAtPoint(l);
        }
        pitch = getNPC().getBukkitEntity().getLocation().getPitch();
        yaw = getNPC().getBukkitEntity().getLocation().getYaw();
    }

    public void moveTo(Location l) {
        setLocation(l);
        if (getHumanNPC() != null) {
            getHumanNPC().moveTo(l);
        }
    }

    public void walkTo(Location l) {
        setLocation(l);
        if (getHumanNPC() != null) {
            getHumanNPC().walkTo(l);
        }
    }

    public HumanNPC getHumanNPC() {
        if (RpgeManager.getInstance().getRpgNpcManager().getNPCManager().containsNPC(id)) {
            return (HumanNPC) getNPC();
        }
        return null;
    }

    public NPC getNPC() {
        return RpgeManager.getInstance().getRpgNpcManager().getNPCManager().getNPC(id);
    }

    private void save() {
        RpgeManager.getInstance().getRpgNpcManager().saveNPC(this);
    }
}
