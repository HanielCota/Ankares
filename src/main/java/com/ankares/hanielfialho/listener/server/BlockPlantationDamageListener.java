package com.ankares.hanielfialho.listener.server;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class BlockPlantationDamageListener implements Listener {

    @EventHandler
    public void onJumpPlantation(EntityChangeBlockEvent e) {
        if (e.getBlock().getType() != Material.SOIL) return;
        e.setCancelled(true);
    }
}