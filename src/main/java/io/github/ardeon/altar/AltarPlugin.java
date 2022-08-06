package io.github.ardeon.altar;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public final class AltarPlugin extends JavaPlugin {

    private static AltarPlugin instance;

    private MainSettings settings;
    private Altar altar;
    private AltarText text;

    public static AltarPlugin getInstance(){
        return instance;
    }

    @Override
    public  void onLoad(){
        instance = this;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        settings = new MainSettings();
        text = new AltarText();
        getServer().getPluginCommand("altar").setExecutor(new AltarCommand());
        loadAltar();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void loadAltar() {
        if (altar != null) {
            altar.disable();
        }
        altar = new Altar(settings, text);
    }
}
