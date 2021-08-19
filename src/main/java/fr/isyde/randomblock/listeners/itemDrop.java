package fr.isyde.randomblock.listeners;

import fr.isyde.randomblock.Main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.server.BroadcastMessageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.SpawnEgg;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;


public class itemDrop implements Listener {


    private Main main;

    public itemDrop(Main Main){
    this.main = Main;
    }



    @EventHandler
    public void test(BlockDropItemEvent event){


        String blockDetruit;


        //recupe le player
        Player p = event.getPlayer();
        //On récupère le materiel détruit
        Material m = event.getBlock().getType();

        // on crée la liste des item
        List<Item> test = event.getItems();
        //on annule le drop
        event.setCancelled(true);

        //on crée la variable bool
        boolean verif = true;
        String name= "";
        // pour chaque item drop
        for (Item i : test) {
            //verif si il à déja était drop
            for(String string : main.getConfig().getStringList("blocksD")){
                if (string.equalsIgnoreCase(i.getName().toUpperCase().replace(" ","_"))){
                    verif = true;
                    name = string;
                    break;

                }else{
                    verif = false;

                }
            }

            //si drop
            if(verif){

                // random
                int pick = new Random().nextInt(Material.values().length);

                //crée en item









                ItemStack t = new ItemStack(Material.getMaterial((main.getConfig().getString("blocksT."+i.getName().toUpperCase()))));


                event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), t);


              //  p.sendMessage("LE DROP"+t.getType().name());


            }else{
                blockDetruit=i.getName();

                int pick = new Random().nextInt(Material.values().length);







                //recup le monde

              //  p.sendMessage( t.getType().name());
//                if (t.getType().name().contains("SPAWN_EGG")) {
//
//                    p.sendMessage("pute");
//                }else {
//
//                    p.sendMessage("dfsijnqqojsfhb yuo");
//                }




//                p.sendMessage("je veux lui"+new ItemStack(Material.values()[pick]).getType().name());
      //          i.setItemStack(new ItemStack(Material.values()[pick]));
//                main.getConfig().set("blocksT."+blockDetruit.toUpperCase(),i.getName().toUpperCase());
//                main.saveConfig();

                // random





                do {





//                    if (string.equalsIgnoreCase(i.getName())) {
//
                        int picko = new Random().nextInt(Material.values().length);
//
                    //p.sendMessage(new ItemStack(Material.values()[picko]).getType().name());
                    main.getConfig().set("blocksT."+blockDetruit.toUpperCase(),i.getName().toUpperCase());
                    main.saveConfig();
                    if(verifBlacklist(new ItemStack(Material.values()[picko]).getType().name())) {
//
                    //    p.sendMessage("je veux"+new ItemStack(Material.values()[picko]).getType().name());
                        i.setItemStack(new ItemStack(Material.values()[picko]));



                    }

//                    } else {
//
//                        break;
//                    }


                }while (main.getConfig().getString("blocksT."+blockDetruit.toUpperCase()).equalsIgnoreCase(i.getName()));





                //udate le fichier
                main.getConfig().set("blocksT."+blockDetruit.toUpperCase(),i.getName().toUpperCase().replace(" ","_"));
                main.saveConfig();


                List<String> uneListe = new ArrayList<String>();




                 uneListe = (List<String>) main.getConfig().getStringList("blocksD");


                 uneListe.add(blockDetruit.toUpperCase().replace(" ","_"));


                 main.getConfig().set("blocksD",uneListe);

                 main.saveConfig();





                p.sendMessage("LE DROP"+i.getName());
                event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), i.getItemStack());



            }




        }

    }





    @EventHandler
    public void mobDrop(EntityDeathEvent event){


        String blockDetruit;


        //recupe le player
        Player p = (Player) event.getEntity().getKiller();
        //On récupère le materiel détruit
        String m = event.getEntity().getName();

        // on crée la liste des item
        List<ItemStack> test = event.getDrops();
        //on annule le drop


        //on crée la variable bool
        boolean verif = true;

        // pour chaque item drop
        for (ItemStack i : test) {
            //verif si il à déja était drop
            for(String string : main.getConfig().getStringList("blocksD")){
                if (string.equalsIgnoreCase(i.getType().name().toUpperCase().replace(" ","_"))){
                    verif = true;

                    break;

                }else{
                    verif = false;

                }
            }

            //si drop
            if(verif){

                // random
                int pick = new Random().nextInt(Material.values().length);

                //crée en item









                ItemStack t = new ItemStack(Material.getMaterial((main.getConfig().getString("blocksT."+i.getType().name().toUpperCase()))));



                event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),t);
                event.getDrops().clear();
                //  p.sendMessage("LE DROP"+t.getType().name());


            }else{
                blockDetruit=i.getType().name();

                int pick = new Random().nextInt(Material.values().length);







                //recup le monde

                //  p.sendMessage( t.getType().name());
//                if (t.getType().name().contains("SPAWN_EGG")) {
//
//                    p.sendMessage("pute");
//                }else {
//
//                    p.sendMessage("dfsijnqqojsfhb yuo");
//                }




//                p.sendMessage("je veux lui"+new ItemStack(Material.values()[pick]).getType().name());
                //          i.setItemStack(new ItemStack(Material.values()[pick]));
//                main.getConfig().set("blocksT."+blockDetruit.toUpperCase(),i.getName().toUpperCase());
//                main.saveConfig();

                // random





                do {





//                    if (string.equalsIgnoreCase(i.getName())) {
//
                    int picko = new Random().nextInt(Material.values().length);
//
                    //p.sendMessage(new ItemStack(Material.values()[picko]).getType().name());
                    main.getConfig().set("blocksT."+blockDetruit.toUpperCase(),i.getType().name().toUpperCase());
                    main.saveConfig();
                    if(verifBlacklist(new ItemStack(Material.values()[picko]).getType().name())) {
//
                        //    p.sendMessage("je veux"+new ItemStack(Material.values()[picko]).getType().name());
                        i = new ItemStack(Material.values()[picko]);



                    }

//                    } else {
//
//                        break;
//                    }


                }while (main.getConfig().getString("blocksT."+blockDetruit.toUpperCase()).equalsIgnoreCase(i.getType().name()));





                //udate le fichier
                main.getConfig().set("blocksT."+blockDetruit.toUpperCase(),i.getType().name().toUpperCase().replace(" ","_"));
                main.saveConfig();


                List<String> uneListe = new ArrayList<String>();




                uneListe = (List<String>) main.getConfig().getStringList("blocksD");


                uneListe.add(blockDetruit.toUpperCase().replace(" ","_"));


                main.getConfig().set("blocksD",uneListe);

                main.saveConfig();







                event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),i);

                event.getDrops().clear();

            }




        }

    }




    public boolean verifBlacklist(String s){

        List<String> uneListe = new ArrayList<String>();
        uneListe = (List<String>) main.getConfig().getStringList("blacklist");
        for (String l: uneListe){

            // Bukkit.broadcastMessage("Le s "+s);
            //Bukkit.broadcastMessage("Le s "+l);
            if(s.contains(l))
            {
                // Bukkit.broadcastMessage("Je sors");
                return false;



            }



        }


        return true;
    }




}
