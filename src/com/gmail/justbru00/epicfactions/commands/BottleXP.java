package com.gmail.justbru00.epicfactions.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.justbru00.epicfactions.main.Main;
import com.gmail.justbru00.epicfactions.utils.ItemMaker;
import com.gmail.justbru00.epicfactions.utils.Messager;

public class BottleXP implements CommandExecutor {

	Main main;
	
	public BottleXP(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(command.getName().equalsIgnoreCase("bottlexp")) {
			if (!sender.hasPermission(main.config.getString("commands.bottlexp.permission"))) {
				Messager.msgSender(sender, main.config.getString("messages.bottlexp.noperms"));
				return true;
			}
			
			if (sender instanceof Player) {
				Player p = (Player) sender;
				
				if (args.length == 1) {
					
					int withdraw;
					try {
					withdraw = Integer.parseInt(args[0]);
					} catch (Exception e) {
						Messager.msgPlayer(p, main.config.getString("messages.bottlexp.invalidnumber"));
						return true;
					}
					
					if (p.getLevel() < withdraw) {
						Messager.msgPlayer(p, main.config.getString("messages.bottlexp.notenoughlvls"));
						return true;
					}
					
					int newlvl = p.getLevel() - withdraw;
					
					p.setLevel(newlvl);
					
					p.getInventory().addItem(ItemMaker.createItem("EXP_BOTTLE", "&eXP BOTTLE", "&f" + withdraw + " XP", ItemMaker.NO_DATA_VALUE));
					
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
					Messager.msgPlayer(p, main.config.getString("messages.bottlexp.success"));
					
					return true;
				} else {
					Messager.msgPlayer(p, main.config.getString("messages.bottlexp.argserror"));
					return true;
				}
			} else {
				Messager.msgSender(sender, main.config.getString("messages.bottlexp.invaildsender"));
				return true;
			}
		}

		return false;
	}

}
