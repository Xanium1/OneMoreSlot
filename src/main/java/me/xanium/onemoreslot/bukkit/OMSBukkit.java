package me.xanium.onemoreslot.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Xanium on 16.06.2016.
 */
public class OMSBukkit extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPing(ServerListPingEvent e) {
        int max = Bukkit.getServer().getMaxPlayers();
        if (e.getNumPlayers() == max) {
            e.setMaxPlayers(e.getNumPlayers());
        } else {
            e.setMaxPlayers(e.getNumPlayers() + 1);
        }
    }
}
