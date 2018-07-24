package com.cocopixelmc.HappyToHelp.Tutorial.RunType;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.connorlinfoot.actionbarapi.ActionBarAPI;

public class ActionBar {

	public ActionBar(){
	}
	
	public static void SendActionBar(Player player, String msg){
		String colormsg = ChatColor.translateAlternateColorCodes('&', msg);
		ActionBarAPI.sendActionBar(player, colormsg);
	}
}
