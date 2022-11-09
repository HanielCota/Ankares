package com.ankares.hanielfialho.util;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public record SoundWrapper(Sound sound, float volume, float pitch) {

    public void play(Player sender) {
        sender.playSound(sender.getLocation(), sound, volume, pitch);
    }
}
