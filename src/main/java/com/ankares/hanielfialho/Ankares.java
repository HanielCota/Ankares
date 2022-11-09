package com.ankares.hanielfialho;

import com.ankares.hanielfialho.commands.CommandsRegistry;
import com.ankares.hanielfialho.listener.ListenerRegistry;
import org.bukkit.plugin.java.JavaPlugin;

public final class Ankares extends JavaPlugin {

    public static Ankares getInstance() {
        return getPlugin(Ankares.class);
    }

    @Override
    public void onEnable() {
        new CommandsRegistry(this);
        new ListenerRegistry(this);
    }

}
