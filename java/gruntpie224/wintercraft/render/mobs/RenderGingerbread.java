package gruntpie224.wintercraft.render.mobs;

import gruntpie224.wintercraft.entity.monster.EntityGingerbread;
import gruntpie224.wintercraft.render.models.ModelGingerbread;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGingerbread extends RenderLiving {

	public static final Factory FACTORY = new Factory();
	
	public RenderGingerbread(RenderManager rendermanagerIn){
		super(rendermanagerIn, new ModelGingerbread(), 0.5F);	
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return new ResourceLocation("wc:textures/models/gingerbreadman.png");
	}
	
	public static class Factory implements IRenderFactory<EntityGingerbread> {
		@Override
		public Render<? super EntityGingerbread> createRenderFor(RenderManager manager) {
			return new RenderGingerbread(manager);
		}
	}

}
