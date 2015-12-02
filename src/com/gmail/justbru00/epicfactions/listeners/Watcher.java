package com.gmail.justbru00.epicfactions.listeners;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.justbru00.epicfactions.main.Main;
import com.gmail.justbru00.epicfactions.utils.ColorConverter;
import com.gmail.justbru00.epicfactions.utils.Messager;

import net.md_5.bungee.api.ChatColor;

public class Watcher implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		
		if (e.getAction() == null) return;
		
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
				return;
		}
				
		
		ItemStack inHand = e.getItem();
		String itemname = inHand.getItemMeta().getDisplayName();
		
		if (!inHand.getItemMeta().hasLore()) return;
		
		ArrayList<String> itemlore = (ArrayList<String>) inHand.getItemMeta().getLore();
		
		if (inHand.getType() == Material.EXP_BOTTLE) {
			if (itemname == ColorConverter.color("&eXP BOTTLE")) {
				if (itemlore.get(0) == Main.Prefix) {
					Player p = e.getPlayer();
					
					int currentLvl = p.getLevel();
					
					String amount = itemlore.get(1);
					amount = ChatColor.stripColor(amount);
					amount = amount.replace("XP", "");
					
					int deposit = 0;
					try {
						deposit = Integer.parseInt(amount.trim());
					} catch (NumberFormatException nfe) {
						Messager.msgConsole(Main.c, "&4&lWARNING IF YOU SEE THIS PLEASE TELL THE PLUGIN DEVELOPER THE FOLLOWING: "
								+ "NumberFormatException in Interact Handler. Problem Parsing from String amount."
								+ "END OF DEBUGING.");
					}
					
					p.setLevel(currentLvl + deposit);
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
					
					return;
				}
			}
		}		
	}
}
