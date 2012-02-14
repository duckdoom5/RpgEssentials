package me.duckdoom5.RpgEssentials.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.error.YAMLException;

public class MyConfiguration extends YamlConfiguration {

	private File file;
	
	public String getFilename(){
		if (file == null)
			throw new UnsupportedOperationException("You didn't use a File to create this object.");
		String[] f = file.getAbsolutePath().split("/");
		return f[f.length-1];
	}
	
	public void load(String file) throws FileNotFoundException, IOException, InvalidConfigurationException{
		load(new File(file));
	}
	
	public void load(File file) throws FileNotFoundException, IOException, InvalidConfigurationException{
		super.load(file);
		this.file = file;
	}
	
	public void reload() throws FileNotFoundException, IOException, InvalidConfigurationException{
		load(file);
	}

	public static MyConfiguration loadConfiguration(String file){
		return loadConfiguration(new File(file));
	}
	
	public static MyConfiguration loadConfiguration(File file){
		if (file == null) {
			throw new IllegalArgumentException("File cannot be null");
		}

		MyConfiguration config = new MyConfiguration();

		try {
			config.load(file);
		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
			Bukkit.getLogger().log(Level.SEVERE, "Cannot load " + file, ex);
		} catch (InvalidConfigurationException ex) {
			if (ex.getCause() instanceof YAMLException) {
				Bukkit.getLogger().severe("Config file " + file + " isn't valid! " + ex.getCause());
			} else if ((ex.getCause() == null) || (ex.getCause() instanceof ClassCastException)) {
				Bukkit.getLogger().severe("Config file " + file + " isn't valid!");
			} else {
				Bukkit.getLogger().log(Level.SEVERE, "Cannot load " + file + ": " + ex.getCause().getClass(), ex);
			}
		}
		config.file = file;

		return config;
	}
	
	public void save() throws IOException{
		if (file == null)
			throw new UnsupportedOperationException("You didn't use a File to create this object.");
		super.save(file);
	}

}
