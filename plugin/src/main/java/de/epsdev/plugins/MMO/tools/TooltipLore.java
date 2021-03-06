package de.epsdev.plugins.MMO.tools;

import de.epsdev.plugins.MMO.data.player.Character;
import org.bukkit.ChatColor;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class TooltipLore {

    public static ArrayList<String> toTT(String string){
        ArrayList<String> lore = new ArrayList<>();

        lore.add(ChatColor.WHITE + string);

        return lore;
    }

    public static ArrayList<String> tt_clickToUpdate(){
        return toTT(ChatColor.GREEN + "Click to update");
    }

    public static ArrayList<String> tt_clickToTeleport(){
        return toTT(ChatColor.GREEN + "Click to teleport");
    }

    public static ArrayList<String> tt_clickToSelect(){
        return toTT(ChatColor.GREEN + "Click to select");
    }

    public static ArrayList<String> tt_clickToCreate(){
        return toTT(ChatColor.GREEN + "Click to create");
    }

    public static ArrayList<String> tt_clickToDisconnect(){
        return toTT(ChatColor.RED + "Click to disconnect");
    }

    public static ArrayList<String> tt_buyCharSpace(){
        return toTT(ChatColor.RED + "" + ChatColor.BOLD + "Buy a higher rank for more character slots.");
    }

    public static ArrayList<String> tt_changeChar(){
        return toTT(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Click to change characters");
    }

    public static ArrayList<String> tt_deleteChar(){
        return toTT(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Click to delete this character");
    }

    public static ArrayList<String> tt_clickToDelete(){
        return toTT(ChatColor.GREEN + "Click to delete");
    }
}
