package org.sngaming.bonana.youtube;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class MyPlayerListener implements Listener{
	public static Youtube plugin;
	
	@EventHandler
	public void onPlayerJoin(PlayerInteractEvent event){
		Player player = event.getPlayer();
		int blockId = player.getItemInHand().getType().getId();
		if(blockId == 280){
			Block block = player.getTargetBlock(null, 50);
			Location location = block.getLocation();
			World world = player.getWorld();
			world.createExplosion(location, 5);
		}else if(blockId == 352){
			Block block = player.getTargetBlock(null, 50);
			Location location = block.getLocation();
			World world = player.getWorld();
			world.strikeLightning(location);
			Bukkit.broadcastMessage("Server is exploding!");
			
		}
	}
}