package com.ankares.hanielfialho.commands.basics;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.ankares.hanielfialho.messages.DefaultMessage;
import com.ankares.hanielfialho.messages.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandPermission("ankares.op")
@CommandAlias("speed")
public class SpeedCommand extends BaseCommand {

    @CommandCompletion("@players")
    @Default
    private void onCommand(Player player, String[] args) {
        if (args.length == 0) {
            resetPlayerSpeeds(player);
            Message.SUCCESS.send(player, "Suas velocidades foram resetadas.");
            return;
        }

        int speed = 0;
        boolean reset = false;
        Player target;

        if (args.length > 1) {
            target = Bukkit.getPlayerExact(args[0]);
            if (target == null) {
                Message.ERROR.send(player, DefaultMessage.PLAYER_NOT_FOUND.format(args[0]));
                return;
            }

            if (args[1].equalsIgnoreCase("reset")) {
                reset = true;
            } else {
                try {
                    speed = Integer.parseInt(args[1]);
                } catch (Exception e) {
                    Message.ERROR.send(player, "Você especificou um número inválido: " + args[1] + ".");
                    return;
                }
            }
        } else {
            target = player;
            if (args[0].equalsIgnoreCase("reset")) {
                reset = true;
            } else {
                try {
                    speed = Integer.parseInt(args[0]);
                } catch (Exception e) {

                    Message.ERROR.send(player, "Você especificou um número inválido: " + args[0] + ".");
                    return;
                }
            }
        }

        if (reset) {
            resetPlayerSpeeds(target);
            Message.SUCCESS.send(player, "As velocidades de " + target.getName() + " foram resetadas.");
            return;
        }

        speed = Math.max(0, Math.min(10, speed));

        float finalSpeed = speed / 10F;

        if (target.isFlying()) {
            target.setFlySpeed(finalSpeed);
        } else {
            target.setWalkSpeed(finalSpeed);
        }

        String mode = (target.isFlying() ? "voo" : "corrida");

        if (target.getName().equals(player.getName())) {
            Message.SUCCESS.send(player, "Sua velocidade de " + mode + " foi alterada para: " + speed + ".");
        } else {
            Message.SUCCESS.send(player, "A velocidade de " + mode + " de " + target.getName() + " foi alterada para: " + speed + ".");
        }

    }


    private void resetPlayerSpeeds(Player player) {
        player.setFlySpeed(0.1f);
        player.setWalkSpeed(0.2f);
    }
}
