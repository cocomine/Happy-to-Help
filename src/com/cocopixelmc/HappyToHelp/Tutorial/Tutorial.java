package com.cocopixelmc.HappyToHelp.Tutorial;

import java.util.List;

import org.bukkit.entity.Player;
import org.json.JSONObject;

import com.cocopixelmc.HappyToHelp.Main;
import com.cocopixelmc.HappyToHelp.Tutorial.RunType.ActionBar;
import com.cocopixelmc.HappyToHelp.Tutorial.RunType.Delay;
import com.cocopixelmc.HappyToHelp.Tutorial.RunType.Msg;
import com.cocopixelmc.HappyToHelp.Tutorial.RunType.Title;

public class Tutorial {

	private Main plugin;

	public Tutorial(Main plugin){
		this.plugin = plugin;
	}
	
	public void Run(Player player){
		List<String> steps = plugin.getConfig().getStringList("Step");
		for(String step : steps){
			JSONObject json = new JSONObject(step);
			String type = json.getString("Type");
			
			if(type.equals("ActionBar")){
				ActionBar.SendActionBar(player, json.getString("Msg"));
			}
			if(type.equals("Delay")){
				Delay.RunDelay(json.getLong("Tick"));
			}
			if(type.equals("Msg")){
				Msg.SendMsg(player, json.getJSONArray("Msg").toList());
			}
			if(type.equals("Title")){
				Title.SendTitle(player, json.getString("SubType"), json.getInt("fadeIn"), json.getInt("stay"), json.getInt("fadeOut"), json.getString("Title"), json.optString("Title-2", null));
			}
		}
	}
}
