package org.dragonet.profileapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.dragonet.profileapi.PlayerProfile;

public class PlayerFirstJoinEvent extends PlayerEvent {

    private static final HandlerList handlerList = new HandlerList();

    private PlayerProfile profile;

    public PlayerFirstJoinEvent(Player who, PlayerProfile profile) {
        super(who);
        this.profile = profile;
    }

    public PlayerProfile getProfile() {
        return profile;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }
}
