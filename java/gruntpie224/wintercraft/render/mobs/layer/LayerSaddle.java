package gruntpie224.wintercraft.render.mobs.layer;

import gruntpie224.wintercraft.entity.passive.EntityReindeer;
import gruntpie224.wintercraft.render.mobs.RenderReindeer;
import gruntpie224.wintercraft.render.models.ModelReindeer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerSaddle implements LayerRenderer
{
	private static final ResourceLocation TEXTURE = new ResourceLocation("wc:textures/models/reindeer_saddle.png");
    private final RenderReindeer pigRenderer;
    private final ModelReindeer pigModel = new ModelReindeer();
    private static final String __OBFID = "CL_00002414";

    public LayerSaddle(RenderReindeer p_i46113_1_)
    {
        this.pigRenderer = p_i46113_1_;
    }

    public void doRenderLayer(EntityReindeer p_177155_1_, float p_177155_2_, float p_177155_3_, float p_177155_4_, float p_177155_5_, float p_177155_6_, float p_177155_7_, float p_177155_8_)
    {
        if (p_177155_1_.getSaddled())
        {
            this.pigRenderer.bindTexture(TEXTURE);
            this.pigModel.setModelAttributes(this.pigRenderer.getMainModel());
            this.pigModel.render(p_177155_1_, p_177155_2_, p_177155_3_, p_177155_5_, p_177155_6_, p_177155_7_, p_177155_8_);
        }
    }

    public boolean shouldCombineTextures()
    {
        return false;
    }

    public void doRenderLayer(EntityLivingBase p_177141_1_, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_)
    {
        this.doRenderLayer((EntityReindeer)p_177141_1_, p_177141_2_, p_177141_3_, p_177141_4_, p_177141_5_, p_177141_6_, p_177141_7_, p_177141_8_);
    }
}