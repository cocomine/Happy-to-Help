package com.cocopixelmc.HappyToHelp.Tutorial;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.cocopixelmc.HappyToHelp.Main;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListeningWhitelist;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.events.PacketListener;
import com.comphenix.protocol.events.ListeningWhitelist.Builder;

public class HidePlayer implements PacketListener{

	private Main plugin;

	public HidePlayer(Main plugin){
		this.plugin = plugin;
	}
	
	@Override
	public void onPacketSending(PacketEvent e) {
		Player player = e.getPlayer();
		
		if(Tutorial.RuningList.contains(player)){
			e.setCancelled(true);
		}
		
		e.getPacket().get
	}

	@Override
	public void onPacketReceiving(PacketEvent event) {
		// TODO 自動產生的方法 Stub
	}

	@Override
	public ListeningWhitelist getSendingWhitelist() {
		Builder bli = ListeningWhitelist.newBuilder();
		bli.highest();
		bli.types(PacketType.Play.Server.ENTITY);
		ListeningWhitelist li = bli.build();
		return li;
	}

	@Override
	public ListeningWhitelist getReceivingWhitelist() {
		return ListeningWhitelist.EMPTY_WHITELIST;
	}

	@Override
	public Plugin getPlugin() {
		return plugin;
	}

}
