package com.cocopixelmc.HappyToHelp.Tutorial;

import java.util.HashSet;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListeningWhitelist;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.events.PacketListener;

public class HideChat implements PacketListener{

	public static HashSet<Player> RuningList = new HashSet<Player>();
	
	public HideChat(){
		
	}

	@Override
	public Plugin getPlugin() {
		// TODO 自動產生的方法 Stub
		return null;
	}

	@Override
	public ListeningWhitelist getReceivingWhitelist() {
		// TODO 自動產生的方法 Stub
		return null;
	}

	@Override
	public ListeningWhitelist getSendingWhitelist() {
		// TODO 自動產生的方法 Stub
		return null;
	}

	@Override
	//client
	public void onPacketReceiving(PacketEvent e) {
		if(e.getPacketType() == PacketType.Play.Client.CHAT){
			Player player = e.getPlayer();
			if(RuningList.contains(player)){
				e.setCancelled(true);
			}
		}
	}

	@Override
	//server
	public void onPacketSending(PacketEvent e) {
		if(e.getPacketType() == PacketType.Play.Server.CHAT){
			String msg = e.getPacket().getStrings().read(0);
			Player player = e.getPlayer();
			if(RuningList.contains(player)){
				if(!msg.startsWith(ChatColor.AQUA + ChatColor.BLUE.toString() + ChatColor.BOLD + ChatColor.RESET)){
					e.setCancelled(true);
				}
			}
		}
	}
}
