package com.cocopixelmc.HappyToHelp.Tutorial.RunType;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Song {

	public Song(){
		
	}
	
	public static void PlaySound(Player player, String soungtype, float volume, float pitch){
		player.playSound(player.getLocation(), Sound.valueOf(soungtype), volume, pitch);
	}
}
