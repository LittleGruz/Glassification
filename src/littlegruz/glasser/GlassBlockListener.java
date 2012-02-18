package littlegruz.glasser;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class GlassBlockListener implements Listener{
   public static Glassification plugin;

   public GlassBlockListener(Glassification instance){
      plugin = instance;
   }

   @EventHandler
   public void onBlockIgnite(BlockIgniteEvent event){
      Block block;
      World world;
      Location loc;

      loc = event.getBlock().getLocation();
      loc.setY(loc.getY() - 1);
      block = loc.getBlock();
      world = block.getWorld();

      if(block.getType().compareTo(Material.SAND) == 0){
         block.setType(Material.AIR);
         world.dropItem(block.getLocation(), new ItemStack(Material.GLASS, 1));
      }
   }

   @EventHandler
   public void onBlockFromTo(BlockFromToEvent event){
      Block block;
      Location loc;
      
      loc = event.getBlock().getLocation();
      loc.setY(loc.getY() - 1);
      block = loc.getBlock();

      if(block.getType().compareTo(Material.SAND) == 0 && event.getBlock().getType().compareTo(Material.STATIONARY_LAVA) == 0){
         block.setType(Material.GLASS);
      }
   }

   @EventHandler
   public void onBlockPlace(BlockPlaceEvent event){
      Block block;
      World world;
      Location loc;

      loc = event.getBlock().getLocation();
      loc.setY(loc.getY() - 1);
      block = loc.getBlock();
      world = block.getWorld();
      if(block.getType().compareTo(Material.SAND) == 0 && event.getBlock().getType().compareTo(Material.FIRE) == 0){
         block.setType(Material.AIR);
         world.dropItem(block.getLocation(), new ItemStack(Material.GLASS, 1));
      }
   }
}
