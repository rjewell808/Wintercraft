package wintercraft.render;

import org.lwjgl.opengl.GL11;

import wintercraft.Wintercraft;
import wintercraft.helper.tileEntity.TileEntityFirePlace;
import wintercraft.helper.tileEntity.TileEntitySnowManHead;
import wintercraft.render.models.ModelCandle;
import wintercraft.render.models.ModelFirePlace;
import wintercraft.render.models.ModelHead;
import wintercraft.render.models.ModelSnowGlobe;
import wintercraft.render.tileEntity.TileEntityCandle;
import wintercraft.render.tileEntity.TileEntitySnowGlobe;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class FirePlaceRenderer extends TileEntitySpecialRenderer
{
    static final float scale = (float)(1.0 / 16.0);
    private ModelFirePlace model;
    public FirePlaceRenderer()
    {
        model = new  ModelFirePlace();
    }
    @Override
    public void renderTileEntityAt(TileEntity var1, double x, double y,
            double z, float tick)
    {
        this.renderAModelAt((TileEntityFirePlace)var1, x, y, z, tick);
    }

    public void renderAModelAt(TileEntityFirePlace tileentity1, double x, double y, double z, float f)
    {
        GL11.glPushMatrix();
        GL11.glTranslated((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);	
        this.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/models/firePlace.png"));
        TileEntityFirePlace myTile = (TileEntityFirePlace) tileentity1;
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glScaled(1.0D, 1.0D, 1.0D);
        model.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}