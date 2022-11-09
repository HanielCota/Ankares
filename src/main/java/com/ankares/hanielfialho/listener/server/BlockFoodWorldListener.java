package com.ankares.hanielfialho.listener.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class BlockFoodWorldListener implements Listener {

    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent e) {
        e.setFoodLevel(20);
        e.setCancelled(true);
    }

}
