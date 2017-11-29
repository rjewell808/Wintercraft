package gruntpie224.wintercraft.helper.config;

import gruntpie224.wintercraft.WintercraftReference;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

public class WintercraftGuiConfig extends GuiConfig
{
	public WintercraftGuiConfig(GuiScreen guiScreen)
	{
		super (guiScreen,
				new ConfigElement(ConfigHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
					WintercraftReference.MOD_ID,
					false,
					true,
					GuiConfig.getAbridgedConfigPath(ConfigHandler.configuration.toString()));
	}
	
	@Override
    public void initGui()
    {
        // You can add buttons and initialize fields here
        super.initGui();
    }
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        // You can do things like create animations, draw additional elements, etc. here
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button)
    {
        // You can process any additional buttons you may have added here
        super.actionPerformed(button);
    }
}