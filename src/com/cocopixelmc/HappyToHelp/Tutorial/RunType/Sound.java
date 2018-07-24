package com.cocopixelmc.HappyToHelp.Tutorial.RunType;

import org.bukkit.entity.Player;

public class Sound {

	public Sound(){
		
	}
	
	public static void PlaySound(Player player, String soungtype, float volume, float pitch){
		player.playSound(player.getLocation(), soungtype, volume, pitch);
	}
}
