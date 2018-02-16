package wintercraft.render;

import org.lwjgl.opengl.GL11;

import wintercraft.Wintercraft;
import wintercraft.helper.tileEntity.TileEntitySnowManHead;
import wintercraft.render.models.ModelCandle;
import wintercraft.render.models.ModelHead;
import wintercraft.render.tileEntity.TileEntityCandle;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SnowManHeadRenderer extends TileEntitySpecialRenderer
{
    static final float scale = (float)(1.0 / 16.0);
    private ModelHead model;
    public SnowManHeadRenderer()
    {
        model = new  ModelHead();
    }
    @Override
    public void renderTileEntityAt(TileEntity var1, double x, double y,
            double z, float tick)
    {
        this.renderAModelAt((TileEntitySnowManHead )var1, x, y, z, tick);
        
        
    }

    public void renderAModelAt(TileEntitySnowManHead tileentity1, double x, double y, double z, float f)
    {
        GL11.glPushMatrix();
        GL11.glTranslated((float)x + 0.5F, (float)y, (float)z + 0.5F);	
        this.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/models/snowManHead.png"));
        TileEntitySnowManHead myTile = (TileEntitySnowManHead) tileentity1;
        int direction = myTile.direction*90;
        if(myTile.direction*90 == 0){
    		direction = 180;
    	}else
    	if(myTile.direction*90 == 180){
    		direction = 0;
    	}
        GL11.glRotatef(direction, 0.0F, 1.0F, 0.0F);
        GL11.glPushMatrix();
        model.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}