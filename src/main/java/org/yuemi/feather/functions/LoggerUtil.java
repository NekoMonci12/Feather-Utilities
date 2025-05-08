package org.yuemi.feather.functions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

/**
 * Simple logger with numeric level input
 */
public class LoggerUtil {

    /**
     * Log message with numeric level:
     * 1 = INFO, 2 = WARNING, 3 = ERROR, 4 = DEBUG
     */
    public static void logs(int level, Object message) {
        String msg = message.toString();

        String prefix = "[FeatherUtils]";
        String formattedMessage;

        switch (level) {
            case 1: // INFO
                formattedMessage = String.format("%s %s%s", prefix, ChatColor.GREEN, msg);
                Bukkit.getLogger().info(formattedMessage);
                break;
            case 2: // WARNING
                formattedMessage = String.format("%s %s%s", prefix, ChatColor.YELLOW, msg);
                Bukkit.getLogger().warning(formattedMessage);
                break;
            case 3: // ERROR
                formattedMessage = String.format("%s %s%s", prefix, ChatColor.RED, msg);
                Bukkit.getLogger().severe(formattedMessage);
                break;
            case 4: // DEBUG
                formattedMessage = String.format("%s %s%s", prefix, ChatColor.GRAY, msg);
                Bukkit.getLogger().info(formattedMessage);
                break;
            default:
                // fallback to info if level wrong
                formattedMessage = String.format("%s %s%s", prefix, ChatColor.GREEN, msg);
                Bukkit.getLogger().info(formattedMessage);
                break;
        }
    }
}