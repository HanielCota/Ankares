package com.ankares.hanielfialho.commands.basics;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import org.bukkit.World;
import org.bukkit.entity.Player;

@CommandAlias("day|dia")
@CommandPermission("ankares.op")
public class DayCommand extends BaseCommand {

    @Default
    private void setDay(Player player) {
        World world = player.getWorld();
        world.setTime(1500);
        player.sendMessage("§aVocê mudou o mundo para dia.");
    }
}
