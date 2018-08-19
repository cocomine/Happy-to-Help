package com.cocopixelmc.HappyToHelp.Tutorial.RunType;

import org.bukkit.entity.Player;

import com.cocopixelmc.playerdeath.API.Titles;

public class Title {

	public Title(){
		
	}
	
	public static void SendTitle(Player player, String type, int fadeIn, int stay, int fadeOut, String... msg){
		if(type.equals("FULL")){
			Titles.sendFulltitle(player, msg[0], msg[1], fadeIn, stay, fadeOut);
		}
		if(type.equals("MAIN")){
			Titles.sendTitle(player, msg[0], fadeIn, stay, fadeOut);
		}
		if(type.equals("SUB")){
			Titles.sendSubtitle(player, msg[1], fadeIn, stay, fadeOut);
		}
	}
}