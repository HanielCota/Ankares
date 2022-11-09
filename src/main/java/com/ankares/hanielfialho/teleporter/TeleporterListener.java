package com.ankares.hanielfialho.teleporter;

import com.ankares.hanielfialho.messages.Message;
import lombok.val;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TeleporterListener implements Listener {


    @EventHandler
    private void teleporterEvent(TeleporterEvent event) {
        val player = event.getPlayer();
        if (player.hasPermission("ankares.vip")) {
            Message.SUCCESS.send(player, "Você chegou ao seu destino.");
            sendEffect(player, 55);
        } else {
            sendEffect(player, 90);
        }
    }

    private void sendEffect(Player player, int duration) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, duration, 10));
    }
}