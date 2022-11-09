package com.ankares.hanielfialho.commands.basics;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.ankares.hanielfialho.messages.Message;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@CommandPermission("ankares.op")
@CommandAlias("hat|chapeu")
public class HatCommand extends BaseCommand {


    @Default
    private void onCommand(Player player) {
        ItemStack item = player.getItemInHand();
        if (item != null && ! item.getType().equals(Material.AIR)) {
            if (item.getType().getMaxDurability() > 0) {
                Message.ERROR.send(player, "Não é possível por este item na cabeça.");
                return;
            }
            ItemStack inHead = player.getInventory().getHelmet();
            player.getInventory().setHelmet(item);
            player.setItemInHand(inHead);
            Message.SUCCESS.send(player, "Você colocou um chapéu!");
        } else {
            Message.ERROR.send(player, "Você não está segurando nenhum item.");
        }
    }
}
