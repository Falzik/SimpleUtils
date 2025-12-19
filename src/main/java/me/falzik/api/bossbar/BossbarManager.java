package me.falzik.api.bossbar;

import me.falzik.api.util.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BossbarManager implements Bossbar {

    private final BossBar bossbar;

    public BossbarManager(String title, BarColor color, BarStyle style) {
        bossbar = Bukkit.createBossBar(ChatUtil.translateCodes(title), color, style);
    }

    @Override
    public void addPlayer(Player player) {
        bossbar.addPlayer(player);
    }

    @Override
    public void removePlayer(Player player) {
        bossbar.removePlayer(player);
    }

    @Override
    public double progress() {
        return bossbar.getProgress();
    }

    @Override
    public void setProgress(double progress) {
        bossbar.setProgress(progress);
    }

    @Override
    public String getTitle() {
        return ChatUtil.translateCodes(bossbar.getTitle());
    }

    @Override
    public void setTitle(String title) {
        bossbar.setTitle(ChatUtil.translateCodes(title));
    }

    @Override
    public BarColor getColor() {
        return bossbar.getColor();
    }

    @Override
    public void setColor(BarColor color) {
        bossbar.setColor(color);
    }

    @Override
    public BarStyle getStyle() {
        return bossbar.getStyle();
    }

    @Override
    public void setStyle(BarStyle style) {
        bossbar.setStyle(style);
    }

    @Override
    public void addBarFlag(BarFlag barFlag) {
        bossbar.addFlag(barFlag);
    }

    @Override
    public void remoBarFlag(BarFlag barFlag) {
        bossbar.removeFlag(barFlag);
    }

    @Override
    public void destroy() {
        bossbar.getPlayers().forEach(bossbar::removePlayer);
    }

    @Override
    public BossBar getBukkitBossBar() {
        return bossbar;
    }
}
