package org.yuemi.feather;

// Bukkit
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
// PlaceholderAPI
//import me.clip.placeholderapi.PlaceholderAPI;
//import me.clip.placeholderapi.expansion.PlaceholderExpansion;
// YueMi
import org.yuemi.feather.functions.LoggerUtil;

public class Main extends JavaPlugin {
    String pluginName = getDescription().getName();


    @Override
    public void onEnable() {
        saveDefaultConfig(); // Save the default config if it doesn't exist yet
        LoggerUtil.logs(1, "Enabling " + pluginName);
    }


    @Override
    public void onDisable() {
        LoggerUtil.logs(1, "Disabling " + pluginName);
    }
}