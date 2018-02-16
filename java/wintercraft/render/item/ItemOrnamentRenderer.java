package wintercraft.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import wintercraft.Wintercraft;
import wintercraft.render.models.ModelOrnament;

public class ItemOrnamentRenderer implements IItemRenderer {
	private static RenderItem renderItem = new RenderItem();
	
	protected ModelOrnament model;


	public ItemOrnamentRenderer() {
		model = new ModelOrnament();
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
		case INVENTORY:
			return false;
		default:
			return false;
		}

	}

	@Override
	  public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;

	  }

	private enum TransformationTypes {NONE, DROPPED, INVENTORY};
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

		switch (type) {
		case EQUIPPED_FIRST_PERSON: {
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/ornament/ornament" + item.getItemDamage() + ".png")); 

			GL11.glRotatef(0.0f, 0.0F, -0.0F, -1.0F);
			GL11.glRotatef(0.0f, 0.0F, -0.0F, 1.0F);
			GL11.glRotatef(40.0f,  0.0F, -0.0F, 1.0F);

			GL11.glTranslatef(0.6F, -0.9F, -0.3F);


			float scale1 = 1.5F;
			GL11.glScalef(scale1, scale1, scale1);

			model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
					0.0625F);
			GL11.glPopMatrix();

		}break;
		case ENTITY: {
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/ornament/ornament" + item.getItemDamage() + ".png")); 
			
			GL11.glRotatef(0.0f, 0.0F, -0.0F, -1.0F);
			GL11.glRotatef(0.0f, 0.0F, -0.0F, 1.0F);
			GL11.glRotatef(0.0f,  0.0F, -0.0F, 1.0F);

			GL11.glTranslatef(-0.025F,-0.7F, 0F);


			float scale1 = 1.0F;
			GL11.glScalef(scale1, scale1, scale1);

			model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
					0.0625F);
			GL11.glPopMatrix();

		}break;
		case EQUIPPED: {
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Wintercraft.modid.toLowerCase(), "textures/blocks/ornament/ornament" + item.getItemDamage() + ".png"));  
			
			GL11.glRotatef(0.0f, 0.0F, -0.0F, -1.0F);
			GL11.glRotatef(0.0f, 0.0F, -0.0F, 1.0F);
			GL11.glRotatef(40.0f,  0.0F, -0.0F, 1.0F);

			GL11.glTranslatef(0.3F, -0.65F, -0.1F);


			float scale1 = 1.0F;
			GL11.glScalef(scale1, scale1, scale1);

			model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
					0.0625F);
			GL11.glPopMatrix();

		}break;
		default:
			break;
		}

	}

}