package com.ankares.hanielfialho.teleporter;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.entity.Player;

@CommandAlias("warp|warps")
public class TeleporterCommand extends BaseCommand {

    @CommandCompletion("spawn|crates|pesca|plot")
    @Default
    private void onCommand(Player player, String[] args) {
        if (args.length == 0) {
            return;
        }
        String location = args[0];
        if (args.length == 1 && (args[0]) != null) {
            new TeleporterBuilder().teleport(player, location);
        }
    }

    @CommandCompletion("spawn|crates|pesca|plot")
    @Subcommand("set")
    private void setLocation(Player player, String[] args) {
        String location = args[0];
        new TeleporterBuilder().setTeleport(player, location);
    }

    @Subcommand("delete")
    private void deleteLocation(Player player, String args) {
        new TeleporterBuilder().deleteWarp(player, args);
    }

}
