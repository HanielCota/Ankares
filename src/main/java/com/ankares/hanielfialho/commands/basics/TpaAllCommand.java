package com.ankares.hanielfialho.commands.basics;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Default;
import com.ankares.hanielfialho.messages.DefaultMessage;
import com.ankares.hanielfialho.messages.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("tpall")
public class TpaAllCommand extends BaseCommand {


    @CommandCompletion("@players")
    @Default
    private void onCommand(Player player, String[] args) {
        if (args.length == 0) {
            Message.ERROR.send(player, "Utilize /tpall <player>.");
            return;
        }
        player = Bukkit.getPlayerExact(args[0]);
        if (player == null) {
            Message.ERROR.send(null, DefaultMessage.PLAYER_NOT_FOUND.format(args[0]));
            return;
        }
        for (Player target : Bukkit.getOnlinePlayers()) {
            if (target != player) target.teleport(player);
            Message.SUCCESS.send(target, "Você foi teleportado até " + player.getName() + ".");
        }
        Message.SUCCESS.send(player, "Todos os jogadores foram teleportados até você.");

    }

}
