package com.cocopixelmc.HappyToHelp.Tutorial;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.cocopixelmc.HappyToHelp.Main;

public class BlockMove implements Listener {

	public BlockMove(Main plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerMoveExit(PlayerMoveEvent e){
		Player player = e.getPlayer();
		if(Main.RuningList.contains(player.getUniqueId())){
			player.teleport(e.getFrom());
		}
	}
}
