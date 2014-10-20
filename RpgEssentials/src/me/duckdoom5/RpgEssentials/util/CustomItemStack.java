package me.duckdoom5.RpgEssentials.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItemStack implements Serializable {
    private static final long serialVersionUID = 4591970773275136800L;

    private final int amount;
    private final short durability;
    private final String material;
    private Map<String, Object> meta;

    public CustomItemStack(ItemStack stack) {
        amount = stack.getAmount();
        durability = stack.getDurability();
        material = stack.getType().name();
        if (stack.hasItemMeta()) {
            meta = getNewMap(((ConfigurationSerializable) stack.getItemMeta()).serialize());
        }
    }

    public ItemStack getItemStack() {

        final ItemStack i = new ItemStack(Material.getMaterial(material));
        i.setAmount(amount);
        i.setDurability(durability);

        if (meta != null && !meta.isEmpty()) {
            i.setItemMeta((ItemMeta) ConfigurationSerialization.deserializeObject(meta, ConfigurationSerialization.getClassByAlias("ItemMeta")));
        }

        return i;
    }

    @SuppressWarnings ("unchecked")
    private Map<String, Object> getNewMap(Map<String, Object> map) {
        final Map<String, Object> newMap = new HashMap<>();

        if (!map.isEmpty()) {
            for (final String x : map.keySet()) {
                Object value = map.get(x);
                if (value instanceof Map) {
                    value = getNewMap((Map<String, Object>) value);
                }
                newMap.put(new String(x), value);
            }
        }

        return newMap;
    }
}
