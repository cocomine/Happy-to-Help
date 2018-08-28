package com.cocopixelmc.HappyToHelp.Tutorial.RunType;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.connorlinfoot.actionbarapi.ActionBarAPI;

import me.clip.placeholderapi.PlaceholderAPI;

public class ActionBar {

	public ActionBar(){
	}
	
	public static void SendActionBar(Player player, String msg){
		String colormsg = ChatColor.translateAlternateColorCodes('&', msg);
		colormsg = PlaceholderAPI.setPlaceholders(player, colormsg);
		ActionBarAPI.sendActionBar(player, colormsg);
	}
}
