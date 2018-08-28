package com.cocopixelmc.HappyToHelp.Tutorial;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import com.cocopixelmc.HappyToHelp.Main;

public class Join implements Listener {

	@SuppressWarnings("unused")
	private Main plugin;

	public Join(Main plugin){
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerJoinEvent e){
		Player hideplayer = e.getPlayer();
		for(UUID uuid : Main.RuningList){
			Player player = Bukkit.getPlayer(uuid);
			Main.entityHider.hideEntity(player, hideplayer);
			Main.entityHider.hideEntity(hideplayer, player);
		}
	}
}
