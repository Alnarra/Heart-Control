package heartControl.core;

import heartControl.config.configHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
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
			player.setHealth(playerHealth + 1);
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
					player.setHealth(playerHealth + 1); 
				}
			case 1: 
				//This is an Iron heart 
				if (playerHealth < 40 && playerHealth > 20)
				{
					player.setHealth(playerHealth + 1);
				}
				else if (playerHealth < 20)
				{
					player.setHealth(playerHealth + 2);
				}
			case 2: 
				//This is an Emerald Heart 
				if (playerHealth < 60 && playerHealth > 40)
				{
					player.setHealth(playerHealth + 1);
				}
				else if (playerHealth < 40)
				{
					player.setHealth(playerHealth + 3);
				}
			case 3: 
				//This is a Diamond Heart 
				if (playerHealth < 80 && playerHealth > 60)
				{
					player.setHealth(playerHealth + 1);
				}
				else if (playerHealth < 60)
				{
					player.setHealth(playerHealth + 4);
				}
			case 4: 
				//This is the NetherHeart 
				if (playerHealth < 100 && playerHealth > 80)
				{
					player.setHealth(playerHealth + 1);
				}
				else if (playerHealth < 80)
				{
					player.setHealth(playerHealth + 5);
				}
			}	
		}
	}
}
