package me.duckdoom5.RpgEssentials.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import me.duckdoom5.RpgEssentials.RpgEssentials;

public class Configuration {
    private static final String pluginName = "RpgEssentials";

    public static MyConfiguration config;
    public static MyConfiguration block;
    public static MyConfiguration pets;
    public static MyConfiguration generator;
    public static MyConfiguration items;
    public static MyConfiguration texture;
    public static MyConfiguration mail;
    public static MyConfiguration modules;
    // public static MyConfiguration clans;
    public static MyConfiguration tracks;
    
    static {
        config = new MyConfiguration();
        block = new MyConfiguration();
        pets = new MyConfiguration();
        generator = new MyConfiguration();
        items = new MyConfiguration();
        texture = new MyConfiguration();
        mail = new MyConfiguration();
        modules = new MyConfiguration();
        // clans = new MyConfiguration();
        tracks = new MyConfiguration();
    }

    public static void start() {
        RpgEssentials.getLog().info("Static Configuration loading...");
        if (load(config, "config.yml")) {
            config = MyConfiguration.loadConfiguration("plugins/" + pluginName + "/config.yml");
            Config.set();
            save(config);
        }
        Config.set();
        try {
            config.save();
        } catch (final Exception e) {
            e.printStackTrace();
        }

        if (load(block, "blocks.yml")) {
            block = MyConfiguration.loadConfiguration("plugins/" + pluginName + "/blocks.yml");
            BlockConfig.set();
            save(block);
        }
        BlockConfig.set();
        try {
            block.save();
        } catch (final Exception e) {
            e.printStackTrace();
        }

        if (load(items, "items.yml")) {
            items = MyConfiguration.loadConfiguration("plugins/" + pluginName + "/items.yml");
            ItemConfig.set();
            save(items);
        }
        ItemConfig.set();
        try {
            items.save();
        } catch (final Exception e) {
            e.printStackTrace();
        }

        if (load(pets, "Temp/pets.yml")) {
            pets = MyConfiguration.loadConfiguration("plugins/" + pluginName + "/Temp/pets.yml");
            PetsConfig.set();
            save(pets);
        }
        PetsConfig.set();
        try {
            pets.save();
        } catch (final Exception e) {
            e.printStackTrace();
        }

        if (load(generator, "worldgenerator.yml")) {
            generator = MyConfiguration.loadConfiguration("plugins/" + pluginName + "/worldgenerator.yml");
            GeneratorConfig.set();
            save(generator);
        }
        GeneratorConfig.set();
        try {
            generator.save();
        } catch (final Exception e) {
            e.printStackTrace();
        }

        if (load(texture, "textures.yml")) {
            texture = MyConfiguration.loadConfiguration("plugins/" + pluginName + "/textures.yml");
            TextureConfig.set();
            save(texture);
        }
        TextureConfig.set();
        try {
            texture.save();
        } catch (final Exception e) {
            e.printStackTrace();
        }

        if (load(mail, "Temp/mail.yml")) {
            mail = MyConfiguration.loadConfiguration("plugins/" + pluginName + "/Temp/mail.yml");
            MailConfig.set();
            save(mail);
        }
        MailConfig.set();
        try {
            mail.save();
        } catch (final Exception e) {
            e.printStackTrace();
        }

        if (load(modules, "modules.yml")) {
            modules = MyConfiguration.loadConfiguration("plugins/" + pluginName + "/modules.yml");
            ModulesConfig.set();
            save(modules);
        }
        ModulesConfig.set();
        try {
            modules.save();
        } catch (final Exception e) {
            e.printStackTrace();
        }

        /*
         * if(load(clans,"clans.yml")){ clans =
         * MyConfiguration.loadConfiguration("plugins/" + pluginName +
         * "/clans.yml"); ClanConfig.set(); save(clans); } ClanConfig.set(); try
         * { clans.save(); } catch (Exception e) { e.printStackTrace(); }
         */

        if (load(tracks, "Temp/tracks.yml")) {
            tracks = MyConfiguration.loadConfiguration("plugins/" + pluginName + "/Temp/tracks.yml");
            save(tracks);
        }
        try {
            tracks.save();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    private static void exclaim(String filename) {
        RpgEssentials.getLog().info("Saved file " + filename + "!");
    }

    private static void complain(String filename) {
        RpgEssentials.getLog().severe("On file " + filename + ":");
        RpgEssentials.getLog().severe("Invalid configuration! Did you use tabs or restrict permissions?");
    }

    private static void complainFileCreation(String filename) {
        RpgEssentials.getLog().severe("On file " + filename + ":");
        RpgEssentials.getLog().severe("Could NOT create default files! Did you restrict permissions?");
    }

    // return true if defaults need to be created
    private static boolean load(MyConfiguration y, String name) {
        try {
            y.load("plugins/" + pluginName + "/" + name);
        } catch (final FileNotFoundException e) {
            return true;
        } catch (final Exception e) {
            complain(name);
        }
        return false;
    }

    private static void save(MyConfiguration y) {
        try {
            y.save();
            try {
                y.load("plugins/" + pluginName + "/" + y.getFilename());
            } catch (final Exception e) {
            }
            exclaim(y.getFilename());
        } catch (final IOException e) {
            complainFileCreation(y.getFilename());
        }
    }

    public static Object load(String path) throws FileNotFoundException, Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            final Object result = ois.readObject();
            ois.close();
            return result;
        }
    }

    public static void save(Object obj, String path) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(obj);
            oos.flush();
            oos.close();
        }
    }
}