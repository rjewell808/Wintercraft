package gruntpie224.wintercraft.helper.gui;

import org.lwjgl.opengl.GL11;

import gruntpie224.wintercraft.WintercraftReference;
import gruntpie224.wintercraft.tileentity.TileEntityFreezer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class FreezerGUIContainer extends GuiContainer
{
	private ResourceLocation tif = new ResourceLocation(WintercraftReference.MOD_ID + ":" + "textures/gui/freezerGUI.png");
	/** The player inventory bound to this GUI. */
    private final InventoryPlayer playerInventory;
	private TileEntityFreezer tileFreezer;
	
	public FreezerGUIContainer(InventoryPlayer playerInv, TileEntityFreezer tileEntity, FreezerContainer freezerInv)
	{
		super(freezerInv);
		tileFreezer = tileEntity;
		this.playerInventory = playerInv;
	}
	
	/**
     * Draw the foreground layer for the GuiContainer (everythin in front of the items)
     */
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		String s = this.tileFreezer.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 0x404040);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 0x404040);
	}
	
	/**
	 * Draw the background layer for the GuiContainer (everything behind the items)
	*/
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         mc.renderEngine.bindTexture(tif);
         int l = (width - xSize) / 2;
         int i1 = (height - ySize) / 2;
         drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
         if (tileFreezer.isBurning())
         {
        	 int j1 = getBurnLeftScaled(12);
             drawTexturedModalRect(l + 56, (i1 + 36 + 12) - j1, 176, 12 - j1, 14, j1 + 2);
         }
         int k1 = getCookProgressScaled(24);
         drawTexturedModalRect(l + 79, i1 + 34, 176, 14, k1 + 1, 16);
	}
	
	 private int getCookProgressScaled(int pixels)
    {
        int i = this.tileFreezer.getField(2);
        int j = this.tileFreezer.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }

    private int getBurnLeftScaled(int pixels)
    {
        int i = this.tileFreezer.getField(1);

        if (i == 0)
        {
            i = 200;
        }

        return this.tileFreezer.getField(0) * pixels / i;
    }
}
