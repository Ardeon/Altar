package io.github.ardeon.altar;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AltarCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if ((sender instanceof Player))
        {
            Player p = (Player) sender;

            if (args.length >= 2){
                if (args[0].equalsIgnoreCase("world")){
                    String worldName = args[1];
                    World world = Bukkit.getWorld(worldName);
                    if (world == null)
                        return false;
                    AltarPlugin.getInstance().getConfig().set("main.world", args[1]);
                    AltarPlugin.getInstance().saveConfig();
                    AltarPlugin.getInstance().loadAltar();
                    return true;
                }
            }

            AltarPlugin.getInstance().getConfig().set("main.location", p.getLocation());
            AltarPlugin.getInstance().getLogger().info(p.getLocation().toString());
            AltarPlugin.getInstance().saveConfig();
            AltarPlugin.getInstance().loadAltar();
            return true;
        }
        return false;
    }

}