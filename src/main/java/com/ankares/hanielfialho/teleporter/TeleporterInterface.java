package com.ankares.hanielfialho.teleporter;

import org.bukkit.entity.Player;

public interface TeleporterInterface {

    void teleport(Player player, String localname);

    void setTeleport(Player player, String localname);

    void deleteWarp(Player player, String localname);

    void sendSpawn(Player player);

}
