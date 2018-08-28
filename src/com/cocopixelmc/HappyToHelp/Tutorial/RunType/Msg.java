package com.cocopixelmc.HappyToHelp.Tutorial.RunType;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.cocopixelmc.HappyToHelp.Main;

import me.clip.placeholderapi.PlaceholderAPI;

public class Msg {

	public Msg(Main plugin){
	}
	
	public static void SendMsg(Player player, List<Object> list){
		for(Object msg : list){
			String colormsg = ChatColor.translateAlternateColorCodes('&', msg.toString());
			colormsg = PlaceholderAPI.setPlaceholders(player, colormsg);
			colormsg = "HappyHelp" + ChatColor.RESET + colormsg;
			player.sendMessage(colormsg);
		}
	}
}
