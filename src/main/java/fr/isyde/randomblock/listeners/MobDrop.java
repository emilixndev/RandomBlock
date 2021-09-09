package fr.isyde.randomblock.listeners;

import fr.isyde.randomblock.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.entity.EntityDeathEvent;

public class MobDrop implements Listener {
    private Main main;

    public MobDrop(Main Main){
        this.main = Main;
    }

    @EventHandler
    public void Drop(EntityDeathEvent event) {





      //  Entity E = event.getEntity();
//        Bukkit.broadcastMessage("test");


//
//        if(E instanceof Player){
//            Bukkit.broadcastMessage("test");
//        }else {
//
//            ItemStack i = new ItemStack(Material.CARROT);
         //   event.getDrops().clear();
        //    event.getDrops().add(i);
//        }




    }
}
