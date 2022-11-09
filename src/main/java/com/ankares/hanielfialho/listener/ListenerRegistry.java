package com.ankares.hanielfialho.listener;

import com.ankares.hanielfialho.Ankares;
import com.ankares.hanielfialho.chat.LocalChat;
import com.ankares.hanielfialho.listener.player.PlayerJoinControl;
import com.ankares.hanielfialho.listener.player.PlayerQuitControl;
import com.ankares.hanielfialho.listener.server.*;
import lombok.val;
import org.bukkit.Bukkit;

import java.util.Arrays;

public class ListenerRegistry {

    public ListenerRegistry(Ankares plugin) {
        val logger = plugin.getLogger();
        try {
            val pluginManager = Bukkit.getPluginManager();
            val listeners = Arrays.asList(
                    new BlockVoidListener(),
                    new BlockVehicleListener(),
                    new BlockSmeltSnowListener(),
                    new BlockNaturalSpawnListener(),
                    new BlockPlantationDamageListener(),
                    new BlockFreezeListener(),
                    new BlockFoodWorldListener(),
                    new BlockFireListener(),
                    new BlockFireEntityListener(),
                    new BlockExplodeItemListener(),
                    new BlockDecayListener(),
                    new BlockWeatherListener(),
                    new BlockFallDamage(),
                    new PlayerJoinControl(),
                    new PlayerQuitControl(),
                    new LocalChat(),
                    new BlockExplosionsListener());
            listeners.forEach(listener -> pluginManager.registerEvents(listener, plugin));
            logger.info("§awere registered " + listeners.size() + " successful listeners!");
        } catch (Throwable t) {
            t.printStackTrace();
            logger.severe("§cCould not register listeners.");
        }
    }
}
