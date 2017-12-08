package nl.maartenvr98.globaljoin.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;
import nl.maartenvr98.globaljoin.components.Colorize;
import nl.maartenvr98.globaljoin.config.Config;

public class Commands extends Command {

    public Commands(String string) {
        super(string);
    }

    public void execute(CommandSender s, String[] arg1)
    {
        if (s.hasPermission("globaljoin.reload")) {
            Config.reloadConfig();
            sendMessage(s, Config.getConfig().getString("messages.reloaed"));
        } else {
            sendMessage(s, Config.getConfig().getString("messages.permission-denied"));
        }
    }

    private void sendMessage(CommandSender sender, String text) {
        TextComponent message = new TextComponent(Colorize.run(text));
        sender.sendMessage(message);
    }

}
