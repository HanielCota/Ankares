package com.ankares.hanielfialho.commands.basics;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.ankares.hanielfialho.messages.Message;
import com.ankares.hanielfialho.util.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

@CommandPermission("ankares.op")
@CommandAlias("heal|curar")
public class HealCommand extends BaseCommand {

    @CommandCompletion("@players")
    @Default
    private void onCommand(Player player, String[] args) {
        Player target;

        if (args.length == 0) {
            Message.ERROR.send(player, "Utilize /heal <player>.");
            return;
        }
        target = Bukkit.getPlayerExact(args[0]);
        if (target == null) {
            Message.ERROR.send(player, String.format("O jogador \"%s\" não está online.", args[0]));
            return;
        }

        if (target.isDead()) {
            Message.ERROR.send(player, "Este jogador está morto.");
            return;
        }

        if (target != player) {
            Message.SUCCESS.send(player, "O jogador " + target.getName() + " foi curado.");
        }

        PlayerUtils.healPlayer(target);
        target.setExhaustion(0F);
        target.setFireTicks(0);
        target.setFallDistance(0F);

        for (PotionEffect pe : target.getActivePotionEffects()) {
            if (target.hasPotionEffect(pe.getType())) {
                target.removePotionEffect(pe.getType());
            }
        }

        Message.SUCCESS.send(target, "Você foi curado.");
    }

}
