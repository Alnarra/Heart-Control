package heartControl.config;

import java.io.File;
import net.minecraftforge.common.config.Configuration;

public class configHandler {

	//Setup the configuration Categories 
	public static final String CATEGORY_HOSTILE = "Hostile Mobs Heart Drop Settings";
	public static final String CATEGORY_PASSIVE = "Passive Mobs Heart Drop Settings";
	public static final String CATEGORY_CHEST = "Chest Heart Drop Settings";
	public static final String CATEGORY_BOSS = "Boss Heart Drop Settings"; 
	public static final String CATEGORY_WHITELIST = "Whitelist Settings"; 
	public static final String CATEGORY_BLACKLIST = "Blacklist Settings"; 
	public static final String CATEGORY_GENERAL = "General Settings";
	
	//Variable Declaration 
	public static boolean tierRecipies; 
	public static int startingHealth; 
	public static int maxHealth;
	public static boolean enableHeartRecipie; 
	public static boolean enableDebug; 
	public static boolean enableExtraEffects; 
	
	public static boolean lootGeneralHostileMobs;
	public static int chanceHostileMobs;
	public static int minNumberHostileMobs;
	public static int maxNumberHostileMobs;
	
	public static boolean lootGeneralPassiveMobs; 
	public static int chancePassiveMobs; 
	public static int minNumberPassiveMobs;
	public static int maxNumberPassiveMobs;
	
	public static boolean lootGeneralBossMobs; 
	public static int chanceBossMobs; 
	public static int minNumberBossMobs; 
	public static int maxNumberBossMobs;
	
	public static boolean lootSpawnChest;
	public static int chanceSpawnChest;
	public static int minNumberSpawnChest;
	public static int maxNumberSpawnChest; 
	
	public static boolean enableMobWhiteList;
	public static String[] whiteList; 
	public static int chanceWhitelistMobs; 
	public static int minNumberWhitelistMobs;
	public static int maxNumberWhitelistMobs; 
	
	public static boolean enableMobBlackList; 
	public static String[] blackList; 

	static Configuration config; 
	public static void init(File file)
	{	
		config = new Configuration(file);
		config.load();
		
		//General settings 
		tierRecipies = config.getBoolean("enableTieredRecipies", configHandler.CATEGORY_GENERAL, true, "Enable the Tiered Recipie Setup for Heart canisters");
		startingHealth = config.getInt("startingHealth", configHandler.CATEGORY_GENERAL, 20, 1, 999, "The Starting HP A player will start with, remember that 1 Heart = 2 HP");
		maxHealth = config.getInt("maxHealth", configHandler.CATEGORY_GENERAL, 100, 1, 999, "The Max Health a Player Can Have. Initial Value is after final tiered hearts");
		enableHeartRecipie = config.getBoolean("enableCratableHeart", configHandler.CATEGORY_GENERAL, false, "Enable a craftable recipie for the hearts");
		enableDebug = config.getBoolean("enableDebug", configHandler.CATEGORY_GENERAL, true, "Enable Console Debugging?");
		enableExtraEffects = config.getBoolean("enableExtraEffects", configHandler.CATEGORY_GENERAL, true, "Enable or Disable the Effects that the Hearts have when consumed");
		
		//Hostile Mob Settings
		lootGeneralHostileMobs = config.getBoolean("lootGeneralHostileMobs", configHandler.CATEGORY_HOSTILE, true, "If Hearts drop from 'Ordinary' Mobs such as Skeletons, Creepers, Wither Skeletons, etc. Including Modded Creatures. "); 
		chanceHostileMobs = config.getInt("chanceHostileMobs", configHandler.CATEGORY_HOSTILE, 1, 1, 100000, "Chance of a Hostile Mob Dropping a heart");
		minNumberHostileMobs = config.getInt("minDropHostileMobs", configHandler.CATEGORY_HOSTILE, 1, 1, 100, "If a hostile Mob does drop a heart, how many will they drop at minimum");
		maxNumberHostileMobs = config.getInt("maxDropHostileMobs", configHandler.CATEGORY_HOSTILE, 1, 1, 100, "If a hostile Mob does drop a heart, how many will they drop at maximum");
		
		//Passive Mob Settings 
		lootGeneralPassiveMobs = config.getBoolean("lootGeneralPassiveMobs", configHandler.CATEGORY_PASSIVE, false, "If Hearts drop from 'Passive' Mobs such as Cows, Pigs, Sheep, etc."); 
		chancePassiveMobs = config.getInt("chancePassiveMobs", configHandler.CATEGORY_PASSIVE, 1, 1, 100000, "Chance of a Passive Mob Dropping a heart");
		minNumberPassiveMobs = config.getInt("minDropPassiveMobs", configHandler.CATEGORY_PASSIVE, 1, 1, 100, "If a Passive Mob does drop a heart, how many will they drop at minimum");
		maxNumberPassiveMobs = config.getInt("maxDropPassiveMobs", configHandler.CATEGORY_PASSIVE, 1, 1, 100, "If a Passive Mob does drop a heart, how many will they drop at maximum");
		
		//Boss Mob Settings
		lootGeneralBossMobs = config.getBoolean("lootGeneralBossMobs", configHandler.CATEGORY_BOSS, true, "If Hearts drop from 'Boss' Mobs such as Ender Dragons, The Wither, etc. Including Modded Creatures"); 
		chanceBossMobs = config.getInt("chanceBossMobs", configHandler.CATEGORY_BOSS, 10000, 1, 100000, "Chance of a Boss Mob Dropping a heart");
		minNumberBossMobs = config.getInt("minDropBossMobs", configHandler.CATEGORY_BOSS, 1, 1, 100, "If a hostile Mob does drop a heart, how many will they drop at minimum");
		maxNumberBossMobs = config.getInt("maxDropBossMobs", configHandler.CATEGORY_BOSS, 3, 1, 100, "If a hostile Mob does drop a heart, how many will they drop at maximum");
	
		//Chest 
		lootSpawnChest = config.getBoolean("lootSpawnChest", configHandler.CATEGORY_CHEST, true, "If you wish to allow for hearts to spawn in chest");
		chanceSpawnChest = config.getInt("chanceSpawnChest", configHandler.CATEGORY_CHEST, 1000, 1, 100000, "Chance of a chest containing a heart");
		minNumberSpawnChest = config.getInt("minDropChest", configHandler.CATEGORY_CHEST, 1, 1, 100, "If a chest does contain a heart, how many will it contain at minimum");
		maxNumberSpawnChest = config.getInt("maxDropChest", configHandler.CATEGORY_CHEST, 1, 1, 100, "If a chest does contain a heart, how many will it contain at maximum");
		
		//Mob White List
		enableMobWhiteList = config.getBoolean("enableMobWhiteList", configHandler.CATEGORY_WHITELIST, false, "If you wish to allow only Certain Mobs to drop Hearts. Overrides all other settings");
		whiteList = config.getStringList("whiteList", configHandler.CATEGORY_WHITELIST, new String[]{""}, "An array of mobs that you wish to allow objects to drop from, Seperate with a ,");
		chanceWhitelistMobs = config.getInt("chanceWhitelistMobs", configHandler.CATEGORY_WHITELIST, 1, 1, 100000, "Chance of a Whitelisted Mob Dropping a heart");
		minNumberWhitelistMobs = config.getInt("minDropWhitelistMobs", configHandler.CATEGORY_WHITELIST, 1, 1, 100, "If a Whitelisted Mob does drop a heart, how many will they drop at minimum");
		maxNumberWhitelistMobs = config.getInt("maxDropWhitelistMobs", configHandler.CATEGORY_WHITELIST, 1, 1, 100, "If a Whitelisted Mob does drop a heart, how many will they drop at maximum");
	
		//Mob Black List 
		enableMobBlackList = config.getBoolean("enableMobWhiteList", configHandler.CATEGORY_BLACKLIST, false, "If you wish for Certain Mobs even if they are allowed to in the above settings to NOT drop hearts");
		blackList = config.getStringList("blackList", configHandler.CATEGORY_BLACKLIST, new String[]{""}, "An array of mobs that you do not wish to allow objects to drop from. Seperate with a ,");
		
		//Finally Save the file back out 
		config.save();
	}
}
