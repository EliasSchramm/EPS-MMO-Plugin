package de.epsdev.plugins.MMO.data.output;

import de.epsdev.plugins.MMO.npc.NPC;
import de.epsdev.plugins.MMO.tools.Vec3i;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Out {
    public static void printToConsole(String msg){
        System.out.println("[EPS-MMO] " + msg);
    }

    public static void printToConsole(int msg){
        System.out.println("[EPS-MMO] " + msg);
    }

    public static void printToConsole(float msg){
        System.out.println("[EPS-MMO] " + msg);
    }

    public static void printToConsole(double msg){
        System.out.println("[EPS-MMO] " + msg);
    }

    public static void printToConsole(String[] msg){
        System.out.println("[EPS-MMO] " + msg.length);
        for(String s : msg){
            System.out.println("[EPS-MMO] " + s);
        }
    }

    public static void printToPlayer(Player player, String msg){
        player.sendMessage("[EPS-MMO] " + msg);
    }
    public static void printToPlayer(Player player, float msg){
        player.sendMessage("[EPS-MMO] " + msg);
    }
    public static void printToPlayer(Player player, double msg){
        player.sendMessage("[EPS-MMO] " + msg);
    }
    public static void printToPlayer(Player player, String msg, NPC npc){
        player.sendMessage("[" + npc.name + "] " + msg);
    }

    public static void printToPlayer(Player player, int msg){
        player.sendMessage("[EPS-MMO] " + msg);
    }

    public static void printToBroadcast(String msg){
        Bukkit.broadcastMessage(msg);
    }
    public static void printToBroadcast(int msg){
        Bukkit.broadcastMessage(String.valueOf(msg));
    }

    public static void printToShield(String msg, Vec3i pos){

    }
}
