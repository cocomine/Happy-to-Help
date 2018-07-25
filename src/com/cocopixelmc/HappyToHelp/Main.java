package com.cocopixelmc.HappyToHelp;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.cocopixelmc.HappyToHelp.Tutorial.HideChat;
import com.cocopixelmc.HappyToHelp.Tutorial.RunType.ActionBar;
import com.cocopixelmc.HappyToHelp.Tutorial.RunType.Msg;
import com.cocopixelmc.HappyToHelp.Tutorial.RunType.Song;
import com.cocopixelmc.HappyToHelp.Tutorial.RunType.Title;
import com.cocopixelmc.HappyToHelp.Tutorial.RunType.Tp;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;

public class Main extends JavaPlugin implements Listener{

	public static ProtocolManager protocolManager;

	@Override
    public void onEnable() {
		getCommand("happyhelp").setExecutor(new Cmd(this));
		
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		reloadConfig();
		
		new ActionBar();
		new Msg(this);
		new Song();
		new Title();
		new Tp();
		
		if (Bukkit.getPluginManager().isPluginEnabled("ProtocolLib")){
			protocolManager = ProtocolLibrary.getProtocolManager();
			protocolManager.addPacketListener(new HideChat());
			getLogger().info("ProtocolLib Hook");
		} else {
			getLogger().warning("ProtocolLib Not Enabled!!");
			this.getPluginLoader().disablePlugin(this);
		}
		
		getLogger().info("Happy to Help Enable!");
	}
	
	@Override
    public void onDisable() {
		getLogger().info("Happy to Help Disable!");
	}
}
