package wintercraft.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import wintercraft.Wintercraft;
import wintercraft.render.models.ModelCandle;
import wintercraft.render.tileEntity.TileEntityCandle;

public class CandleRenderer extends TileEntitySpecialRenderer
{
    static final float scale = (float)(1.0 / 16.0);
    private ModelCandle model;
    public CandleRenderer()
    {
        model = new  ModelCandle();
    }
    @Override
    public void renderTileEntityAt(TileEntity var1, double x, double y,
            double z, float tick)
    {
        this.renderAModelAt((TileEntityCandle)var1, x, y, z, tick);
    }

    public void renderAModelAt(TileEntityCandle tileentity1, double x, double y, double z, float f)
    {
        GL11.glPushMatrix();
        GL11.glTranslated((float)x + 0.4F, (float)y, (float)z + 0.4F);	
        	if(tileentity1.getBlockMetadata() == 0){ 
        		this.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/candle15.png"));} 
        	if(tileentity1.getBlockMetadata() == 1){ 
        		this.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/candle1.png"));} 
        	if(tileentity1.getBlockMetadata() == 2){ 
        		this.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/candle2.png"));} 
        	if(tileentity1.getBlockMetadata() == 3){ 
        		this.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/candle3.png"));} 
        	if(tileentity1.getBlockMetadata() == 4){ 
				this.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/candle4.png"));} 
        	if(tileentity1.getBlockMetadata() == 5){ 
				this.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/candle5.png"));} 
        	if(tileentity1.getBlockMetadata() == 6){ 
				this.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/candle6.png"));} 
        	if(tileentity1.getBlockMetadata() == 7){ 
				this.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/candle7.png"));} 
        	if(tileentity1.getBlockMetadata() == 8){ 
				this.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/candle8.png"));} 
        	if(tileentity1.getBlockMetadata() == 9){ 
				this.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/candle9.png"));} 
        	if(tileentity1.getBlockMetadata() == 10){ 
				this.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/candle10.png"));} 
        	if(tileentity1.getBlockMetadata() == 11){ 
				this.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/candle11.png"));} 
        	if(tileentity1.getBlockMetadata() == 12){ 
				this.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/candle12.png"));} 
        	if(tileentity1.getBlockMetadata() == 13){ 
				this.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/candle13.png"));}
        	if(tileentity1.getBlockMetadata() == 14){ 
				this.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/candle14.png"));}
        	if(tileentity1.getBlockMetadata() == 15){ 
				this.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/candle0.png"));}
        GL11.glPushMatrix();
        model.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}