package wintercraft.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import wintercraft.Wintercraft;
import wintercraft.render.models.ModelOrnament;
import wintercraft.render.tileEntity.TileEntityOrnamentRare;

public class OrnamentRareRenderer extends TileEntitySpecialRenderer
{
    static final float scale = (float)(1.0 / 16.0);
    private ModelOrnament model;
    public OrnamentRareRenderer()
    {
        model = new ModelOrnament();
    }
    @Override
    public void renderTileEntityAt(TileEntity var1, double x, double y,
            double z, float tick)
    {
        this.renderAModelAt((TileEntityOrnamentRare)var1, x, y, z, tick);
    }

    public void renderAModelAt(TileEntityOrnamentRare tileentity1, double x, double y, double z, float f)
    {
        GL11.glPushMatrix();
        GL11.glTranslated((float)x + 0.5F, (float)y, (float)z + 0.5F);
        this.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/ornament/Rare" + tileentity1.getBlockMetadata() + ".png"));
        GL11.glPushMatrix();
        model.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}