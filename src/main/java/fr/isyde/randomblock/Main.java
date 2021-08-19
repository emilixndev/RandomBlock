package fr.isyde.randomblock;

import fr.isyde.randomblock.Commands.CommandTest;
import fr.isyde.randomblock.listeners.itemDrop;
import fr.isyde.randomblock.listeners.MobDrop;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerUnleashEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        System.out.println("Le plugin c'est lancé");
        //getCommand("explosion").setExecutor(new CommandTest());
        getServer().getPluginManager().registerEvents(new itemDrop(this), this);
        getServer().getPluginManager().registerEvents(new MobDrop(this),this);

    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
