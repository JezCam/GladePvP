package com.thegladenetwork.gladepvp.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Kit implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            ItemStack bow = new ItemStack(Material.BOW);
            bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
            player.getInventory().addItem(bow);

            ItemStack arrow = new ItemStack(Material.ARROW);
            player.getInventory().setItem(9, arrow);

            ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
            player.getInventory().addItem(axe);

            // Wood, set number, don't disappear
            //player.getInventory().setMaxStackSize(120);
            //ItemStack woodStack = new ItemStack(Material.OAK_PLANKS, 120);

            ItemStack woolStack = new ItemStack(Material.LIME_WOOL);
            player.getInventory().addItem(woolStack);
            player.updateInventory();
        }

        return false;
    }
}
