package com.ankares.hanielfialho.teleporter;

import com.ankares.hanielfialho.messages.Message;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;

import static com.ankares.hanielfialho.Ankares.getInstance;

public class TeleporterBuilder implements TeleporterInterface {


    private final File file = new File("plugins/" + "Ankares", "warps/warps.yml");
    private final YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

    @Override
    public void teleport(Player player, String localname) {
        if (config.getString(localname) != null) {
            if (player.hasPermission("ankares.vip")) {
                Bukkit.getPluginManager().callEvent(new TeleporterEvent(player));
                player.teleport((Location) config.get(localname));
                return;
            }
            Bukkit.getPluginManager().callEvent(new TeleporterEvent(player));
            Message.SUCCESS.send(player, "Requisitando " + localname + "...");
            new BukkitRunnable() {
                @Override
                public void run() {
                    Message.SUCCESS.send(player, "Você chegou ao " + localname + "!");
                    player.teleport((Location) config.get(localname));
                }
            }.runTaskLaterAsynchronously(getInstance(), 60);
        }
    }

    @Override
    public void setTeleport(Player player, String localname) {
        config.set(localname, player.getLocation());
        try {
            config.save(file);
            Message.SUCCESS.send(player, "Salvando localização....");
        } catch (IOException e) {
            throw new RuntimeException("§cErro ao salvar localização " + localname);
        }
    }

    @Override
    public void deleteWarp(Player player, String localname) {
        if (config.getString(localname) != null) {
            config.set(localname, null);
            try {
                Message.SUCCESS.send(player, "Você deletou a Warp " + localname);
                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void sendSpawn(Player player) {
        if (config.getString("spawn") != null) {
            if (player.hasPermission("ankares.vip")) {
                Bukkit.getPluginManager().callEvent(new TeleporterEvent(player));
                player.teleport((Location) config.get("spawn"));
                return;
            }
            Bukkit.getPluginManager().callEvent(new TeleporterEvent(player));
            Message.SUCCESS.send(player, "Requisitando " + "spawn" + "...");
            new BukkitRunnable() {
                @Override
                public void run() {
                    Message.SUCCESS.send(player, "Você chegou ao " + "spawn" + "!");
                    player.teleport((Location) config.get("spawn"));
                }
            }.runTaskLaterAsynchronously(getInstance(), 60);
        }
    }

    public void sendSpawnNoDelay(Player player) {
        if (config.getString("spawn") == null) {
            Message.ERROR.send(player, "Area principal não está setada.");
            return;
        }
        player.teleport((Location) config.get("spawn"));
    }
}
