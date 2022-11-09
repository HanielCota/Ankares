package com.ankares.hanielfialho.commands.basics;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

@CommandPermission("ankares.op")
@CommandAlias("gamemode|gm")
public class GamemodeCommand extends BaseCommand {

    @CommandCompletion("@players")
    @Default
    private void onCommmand(Player player, String[] args) {
        if (args.length == 0) {
            player.sendMessage("§cUtilize /gamemode <modo> para alterar seu modo de jogo.");
            return;
        }
        String gm = args[0];
        Player target;
        if (gm.equalsIgnoreCase("0") || gm.equalsIgnoreCase("survival")) {
            if (args.length == 2) {
                target = Bukkit.getPlayerExact(args[1]);
                if (target == null) {
                    player.sendMessage("§cEste jogador não foi encontrado.");
                    return;
                }
                target.setGameMode(GameMode.SURVIVAL);
                target.sendMessage("§aModo de jogo alterado para " + player.getGameMode() + ".");
                player.sendMessage("§aModo de jogo do jogador " + target.getName() + ", foi alterado para " + target.getGameMode() + ".");
            } else {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage("§aModo de jogo alterado para " + player.getGameMode() + ".");
            }
        }
        if (gm.equalsIgnoreCase("1") || gm.equalsIgnoreCase("criativo")) {
            if (args.length == 2) {
                target = Bukkit.getPlayer(args[1]);
                if (target == null) {
                    player.sendMessage("§cEste jogador não foi encontrado!");
                    return;
                }
                player.setGameMode(GameMode.CREATIVE);
                target.sendMessage("§aModo de jogo alterado para " + player.getGameMode() + ".");
                player.sendMessage("§aModo de jogo do jogador " + target.getName() + ", foi alterado para " + target.getGameMode() + ".");
            } else {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage("§aModo de jogo alterado para " + player.getGameMode() + ".");
            }
        }
        if (gm.equalsIgnoreCase("2") || gm.equalsIgnoreCase("adventure")) {
            if (args.length == 2) {
                target = Bukkit.getPlayer(args[1]);
                if (target == null) {
                    player.sendMessage("§cEste jogador não foi encontrado!");
                    return;
                }

                target.setGameMode(GameMode.ADVENTURE);
                target.sendMessage("§aModo de jogo alterado para " + player.getGameMode() + ".");
                player.sendMessage("§aModo de jogo do jogador " + target.getName() + ", foi alterado para " + target.getGameMode() + ".");
            } else {
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage("§aModo de jogo alterado para " + player.getGameMode() + ".");
            }
        }
        if (gm.equalsIgnoreCase("3") || gm.equalsIgnoreCase("spectator")) {
            if (args.length == 2) {
                target = Bukkit.getPlayer(args[1]);
                if (target == null) {
                    player.sendMessage("§cEste jogador não foi encontrado!");
                    return;
                }
                target.setGameMode(GameMode.SPECTATOR);
                target.sendMessage("§aModo de jogo alterado para " + player.getGameMode() + ".");
                player.sendMessage("§aModo de jogo do jogador " + target.getName() + ", foi alterado para " + target.getGameMode() + ".");
            } else {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage("§aModo de jogo alterado para " + player.getGameMode() + ".");
            }
        }
    }
}
