package de.epsdev.plugins.MMO.scoreboards;

import de.epsdev.plugins.MMO.data.player.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class DefaultScroreboard {
    public static void refresh(User user){
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("main", "dummy");
        objective.setDisplayName(ChatColor.GOLD + "MMO");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score gold_line = objective.getScore(user.money.formatString());
        Score playerName = objective.getScore("Welcome " + user.displayName);
        Score playerRank = objective.getScore("Rank: [" + user.rank.prefix + ChatColor.WHITE + "]");

        playerName.setScore(12);
        playerRank.setScore(11);
        gold_line.setScore(1);

        Player player = Bukkit.getPlayer(user.displayName);
        player.setScoreboard(scoreboard);

    }
}