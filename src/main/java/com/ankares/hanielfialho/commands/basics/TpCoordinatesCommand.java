package com.ankares.hanielfialho.commands.basics;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Player;

@CommandAlias("tpc")
@CommandPermission("ankares.op")
public class TpCoordinatesCommand extends BaseCommand {
    @Default
    private void tpCoordinates(Player p, String[] args) {
        Player player = Bukkit.getServer().getPlayer(p.getName());
        Location playerloc = player.getLocation();
        Chunk chunk = player.getWorld().getChunkAt(playerloc);
        Bukkit.getWorld(player.getWorld().getName()).loadChunk(chunk);

        try {
            double x = Double.parseDouble(args[0]);
            double y = Double.parseDouble(args[1]);
            double z = Double.parseDouble(args[2]);
            playerloc = new Location(player.getWorld(), x, y, z);
            player.teleport(playerloc);
        } catch (Exception ex) {
            p.sendMessage("§cVocê não tinha todos os argumentos necessários! tentar /tpc [x] [y] [z]");
        }
    }
}