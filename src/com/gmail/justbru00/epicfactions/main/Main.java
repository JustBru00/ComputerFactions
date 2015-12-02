/**
 * @author Justin Brubaker
 * THE (“EpicFactions”) SOURCE IS PROVIDED AS IS AT NO MONETARY COST FOR PERSONAL USE ONLY. 
 * ANY COMMERCIAL OR NON-COMMERCIAL DISTRIBUTION/USE OF THE (“EpicFactions”) SOURCE IS STRICTLY PROHIBITED.
 * THE CODE CONTAINED WITHIN THIS CLASS IS COPYRIGHT 2015 ("Justin Brubaker").
 */
package com.gmail.justbru00.epicfactions.main;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.justbru00.epicfactions.commands.EpicFactions;
import com.gmail.justbru00.epicfactions.utils.ColorConverter;
import com.gmail.justbru00.epicfactions.utils.Messager;

public class Main extends JavaPlugin {
	
	// Setup Prefix and Console for messaging.
	public static String Prefix = ColorConverter.color("&8[&bEpic&fFactions&8] &f");	
	public static ConsoleCommandSender c = Bukkit.getServer().getConsoleSender();
	public FileConfiguration config;
	
	// Setup Version, Authors and Config version
	public final String PLUGIN_VERSION = this.getDescription().getVersion();
	public final List<String> PLUGIN_AUTHORS = this.getDescription().getAuthors();
	public final int CONFIG_VERSION = 1;

	@Override
	public void onDisable() {
		disablePlugin();
	}

	@Override
	public void onEnable() {
		enablePlugin();
	}

	
	public void enablePlugin() {		
		
		// Message Console
		Messager.msgConsole(c, "EpicFactions plugin by Justin Brubaker.");
		Messager.msgConsole(c, "THE (\"Epicfactions\") SOURCE IS PROVIDED AS IS AT NO MONETARY COST FOR PERSONAL USE ONLY."
				+ "ANY COMMERCIAL OR NON-COMMERCIAL DISTRIBUTION/USE OF THE (\"EpicFactions\") SOURCE IS STRICTLY PROHIBITED."
				+ " THIS PLUGIN IS COPYRIGHT 2015 (\"Justin Brubaker\").");
		Messager.msgConsole(c, "\n\n&aENABLE START.");
		
		// Save Config
		saveDefaultConfig();
		
		// Set Prefix
		this.config = this.getConfig();
		Main.Prefix = config.getString("messages.prefix");
		
		// Register Listeners 
		
		// Register Command Handlers 
		this.getCommand("epicfactions").setExecutor(new EpicFactions(this));
		
		Messager.msgConsole(c, "&aEnabled Sucessfully.");
	}
	
	public void disablePlugin() {
		
	}
}
