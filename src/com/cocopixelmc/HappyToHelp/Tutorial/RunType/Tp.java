package com.cocopixelmc.HappyToHelp.Tutorial.RunType;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Tp {

	public Tp(){
		
	}
	
	public static void SendTp(Player player, String world, double x,double y,double z,float yaw,float pitch){
		Location loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
		player.teleport(loc);
	}
}
