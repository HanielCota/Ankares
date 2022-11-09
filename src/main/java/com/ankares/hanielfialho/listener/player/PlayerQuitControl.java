package com.ankares.hanielfialho.listener.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitControl implements Listener {

    @EventHandler
    private void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
    }
}
