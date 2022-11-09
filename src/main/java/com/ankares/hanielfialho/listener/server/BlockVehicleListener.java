package com.ankares.hanielfialho.listener.server;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;

public class BlockVehicleListener implements Listener {

    @EventHandler
    public void onVehicle(VehicleEnterEvent e) {
        Entity entity = e.getEntered();
        if (entity.getType() != EntityType.PLAYER) return;

        Player player = (Player) entity;
        if (player.hasPermission("ankares.op")) return;

        e.setCancelled(true);
    }
}
