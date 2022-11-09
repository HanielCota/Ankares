package com.ankares.hanielfialho.listener.server;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

public class BlockSmeltSnowListener implements Listener {

    @EventHandler
    public void onSmeltSnow(BlockFadeEvent e) {
        Material type = e.getBlock().getType();
        if (type == Material.ICE || type == Material.SNOW) e.setCancelled(true);
    }
}
