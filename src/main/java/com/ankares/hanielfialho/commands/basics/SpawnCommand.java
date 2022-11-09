package com.ankares.hanielfialho.commands.basics;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import com.ankares.hanielfialho.teleporter.TeleporterBuilder;
import org.bukkit.entity.Player;


@CommandAlias("spawn")
public class SpawnCommand extends BaseCommand {

    @Default
    private void onCommand(Player player) {
        new TeleporterBuilder().sendSpawn(player);
    }
}
