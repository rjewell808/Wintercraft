package wintercraft.render;

import org.lwjgl.opengl.GL11;

import wintercraft.Wintercraft;
import wintercraft.helper.tileEntity.TileEntitySnowManHead;
import wintercraft.render.models.ModelCandle;
import wintercraft.render.models.ModelHead;
import wintercraft.render.models.ModelSnowGlobe;
import wintercraft.render.tileEntity.TileEntityCandle;
import wintercraft.render.tileEntity.TileEntitySnowGlobe;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SnowGlobeRenderer extends TileEntitySpecialRenderer
{
    static final float scale = (float)(1.0 / 16.0);
    private ModelSnowGlobe model;
    public SnowGlobeRenderer()
    {
        model = new  ModelSnowGlobe();
    }
    @Override
    public void renderTileEntityAt(TileEntity var1, double x, double y,
            double z, float tick)
    {
        this.renderAModelAt((TileEntitySnowGlobe)var1, x, y, z, tick);
        
        
    }

    public void renderAModelAt(TileEntitySnowGlobe tileentity1, double x, double y, double z, float f)
    {
        GL11.glPushMatrix();
        GL11.glTranslated((float)x + 0.5F, (float)y + 0.75F, (float)z + 0.5F);	
        this.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/models/snowGlobe.png"));
        TileEntitySnowGlobe myTile = (TileEntitySnowGlobe) tileentity1;
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glScaled(0.5D, 0.5D, 0.5D);
        model.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}