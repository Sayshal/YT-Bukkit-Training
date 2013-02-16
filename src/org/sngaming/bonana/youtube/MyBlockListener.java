package org.sngaming.bonana.youtube;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class MyBlockListener implements Listener{
	public static Youtube plugin;
	public static Material[] blacklist = {Material.TNT, Material.BEDROCK};
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		Material block = event.getBlock().getType();
		Player player = event.getPlayer();
		
		for(Material blocked : blacklist){
			if(blocked == block){
				if(player.isOp()){
					
				}else{
					player.hasPermission("essentials.tp");
					player.getEffectivePermissions();
					player.hasPermission("essentials.teleport");
					event.getBlock().setType(Material.AIR);
				}
			}
		}
	}
}