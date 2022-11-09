package com.ankares.hanielfialho.listener.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import org.bukkit.event.entity.EntityCombustByEntityEvent;
import org.bukkit.event.entity.EntityCombustEvent;

public class BlockFireEntityListener implements Listener {

    @EventHandler
    public void onFireEntity(EntityCombustEvent e) {
        if (!(e instanceof EntityCombustByEntityEvent) && !(e instanceof EntityCombustByBlockEvent))
            e.setCancelled(true);
    }
}
