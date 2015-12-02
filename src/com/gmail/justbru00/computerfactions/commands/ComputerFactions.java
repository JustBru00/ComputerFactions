/**
 * @author Justin Brubaker
 * THE (“ComputerFactions”) SOURCE IS PROVIDED AS IS AT NO MONETARY COST FOR PERSONAL USE ONLY. 
 * ANY COMMERCIAL OR NON-COMMERCIAL DISTRIBUTION/USE OF THE (“ComputerFactions”) SOURCE IS STRICTLY PROHIBITED.
 * THE CODE CONTAINED WITHIN THIS CLASS IS COPYRIGHT 2015 ("Justin Brubaker").
 */
package com.gmail.justbru00.computerfactions.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.gmail.justbru00.computerfactions.main.Main;
import com.gmail.justbru00.computerfactions.utils.Messager;

public class ComputerFactions implements CommandExecutor {
	
	Main main;
	
	public ComputerFactions(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("computerfactions")) {
			if (sender.hasPermission(main.config.getString("commands.computerfactions.permission"))) {
				if (args.length == 1) {
						if (args[0].equalsIgnoreCase("version")) {
							
							return true;
						} else if (args[0].equalsIgnoreCase("license")) {
							
							return true;
						} else if (args[0].equalsIgnoreCase("status")) {
							
							return true;
						} else {
							Messager.msgSender(sender, main.config.getString("messages.computerfactions.argserror"));
							return true;
						}
				} else {
					Messager.msgSender(sender, main.config.getString("messages.computerfactions.argserror"));
					return true;
				}
			} else {
				Messager.msgSender(sender, main.config.getString("messages.computerfactions.noperms"));
				return true;
			}
		}		
		return false;
	}

}
