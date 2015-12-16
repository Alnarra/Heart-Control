package heartControl.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class emeraldHeart extends Item{
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		//make sure we're actually Client Side here
		if(!world.isRemote)
		{
			heartControl.core.heartLogic.attemptHeartAdd(2);
			player.inventory.decrStackSize(player.inventory.currentItem, 1); 
		}
		return stack; 
	}

}
