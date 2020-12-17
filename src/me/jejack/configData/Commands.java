package me.jejack.configData;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
	
	private Main main;
	
	public Commands(Main plugin) {
		main = plugin;
	}
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		if(!(sender instanceof Player)) {
            return false;
        }
		
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("hallo")) {
        	if(args.length >= 1) {
        		if (args[0].equalsIgnoreCase("get")) {
        			String message = main.getConfig().getString("message");
        			if (message != null) {
        				player.sendMessage(message);
        			} else {
        				player.sendMessage("§cEr is nog geen bericht opgegeven");
        			}
        			
        		}else if (args[0].equalsIgnoreCase("set")) {
        			String message = "";
        			for(int i = 1; i < args.length; i++) {
        				message += args[i] + " ";
        			}
        			message = message.replaceAll("&", "§");
        			main.getConfig().set("message", message);
        			main.saveConfig();
        			player.sendMessage("§9Het bericht is nu: §a" + message);
        			
        		}else {
        			player.sendMessage("§cGebruik /hallo set of /hallo get");
        		}
        	} else {
        		player.sendMessage("§cGebruik /hallo set of /hallo get");
        	}
            
        }
        
        return false;
    }

}
