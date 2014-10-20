package me.duckdoom5.RpgEssentials.RpgEntities.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.bukkit.entity.EntityType;

import me.duckdoom5.RpgEssentials.RpgEntities.entities.BatRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.BlazeRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.CaveSpiderRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.ChickenRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.CowRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.CreeperRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.EnderDragonRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.EndermanRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.GhastRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.GiantRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.HorseRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.IronGolemRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.MagmaCubeRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.MushroomCowRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.OcelotRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.PigRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.PigZombieRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.SheepRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.SilverfishRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.SkeletonRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.SlimeRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.SnowmanRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.SpiderRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.SquidRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.VillagerRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.WitchRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.WitherRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.WolfRpg;
import me.duckdoom5.RpgEssentials.RpgEntities.entities.ZombieRpg;
import net.minecraft.server.v1_6_R3.BiomeBase;
import net.minecraft.server.v1_6_R3.BiomeMeta;
import net.minecraft.server.v1_6_R3.EntityBat;
import net.minecraft.server.v1_6_R3.EntityBlaze;
import net.minecraft.server.v1_6_R3.EntityCaveSpider;
import net.minecraft.server.v1_6_R3.EntityChicken;
import net.minecraft.server.v1_6_R3.EntityCow;
import net.minecraft.server.v1_6_R3.EntityCreeper;
import net.minecraft.server.v1_6_R3.EntityEnderDragon;
import net.minecraft.server.v1_6_R3.EntityEnderman;
import net.minecraft.server.v1_6_R3.EntityGhast;
import net.minecraft.server.v1_6_R3.EntityGiantZombie;
import net.minecraft.server.v1_6_R3.EntityHorse;
import net.minecraft.server.v1_6_R3.EntityInsentient;
import net.minecraft.server.v1_6_R3.EntityIronGolem;
import net.minecraft.server.v1_6_R3.EntityMagmaCube;
import net.minecraft.server.v1_6_R3.EntityMushroomCow;
import net.minecraft.server.v1_6_R3.EntityOcelot;
import net.minecraft.server.v1_6_R3.EntityPig;
import net.minecraft.server.v1_6_R3.EntityPigZombie;
import net.minecraft.server.v1_6_R3.EntitySheep;
import net.minecraft.server.v1_6_R3.EntitySilverfish;
import net.minecraft.server.v1_6_R3.EntitySkeleton;
import net.minecraft.server.v1_6_R3.EntitySlime;
import net.minecraft.server.v1_6_R3.EntitySnowman;
import net.minecraft.server.v1_6_R3.EntitySpider;
import net.minecraft.server.v1_6_R3.EntitySquid;
import net.minecraft.server.v1_6_R3.EntityTypes;
import net.minecraft.server.v1_6_R3.EntityVillager;
import net.minecraft.server.v1_6_R3.EntityWitch;
import net.minecraft.server.v1_6_R3.EntityWither;
import net.minecraft.server.v1_6_R3.EntityWolf;
import net.minecraft.server.v1_6_R3.EntityZombie;

public enum CustomEntityType {
    CREEPER("Creeper", 50, EntityType.CREEPER, EntityCreeper.class, CreeperRpg.class),
    SKELETON("Skeleton", 51, EntityType.SKELETON, EntitySkeleton.class, SkeletonRpg.class),
    SPIDER("Spider", 52, EntityType.SPIDER, EntitySpider.class, SpiderRpg.class),
    GIANT("Giant", 53, EntityType.GIANT, EntityGiantZombie.class, GiantRpg.class),
    ZOMBIE("Zombie", 54, EntityType.ZOMBIE, EntityZombie.class, ZombieRpg.class),
    SLIME("Slime", 55, EntityType.SLIME, EntitySlime.class, SlimeRpg.class),
    GHAST("Ghast", 56, EntityType.GHAST, EntityGhast.class, GhastRpg.class),
    PIG_ZOMBIE("PigZombie", 57, EntityType.PIG_ZOMBIE, EntityPigZombie.class, PigZombieRpg.class),
    ENDERMAN("Enderman", 58, EntityType.ENDERMAN, EntityEnderman.class, EndermanRpg.class),
    CAVE_SPIDER("CaveSpider", 59, EntityType.CAVE_SPIDER, EntityCaveSpider.class, CaveSpiderRpg.class),
    SILVERFISH("Silverfish", 60, EntityType.SILVERFISH, EntitySilverfish.class, SilverfishRpg.class),
    BLAZE("Blaze", 61, EntityType.BLAZE, EntityBlaze.class, BlazeRpg.class),
    MAGMA_CUBE("LavaSlime", 62, EntityType.MAGMA_CUBE, EntityMagmaCube.class, MagmaCubeRpg.class),
    ENDER_DRAGON("EnderDragon", 63, EntityType.ENDER_DRAGON, EntityEnderDragon.class, EnderDragonRpg.class),
    WITHER("WitherBoss", 64, EntityType.WITHER, EntityWither.class, WitherRpg.class),
    BAT("Bat", 65, EntityType.BAT, EntityBat.class, BatRpg.class),
    WITCH("Witch", 66, EntityType.WITCH, EntityWitch.class, WitchRpg.class),
    PIG("Pig", 90, EntityType.PIG, EntityPig.class, PigRpg.class),
    SHEEP("Sheep", 91, EntityType.SHEEP, EntitySheep.class, SheepRpg.class),
    COW("Cow", 92, EntityType.COW, EntityCow.class, CowRpg.class),
    CHICKEN("Chicken", 93, EntityType.CHICKEN, EntityChicken.class, ChickenRpg.class),
    SQUID("Squid", 94, EntityType.SQUID, EntitySquid.class, SquidRpg.class),
    WOLF("Wolf", 95, EntityType.WOLF, EntityWolf.class, WolfRpg.class),
    MUSHROOM_COW("MushroomCow", 96, EntityType.MUSHROOM_COW, EntityMushroomCow.class, MushroomCowRpg.class),
    SNOWMAN("SnowMan", 97, EntityType.SNOWMAN, EntitySnowman.class, SnowmanRpg.class),
    OCELOT("Ozelot", 98, EntityType.OCELOT, EntityOcelot.class, OcelotRpg.class),
    IRON_GOLEM("VillagerGolem", 99, EntityType.IRON_GOLEM, EntityIronGolem.class, IronGolemRpg.class),
    HORSE("EntityHorse", 100, EntityType.HORSE, EntityHorse.class, HorseRpg.class),
    VILLAGER("Villager", 120, EntityType.VILLAGER, EntityVillager.class, VillagerRpg.class);
    
    private String name;
    private int id;
    private EntityType entityType;
    private Class<? extends EntityInsentient> nmsClass;
    private Class<? extends EntityInsentient> customClass;
     
    private CustomEntityType(String name, int id, EntityType entityType, Class<? extends EntityInsentient> nmsClass, Class<? extends EntityInsentient> customClass) {
        this.name = name;
        this.id = id;
        this.entityType = entityType;
        this.nmsClass = nmsClass;
        this.customClass = customClass;
    }
     
    public String getName() {
        return name;
    }
     
    public int getID() {
        return id;
    }
     
    public EntityType getEntityType() {
        return entityType;
    }
     
    public Class<? extends EntityInsentient> getNMSClass() {
        return nmsClass;
    }
     
    public Class<? extends EntityInsentient> getCustomClass() {
        return customClass;
    }
     
    /**
    * Register our entities.
    */
    public static void registerEntities() {
        for (CustomEntityType entity : values()){
            a(entity.getCustomClass(), entity.getName(), entity.getID());
        }
        
        // BiomeBase#biomes became private.
        BiomeBase[] biomes;
        try {
            biomes = (BiomeBase[]) getPrivateStatic(BiomeBase.class, "biomes");
        } catch (Exception exc) {
            return;
        }
        
        for (BiomeBase biomeBase : biomes) {
            if (biomeBase == null){
                break;
            }
            // This changed names from J, K, L and M.
            for (String field : new String[] { "J", "K", "L", "M" }){
                try {
                    Field list = BiomeBase.class.getDeclaredField(field);
                    list.setAccessible(true);
                    @SuppressWarnings("unchecked")
                    List<BiomeMeta> mobList = (List<BiomeMeta>) list.get(biomeBase);
                     
                    // Write in our custom class.
                    for (BiomeMeta meta : mobList){
                        for (CustomEntityType entity : values()){
                            if (entity.getNMSClass().equals(meta.b)){
                                meta.b = entity.getCustomClass();
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
     
    /**
    * Unregister our entities to prevent memory leaks. Call on disable.
    */
    public static void unregisterEntities() {
        for (CustomEntityType entity : values()) {
            // Remove our class references.
            try {
                ((Map) getPrivateStatic(EntityTypes.class, "d")).remove(entity.getCustomClass());
            } catch (Exception e) {
                e.printStackTrace();
            }
         
            try {
                ((Map) getPrivateStatic(EntityTypes.class, "f")).remove(entity.getCustomClass());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
     
        for (CustomEntityType entity : values())
            try {
                // Unregister each entity by writing the NMS back in place of the custom class.
                a(entity.getNMSClass(), entity.getName(), entity.getID());
            } catch (Exception e) {
                e.printStackTrace();
            }
     
        // Biomes#biomes was made private so use reflection to get it.
        BiomeBase[] biomes;
        try {
            biomes = (BiomeBase[]) getPrivateStatic(BiomeBase.class, "biomes");
        } catch (Exception exc) {
            // Unable to fetch.
            return;
        }
        for (BiomeBase biomeBase : biomes) {
            if (biomeBase == null)
                break;
     
        // The list fields changed names but update the meta regardless.
        for (String field : new String[] { "J", "K", "L", "M" })
            try {
                Field list = BiomeBase.class.getDeclaredField(field);
                list.setAccessible(true);
                @SuppressWarnings("unchecked")
                List<BiomeMeta> mobList = (List<BiomeMeta>) list.get(biomeBase);
 
                // Make sure the NMS class is written back over our custom class.
                for (BiomeMeta meta : mobList)
                    for (CustomEntityType entity : values())
                        if (entity.getCustomClass().equals(meta.b))
                            meta.b = entity.getNMSClass();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
     
    /**
    * A convenience method.
    * @param clazz The class.
    * @param f The string representation of the private static field.
    * @return The object found
    * @throws Exception if unable to get the object.
    */
    private static Object getPrivateStatic(Class clazz, String f) throws Exception {
        Field field = clazz.getDeclaredField(f);
        field.setAccessible(true);
        return field.get(null);
    }
    
    private static void a(Class paramClass, String paramString, int paramInt) {
        Method a;
        try {
            a = EntityTypes.class.getDeclaredMethod("a", new Class<?>[]{Class.class, String.class, int.class});
            a.setAccessible(true);
            a.invoke(null, paramClass, paramString, paramInt);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
