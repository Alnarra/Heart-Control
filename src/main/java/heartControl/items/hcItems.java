package heartControl.items;

import cpw.mods.fml.common.registry.GameRegistry;
import heartControl.config.configHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe; 

public class hcItems {

	static Item baseHeart = new baseHeart(); 
	
	public static void init()
	{
		//Register the Items
		GameRegistry.registerItem(baseHeart, "hc.baseHeart");
		
		//Get them in the Ore Dictionary
		OreDictionary.registerOre("heartCanisterBase", baseHeart);
		OreDictionary.registerOre("heartCanisterIron", new ItemStack(baseHeart,1,1));
		OreDictionary.registerOre("heartCanisterEmerald", new ItemStack(baseHeart,1,2));
		OreDictionary.registerOre("heartCanisterDiamond", new ItemStack(baseHeart,1,3));
		OreDictionary.registerOre("heartCanisterNether", new ItemStack(baseHeart,1,4)); 
		
		//Turn on the baseHeart Recipe if it's in the config to do so 
		if(configHandler.enableHeartRecipie == true)
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(baseHeart,1,0), new Object[]{
				"EDE",
				"NCN",
				"EDE",
				'E', "gemEmerald", 
				'D', "gemDiamond",
				'N', GameRegistry.findItem("minecraft", "nether_star"),
				'C', GameRegistry.findItem("minecraft", "beef")
			}));
		}
		
		//If the Tiered Recipe System is off we might as well not add the recipes don't you think? Otherwise yeah go right ahead
		if(configHandler.tierRecipies == true)
		{
		//Add the recipes to the game 
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(baseHeart,1,1),new Object[]{
					"III",
					"IBI",
					"III",
					'I',"ingotIron",
					'B',"heartCanisterBase"
				}));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(baseHeart,1,2),new Object[]{
					"DDD",
					"DBD",
					"DDD",
					'D',"gemDiamond",
					'B',"heartCanisterIron"
					}));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(baseHeart,1,3),new Object[]{
					"EEE",
					"EBE",
					"EEE",
					'E',"gemEmerald",
					'B',"heartCanisterDiamond"
				}));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(baseHeart,1,4),new Object[]{
					"NNN",
					"NBN",
					"NNN",
					'N',GameRegistry.findItem("minecraft", "nether_star"),
					'B',"heartCanisterEmerald"
				}));
		}
	}
}
