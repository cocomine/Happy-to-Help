package com.cocopixelmc.HappyToHelp;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.cocopixelmc.HappyToHelp.Tutorial.Tutorial;

public class Cmd implements Listener, CommandExecutor {

	private Main plugin;

	public Cmd(Main plugin) {
		this.plugin=plugin;
	    plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if(cmd.getName().equalsIgnoreCase("happyhelp")){
			if(args.length > 0){
				
				if(args[0].equalsIgnoreCase("reload")){
					if(sender.hasPermission("HappyToHelp.admin")){
						plugin.reloadConfig();
					}else{
						sender.sendMessage(ChatColor.RED+"You not have Permission");
					}
					return true;
				}
				
				if(args[0].equalsIgnoreCase("run")){
					if(sender instanceof Player){
						Tutorial tutorial = new Tutorial(plugin);
						tutorial.Run((Player) sender);
					}else{
						sender.sendMessage(ChatColor.RED+"This command is only player to use");
					}
					return true;
				}
				
				return false;
			}
			return false;
		}
		
		return false;
	}
}
