/**
 * @author Justin Brubaker
 * THE (“EpicFactions”) SOURCE IS PROVIDED AS IS AT NO MONETARY COST FOR PERSONAL USE ONLY. 
 * ANY COMMERCIAL OR NON-COMMERCIAL DISTRIBUTION/USE OF THE (“EpicFactions”) SOURCE IS STRICTLY PROHIBITED.
 * THE CODE CONTAINED WITHIN THIS CLASS IS COPYRIGHT 2015 ("Justin Brubaker").
 */
package com.gmail.justbru00.epicfactions.utils;

import org.bukkit.ChatColor;

public class ColorConverter {

	public static String color(String unformated) {
		return ChatColor.translateAlternateColorCodes('&', unformated);
	}
}
