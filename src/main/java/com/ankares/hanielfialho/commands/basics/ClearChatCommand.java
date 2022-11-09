package com.ankares.hanielfialho.commands.basics;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.IntStream;

@CommandAlias("cc|clearchat")
@CommandPermission("ankares.op")
public class ClearChatCommand extends BaseCommand {

    @Default
    private void clearChat(Player player) {
        IntStream.range(0, 200).forEach(i -> Bukkit.getOnlinePlayers().forEach(consumer -> consumer.sendMessage("")));

        TextComponent component = new TextComponent("");
        Arrays.stream(TextComponent.fromLegacyText("§aExecutamos uma limpeza no chat!")).forEach(component::addExtra);
        component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                TextComponent.fromLegacyText("§fAutor: §r" + (player.getName()) + "\n§fData: §7" + new SimpleDateFormat("d 'de' MMMM. yyyy 'às' HH:mm", Locale.forLanguageTag("pt-BR")).format(System.currentTimeMillis()))));
        Bukkit.getOnlinePlayers().forEach(consumer -> consumer.spigot().sendMessage(component));
    }
}
