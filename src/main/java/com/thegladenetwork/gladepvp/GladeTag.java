package com.thegladenetwork.gladepvp;

import com.thegladenetwork.gladepvp.commands.Kit;
import com.thegladenetwork.gladepvp.listeners.Break;
import com.thegladenetwork.gladepvp.listeners.Scaffold;
import org.bukkit.plugin.java.JavaPlugin;

public final class GladeTag extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("The plugin has started!");
        getServer().getPluginManager().registerEvents(new Scaffold(this), this);
        getServer().getPluginManager().registerEvents(new Break(), this);
        getCommand("Kit").setExecutor(new Kit());
    }
}
