package me.duckdoom5.RpgEssentials.RpgLeveling.Levels;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgLeveling.Config.RpgPlayerLevelManager;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.getspout.spoutapi.material.item.GenericCustomItem;

public class Fishing extends Skill {
    public static Fishing instance;
    
    static {
        instance = new Fishing();
    }
    
    public int getExp(PlayerFishEvent event) {
        if (isEnabled(SkillType.FISHING)) {
            final Player player = event.getPlayer();
            final State state = event.getState();
            final Set<GenericCustomItem> fishes = new LinkedHashSet<>();
            final Random rand = new Random();

            if (state == State.CAUGHT_FISH) {

                final int currentlevel = RpgPlayerLevelManager.getInstance().getRpgPlayerLevel(player.getName()).getLvl(SkillType.FISHING);

                // custom fish
                final Entity entity = event.getCaught();
                if (entity.getType().equals(EntityType.DROPPED_ITEM)) {
                    final Item item = (Item) entity;

                    final int customchance = me.duckdoom5.RpgEssentials.config.Configuration.config.getInt("custom fish chance");
                    if (rand.nextInt(100) < customchance) {
                        for (final GenericCustomItem f : RpgeManager.getInstance().getMaterialManager().getFish()) {
                            final int level = me.duckdoom5.RpgEssentials.config.Configuration.items.getInt("Custom Fish." + f.getName() + ".level");
                            if (level <= currentlevel) {
                                fishes.add(f);
                            }
                        }
                        for (final GenericCustomItem f : fishes) {
                            final int chance = me.duckdoom5.RpgEssentials.config.Configuration.items.getInt("Custom Fish." + f.getName() + ".chance");
                            if (rand.nextInt(100) < chance) {
                                item.getItemStack().setType(Material.FLINT);
                                item.getItemStack().setDurability((short) f.getCustomId());
                                return me.duckdoom5.RpgEssentials.config.Configuration.items.getInt("Custom Fish." + f.getName() + ".xp");
                            }
                        }
                    }
                    return Configuration.level.getInt("Exp.fishing.caught");
                }
            }
        }
        return 0;
    }

    @Override
    public Material getIcon() {
        return Material.FISHING_ROD;
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.FISHING;
    }
}
