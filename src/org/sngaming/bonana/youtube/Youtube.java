package org.sngaming.bonana.youtube;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Youtube extends JavaPlugin {

	public final Logger logger = Logger.getLogger("Minecraft");
	public static Youtube plugin;
	public final MyBlockListener bl = new MyBlockListener();
	public final MyPlayerListener pl = new MyPlayerListener();

	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled.");
	}

	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled.");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.bl, this);
		pm.registerEvents(this.pl, this);
		getConfig().options().copyDefaults(true);
		saveConfig();

	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;
		if(commandLabel.equalsIgnoreCase("motd")){
			player.sendMessage(getConfig().getString("MOTD"));
			
		}
		

		return false;
	}
}