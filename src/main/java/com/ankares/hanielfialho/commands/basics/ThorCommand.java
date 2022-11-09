package com.ankares.hanielfialho.commands.basics;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Default;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.Set;

@CommandAlias("thor")
public class ThorCommand extends BaseCommand {

    @CommandCompletion("@players")
    @Default
    private void onCommand(Player player, String[] args) {
        if (args.length == 0) {
            Block targetBlock = player.getTargetBlock((Set<Material>) null, 150);

            targetBlock.getWorld().strikeLightning(targetBlock.getLocation());

            player.sendMessage("§cO bloco que você esta olhando foi atingido por um raio.");
        } else {
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target == null) {
                player.sendMessage("§cJogador não está on-line!");
                return;
            }
            if (target != player) {
                player.sendMessage("§aO jogador " + target.getName() + " foi atingido por um raio!");
                target.getWorld().strikeLightning(target.getLocation());
                target.sendMessage(ChatColor.GOLD + "Você foi atingido por um raio!");
            }
        }
    }
}