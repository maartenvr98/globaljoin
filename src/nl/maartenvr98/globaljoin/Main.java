package nl.maartenvr98.globaljoin;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import nl.maartenvr98.globaljoin.commands.Commands;
import nl.maartenvr98.globaljoin.config.Config;
import nl.maartenvr98.globaljoin.listeners.Join;
import nl.maartenvr98.globaljoin.listeners.Leave;

public class Main extends Plugin implements Listener {

    Config config;

    @Override
    public void onEnable() {
        this.config = new Config(this, "config");

        ProxyServer.getInstance().getPluginManager().registerListener(this, new Join(this));
        ProxyServer.getInstance().getPluginManager().registerListener(this, new Leave(this));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Commands("globaljoin"));

        System.out.println("Enabled GlobalJoin");
    }

    @Override
    public void onDisable() {
        System.out.println("Disabled GlobalJoin");
    }
}
