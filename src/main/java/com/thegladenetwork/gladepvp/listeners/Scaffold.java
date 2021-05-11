package com.thegladenetwork.gladepvp.listeners;

import com.thegladenetwork.gladepvp.GladeTag;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Scaffold implements Listener {

    private GladeTag mainClass;

    public Scaffold(GladeTag main) {
        this.mainClass = main;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        final Player player = e.getPlayer();
        final Block block = e.getTo().getBlock().getRelative(BlockFace.DOWN);

        if (player.getInventory().getItemInMainHand().getType() == Material.LIME_WOOL
                &&  block.getType() == Material.AIR){
            block.setType(Material.LIME_WOOL);

            Bukkit.getScheduler().scheduleSyncDelayedTask(mainClass, new Runnable()
            {
                @Override
                public void run()
                {
                    block.setType(Material.ORANGE_WOOL);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(mainClass, new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            block.setType(Material.RED_WOOL);
                            Bukkit.getScheduler().scheduleSyncDelayedTask(mainClass, new Runnable()
                            {
                                @Override
                                public void run()
                                {
                                    block.setType(Material.AIR);

                                }
                            }, 2*20L);

                        }
                    }, 2*20L);

                }
            }, 2*20L);

            // Wood version, remove wood from inventory
            //int amount = player.getInventory().getItemInMainHand().getAmount();
            //player.getInventory().getItemInMainHand().setAmount(amount - 1);
        }
    }
}
