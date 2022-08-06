package io.github.ardeon.altar;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Locale;

public class MainSettings {
    private boolean isEnable;
    private World world;
    public Location location;

    public World getWorld() {
        return world;
    }

    public boolean isEnable(){
        return isEnable;
    }

    public Location getLocation() {
        return location;
    }

    public MainSettings(){
        FileConfiguration configuration = AltarPlugin.getInstance().getConfig();
        String worldName = configuration.getString("main.world", null);
        world = Bukkit.getWorld(worldName != null ? worldName : "null");
        isEnable = configuration.getBoolean("main.enable", false);
        location = configuration.getLocation("main.location", null);
    }
}
