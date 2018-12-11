package me.xanium.onemoreslot.bungee;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class OMSBungee extends Plugin implements Listener {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, this);
    }

    @EventHandler
    public void onServerPing(ProxyPingEvent event) {
        ServerPing response = event.getResponse();
        ServerPing.Players players = response.getPlayers();

        players = new ServerPing.Players(players.getOnline() + 1, players.getOnline(), players.getSample());

        ServerPing ping = new ServerPing();
        ping.setDescriptionComponent(response.getDescriptionComponent());
        ping.setPlayers(players);
        ping.setFavicon(response.getFaviconObject());
        ping.setVersion(response.getVersion());

        event.setResponse(ping);
    }
}
