package heartControl.core;

import heartControl.config.configHandler;

public class mobDrop {
	
	protected static boolean passive = configHandler.lootGeneralPassiveMobs; 
	protected static boolean hostile = configHandler.lootGeneralHostileMobs; 
	protected static boolean boss = configHandler.lootGeneralBossMobs;
	protected static boolean whitelist = configHandler.enableMobWhiteList; 
	
	protected static int passiveRate = configHandler.chancePassiveMobs; 
	protected static int hostileRate = configHandler.chanceHostileMobs; 
	protected static int bossRate = configHandler.chanceBossMobs; 
	protected static int whiteListRate = configHandler.chanceWhitelistMobs; 
	
	protected static int passiveMax = configHandler.maxNumberPassiveMobs;
	protected static int hostileMax = configHandler.maxNumberHostileMobs; 
	protected static int bossMax = configHandler.maxNumberBossMobs; 
	protected static int whiteListMax = configHandler.maxNumberWhitelistMobs; 
	
	protected static int passiveMin = configHandler.minNumberPassiveMobs; 
	protected static int hostileMin = configHandler.minNumberHostileMobs; 
	protected static int bossMin = configHandler.minNumberBossMobs; 
	protected static int whiteListMin = configHandler.minNumberWhitelistMobs; 
	
	protected static String[] whiteListMobs = configHandler.whiteList; 
	protected static String[] blackListMobs = configHandler.blackList; 
	
	public static void init()
	{
		//Let's start simple enough, First let's verify that the items on the whitelist and blacklist are vaild mobs
		for (int i = 0; i < whiteListMobs.length; i++)
		{
			//split it up
		}
		//Check the blacklist too
		for (int i = 0; i < blackListMobs.length; i++)
		{
			
		}
	}
}
