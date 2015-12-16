package heartControl.items;

import heartControl.heartControl;
import heartControl.config.configHandler;
import heartControl.core.heartLogic;
import heartControl.utility.hcLogger;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class diamondHeart extends Item{
	
	public diamondHeart(){
		
		setTextureName(heartControl.modID + ":diamondHeart"); 
		setUnlocalizedName("hc.diamondHeart");
		setCreativeTab(CreativeTabs.tabMisc);
		setMaxStackSize(64);
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		//make sure we're actually Client Side here
		if(!world.isRemote)
		{
			hcLogger.logger(player + "used a diamond Heart");
			heartLogic.attemptHeartAdd(1, player);
			player.inventory.decrStackSize(player.inventory.currentItem, 1); 

			//We also want the heart to Give us a potion effect don't we? Let's find out
			if(configHandler.enableExtraEffects == true)
			{
				player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 2400, 1));
				player.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 2400, 1));
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 2400, 1));
				player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(),2400,1));
			}
		}
		return stack; 
	}

}
