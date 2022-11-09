package com.ankares.hanielfialho.listener.server;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class BlockFallDamage implements Listener {

    @EventHandler
    public void onDamageVoid(EntityDamageEvent e) {
        Entity entity = e.getEntity();
        if (entity.getType() != EntityType.PLAYER) return;
        if (!e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) return;
        e.setCancelled(true);
    }
}
