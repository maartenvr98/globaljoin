package nl.maartenvr98.globaljoin.components;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Message {

    public static void send(ProxiedPlayer player, String text) {
        TextComponent message = new TextComponent(Colorize.run(text));
        player.sendMessage(message);
    }

}
