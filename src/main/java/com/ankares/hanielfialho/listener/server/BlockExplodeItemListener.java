package com.ankares.hanielfialho.listener.server;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class BlockExplodeItemListener implements Listener {


    @EventHandler
    public void onItemExplode(EntityDamageByEntityEvent e) {
        Entity entity = e.getEntity();
        if (entity instanceof Item) e.setCancelled(true);
    }
}
