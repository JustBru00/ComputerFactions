/**
 * @author Justin Brubaker
 * This class is copyright 2015 Justin Brubaker.
 * DO NOT REMOVE THIS COMMENT!
 */
package com.gmail.justbru00.computerfactions.utils;

import org.bukkit.ChatColor;

public class ColorConverter {

	public static String color(String unformated) {
		return ChatColor.translateAlternateColorCodes('&', unformated);
	}
}
