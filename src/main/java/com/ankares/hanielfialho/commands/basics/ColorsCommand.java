package com.ankares.hanielfialho.commands.basics;


import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import com.ankares.hanielfialho.messages.MessageUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@CommandAlias("cores")
public class ColorsCommand extends BaseCommand {

    @Default
    private void onCommand(Player player) {
        player.sendMessage(
                "\nCores disponíveis:"
                        + "\n &0 " + MessageUtils.translateColorCodes("&0Preto")
                        + ChatColor.WHITE
                        + "\n &1 " + MessageUtils.translateColorCodes("&1Azul Escuro")
                        + ChatColor.WHITE
                        + "\n &2 " + MessageUtils.translateColorCodes("&2Verde Escuro")
                        + ChatColor.WHITE
                        + "\n &3 " + MessageUtils.translateColorCodes("&3Aqua Escuro")
                        + ChatColor.WHITE
                        + "\n &4 " + MessageUtils.translateColorCodes("&4Vermelho Escuro")
                        + ChatColor.WHITE
                        + "\n &5 " + MessageUtils.translateColorCodes("&5Roxo Escuro")
                        + ChatColor.WHITE
                        + "\n &6 " + MessageUtils.translateColorCodes("&6Laranja")
                        + ChatColor.WHITE
                        + "\n &7 " + MessageUtils.translateColorCodes("&7Cinza")
                        + ChatColor.WHITE
                        + "\n &8 " + MessageUtils.translateColorCodes("&8Cinza Escuro")
                        + ChatColor.WHITE
                        + "\n &9 " + MessageUtils.translateColorCodes("&9Azul")
                        + ChatColor.WHITE
                        + "\n &a " + MessageUtils.translateColorCodes("&aVerde")
                        + ChatColor.WHITE
                        + "\n &b " + MessageUtils.translateColorCodes("&bAqua")
                        + ChatColor.WHITE
                        + "\n &c " + MessageUtils.translateColorCodes("&cVermelho")
                        + ChatColor.WHITE
                        + "\n &d " + MessageUtils.translateColorCodes("&dRoxo Claro")
                        + ChatColor.WHITE
                        + "\n &e " + MessageUtils.translateColorCodes("&eAmarelo")
                        + ChatColor.WHITE
                        + "\n &f " + MessageUtils.translateColorCodes("&fBranco")
                        + "\n "
        );
    }
}
