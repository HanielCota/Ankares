package com.ankares.hanielfialho.listener.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;

public class BlockDecayListener implements Listener {

    @EventHandler
    public void onLeaves(LeavesDecayEvent e) {
        e.setCancelled(true);
    }

}
