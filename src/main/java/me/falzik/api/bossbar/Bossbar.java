package me.falzik.api.bossbar;

import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public interface Bossbar {

    void addPlayer(Player player);
    void removePlayer(Player player);

    double progress();
    void setProgress(double progress);

    String getTitle();
    void setTitle(String title);

    BarColor getColor();
    void setColor(BarColor color);

    BarStyle getStyle();
    void setStyle(BarStyle style);

    void addBarFlag(BarFlag barFlag);
    void remoBarFlag(BarFlag barFlag);

    void destroy();

    BossBar getBukkitBossBar();
}
