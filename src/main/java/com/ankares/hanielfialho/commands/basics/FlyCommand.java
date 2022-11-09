package com.ankares.hanielfialho.commands.basics;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.ankares.hanielfialho.messages.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandPermission("ankares.op")
@CommandAlias("fly|voar")
public class FlyCommand extends BaseCommand {

    @CommandCompletion("@players")
    @Default
    private void onCommand(Player player, String[] args) {
        Player targetPlayer = null;

        if (args.length > 0) {

            targetPlayer = Bukkit.getPlayerExact(args[0]);

            if (targetPlayer == null) {
                Message.ERROR.send(player, String.format("O jogador \"%s\" não está online.", args[0]));
                return;
            }
        }
        if (targetPlayer != null && player != targetPlayer) {
            String string = String.format(player.getAllowFlight() ? "Modo voo de \"%s\" ativo." : "Modo voo de \"%s\" desativado.");
            Message.SUCCESS.send(player, string);
        }
        player.setAllowFlight(!player.getAllowFlight());
        player.setFlying(player.getAllowFlight());
        Message.SUCCESS.send(player, player.getAllowFlight() ? "Modo voo ativo." : "Modo voo desativado.");

    }
}
