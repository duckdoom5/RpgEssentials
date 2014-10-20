package me.duckdoom5.RpgEssentials.Listeners;

import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.Entity.RpgNpc;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.GUI.SpawnerWandGui;
import me.duckdoom5.RpgEssentials.GUI.TextSelectMenu;
import me.duckdoom5.RpgEssentials.RpgBanks.RpgBanks;
import me.duckdoom5.RpgEssentials.RpgBanks.Config.RpgBankManager;
import me.duckdoom5.RpgEssentials.RpgStores.RpgStores;
import me.duckdoom5.RpgEssentials.RpgStores.GUI.StoreSelectGui;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.handelers.Music;
import me.duckdoom5.RpgEssentials.util.AddonType;
import me.duckdoom5.RpgEssentials.util.MessageUtils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class RpgEssentialsPlayerListener implements Listener {
    public RpgEssentials plugin;
    public static boolean warnOp = false;

    public RpgEssentialsPlayerListener(RpgEssentials instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        final Player player = event.getEntity();
        // if(RpgEssentials.wl.worlds.get(player.getWorld())){
        Music.forceStopBattle(plugin, SpoutManager.getPlayer(player));
        // }
    }

    /*
     * @EventHandler public void onPlayerMove(PlayerMoveEvent event) {
     * if(event.getTo().getBlock().isLiquid()){ Player player =
     * event.getPlayer();
     * player.sendMessage("Your are not allowed to swim, get out now!");
     * player.setHealth(player.getHealth - 1); } }
     */

    @SuppressWarnings ("unused")
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        // if(RpgEssentials.wl.worlds.get(player.getWorld())){
        final Block block = event.getClickedBlock();
        final Action action = event.getAction();
        final ItemStack inhand = player.getItemInHand();
        if (action == Action.RIGHT_CLICK_BLOCK) {
            /*
             * if(block.getType().equals(Material.SNOW)){ SNOW WAND SHOULD NOW
             * BE HANDELD BY MINECRAFT IT SELF RIGHT? if(inhand.getDurability()
             * == RpgeManager.getInstance().getMaterialManager().getItemByName(
             * "Snow Wand").getCustomId()){ Byte data = block.getData();
             * block.setData((byte) (data + 1)); } }
             */
            if (block.getType().equals(Material.MOB_SPAWNER)) {
                if (inhand.getDurability() == RpgeManager.getInstance().getMaterialManager().getItemByName("Spawner Wand").getCustomId()) {
                    final CreatureSpawner spawner = (CreatureSpawner) block.getState();
                    new SpawnerWandGui(plugin, (SpoutPlayer) player, spawner);
                }
            }
        }
        // }
    }

    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event) {
        final Player player = event.getPlayer();
        final SpoutPlayer splayer = SpoutManager.getPlayer(player);
        final ItemStack pickedup = event.getItem().getItemStack();
        final int amount = pickedup.getAmount();
        final double money = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).getMoney();

        if (pickedup.getDurability() == RpgeManager.getInstance().getMaterialManager().getItemByName("Bronze Coin").getCustomId()) {
            RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).setMoney(
                            money + (Configuration.config.getInt("currency.bronze value") * amount));
            event.getItem().teleport(player.getLocation());
            SpoutManager.getSoundManager().playCustomSoundEffect(
                            plugin,
                            splayer, "http://dl.lynxdragon.com/rpgessentials/music/getmoney.wav",
                            false, splayer.getLocation(), 0, 100);
            event.getItem().remove();
            event.setCancelled(true);
        } else if (pickedup.getDurability() == RpgeManager.getInstance().getMaterialManager().getItemByName("Silver Coin").getCustomId()) {
            RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).setMoney(
                            money + (Configuration.config.getInt("currency.silver value") * amount));
            event.getItem().teleport(player.getLocation());
            SpoutManager.getSoundManager().playCustomSoundEffect(
                            plugin,
                            splayer, "http://dl.lynxdragon.com/rpgessentials/music/getmoney.wav",
                            false, splayer.getLocation(), 0, 100);
            event.getItem().remove();
            event.setCancelled(true);
        } else if (pickedup.getDurability() == RpgeManager.getInstance().getMaterialManager().getItemByName("Gold Coin").getCustomId()) {
            RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(splayer).setMoney(
                            money + (Configuration.config.getInt("currency.gold value") * amount));
            event.getItem().teleport(player.getLocation());
            SpoutManager.getSoundManager().playCustomSoundEffect(
                            plugin,
                            splayer, "http://dl.lynxdragon.com/rpgessentials/music/getmoney.wav",
                            false, splayer.getLocation(), 0, 100);
            event.getItem().remove();
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        final ItemStack droped = event.getItemDrop().getItemStack();

        if (droped.getDurability() == RpgeManager.getInstance().getMaterialManager().getItemByName("Bronze Coin").getCustomId()) {
            event.getItemDrop().remove();
            event.setCancelled(true);
            return;
        } else if (droped.getDurability() == RpgeManager.getInstance().getMaterialManager().getItemByName("Silver Coin").getCustomId()) {
            event.getItemDrop().remove();
            event.setCancelled(true);
            return;
        } else if (droped.getDurability() == RpgeManager.getInstance().getMaterialManager().getItemByName("Gold Coin").getCustomId()) {
            event.getItemDrop().remove();
            event.setCancelled(true);
            return;
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        RpgPlayer rpgplayer;

        if (RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player) == null) {
            RpgEssentials.getLog().info(player.getName());
            rpgplayer = new RpgPlayer(player);
            RpgeManager.getInstance().getRpgPlayerManager().addPlayer(player.getName(), rpgplayer);
        } else {
            rpgplayer = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player);
        }

        if (warnOp) {
            if (player.isOp()) {
                player.sendMessage(ChatColor.YELLOW + "**ALERT** " + ChatColor.GREEN + "There is a new version of RpgEssentials available!");
            }
        }

        if (Configuration.config.getBoolean("spout.join.enabled")) {
            Player onplayer[];
            final int j = (onplayer = plugin.getServer().getOnlinePlayers()).length;
            for (int i = 0; i < j; i++) {
                final Player joining = onplayer[i];
                final SpoutPlayer sPlayer = SpoutManager.getPlayer(joining);
                if (player.getName().length() <= 26) {
                    sPlayer.sendNotification(player.getName(), "has joined the game", Material.getMaterial(Configuration.config.getInt("spout.join.messageicon")));
                }
            }
        }

        /*
         * //load title + color
         * if(Configuration.modules.getBoolean("Modules.colored names")){
         * SpoutPlayer[] onplayers = Spout.getServer().getOnlinePlayers();
         * for(int i = 0; i < onplayers.length; i++){ SpoutPlayer on =
         * onplayers[i]; RpgPlayer otherrpgplayer =
         * RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(on);
         * 
         * int combatlvl = rpgplayer.getLvl(Skill.COMBAT); int combatlvlother =
         * otherrpgplayer.getLvl(Skill.COMBAT);
         * 
         * if(combatlvl > combatlvlother){ if(combatlvl - combatlvlother <= 5){
         * colorme = ChatColor.RED; colorother = ChatColor.GREEN; }else{ colorme
         * = ChatColor.DARK_RED; colorother = ChatColor.DARK_GREEN; } }else
         * if(combatlvl < combatlvlother){ if(combatlvlother - combatlvl <= 5){
         * colorme = ChatColor.GREEN; colorother = ChatColor.RED; }else{ colorme
         * = ChatColor.DARK_GREEN; colorother = ChatColor.DARK_RED; } }else
         * if(combatlvl == combatlvlother){ colorme = ChatColor.YELLOW;
         * colorother = ChatColor.YELLOW; } splayer.setTitleFor(on, colorme +
         * rpgplayer.getTitle() + " [lvl: " + combatlvl + "]");
         * 
         * onplayers[i].setTitleFor(splayer, colorother +
         * otherrpgplayer.getTitle() + " [lvl: " + combatlvlother + "]"); } }
         */

        /*
         * for(RpgEntityType type: RpgEntityType.values()){
         * if(Configuration.pets.contains(type.toString().toLowerCase())){
         * ConfigurationSection section =
         * Configuration.pets.getConfigurationSection
         * (type.toString().toLowerCase()); Iterator<?> keys =
         * section.getKeys(false).iterator(); while(keys.hasNext()){
         * ConfigurationSection section2 =
         * Configuration.pets.getConfigurationSection((String) keys.next());
         * Iterator<?> keys2 = section.getKeys(false).iterator(); OfflinePlayer
         * owner = Bukkit.getServer().getOfflinePlayer((String) keys2.next());
         * if(owner.getName().equals(player.getName())){ int id = 0;
         * 
         * for(id = 0; Configuration.pets.contains("wolf." + player.getName() +
         * "." + id + ".name"); id++){ World world =
         * Bukkit.getWorld(Configuration.pets.getString("wolf." +
         * player.getName() + "." + id + ".world")); org.bukkit.util.Vector
         * vector = Configuration.pets.getVector("wolf." + player.getName() +
         * "." + id + ".location.vector"); int pitch =
         * Configuration.pets.getInt("wolf." + player.getName() + "." + id +
         * ".location.pitch"); int yaw = Configuration.pets.getInt("wolf." +
         * player.getName() + "." + id + ".location.yaw"); Location location =
         * vector.toLocation(world, yaw, pitch);
         * 
         * Wolf wolf = (Wolf) world.spawnEntity(location, EntityType.WOLF);
         * 
         * RpgWolf rwolf = new RpgWolf(player, wolf, id, location); } } } }else{
         * RpgEssentials.getLog().warning("Pets doesn't contain: " +
         * type.toString().toLowerCase()); } }
         */
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        // RpgEssentials.pm.removePlayer(player);
        RpgeManager.getInstance().getRpgPlayerManager().savePlayer(player);
        Player onplayer[];
        final int j = (onplayer = plugin.getServer().getOnlinePlayers()).length;
        for (int i = 0; i < j; i++) {
            final Player leaving = onplayer[i];
            final SpoutPlayer sPlayer = SpoutManager.getPlayer(leaving);
            if (player.getName().length() > 26) {
                RpgEssentials.getLog().info(ChatColor.RED + "Player name is too long");
            } else {
                sPlayer.sendNotification(player.getName(), "has left the game",
                        Material.getMaterial(Configuration.config.getInt("spout.leave.messageicon")));
            }
        }

        // RpgPlayerManager.removePet(player);
    }

    @SuppressWarnings ("unused")
    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event)
            throws IOException {
        // if(RpgEssentials.wl.worlds.get(event.getPlayer().getWorld())){
        final Entity clicked = event.getRightClicked();
        final Player player = event.getPlayer();
        final RpgPlayer rpgplayer = RpgeManager.getInstance().getRpgPlayerManager().getRpgPlayer(player);
        final SpoutPlayer splayer = SpoutManager.getPlayer(player);
        final ItemStack inhand = player.getItemInHand();

        if (RpgeManager.getInstance().getRpgNpcManager().getNPCManager().isNPC(clicked)) {
            final String id = RpgeManager.getInstance().getRpgNpcManager().getNPCManager().getNPCIdFromEntity(clicked);

            final RpgNpc rnpc = RpgeManager.getInstance().getRpgNpcManager().getRpgNpc(id);

            if (inhand.getDurability() == RpgeManager.getInstance().getMaterialManager().getItemByName("NPC Wand").getCustomId()) {
                rnpc.lookAtPoint(player.getEyeLocation());
                RpgeManager.getInstance().getRpgNpcManager().select(player, id);
            } else {
                rnpc.lookAtPoint(player.getEyeLocation());

                switch (rnpc.getNpcType()) {
                    case DEFAULT:
                        new TextSelectMenu(plugin, splayer, "Hello",
                                MessageUtils.TextMenuSplit(rnpc.getDialogMessage()),
                                new String[] { "Close" });
                        break;
                    case BANKER:
                        if (RpgeManager.getInstance().isAddonEnabled(AddonType.BANKS)) {
                            RpgBankManager.getInstance().getBank(splayer.getName()).clicked(
                                            (RpgBanks) RpgeManager.getInstance().getAddon(
                                                            "RpgBanks"));
                        } else {
                            player.sendMessage(ChatColor.RED + "RpgBank plugin is not enabled!");
                        }
                        break;
                    case MERCHANT:
                        if (RpgeManager.getInstance().isAddonEnabled(AddonType.STORES)) {
                            final StoreSelectGui gui = new StoreSelectGui(
                                    (RpgStores) RpgeManager.getInstance().getAddon("RpgStores"), splayer,
                                    rnpc.getName());
                        } else {
                            player.sendMessage(ChatColor.RED + "RpgStores plugin is not enabled!");
                        }
                        break;
                    case QUESTER:
                        // RpgQuests.qh.npcRightClicked(np, rpgplayer);
                        break;
                    default:
                        break;
                }
            }
        }/*
          * else if(RpgPlayerManager.isRpgEntity(clicked)){ RpgWolf rpgwolf =
          * (RpgWolf) RpgPlayerManager.getRpgEntity(clicked);
          * if(inhand.getType().equals(Material.INK_SACK)){
          * rpgwolf.setBeltColor(
          * RpgWolf.BeltColor.getBeltColor(Methods.getInkColor
          * (inhand.getDurability())));
          * if(player.getGameMode().equals(GameMode.SURVIVAL)){
          * if(inhand.getAmount() > 1){ inhand.setAmount(inhand.getAmount()- 1);
          * }else{ player.getInventory().remove(inhand); } }
          * event.setCancelled(true); } }else if(inhand.getDurability() ==
          * RpgEssentials.mm.getItemByName("Pet Wand").getCustomId()){
          * if(clicked instanceof Wolf){ Wolf wolf = (Wolf)clicked;
          * if(wolf.isTamed() && wolf.getOwner().equals(player)){ int id = 0;
          * for(id = 0; Configuration.pets.contains("wolf." + player.getName() +
          * "." + id + ".name"); id++); RpgWolf rpgwolf = new RpgWolf(player,
          * wolf, id); event.setCancelled(true); } } }
          */
        // }
    }
}
