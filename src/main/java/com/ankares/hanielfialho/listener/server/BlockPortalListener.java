package com.ankares.hanielfialho.listener.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.PortalCreateEvent;

public class BlockPortalListener implements Listener {

    @EventHandler
    public void onPortalCreated(PortalCreateEvent e) {
        e.setCancelled(true);
    }
}

