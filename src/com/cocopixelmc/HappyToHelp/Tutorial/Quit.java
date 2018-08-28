package com.cocopixelmc.HappyToHelp.Tutorial;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.cocopixelmc.HappyToHelp.Main;

public class Quit implements Listener {

	@SuppressWarnings("unused")
	private Main plugin;

	public Quit(Main plugin){
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e){
		Player player = e.getPlayer();
		if(Main.RuningList.contains(player.getUniqueId())){
			Main.RuningList.remove(player.getUniqueId());
			Main.ThreadID.get(player.getUniqueId()).interrupt();
		}
	}
	
}
