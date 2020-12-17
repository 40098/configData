package me.jejack.configData;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("hallo").setExecutor(new Commands(this));
	}
	
	public void onDisable( ) {
		
	}
}