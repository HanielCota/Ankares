package com.ankares.hanielfialho.listener.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class BlockNaturalSpawnListener implements Listener {

    @EventHandler
    public void onSpawnNaturally(CreatureSpawnEvent e) {
        CreatureSpawnEvent.SpawnReason reason = e.getSpawnReason();
        switch (reason) {
            case NATURAL, SPAWNER, CHUNK_GEN, JOCKEY, MOUNT -> e.setCancelled(true);
        }
    }
}
