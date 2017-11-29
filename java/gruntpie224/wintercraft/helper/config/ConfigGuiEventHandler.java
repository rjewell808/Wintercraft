package gruntpie224.wintercraft.helper.config;

import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ConfigGuiEventHandler{

	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.LOW, receiveCanceled=true)
	public void onEvent(GuiOpenEvent event)
	{
	    if (event.gui instanceof GuiIngameMenu)
	    {
	        event.gui = new WintercraftGuiConfig(null);        
	    }
	}

}