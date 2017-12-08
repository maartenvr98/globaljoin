package nl.maartenvr98.globaljoin.listeners;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;
import nl.maartenvr98.globaljoin.components.Colorize;
import nl.maartenvr98.globaljoin.components.Message;
import nl.maartenvr98.globaljoin.components.Placeholders;
import nl.maartenvr98.globaljoin.config.Config;

public class Leave implements Listener {

    private Plugin plugin;

    public Leave(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLogin(PostLoginEvent event) {
        ProxiedPlayer player = event.getPlayer();
        for(ProxiedPlayer p : plugin.getProxy().getPlayers()) {
            String leave = Config.getConfig().getString("leave");
            leave = Placeholders.run(Colorize.run(leave), player);
            Message.send(p, leave);
        }
    }

}
