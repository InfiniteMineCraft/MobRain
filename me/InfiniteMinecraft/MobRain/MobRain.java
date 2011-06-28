package me.InfiniteMinecraft.MobRain;

import java.io.File;
import java.util.Properties;
import org.bukkit.block.Block;
import java.util.logging.Logger;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("restriction")

public class MobRain extends JavaPlugin {
	MRPlayerListener pListener = new MRPlayerListener();	
	Logger           log       = Logger.getLogger("Minecraft");
		
	public void onDisable()
	{
		log.info("[**MobRain**] MobRain 0.1 Disabled!");		
	}

	public void onEnable()
	{
		log.info("[**MobRain**] MobRain 0.1 Enabled!");
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_COMMAND_PREPROCESS, pListener, Priority.Normal, this);
	}
}