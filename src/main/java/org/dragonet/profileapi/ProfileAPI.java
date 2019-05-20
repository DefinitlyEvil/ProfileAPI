package org.dragonet.profileapi;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class ProfileAPI extends JavaPlugin {

    private static ProfileAPI instance;

    public static ProfileAPI getInstance() {
        return instance;
    }

    private File profilesFolder;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventListener(this), this);

        getDataFolder().mkdirs();
        profilesFolder = new File(getDataFolder(), "profiles");
    }

    public boolean isProfileExist(OfflinePlayer player) {
        return getPlayerProfileStore(player).exists();
    }

    public PlayerProfile getProfileFor(OfflinePlayer player) {
        File f = getPlayerProfileStore(player);
        if(f.exists()) {
            YamlConfiguration conf = YamlConfiguration.loadConfiguration(f);
            conf.set("name", player.getName()); // update?
            PlayerProfile prof = new PlayerProfile(f, player, conf);
            prof.save();
            return prof;
        } else {
            YamlConfiguration mem = new YamlConfiguration();
            mem.set("uuid", player.getUniqueId().toString());
            mem.set("name", player.getName());
            return new PlayerProfile(f, player, mem);
        }
    }


    private File getPlayerProfileStore(OfflinePlayer player) {
        return new File(profilesFolder, player.getUniqueId().toString() + ".yml");
    }
}
