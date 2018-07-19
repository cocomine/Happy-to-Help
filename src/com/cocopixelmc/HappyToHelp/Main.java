package com.cocopixelmc.HappyToHelp;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;

public class Main extends JavaPlugin implements Listener{

	public static ProtocolManager protocolManager;

	@Override
    public void onEnable() {
		protocolManager = ProtocolLibrary.getProtocolManager();
	}
	
	@Override
    public void onDisable() {
		
	}
}
