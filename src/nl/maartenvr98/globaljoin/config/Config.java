package nl.maartenvr98.globaljoin.config;

import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.*;

public class Config {

    private static Configuration configuration;
    private static File file;
    private String name;

    public Config(Plugin plugin, String name) {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }

        file = new File(plugin.getDataFolder(), name + ".yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
                try (InputStream is = plugin.getResourceAsStream(name + ".yml");
                     OutputStream os = new FileOutputStream(file)) {
                    ByteStreams.copy(is, os);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        configuration.set("join", "&c[+] &7%player% joined the server");
                        configuration.set("leave", "&c[-] &7%player% leaved the server");
                        configuration.set("messages.permission-denied", "&c[globaljoin] &7You do not have permissions for this!");
                        configuration.set("messages.reloaded", "&c[globaljoin] &7You have reloaded BungeeKickStop!");
                        saveConfig();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException("Unable to create configuration file", e);
            }
        }

        try {
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Configuration getConfig() {
        return configuration;
    }

    public void saveConfig() {
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration, this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reloadConfig() {
        try {
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
