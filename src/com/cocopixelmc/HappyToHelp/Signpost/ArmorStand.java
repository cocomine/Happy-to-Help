package com.cocopixelmc.HappyToHelp.Signpost;

import org.bukkit.configuration.file.FileConfiguration;

import com.cocopixelmc.HappyToHelp.Main;

public class ArmorStand {

	private Main plugin;

	public ArmorStand(Main plugin) {
		this.plugin=plugin;
	    //plugin.getServer().getPluginManager().registerEvents(this, plugin);
		FileConfiguration config = plugin.SignpostConfig;
	}
	
}
