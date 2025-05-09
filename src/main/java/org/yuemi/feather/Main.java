package org.yuemi.feather;

// Bukkit
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
// Feather
import net.digitalingot.feather.serverapi.api.FeatherAPI;
import net.digitalingot.feather.serverapi.api.meta.MetaService;
import net.digitalingot.feather.serverapi.api.meta.ServerListBackground;
import net.digitalingot.feather.serverapi.api.meta.ServerListBackgroundFactory; 
import net.digitalingot.feather.serverapi.api.meta.exception.UnsupportedImageFormatException;
import net.digitalingot.feather.serverapi.api.meta.exception.ImageSizeExceededException;
import net.digitalingot.feather.serverapi.api.meta.exception.InvalidImageException;
import net.digitalingot.feather.serverapi.api.meta.exception.ServerListBackgroundException;
// YueMi
import org.yuemi.feather.functions.LoggerUtil;
import org.yuemi.feather.functions.AssetManager;
// Java
import java.io.IOException;
import java.nio.file.Path;

public class Main extends JavaPlugin {
    String pluginName = getDescription().getName();

    @Override
    public void onEnable() {
        LoggerUtil.logs(1, "Enabling " + pluginName);

        saveDefaultConfig(); // Save the default config if it doesn't exist yet

        AssetManager assetManager = new AssetManager(getDataFolder());
        assetManager.copyAssets(); // Copy all assets from the resources folder

        String bannerFile = getConfig().getString("banner");
        setBanner(bannerFile); // Set Server Banner
    }

    @Override
    public void onDisable() {
        LoggerUtil.logs(1, "Disabling " + pluginName);
    }

    public void setBanner(String imagePath) {
        MetaService metaService = FeatherAPI.getMetaService();
        try {
            ServerListBackgroundFactory factory = metaService.getServerListBackgroundFactory();
            Path resolvedPath = getDataFolder().toPath().resolve("assets").resolve(imagePath);
            ServerListBackground background = factory.byPath(resolvedPath);
            metaService.setServerListBackground(background);
            LoggerUtil.logs(1, "Succesfully set Background to Feather API");
        } catch (UnsupportedImageFormatException e) {
            LoggerUtil.logs(3, "Image format not supported. Only PNG is supported.");
        } catch (ImageSizeExceededException e) {
            LoggerUtil.logs(3, "Image is too large. Maximum dimensions: 1009×202, Maximum size: 512KB");
        } catch (InvalidImageException e) {
            LoggerUtil.logs(3, "Image file is corrupted or invalid.");
        } catch (IOException e) {
            LoggerUtil.logs(3, "Error reading image file.");
        }
    }
}