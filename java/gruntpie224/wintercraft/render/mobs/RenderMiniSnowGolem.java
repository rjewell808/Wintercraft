package gruntpie224.wintercraft.render.mobs;

import gruntpie224.wintercraft.entity.monster.EntityGingerbread;
import gruntpie224.wintercraft.entity.monster.EntityMiniSnowGolem;
import gruntpie224.wintercraft.render.mobs.RenderGingerbread.Factory;
import gruntpie224.wintercraft.render.models.ModelGingerbread;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMiniSnowGolem extends RenderLiving {
public static final Factory FACTORY = new Factory();
	
	public RenderMiniSnowGolem(RenderManager rendermanagerIn){
		super(rendermanagerIn, new ModelGingerbread(), 0.5F);	
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return new ResourceLocation("wc:textures/models/minisnowgolem.png");
	}
	
	public static class Factory implements IRenderFactory<EntityMiniSnowGolem> {
		@Override
		public Render<? super EntityMiniSnowGolem> createRenderFor(RenderManager manager) {
			return new RenderMiniSnowGolem(manager);
		}
	}
}
