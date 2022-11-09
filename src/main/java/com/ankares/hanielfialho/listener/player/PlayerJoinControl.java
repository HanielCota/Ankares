package com.ankares.hanielfialho.listener.player;

import com.ankares.hanielfialho.teleporter.TeleporterBuilder;
import com.ankares.hanielfialho.util.TabList;
import lombok.val;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinControl implements Listener {

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event) {
        val player = event.getPlayer();
        TabList.setHeaderFooter(player, "\n§a§lANKARES\n   §7loja.ankares.com\n", "\n    §aAjuda nosso servidor comprando VIP e Brilhantes  §e\n§fObrigado por jogar em nossa rede!§e\n");
        new TeleporterBuilder().sendSpawnNoDelay(player);
        event.setJoinMessage(null);
    }
}
