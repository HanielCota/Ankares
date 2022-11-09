package com.ankares.hanielfialho.chat;

import com.ankares.hanielfialho.messages.Message;
import lombok.val;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class LocalChat implements Listener {


    @EventHandler(priority = EventPriority.MONITOR)
    public void on(AsyncPlayerChatEvent event) {
        if (event.isCancelled()) {
            return;
        }

        val player = event.getPlayer();
        val message = event.getMessage();

        for (Entity entity : player.getWorld().getNearbyEntities(player.getLocation(), 70, 70, 70)) {

            if (!(entity instanceof Player target)) {
                continue;
            }

            val format = "§e[L] " + player.getName() + "§e:";

            if (player.hasPermission("ankares.chat.destaque")) {
                target.sendMessage(new String[]{"", format + " " + ChatColor.translateAlternateColorCodes('&', message), ""});
            } else if (player.hasPermission("ankares.chat.color")) {
                target.sendMessage(format + " " + ChatColor.translateAlternateColorCodes('&', message));
            } else {
                target.sendMessage(format + " " + message);
            }
            event.setCancelled(true);
        }

        List<Entity> entityList = player.getWorld().getNearbyEntities(player.getLocation(), 70, 70, 70).stream().filter(entity -> (entity instanceof Player) && !entity.getName().equalsIgnoreCase(player.getName())).toList();

        if (entityList.isEmpty()) {
            Message.ERROR.send(player, "§cNão há ninguém por perto :(");
            event.setCancelled(true);
        }
    }
}
