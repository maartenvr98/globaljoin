package nl.maartenvr98.globaljoin.components;

import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Placeholders {

    public static String run(String ln, ProxiedPlayer p) {
        ln.replaceAll("%player%", p.getName());
        return ln;
    }

}
