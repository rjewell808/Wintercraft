package wintercraft.render.mobs;

import wintercraft.entity.monster.EntityMiniSnowGolem;
import wintercraft.entity.passive.EntitySnowMan;
import wintercraft.render.models.ModelMiniSnowGolem;
import wintercraft.render.models.ModelSnowManPet;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderSnowManPet extends RenderLiving {

	protected ModelSnowManPet model;
	
	public RenderSnowManPet(ModelBase par1ModelBase, float par2){
		super(par1ModelBase, par2);
		model = ((ModelSnowManPet)mainModel);
		
	}
	
	public void renderGoblin(EntitySnowMan entity, double par2, double par4, double par6, float par8, float par9){
		super.doRender(entity, par2, par4, par6, par8, par9);
	}
	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9){
		renderGoblin((EntitySnowMan)par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRender(Entity entity, double d0, double d1, double d2,float f, float f1) 
	{
		renderGoblin((EntitySnowMan)entity, d0, d1, d2, f, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return new ResourceLocation("Wintercraft:textures/models/snowManPet.png");
	}

}