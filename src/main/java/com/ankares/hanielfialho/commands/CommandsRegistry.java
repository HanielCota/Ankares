package com.ankares.hanielfialho.commands;

import co.aikar.commands.Locales;
import co.aikar.commands.PaperCommandManager;
import com.ankares.hanielfialho.Ankares;
import com.ankares.hanielfialho.chat.GlobalChat;
import com.ankares.hanielfialho.commands.basics.*;
import com.ankares.hanielfialho.teleporter.TeleporterCommand;

import java.util.logging.Logger;

import static com.ankares.hanielfialho.Ankares.getInstance;

public class CommandsRegistry {

    public CommandsRegistry(Ankares plugin) {
        Logger logger = getInstance().getLogger();
        try {
            PaperCommandManager manager = new PaperCommandManager(plugin);
            manager.registerCommand(new ThorCommand());
            manager.registerCommand(new ColorsCommand());
            manager.registerCommand(new EnchantCommand());
            manager.registerCommand(new HatCommand());
            manager.registerCommand(new HealCommand());
            manager.registerCommand(new SpeedCommand());
            manager.registerCommand(new TpaAllCommand());
            manager.registerCommand(new ClearCommand());
            manager.registerCommand(new CraftCommand());
            manager.registerCommand(new LigthCommand());
            manager.registerCommand(new DayCommand());
            manager.registerCommand(new NigthCommand());
            manager.registerCommand(new TpCoordinatesCommand());
            manager.registerCommand(new TeleportCommand());
            manager.registerCommand(new ClearChatCommand());
            manager.registerCommand(new LocationCommand());
            manager.registerCommand(new RocketCommand());
            manager.registerCommand(new TeleporterCommand());
            manager.registerCommand(new GamemodeCommand());
            manager.registerCommand(new FlyCommand());
            manager.registerCommand(new SpawnCommand());
            manager.registerCommand(new GlobalChat());
            manager.registerCommand(new KillCommand());

            manager.getLocales().setDefaultLocale(Locales.PORTUGUESE);
            logger.info("§awere registered successful commands!");
        } catch (RuntimeException e) {
            e.printStackTrace();
            logger.severe("§ccould not register commands.");
        }
    }
}
