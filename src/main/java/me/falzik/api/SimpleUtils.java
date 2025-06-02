package me.falzik.api;

import me.falzik.api.utils.ChatUtil;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleUtils extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        ChatUtil.setErrorPrefix("&c[ERROR] &7>> ");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
