package org.dragonet.profileapi;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PlayerProfile {

    private final File store;
    private final OfflinePlayer player;
    private final YamlConfiguration data;

    public PlayerProfile(File store, OfflinePlayer player, YamlConfiguration data) {
        this.store = store;
        this.player = player;
        this.data = data;
    }

    public ConfigurationSection getData() {
        return data;
    }

    public boolean save() {
        try {
            data.save(store);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
