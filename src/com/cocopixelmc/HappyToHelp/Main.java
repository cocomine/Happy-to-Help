package com.cocopixelmc.HappyToHelp;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.cocopixelmc.HappyToHelp.Tutorial.ChatPacket;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;

public class Main extends JavaPlugin implements Listener{

	public static ProtocolManager protocolManager;

	@Override
    public void onEnable() {
		getCommand("happyhelp").setExecutor(new Cmd(this));
		
		getConfig().addDefault("Step", "[]");
		saveDefaultConfig();
		reloadConfig();
		
		protocolManager = ProtocolLibrary.getProtocolManager();
		
		new ChatPacket(protocolManager, this);
		
		getLogger().info("Happy to Help Enable!");
	}
	
	@Override
    public void onDisable() {
		getLogger().info("Happy to Help Disable!");
	}
}
