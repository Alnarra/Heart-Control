package heartControl.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import heartControl.heartControl;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe; 

public class hcItems {

	static Item baseHeart = new baseHeart(); 
	static Item ironHeart = new ironHeart(); 
	static Item emeraldHeart = new emeraldHeart(); 
	static Item diamondHeart = new diamondHeart(); 
	static Item netherStarHeart = new netherStarHeart(); 

	public static void init()
	{
		//Register the Items
		GameRegistry.registerItem(baseHeart, "hc.BaseHeart");
		GameRegistry.registerItem(ironHeart, "hc.ironHeart");
		GameRegistry.registerItem(emeraldHeart, "hc.emeraldHeart");
		GameRegistry.registerItem(diamondHeart, "hc.diamondHeart");
		GameRegistry.registerItem(netherStarHeart, "hc.netherStarHeart");
		
		//Get them in the Ore Dictionary
		OreDictionary.registerOre("heartCanisterBase", baseHeart);
		OreDictionary.registerOre("heartCanisterIron", ironHeart);
		OreDictionary.registerOre("heartCanisterEmerald", emeraldHeart);
		OreDictionary.registerOre("heartCanisterDiamond", diamondHeart);
		OreDictionary.registerOre("heartCanisterNether", netherStarHeart);
		
		//Add the recipies to the game 
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ironHeart),new Object[]{
			"III",
			"IBI",
			"III",
			'I',"ingotIron",
			'B',"heartCanisterBase"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(emeraldHeart),new Object[]{
			"EEE",
			"EBE",
			"EEE",
			'E',"gemEmerald",
			'B',"heartCanisterIron"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(diamondHeart),new Object[]{
			"DDD",
			"DBD",
			"DDD",
			'D',"gemDiamond",
			'B',"heartCanisterEmerald"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(netherStarHeart),new Object[]{
			"NNN",
			"NBN",
			"NNN",
			'N',"nether_star",
			'B',"heartCanisterDiamond"
			}));
	}
}
