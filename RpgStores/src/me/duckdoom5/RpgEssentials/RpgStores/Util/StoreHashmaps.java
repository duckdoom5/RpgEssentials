package me.duckdoom5.RpgEssentials.RpgStores.Util;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.RpgStores.RpgStores;
import me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgStores.Config.StoreConfig;
import me.duckdoom5.RpgEssentials.RpgStores.Config.StoreConfig.StoreValue;
import me.duckdoom5.RpgEssentials.RpgStores.GUI.CustomStoreGui;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.material.item.GenericCustomItem;
import org.getspout.spoutapi.player.SpoutPlayer;

public class StoreHashmaps {
    // all
    public static Set<Material> custom = new LinkedHashSet<>();
    public static Set<org.getspout.spoutapi.material.Material> customcustom = new LinkedHashSet<>();

    public static Set<Material> food = new LinkedHashSet<>();
    public static Set<Material> tools = new LinkedHashSet<>();
    public static Set<Material> armor = new LinkedHashSet<>();
    public static Set<Material> mechanisms = new LinkedHashSet<>();
    public static Set<Material> gardening = new LinkedHashSet<>();
    public static Set<Material> furniture = new LinkedHashSet<>();
    public static Set<Material> materials = new LinkedHashSet<>();
    public static Set<Material> rawmaterials = new LinkedHashSet<>();
    public static Set<Material> theend = new LinkedHashSet<>();
    public static Set<Material> ores = new LinkedHashSet<>();
    public static Set<Material> mobdrops = new LinkedHashSet<>();
    public static Set<Material> brewing = new LinkedHashSet<>();
    public static Set<Material> painting = new LinkedHashSet<>();
    public static Set<Material> nether = new LinkedHashSet<>();
    public static Set<Material> music = new LinkedHashSet<>();
    public static Set<Material> misc = new LinkedHashSet<>();

    public static Set<org.getspout.spoutapi.material.Material> customfood = new LinkedHashSet<>();
    public static Set<org.getspout.spoutapi.material.Material> customtools = new LinkedHashSet<>();
    public static Set<org.getspout.spoutapi.material.Material> customarmor = new LinkedHashSet<>();
    public static Set<org.getspout.spoutapi.material.Material> custommechanisms = new LinkedHashSet<>();
    public static Set<org.getspout.spoutapi.material.Material> customgardening = new LinkedHashSet<>();
    public static Set<org.getspout.spoutapi.material.Material> customfurniture = new LinkedHashSet<>();
    public static Set<org.getspout.spoutapi.material.Material> custommaterials = new LinkedHashSet<>();
    public static Set<org.getspout.spoutapi.material.Material> customrawmaterials = new LinkedHashSet<>();
    public static Set<org.getspout.spoutapi.material.Material> customtheend = new LinkedHashSet<>();
    public static Set<org.getspout.spoutapi.material.Material> customores = new LinkedHashSet<>();
    public static Set<org.getspout.spoutapi.material.Material> custommobdrops = new LinkedHashSet<>();
    public static Set<org.getspout.spoutapi.material.Material> custombrewing = new LinkedHashSet<>();
    public static Set<org.getspout.spoutapi.material.Material> custompainting = new LinkedHashSet<>();
    public static Set<org.getspout.spoutapi.material.Material> customnether = new LinkedHashSet<>();
    public static Set<org.getspout.spoutapi.material.Material> custommusic = new LinkedHashSet<>();
    public static Set<org.getspout.spoutapi.material.Material> custommisc = new LinkedHashSet<>();

    // buy
    public static Set<Material> buy = new LinkedHashSet<>();
    public static Set<Material> custombuy = new LinkedHashSet<>();

    public static Set<GenericCustomBlock> buycustomblocks = new LinkedHashSet<>();
    public static Set<GenericCustomItem> buycustomitems = new LinkedHashSet<>();

    // sell
    public static Set<Material> sell = new LinkedHashSet<>();
    public static Set<Material> customsell = new LinkedHashSet<>();

    public static Set<GenericCustomBlock> sellcustomblocks = new LinkedHashSet<>();
    public static Set<GenericCustomItem> sellcustomitems = new LinkedHashSet<>();

    public static void registerstore() {

        for (final StoreValue value : StoreValue.values()) {
            final String name = value.toString().toLowerCase().replace("_", " ");
            final String type = value.getType();
            final String type2 = value.getType2();
            final String type3 = value.getType3();
            final Material material = Material.getMaterial(value.toString());
            Set<Material> set = null;

            set = StoreType.valueOf(type.replace(" ", "_")).getType();

            if (Configuration.store.getBoolean("Store." + type + "." + name + ".Sell Able")) {
                if (!set.contains(material)) {
                    set.add(material);
                }
                sell.add(material);
            }
            if (Configuration.store.getBoolean("Store." + type + "." + name + ".Buy Able")) {
                if (!set.contains(material)) {
                    set.add(material);
                }
                buy.add(material);
            }

            if (type2 != null) {
                set = StoreType.valueOf(type2.replace(" ", "_")).getType();

                if (Configuration.store.getBoolean("Store." + type2 + "." + name + ".Sell Able")) {
                    if (!set.contains(material)) {
                        set.add(material);
                    }
                    if (!sell.contains(material)) {
                        sell.add(material);
                    }
                }
                if (Configuration.store.getBoolean("Store." + type2 + "." + name + ".Buy Able")) {
                    if (!set.contains(material)) {
                        set.add(material);
                    }
                    if (!buy.contains(material)) {
                        buy.add(material);
                    }
                }
            }

            if (type3 != null) {
                set = StoreType.valueOf(type3.replace(" ", "_")).getType();

                if (Configuration.store.getBoolean("Store." + type3 + "." + name + ".Sell Able")) {
                    if (!set.contains(material)) {
                        set.add(material);
                    }
                    if (!sell.contains(material)) {
                        sell.add(material);
                    }
                }
                if (Configuration.store.getBoolean("Store." + type3 + "." + name + ".Buy Able")) {
                    if (!set.contains(material)) {
                        set.add(material);
                    }
                    if (!buy.contains(material)) {
                        buy.add(material);
                    }
                }
            }
        }

        // custom ores
        for (final GenericCustomBlock block : RpgeManager.getInstance().getMaterialManager().getOres()) {
            if (me.duckdoom5.RpgEssentials.config.Configuration.block.getBoolean("Custom Ores." + block.getName() + ".Sell Able")) {
                customores.add(block);
                sellcustomblocks.add(block);
            }
            if (me.duckdoom5.RpgEssentials.config.Configuration.block.getBoolean("Custom Ores." + block.getName() + ".Buy Able")) {
                if (!customores.contains(block)) {
                    customores.add(block);
                }
                buycustomblocks.add(block);
            }
        }

        // custom blocks
        for (final GenericCustomBlock block : RpgeManager.getInstance().getMaterialManager().getBlocks()) {
            if (me.duckdoom5.RpgEssentials.config.Configuration.block.getBoolean("Custom Blocks." + block.getName() + ".Sell Able")) {
                CustomStoreType.valueOf(
                                me.duckdoom5.RpgEssentials.config.Configuration.block.getString(
                                                "Custom Blocks." + block.getName() + ".storetype").toUpperCase().replace(" ", "_")).getType().add(block);
                sellcustomblocks.add(block);
            }
            if (me.duckdoom5.RpgEssentials.config.Configuration.block.getBoolean("Custom Blocks." + block.getName() + ".Buy Able")) {
                if (!CustomStoreType.valueOf(
                                me.duckdoom5.RpgEssentials.config.Configuration.block.getString(
                                                "Custom Blocks." + block.getName() + ".storetype").toUpperCase().replace(" ", "_")).getType().contains(block)) {
                    CustomStoreType.valueOf(
                                    me.duckdoom5.RpgEssentials.config.Configuration.block.getString(
                                                    "Custom Blocks." + block.getName() + ".storetype").toUpperCase().replace(" ", "_")).getType().add(block);
                }
                buycustomblocks.add(block);
            }
        }

        // custom items
        for (final GenericCustomItem items : RpgeManager.getInstance().getMaterialManager().getItems()) {
            if (me.duckdoom5.RpgEssentials.config.Configuration.items.getBoolean("Custom Items." + items.getName() + ".Sell Able")) {
                CustomStoreType.valueOf(
                                me.duckdoom5.RpgEssentials.config.Configuration.items.getString(
                                                "Custom Items." + items.getName() + ".storetype").toUpperCase().replace(" ", "_")).getType().add(items);
                sellcustomitems.add(items);
            }
            if (me.duckdoom5.RpgEssentials.config.Configuration.items.getBoolean("Custom Items." + items.getName() + ".Buy Able")) {
                if (!CustomStoreType.valueOf(
                                me.duckdoom5.RpgEssentials.config.Configuration.items.getString(
                                                "Custom Items." + items.getName() + ".storetype").toUpperCase().replace(" ", "_")).getType().contains(items)) {
                    CustomStoreType.valueOf(
                                    me.duckdoom5.RpgEssentials.config.Configuration.items.getString(
                                                    "Custom Items." + items.getName() + ".storetype").toUpperCase().replace(" ", "_")).getType().add(items);
                }
                buycustomitems.add(items);
            }
        }

        // custom tools
        for (final GenericCustomItem tools : RpgeManager.getInstance().getMaterialManager().getTools()) {
            if (me.duckdoom5.RpgEssentials.config.Configuration.items.getBoolean("Custom Tools." + tools.getName() + ".Sell Able")) {
                customtools.add(tools);
                sellcustomitems.add(tools);
            }
            if (me.duckdoom5.RpgEssentials.config.Configuration.items.getBoolean("Custom Tools." + tools.getName() + ".Buy Able")) {
                if (!customtools.contains(tools)) {
                    customtools.add(tools);
                }
                buycustomitems.add(tools);
            }
        }

        // custom food
        for (final GenericCustomItem food : RpgeManager.getInstance().getMaterialManager().getFood()) {
            final String type = StoreConfig.custommaterials.get(food.getName());
            if (me.duckdoom5.RpgEssentials.config.Configuration.items.getBoolean("Custom " + type + "." + food.getName() + ".Sell Able")) {
                customfood.add(food);
                sellcustomitems.add(food);
            }
            if (me.duckdoom5.RpgEssentials.config.Configuration.items.getBoolean("Custom " + type + "." + food.getName() + ".Buy Able")) {
                if (!customfood.contains(food)) {
                    customfood.add(food);
                }
                buycustomitems.add(food);
            }
        }
    }

    public static void registerCustomStore(RpgStores plugin,
            SpoutPlayer splayer, String type) {
        custom.clear();
        custombuy.clear();
        customsell.clear();
        final ConfigurationSection section = Configuration.customstores.getConfigurationSection(type);
        final Iterator<?> keys = section.getKeys(false).iterator();
        while (keys.hasNext()) {
            try {
                final Material m = Material.getMaterial(Integer.parseInt((String) keys.next()));

                if (Configuration.customstores.getBoolean(type + "." + m.getId() + ".Sell Able")) {
                    custom.add(m);
                    customsell.add(m);
                }
                if (Configuration.customstores.getBoolean(type + "." + m.getId() + ".Buy Able")) {
                    if (!custom.contains(m)) {
                        custom.add(m);
                    }
                    custombuy.add(m);
                }
            } catch (final NumberFormatException e) {
            }
        }
        new CustomStoreGui(plugin, splayer, type);
    }

    public static enum CustomStoreType {
        FOOD(customfood), TOOLS(customtools), ARMOR(customarmor), MECHANISMS(
                custommechanisms), GARDENING(customgardening), FURNITURE(
                customfurniture), MATERIALS(custommaterials), RAW_MATERIALS(
                customrawmaterials), THE_END(customtheend), ORES(customores), MOB_DROPS(
                custommobdrops), BREWING(custombrewing), PAINTING(
                custompainting), NETHER(customnether), MUSIC(custommusic), MISCELLANEOUS(
                custommisc);

        private final Set<org.getspout.spoutapi.material.Material> map;

        CustomStoreType(Set<org.getspout.spoutapi.material.Material> map) {
            this.map = map;
        }

        public Set<org.getspout.spoutapi.material.Material> getType() {
            return map;
        }
    }

    public static enum StoreType {
        Food(food), Tools(tools), Armor(armor), Mechanisms(mechanisms), Gardening(
                gardening), Furniture(furniture), Materials(materials), Raw_Materials(
                rawmaterials), The_End(theend), Ores(ores), Mob_Drops(mobdrops), Brewing(
                brewing), Painting(painting), Nether(nether), Music(music), Miscellaneous(
                misc);

        private final Set<Material> map;

        StoreType(Set<Material> map) {
            this.map = map;
        }

        public Set<Material> getType() {
            return map;
        }
    }
}
