package com.cocopixelmc.HappyToHelp.Tutorial;

import java.util.HashSet;
import java.util.List;

import org.bukkit.entity.Player;
import org.json.JSONObject;

import com.cocopixelmc.HappyToHelp.Main;
import com.cocopixelmc.HappyToHelp.Tutorial.RunType.ActionBar;
import com.cocopixelmc.HappyToHelp.Tutorial.RunType.Msg;
import com.cocopixelmc.HappyToHelp.Tutorial.RunType.Song;
import com.cocopixelmc.HappyToHelp.Tutorial.RunType.Title;
import com.cocopixelmc.HappyToHelp.Tutorial.RunType.Tp;

import net.md_5.bungee.api.ChatColor;

public class Tutorial {

	private Main plugin;
	public static HashSet<Player> RuningList = new HashSet<Player>();

	public Tutorial(Main plugin){
		this.plugin = plugin;
	}
	
	public void Run(Player player){
		new Thread(){
			public void run() {
				try {
					RuningList.add(player);
					List<String> steps = plugin.getConfig().getStringList("Step");
					for(String step : steps){
						JSONObject json = new JSONObject(step);
						String type = json.getString("Type");

						if(type.equalsIgnoreCase("ActionBar")){
							ActionBar.SendActionBar(player, json.getString("Msg"));
						}
						if(type.equalsIgnoreCase("Delay")){
							Thread.sleep(json.getLong("Millis"));
						}
						if(type.equalsIgnoreCase("Msg")){
							Msg.SendMsg(player, json.getJSONArray("Msg").toList());
						}
						if(type.equalsIgnoreCase("Title")){
							Title.SendTitle(player, json.getString("TitleType"), json.getInt("fadeIn"), json.getInt("stay"), json.getInt("fadeOut"), json.optString("Title", ""), json.optString("SUB-Title", ""));
						}
						if(type.equalsIgnoreCase("Tp")){
							Tp.SendTp(player, json.getString("world"), json.getDouble("X"), json.getDouble("Y"), json.getDouble("Z"), json.getFloat("Yaw"), json.getFloat("Pitch"));
						}
						if(type.equalsIgnoreCase("Sound")){
							Song.PlaySound(player, json.getString("SoundType"), json.getFloat("Volume"), json.getFloat("Pitch"));
						}
					}
					RuningList.remove(player);
				}catch(Exception e) {
					player.sendMessage(ChatColor.RED+"Have some error please contact admin");
					e.printStackTrace();
				}
			}
		}.start();
	}
}
