/**
 * @author Justin Brubaker
 * THE (“EpicFactions”) SOURCE IS PROVIDED AS IS AT NO MONETARY COST FOR PERSONAL USE ONLY. 
 * ANY COMMERCIAL OR NON-COMMERCIAL DISTRIBUTION/USE OF THE (“EpicFactions”) SOURCE IS STRICTLY PROHIBITED.
 * THE CODE CONTAINED WITHIN THIS CLASS IS COPYRIGHT 2015 ("Justin Brubaker").
 */
package com.gmail.justbru00.epicfactions.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.gmail.justbru00.epicfactions.main.Main;
import com.gmail.justbru00.epicfactions.utils.Messager;

public class EpicFactions implements CommandExecutor {
	
	Main main;
	
	public EpicFactions(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("epicfactions")) {
			if (sender.hasPermission(main.config.getString("commands.epicfactions.permission"))) {
				if (args.length == 1) {
						if (args[0].equalsIgnoreCase("version")) {
							Messager.msgSender(sender, "");
							return true;
						} else if (args[0].equalsIgnoreCase("license")) {
							
							return true;
						} else if (args[0].equalsIgnoreCase("status")) {
							
							return true;
						} else {
							Messager.msgSender(sender, main.config.getString("messages.epicfactions.argserror"));
							return true;
						}
				} else {
					Messager.msgSender(sender, main.config.getString("messages.epicfactions.argserror"));
					return true;
				}
			} else {
				Messager.msgSender(sender, main.config.getString("messages.epicfactions.noperms"));
				return true;
			}
		}		
		return false;
	}

}
