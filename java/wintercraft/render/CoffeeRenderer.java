package wintercraft.render;

import org.lwjgl.opengl.GL11;

import wintercraft.Wintercraft;
import wintercraft.render.models.ModelCandle;
import wintercraft.render.models.ModelMug;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class CoffeeRenderer implements IItemRenderer {

	protected ModelMug model;


	public CoffeeRenderer() {
		model = new ModelMug();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {

		switch (type) {
		case EQUIPPED:
			return true;
		case EQUIPPED_FIRST_PERSON:
			return true;
		case ENTITY:
			return true;
		default:
			return false;
		}

	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

		switch (type) {
		case EQUIPPED_FIRST_PERSON: {
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/mug.png")); 
			GL11.glRotatef(90f, 50.0F, -45.0F, 0.0F);
			GL11.glRotatef(-10.0f, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-100f,  0.0F, -0.0F, 1.0F);

			GL11.glTranslatef(0.25F, 0.35F, -0.75F);


			float scale1 = 1.0F;
			GL11.glScalef(scale1, scale1, scale1);

			model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
					0.0625F);
			GL11.glPopMatrix();

		}
		default:
			break;

		}
		switch (type) {
		case ENTITY: {
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/mug.png")); 
			
			GL11.glRotatef(0f, 0.0F, 0.0F, 0.0F);
			GL11.glRotatef(0.0f, 0.0F, 0.0F, 0.0F);
			GL11.glRotatef(-180f,  0.0F, -0.0F, 1.0F);

			GL11.glTranslatef(0.0F, 0.2F, 0.0F);


			float scale1 = 1.0F;
			GL11.glScalef(scale1, scale1, scale1);

			model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
					0.0625F);
			GL11.glPopMatrix();

		}

		default:
			break;
		}
		switch (type) {
		case EQUIPPED: {
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/mug.png")); 
			
			GL11.glRotatef(0.0f, 0.0F, -0.0F, -1.0F);
			GL11.glRotatef(0.0f, 0.0F, -0.0F, 1.0F);
			GL11.glRotatef(-80f,  0.0F, -0.0F, 1.0F);

			GL11.glTranslatef(-0.3F, 0.8F, 0.0F);


			float scale1 = 0.6F;
			GL11.glScalef(scale1, scale1, scale1);

			model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
					0.0625F);
			GL11.glPopMatrix();

		}

		default:
			break;
		}

	}
}
