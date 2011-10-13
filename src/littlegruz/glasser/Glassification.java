package littlegruz.glasser;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Glassification extends JavaPlugin{
   Logger log = Logger.getLogger("This is MINECRAFT!");
   private final GlassBlockListener gbl = new GlassBlockListener(this);

   public void onEnable(){
      log.info("Glassification v1.2 enabled");
      PluginManager pm = this.getServer().getPluginManager();
      pm.registerEvent(Event.Type.BLOCK_IGNITE, gbl, Event.Priority.Normal, this);
      pm.registerEvent(Event.Type.BLOCK_PLACE, gbl, Event.Priority.Normal, this);
      pm.registerEvent(Event.Type.BLOCK_FROMTO, gbl, Event.Priority.Normal, this);
      
   }

   public void onDisable(){
      log.info("Glassification v1.2 disabled");
   }
}
