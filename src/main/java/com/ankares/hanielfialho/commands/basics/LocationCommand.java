package com.ankares.hanielfialho.commands.basics;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.ankares.hanielfialho.util.ClickMessage;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;

@CommandPermission("ankares.op")
@CommandAlias("location")
public class LocationCommand extends BaseCommand {

    @Default
    private void onCommand(Player player) {
        Location l = player.getLocation();
        DecimalFormat format = new DecimalFormat("#.##");

        player.sendMessage("§aSua localização atual: \n" + "§6  WORLD: §e" + l.getWorld().getName() + "\n  §6X: §e" + format.format(l.getX()) + "\n  §6Y: §e" + format.format(l.getBlockY()) + "\n  §6Z: §e" + format.format(l.getZ()) + "\n  §6YAW: §e" + l.getYaw() + "\n  §6PITCH: §e" + l.getPitch());

        new ClickMessage("").then("§bClique para copiar ").click(ClickEvent.Action.SUGGEST_COMMAND, "new Location(Bukkit.getWorld(\"" + l.getWorld().getName() + "\"), " + format.format(l.getX()) + ", " + format.format(l.getY()) + ", " + format.format(l.getZ()) + ", " + format.format(l.getYaw()) + "F, " + format.format(l.getPitch()) + "F)").send(player);

    }
}
