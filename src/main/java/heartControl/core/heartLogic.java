package heartControl.core;

import heartControl.config.configHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class heartLogic {

	public static void attemptHeartAdd(int id, EntityPlayer player)
	{
		
		//First let's find out how much health the player has right now at this very moment 
		float playerHealth = player.getMaxHealth(); 
		
		//This is going to be how we figure out if we should actually give more health UNLESS the tier system is turned off
		//0 = Base Heart
		//1 = Iron Heart
		//2 = Emerald Heart
		//3 = Diamond Heart 
		//4 = NetherStar Heart 
		
		//First lets see if the Tiered System is turned off 
		if(configHandler.tierRecipies == false)
		{
			//Just do it, doesn't matter what kind of heart we've got we're going to add to the total 
		}
		else
		{
			//In this case we need to check each level 
			switch(id)
			{
			case 0: 
				//This is a base heart 
				if(playerHealth < 20)
				{
					// They have less then 20 Health we want to ADD health 
					
				}
			}	
		}
	}
}
