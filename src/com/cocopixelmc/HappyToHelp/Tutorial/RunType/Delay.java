package com.cocopixelmc.HappyToHelp.Tutorial.RunType;

import org.bukkit.scheduler.BukkitRunnable;

import com.cocopixelmc.HappyToHelp.Main;

public class Delay {

	private static Main plugin;

	public Delay(Main plugin){
		Delay.plugin = plugin;
	}
	
	public static void RunDelay(long delay){
		new BukkitRunnable(){

			@Override
			public void run() {
				cancel();
			}
			
		}.runTaskLater(plugin, delay);
	}
}
