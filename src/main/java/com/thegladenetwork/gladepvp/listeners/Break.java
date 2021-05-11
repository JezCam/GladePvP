package com.thegladenetwork.gladepvp.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Break implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player player = e.getPlayer();
        Block currentBlock = null;
        Block startBlock = e.getBlock();

        if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.DIAMOND_AXE){
            for( int xOff = -1 ; xOff <= 1 ; ++xOff ) {
                for( int yOff = -1 ; yOff <= 1 ; ++yOff ) {  // NOTE this goes from -2 to 0, not -1 to +1
                    for( int zOff = -1 ; zOff <= 1 ; ++zOff ) {
                        if (startBlock.getRelative( xOff, yOff, zOff ).getType() == Material.LIME_WOOL) {
                            startBlock.getRelative( xOff, yOff, zOff ).setType(Material.AIR);
                        }
                    }
                }
            }
        }
    }

}
