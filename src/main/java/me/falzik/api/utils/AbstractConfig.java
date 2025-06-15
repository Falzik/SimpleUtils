package me.falzik.api.utils;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class AbstractConfig {

    public static final AbstractConfig instance = new AbstractConfig();

    private final static HashMap<String, YamlConfiguration> configByName = new HashMap<>();

    public void configSetup(String configName, JavaPlugin javaPlugin) {
        File file = new File("plugins/" + javaPlugin.getName(), configName);
        if(!file.exists()) {
            javaPlugin.saveResource(configName, false);
        }
        configByName.put(configName, YamlConfiguration.loadConfiguration(file));
    }

    public void saveConfig(String configName, String pluginName) {
        File file = new File("plugins/" + pluginName, configName);
        try {
            getConfig(configName).save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public YamlConfiguration getConfig(String configName) {
        return configByName.get(configName);
    }

}
