package gruntpie224.wintercraft.helper.gui;

import org.lwjgl.opengl.GL11;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.WintercraftReference;
import gruntpie224.wintercraft.helper.tileEntity.TileEntityFreezer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiFreezer extends GuiContainer
{
private ResourceLocation tif = new ResourceLocation(WintercraftReference.MOD_ID + ":" + "textures/gui/freezerGUI.png");
private TileEntityFreezer inputFurnaceInventory;

public GuiFreezer(InventoryPlayer inventoryplayer, TileEntityFreezer tileentityInputFurnace)
{
         super(new ContainerFreezer(inventoryplayer, tileentityInputFurnace));
         inputFurnaceInventory = tileentityInputFurnace;
}
/**
         * Draw the foreground layer for the GuiContainer (everythin in front of the items)
         */
protected void drawGuiContainerForegroundLayer(int par1, int par2)
{
         fontRendererObj.drawString(StatCollector.translateToLocal("Freezer"), 68, 6, 0x404040);
         fontRendererObj.drawString(StatCollector.translateToLocal("Inventory"), 8, (ySize - 96) + 2, 0x404040);
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
         if (inputFurnaceInventory.isBurning())
         {
                 int j1 = inputFurnaceInventory.getBurnTimeRemainingScaled(12);
                 drawTexturedModalRect(l + 56, (i1 + 36 + 12) - j1, 176, 12 - j1, 14, j1 + 2);
         }
         int k1 = inputFurnaceInventory.getCookProgressScaled(24);
         drawTexturedModalRect(l + 79, i1 + 34, 176, 14, k1 + 1, 16);
}
}