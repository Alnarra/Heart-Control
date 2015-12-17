package heartControl.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

public class displayManager {
	
	@SubscribeEvent
	public void overrideHealthBar(RenderGameOverlayEvent.Pre event)
	{
	}
}
