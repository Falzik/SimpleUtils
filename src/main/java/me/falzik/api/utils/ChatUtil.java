package me.falzik.api.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.Duration;
import java.util.logging.Logger;

public class ChatUtil {

    private static String prefix;
    private static String errorPrefix;

    private static JavaPlugin plugin;

    public static String translateCodes(String value) {
        return ChatColor.translateAlternateColorCodes('&', value);
    }

    public static void sendMessage(CommandSender sender, String message) {
        if(prefix != null) {
            sender.sendMessage(translateCodes(prefix + message));
        } else {
            sender.sendMessage(translateCodes(message));
        }
    }

    public static void sendErrorMessage(CommandSender sender, String message) {
        if(errorPrefix != null) {
            sender.sendMessage(translateCodes(errorPrefix + message));
        } else {
            sender.sendMessage(translateCodes(message));
            System.out.println(message + " (prefix is null!)");
        }
    }

    /**
     * i = start time title
     * i2 = all time title
     * i3 = end title time
     */
    public static void sendTitle(Player player, String title, String subTitle, int i, int i2, int i3) {
        Title title1 = Title.title(
                Component.text(translateCodes(title)),
                Component.text(translateCodes(subTitle)),
                Title.Times.times(
                        Duration.ofSeconds(i),
                        Duration.ofSeconds(i2),
                        Duration.ofSeconds(i3)
                )
        );
        player.showTitle(title1);
    }

    public static void sendTitle(Player player, String title, String subTitle) {
        player.showTitle(Title.title(Component.text(translateCodes(title)), Component.text(translateCodes(subTitle))));
    }

    public static void sendActionBar(Player player, String value) {
        player.sendActionBar(Component.text(translateCodes(value)));
    }

    public static void setPrefix(String prefix) {
        ChatUtil.prefix = translateCodes(prefix);
    }

    public static void setErrorPrefix(String errorPrefix) {
        ChatUtil.errorPrefix = translateCodes(errorPrefix);
    }

    public static Logger getLogger() {
        return plugin.getLogger();
    }

    public static void setPlugin(JavaPlugin plugin) {
        ChatUtil.plugin = plugin;
    }
}
