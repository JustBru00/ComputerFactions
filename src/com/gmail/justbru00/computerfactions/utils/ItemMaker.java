/**
 * @author Justin Brubaker
 * This class is copyright 2015 Justin Brubaker.
 * DO NOT REMOVE THIS COMMENT!
 */
package com.gmail.justbru00.computerfactions.utils;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemMaker {
	
	public static final short NO_DATA_VALUE = -1;
	private static ItemStack is;

	public static ItemStack createItem(String material, String name, short dataValue) {		
		if (dataValue == ItemMaker.NO_DATA_VALUE) {
			 is = new ItemStack(Material.getMaterial(material), 1);
		} else {
		     is = new ItemStack(Material.getMaterial(material), 1, dataValue);
		}
		
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ColorConverter.color(name));
		
		is.setItemMeta(im);
		return is;
	}
	
	public static ItemStack createItem(String material, String name, String lore, short dataValue) {
		
		ArrayList<String> loreList = new ArrayList<String>();
		loreList.add(ColorConverter.color(lore));
		
		if (dataValue == ItemMaker.NO_DATA_VALUE) {
			 is = new ItemStack(Material.getMaterial(material), 1);
		} else {
		     is = new ItemStack(Material.getMaterial(material), 1, dataValue);
		}
		
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ColorConverter.color(name));
		
		is.setItemMeta(im);
		return is;
	}
}
