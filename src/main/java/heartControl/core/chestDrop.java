package heartControl.core;

import cpw.mods.fml.common.FMLLog;
import heartControl.config.configHandler;
import heartControl.utility.hcLogger;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class chestDrop {
//This class exist to shove hearts into chest if that feature is turned on 
	public static Item baseHeart = new heartControl.items.baseHeart(); 
	public static void init()
	{
		//First thing I suppose we should check for is if the config actually has them set to drop from chest. 
		if(configHandler.lootSpawnChest == true)
		{
			//Oh good they do indeed drop out of chest 
			ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(baseHeart),configHandler.minNumberSpawnChest, configHandler.maxNumberSpawnChest, configHandler.chanceSpawnChest));
			ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(baseHeart),configHandler.minNumberSpawnChest, configHandler.maxNumberSpawnChest, configHandler.chanceSpawnChest +4)); //Adding a minor weighting chance to Chest
			ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(baseHeart),configHandler.minNumberSpawnChest, configHandler.maxNumberSpawnChest, configHandler.chanceSpawnChest));
			ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(baseHeart),configHandler.minNumberSpawnChest, configHandler.maxNumberSpawnChest, configHandler.chanceSpawnChest));
			ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(baseHeart),configHandler.minNumberSpawnChest, configHandler.maxNumberSpawnChest, configHandler.chanceSpawnChest));
			ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(baseHeart),configHandler.minNumberSpawnChest, configHandler.maxNumberSpawnChest, configHandler.chanceSpawnChest));
			ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(baseHeart),configHandler.minNumberSpawnChest, configHandler.maxNumberSpawnChest, configHandler.chanceSpawnChest));
			ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(baseHeart),configHandler.minNumberSpawnChest, configHandler.maxNumberSpawnChest, configHandler.chanceSpawnChest));
			hcLogger.logger("Chest Seeded with Hearts");
		}
		else
		{
			//Time to just drop out and tell the Console there are no hearts for the player
			hcLogger.logger("Chest not Seeded with hearts");
		}
	}
}
