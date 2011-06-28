package me.InfiniteMinecraft.MobRain;

import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerListener;

/**
 *
 * @author InfiniteMinecraft
 */


public class MRPlayerListener extends PlayerListener {
	
    Logger log = Logger.getLogger("Minecraft");
    int i = 0;
    
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) 
    {
		
		
		String[] args = event.getMessage().split(" ");
		Player player  = event.getPlayer();
		
		if(args[0].equalsIgnoreCase("/mrain"))
		{
			event.setCancelled(true);
			CreatureType creature = CreatureType.valueOf(args[2].toUpperCase());
			int toDrop = Integer.parseInt(args[1]);
			
			while(i<toDrop)
			{
				Random x = new Random();
				Random y = new Random();
				Random z = new Random();
				double xloc = x.nextInt(50);
				double height = z.nextInt(50);
				double zloc = z.nextInt(50);
				
				Location loc = new Location(
						player.getWorld(),   player.getLocation().getX()-25+xloc,
						100+height,		     player.getLocation().getZ()-25+zloc,
						1, 1);
				
				player.getWorld().spawnCreature(loc, creature);
				
				i++;
			}
		}		
    }   
}
