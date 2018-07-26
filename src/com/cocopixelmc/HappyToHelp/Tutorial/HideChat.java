package com.cocopixelmc.HappyToHelp.Tutorial;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.json.JSONArray;
import org.json.JSONObject;

import com.cocopixelmc.HappyToHelp.Main;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListeningWhitelist;
import com.comphenix.protocol.events.ListeningWhitelist.Builder;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.events.PacketListener;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

public class HideChat implements PacketListener{
	
	private Main plugin;

	public HideChat(Main plugin){
		this.plugin = plugin;
	}

	@Override
	public Plugin getPlugin() {
		return plugin;
	}

	@Override
	public ListeningWhitelist getReceivingWhitelist() {
		Builder bli = ListeningWhitelist.newBuilder();
		bli.highest();
		bli.types(PacketType.Play.Client.CHAT);
		ListeningWhitelist li = bli.build();
		return li;
	}

	@Override
	public ListeningWhitelist getSendingWhitelist() {
		Builder bli = ListeningWhitelist.newBuilder();
		bli.highest();
		bli.types(PacketType.Play.Server.CHAT);
		ListeningWhitelist li = bli.build();
		return li;
	}

	@Override
	//client
	public void onPacketReceiving(PacketEvent e) {
		if(e.getPacketType().equals(PacketType.Play.Client.CHAT)){
			Player player = e.getPlayer();
			if(Tutorial.RuningList.contains(player)){
				e.setCancelled(true);
			}
		}
	}

	@Override
	//server
	public void onPacketSending(PacketEvent e) {
		Player player = e.getPlayer();
		
		if(Tutorial.RuningList.contains(player)){
			StructureModifier <WrappedChatComponent> chatComponents = e.getPacket().getChatComponents();; 
            WrappedChatComponent msg = chatComponents.read(0);
            
            try {
            	JSONObject json = new JSONObject(e.getPacket().getChatComponents().read(0).getJson());
				JSONArray extra = json.getJSONArray("extra");
				System.out.println(json);  //debug
		
				if(extra.getString(0).startsWith("HappyHelp")){
					extra.remove(0);
					json.put("extra", extra);
					System.out.println(json);//debug
				
					msg.setJson(json.toString());
					chatComponents.write(0, msg);
				}else{
					e.setCancelled(true);
				}
            }catch(Exception e1) {
            	e1.printStackTrace();
            }
		}
	}
}
