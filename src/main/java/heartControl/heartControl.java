package heartControl;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import heartControl.config.configHandler;
import heartControl.core.mobDrop;
import heartControl.items.hcItems;
import heartControl.network.commonProxy;
import heartControl.utility.hcLogger;
import net.minecraftforge.common.MinecraftForge; 

//Publish This for Minecraft's sake so it knows what it's looking at
@Mod( 
		modid = heartControl.modID,
		name = heartControl.modName,
		version = heartControl.modVersion
		)

public class heartControl {
	
	//Mod Key information 
	public static final String modID = "heartControl"; 
	public static final String modName = "Heart Control"; 
	public static final String modVersion = "0.1.0";
	
	//Make an instance of the mod 
	@Mod.Instance(modID)
	public static heartControl instance = new heartControl();
	
	//Setup the Network handling Information 
	@SidedProxy(serverSide = "heartControl.Network.commonProxy", clientSide="heartControl.network.clientProxy")
	
	//This is a class we build ourselves in the network section 
	public static commonProxy proxy;
	
	//Finally fire up the network manager so the mod will use it's own channel 
	public static final SimpleNetworkWrapper packetHandler = NetworkRegistry.INSTANCE.newSimpleChannel(modID);
	
	public static configHandler config; 
	
	@Mod.EventHandler 
	public void preIniit(FMLPreInitializationEvent event)
	{
		//Get the Configuration File 
		instance = this; 
		config.init(event.getSuggestedConfigurationFile());
		hcLogger.logger("Configuration File Created");
		hcLogger.logger("Adding Items");
		hcItems.init();
		hcLogger.logger("Items Added");
		hcLogger.logger("Setting up Mob Drops");
		MinecraftForge.EVENT_BUS.register(new mobDrop());
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		
	}
	
	@Mod.EventHandler
	public void post(FMLPostInitializationEvent event)
	{
		
	}
}
