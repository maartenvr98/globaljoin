package nl.maartenvr98.globaljoin.components;

public class Colorize {

    public static String run(String ln) {
        ln = ln.replaceAll("&0", "§0");
        ln = ln.replaceAll("&1", "§1");
        ln = ln.replaceAll("&2", "§2");
        ln = ln.replaceAll("&3", "§3");
        ln = ln.replaceAll("&4", "§4");
        ln = ln.replaceAll("&5", "§5");
        ln = ln.replaceAll("&6", "§6");
        ln = ln.replaceAll("&7", "§7");
        ln = ln.replaceAll("&8", "§8");
        ln = ln.replaceAll("&9", "§9");
        ln = ln.replaceAll("&a", "§a");
        ln = ln.replaceAll("&b", "§b");
        ln = ln.replaceAll("&c", "§c");
        ln = ln.replaceAll("&d", "§d");
        ln = ln.replaceAll("&e", "§e");
        ln = ln.replaceAll("&f", "§f");
        ln = ln.replaceAll("&k", "§k");
        ln = ln.replaceAll("&l", "§l");
        ln = ln.replaceAll("&n", "§n");
        ln = ln.replaceAll("&m", "§m");
        ln = ln.replaceAll("&r", "§r");
        return ln;
    }

}
