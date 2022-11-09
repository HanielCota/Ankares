package com.ankares.hanielfialho.listener.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

public class BlockFreezeListener implements Listener {

    @EventHandler
    public void onFreeze(BlockFormEvent e) {
        if (!e.getBlock().getType().toString().contains("WATER")) return;
        e.setCancelled(true);
    }
}