package de.epsdev.plugins.MMO.commands;

import de.epsdev.plugins.MMO.GUI.dev.CheatMenu_GUI;
import de.epsdev.plugins.MMO.data.DataManager;
import de.epsdev.plugins.MMO.data.output.Err;
import de.epsdev.plugins.MMO.data.player.User;
import de.epsdev.plugins.MMO.schedulers.Static_Effect_Scheduler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class c_toggletatic implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            User user = DataManager.onlineUsers.get(player.getUniqueId().toString());;
            if(user.rank.canManageStaticEffects){
                Static_Effect_Scheduler.toggleArmorStands();
            }else {
                Err.rankError(player);
            }
        }
        return true;
    }
}
