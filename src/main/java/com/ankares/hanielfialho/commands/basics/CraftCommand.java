package com.ankares.hanielfialho.commands.basics;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import org.bukkit.entity.Player;

@CommandPermission("ankares.vip")
@CommandAlias("craft")
public class CraftCommand extends BaseCommand {

    @Default
    private void onCommand(Player player) {
        player.openWorkbench(player.getLocation(), true);
    }

}
