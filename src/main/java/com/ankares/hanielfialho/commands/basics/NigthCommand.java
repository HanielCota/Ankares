package com.ankares.hanielfialho.commands.basics;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import org.bukkit.World;
import org.bukkit.entity.Player;

@CommandAlias("nigth|noite")
@CommandPermission("ankares.op")
public class NigthCommand extends BaseCommand {

    @Default
    private void nigth(Player player) {
        World world = player.getWorld();
        world.setTime(19000L);
        player.sendMessage("§aVocê alterou o tempo deste mundo para: NOITE.");
    }
}
