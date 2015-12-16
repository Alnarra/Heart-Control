package heartControl.utility;

import cpw.mods.fml.common.FMLLog;
import heartControl.config.configHandler;

public class hcLogger {
	//This class handles all the logging and output to the console. 
	public static void logger(String logText)
	{
		//First thing we want to know is if debugging is turned on. If it's not we don't want to return a thing. 
		if(configHandler.enableDebug == true)
		{
			FMLLog.info("[Heart Control]: " + logText);
		}
	}
}
