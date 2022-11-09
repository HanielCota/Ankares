package com.ankares.hanielfialho.commands.basics;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Default;
import com.ankares.hanielfialho.messages.DefaultMessage;
import com.ankares.hanielfialho.messages.Message;
import lombok.val;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Objects;


@CommandAlias("kill")
public class KillCommand extends BaseCommand {

    @CommandCompletion("@players")
    @Default
    private void onCommand(Player player, String[] args) {
        if (args.length == 0) {
            player.setHealth(0);
            Message.SUCCESS.send(player, "Você se matou.");
            return;
        }
        String targetName = args[0];
        val target = Bukkit.getPlayerExact(targetName);

        if (Objects.isNull(target)) {
            Message.ERROR.send(player, DefaultMessage.PLAYER_NOT_FOUND.format(targetName));
            return;
        }
        if (!target.isOnline()) {
            Message.ERROR.send(player, DefaultMessage.PLAYER_NOT_ONLINE.format(targetName));
            return;
        }
        target.setHealth(0);
        Message.SUCCESS.send(player, "Você matou " + targetName);
        Message.SUCCESS.send(target, "Você foi morto por " + player.getName());
    }
}
