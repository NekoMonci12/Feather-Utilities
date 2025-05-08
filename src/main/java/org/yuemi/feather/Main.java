package org.yuemi.yuelicenser;

// Bukkit
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
// PlaceholderAPI
//import me.clip.placeholderapi.PlaceholderAPI;
//import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class Main extends JavaPlugin {
    public enum LogType {
        NONE, LOW, MEDIUM, HIGH
    }
    private LogType logType = LogType.LOW;
    @Override
    public void onEnable() {
        // Save the default config if it doesn't exist yet
        saveDefaultConfig();
    }


    @Override
    public void onDisable() {
        // Implement Here
    }
}