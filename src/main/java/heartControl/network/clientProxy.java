package heartControl.network;

import net.minecraftforge.common.MinecraftForge;
import heartControl.client.displayManager;

public class clientProxy extends commonProxy {

	@Override
	public void clientSetup()
	{
		MinecraftForge.EVENT_BUS.register(new displayManager());
	}
}
