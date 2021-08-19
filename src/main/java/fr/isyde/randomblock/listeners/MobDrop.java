package fr.isyde.randomblock.listeners;

import fr.isyde.randomblock.Main;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MobDrop implements Listener {
    private Main main;

    public MobDrop(Main Main) {
        this.main = Main;
    }

    @EventHandler
    public void Drop(EntityDeathEvent event) {


        Entity E = event.getEntity();




    }
}
