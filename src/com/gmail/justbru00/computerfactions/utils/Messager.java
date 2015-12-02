/**
 * @author Justin Brubaker
 * THE (“ComputerFactions”) SOURCE IS PROVIDED AS IS AT NO MONETARY COST FOR PERSONAL USE ONLY. 
 * ANY COMMERCIAL OR NON-COMMERCIAL DISTRIBUTION/USE OF THE (“ComputerFactions”) SOURCE IS STRICTLY PROHIBITED.
 * THE CODE CONTAINED WITHIN THIS CLASS IS COPYRIGHT 2015 ("Justin Brubaker").
 */
package com.gmail.justbru00.computerfactions.utils;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.gmail.justbru00.computerfactions.main.Main;

public class Messager {

	public static void msgConsole(ConsoleCommandSender c, String msg) {
		c.sendMessage(Main.Prefix + ColorConverter.color(msg));
	}
	
	public static void msgPlayer(Player p, String msg) {
		p.sendMessage(Main.Prefix + ColorConverter.color(msg));
	}
	
	public static void msgSender(CommandSender s, String msg) {
		s.sendMessage(Main.Prefix + ColorConverter.color(msg));
	}
	
}
