package littlegruz.glasser;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class GlassBlockListener extends BlockListener{
   public static Glassification plugin;

   public GlassBlockListener(Glassification instance){
      plugin = instance;
   }

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
