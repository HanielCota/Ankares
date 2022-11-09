package com.ankares.hanielfialho.commands.basics;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.ankares.hanielfialho.messages.DefaultMessage;
import com.ankares.hanielfialho.messages.Message;
import com.ankares.hanielfialho.util.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandPermission("ankares.op")
@CommandAlias("clear")
public class ClearCommand extends BaseCommand {


    @CommandCompletion("@players")
    @Default
    private void onCommand(Player player, String[] args) {
        Player target = null;
        if (args.length == 0) {
            Message.ERROR.send(player, "Utilize /clear <nick>.");
            return;
        }
        target = Bukkit.getPlayerExact(args[0]);

        if (target == null) {
            Message.ERROR.send(player, DefaultMessage.PLAYER_NOT_FOUND.format(args[0]));
            return;
        }

        PlayerUtils.clear(target);

        if (player != target) {
            Message.SUCCESS.send(player, "Você limpou o inventário de " + target.getName() + "!");
            return;
        }

        Message.SUCCESS.send(player, "Seu inventário agora está vazio.");
    }
}
