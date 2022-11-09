package com.ankares.hanielfialho.commands.basics;


import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

@CommandAlias("tp")
@CommandPermission("ankares.op")
public class TeleportCommand extends BaseCommand {
    @CommandCompletion("@players")
    @Default
    private void teleport(Player p, String[] args) {
        if (args.length == 0) p.sendMessage("§cUtilize /tp <jogador> para teleportar para um jogador.");
        Player p1;
        if (args.length == 1) {
            p1 = Bukkit.getPlayer(args[0]);
            if (p1 == null) {
                p.sendMessage("§cEste jogador não está on-line!");
                p.playSound(p.getLocation(), Sound.ORB_PICKUP, 2.0F, 1.0F);
            } else if (p1.getName().equals(p.getName())) p.sendMessage("§cVocê não pode se teleportar para si mesmo.");
            else {
                p.teleport(p1);
                p.sendMessage("§a" + p.getName() + " foi teleportado para " + p1.getName() + ".");
                p.playSound(p.getLocation(), Sound.ORB_PICKUP, 2.0F, 1.0F);
            }
        } else if (args.length == 2) {
            p1 = Bukkit.getPlayer(args[0]);
            if (p1 == null) {
                p.sendMessage("§cEste jogador não está on-line!");
                return;
            }

            Player p2 = Bukkit.getPlayer(args[1]);
            if (p2 == null) {
                p.sendMessage("§cEste jogador não está on-line!");
                return;
            }

            if (p1.getName().equals(p2.getName())) {
                p.sendMessage("§cVocê não pode se teleportar para si mesmo.");
                return;
            }

            String player1 = p1.getName();
            String player2 = p2.getName();
            p1.teleport(p2);
            p.sendMessage("§a" + player1 + " foi teleportado para " + player2 + ".");
            p1.sendMessage("§aTeleportado para " + p2.getName() + ".");
        }
    }
}


