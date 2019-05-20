package org.dragonet.profileapi;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.dragonet.profileapi.events.PlayerFirstJoinEvent;

public class EventListener implements Listener {

    private final ProfileAPI plugin;

    public EventListener(ProfileAPI plugin) {
        this.plugin = plugin;
    }

    @EventHandler()
    public void onJoin(PlayerJoinEvent e) {
        if(!plugin.isProfileExist(e.getPlayer())) {
            // first join
            PlayerFirstJoinEvent ev = new PlayerFirstJoinEvent(e.getPlayer(), plugin.getProfileFor(e.getPlayer()));
            plugin.getServer().getPluginManager().callEvent(ev);
        }
    }
}
