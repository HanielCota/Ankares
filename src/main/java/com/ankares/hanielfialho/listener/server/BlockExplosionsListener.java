package com.ankares.hanielfialho.listener.server;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class BlockExplosionsListener implements Listener {

    @EventHandler
    public void onBlockExplode(EntityExplodeEvent event) {
        EntityType entity = event.getEntity().getType();
        switch (entity) {
            case ENDER_DRAGON, PRIMED_TNT, MINECART_TNT -> {
                event.setCancelled(true);
                event.blockList().clear();
            }
        }
    }

    @EventHandler
    public void explosionPrime(ExplosionPrimeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void explosion(BlockExplodeEvent e) {
        e.setCancelled(true);
    }
}
