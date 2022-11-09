package com.ankares.hanielfialho.listener.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockIgniteEvent;

public class BlockFireListener implements Listener {


    @EventHandler
    public void onSpreadFire(BlockIgniteEvent e) {
        switch (e.getCause()) {
            case LAVA, SPREAD -> e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockFire(BlockBurnEvent e) {
        e.setCancelled(true);
    }

}