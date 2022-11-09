package com.ankares.hanielfialho.chat;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import com.ankares.hanielfialho.messages.MessageUtils;
import com.ankares.hanielfialho.util.ClickMessage;
import com.ankares.hanielfialho.util.CooldownManager;
import net.md_5.bungee.api.chat.ClickEvent;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.concurrent.TimeUnit;

@CommandAlias("g|global")
public class GlobalChat extends BaseCommand {
    private final CooldownManager cooldownManager = new CooldownManager();

    @Default
    private void onCommand(Player player, String[] args) {
        String format = "&7[G] " + player.getName() + ":";
        String message = StringUtils.join(args, ' ', 0, args.length);
        long timeLeft = (int) (System.currentTimeMillis() - cooldownManager.getCooldown(player.getUniqueId()));
        if (TimeUnit.MILLISECONDS.toSeconds(timeLeft) >= CooldownManager.DEFAULT_COOLDOWN) {
            Bukkit.getOnlinePlayers().forEach(online -> online.sendMessage(MessageUtils.translateColorCodes(format + " " + MessageUtils.stripColor(message))));
            cooldownManager.setCooldown(player.getUniqueId(), (int) System.currentTimeMillis());
        } else {
            new ClickMessage("").then("§cAguarde " + (CooldownManager.DEFAULT_COOLDOWN - TimeUnit.MILLISECONDS.toSeconds(timeLeft)) + " para falar no global.").tooltip("§aVIPS não possuem delay para falar.").click(ClickEvent.Action.OPEN_URL, "http://ankares.com/").send(player);
        }
    }
}