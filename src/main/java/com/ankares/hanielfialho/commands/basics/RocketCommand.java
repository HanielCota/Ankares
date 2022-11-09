package com.ankares.hanielfialho.commands.basics;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.ankares.hanielfialho.messages.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;


@CommandPermission("ankares.op")
@CommandAlias("rocket")
public class RocketCommand extends BaseCommand {

    private void repulse(Player player) {
        Vector dir = player.getVelocity();
        dir.setY(1.5);
        player.setVelocity(dir);
    }

    @CommandCompletion("@players")
    @Default
    private void onCommand(Player player, String[] args) {
        if (args.length == 0) {
            repulse(player);
            Message.SUCCESS.send(player, "§aVocê se jogou para o alto.");
        } else {
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target == null) {
                Message.ERROR.send(player, String.format("O jogador \"%s\" não está online.", args[0]));
                return;
            }
            if (target != player) {
                Message.SUCCESS.send(player, "Você jogou  " + target.getName() + " para o alto.");
                repulse(target);
            }
        }
    }

    @Subcommand("todos")
    private void repulseAllPlayers(Player player) {
        Bukkit.getOnlinePlayers().forEach(this::repulse);
        Message.SUCCESS.send(player, "Você jogou todos players online para o alto.");
    }

}