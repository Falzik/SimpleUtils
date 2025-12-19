package me.falzik.api;

import me.falzik.api.bossbar.Bossbar;
import me.falzik.api.bossbar.BossbarManager;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleUtils extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bossbar bossbar = new BossbarManager("&cПошёл нахуй", BarColor.GREEN, BarStyle.SOLID);
        bossbar.getBukkitBossBar().setVisible(true);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
