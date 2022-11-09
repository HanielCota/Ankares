package com.ankares.hanielfialho.commands.basics;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

@CommandAlias("encantar|enchant")
@CommandPermission("ankares.op")
public class EnchantCommand extends BaseCommand {
    @Default
    private void onCommand(Player s, String[] args) {
        if (args.length != 2) {
            s.sendMessage("§cVocê deve usar /encantar <enchant> <valor>");
            return;
        }
        String en = args[0].toUpperCase();
        Enchantment ench = getEnchantment(en);
        if (ench == null) {
            s.sendMessage("§cVocê escreveu o nome do enchantment errado " + getEnchants());
            return;
        }
        int level;
        try {
            level = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            s.sendMessage("§cValor de enchantment errado...");
            return;
        }
        ItemStack hand = s.getItemInHand();
        if (hand == null || hand.getType() == Material.AIR) {
            s.sendMessage("§cSegura o item na mão");
            return;
        }

        hand.addUnsafeEnchantment(ench, level);
        s.sendMessage("§aVocê encantou com Sucesso.");
    }

    private Enchantment getEnchantment(String enchant) {
        try {
            return Enchantment.getByName(enchant);
        } catch (RuntimeException e) {
            return null;
        }
    }

    private String getEnchants() {
        List<String> enchants = new ArrayList<>();
        for (Enchantment e : Enchantment.values()) {
            if (e != null) {
                enchants.add(e.getName());
            }
        }
        return enchants.toString().replace(",", "§8,§7");
    }
}
