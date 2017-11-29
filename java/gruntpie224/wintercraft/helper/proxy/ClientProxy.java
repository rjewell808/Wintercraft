package gruntpie224.wintercraft.helper.proxy;

import gruntpie224.wintercraft.blocks.BlockDecorDoor;
import gruntpie224.wintercraft.entity.monster.EntityAlbinoReindeer;
import gruntpie224.wintercraft.entity.monster.EntityGingerbread;
import gruntpie224.wintercraft.entity.monster.EntityMiniSnowGolem;
import gruntpie224.wintercraft.entity.passive.EntityElf;
import gruntpie224.wintercraft.entity.passive.EntityPenguin;
import gruntpie224.wintercraft.entity.passive.EntityPolarBear;
import gruntpie224.wintercraft.entity.passive.EntityReindeer;
import gruntpie224.wintercraft.entity.passive.EntitySnowMan;
import gruntpie224.wintercraft.entity.projectiles.EntityIceball;
import gruntpie224.wintercraft.entity.projectiles.EntityRockySnowball;
import gruntpie224.wintercraft.entity.projectiles.EntityRockySnowballGolem;
import gruntpie224.wintercraft.entity.projectiles.EntityStaff;
import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterItems;
import gruntpie224.wintercraft.init.WinterSpecialBlocks;
import gruntpie224.wintercraft.render.mobs.RenderAlbinoReindeer;
import gruntpie224.wintercraft.render.mobs.RenderElf;
import gruntpie224.wintercraft.render.mobs.RenderGingerbread;
import gruntpie224.wintercraft.render.mobs.RenderMiniSnowGolem;
import gruntpie224.wintercraft.render.mobs.RenderPenguin;
import gruntpie224.wintercraft.render.mobs.RenderPolarBear;
import gruntpie224.wintercraft.render.mobs.RenderReindeer;
import gruntpie224.wintercraft.render.mobs.RenderSnowManPet;
import gruntpie224.wintercraft.render.models.ModelAntlers;
import gruntpie224.wintercraft.render.models.ModelElf;
import gruntpie224.wintercraft.render.models.ModelGingerbread;
import gruntpie224.wintercraft.render.models.ModelMiniSnowGolem;
import gruntpie224.wintercraft.render.models.ModelPenguin;
import gruntpie224.wintercraft.render.models.ModelPolarBear;
import gruntpie224.wintercraft.render.models.ModelReindeer;
import gruntpie224.wintercraft.render.models.ModelSantaHat;
import gruntpie224.wintercraft.render.models.ModelSnowManPet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenders() 
	{
		WinterBlocks.registerRenders();
		WinterItems.registerRenders();
		
		//Candles
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCandle.class, new CandleRenderer());
		
		//Ornaments
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOrnament.class, new OrnamentRenderer());
		//MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(WinterSpecialBlocks.ornament), new ItemOrnamentRenderer());
		
		//Rare Ornaments
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOrnamentRare.class, new OrnamentRareRenderer());
		//MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(WinterSpecialBlocks.ornamentRare), new ItemOrnamentRareRenderer());
		
		//Head
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySnowManHead.class, new SnowManHeadRenderer());
		//MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(WinterBlocks.snowManHead), new ItemSnowManHeadRenderer());
		
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySnowGlobe.class, new SnowGlobeRenderer());
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFirePlace.class, new FirePlaceRenderer());
		
		//RenderingRegistry.registerBlockHandler(2105, RenderFreezer.INSTANCE);
		
		RenderingRegistry.registerEntityRenderingHandler(EntityRockySnowball.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), WinterItems.snowball_rock, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityIceball.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(),WinterItems.snowball_ice, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityStaff.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(),WinterItems.snowball_ice, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityRockySnowballGolem.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), WinterItems.snowball_ice, Minecraft.getMinecraft().getRenderItem()));
		
		//MinecraftForgeClient.registerItemRenderer(WinterItems.coffee, (IItemRenderer) new CoffeeRenderer());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityGingerbread.class, new RenderGingerbread(new ModelGingerbread(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPolarBear.class, new RenderPolarBear(new ModelPolarBear(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPenguin.class, new RenderPenguin(new ModelPenguin(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMiniSnowGolem.class, new RenderMiniSnowGolem(new ModelMiniSnowGolem(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySnowMan.class, new RenderSnowManPet(new ModelSnowManPet(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityReindeer.class, new RenderReindeer(new ModelReindeer(),new ModelPig(6.0F), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityAlbinoReindeer.class, new RenderAlbinoReindeer(new ModelReindeer(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityElf.class, new RenderElf(new ModelElf(),0.3F));
		
	}
	
	@Override
	public void ignoreProperties()
	{
		ModelLoader.setCustomStateMapper(WinterSpecialBlocks.decor_door_block, (new StateMap.Builder()).ignore(BlockDecorDoor.POWERED).build());
	}
	
	@Override
	public void registerTickHandler() {
		
	}

	private static final ModelSantaHat santaHat = new ModelSantaHat(1.0f);
	private static final ModelSantaHat santaHat2 = new ModelSantaHat(-1.0f);
	private static final ModelAntlers antlersHat = new ModelAntlers(1.0f,1.5F,-4.0F,12.0F);
	private static final ModelAntlers antlersHat2 = new ModelAntlers(-1.0f,1.5F,-4.0F,12.0F);
	
	@Override
	public ModelBiped getArmorModel(int id){
		
		switch (id) {
			case 0:
				return santaHat;
			case 1:
				return santaHat2;
			case 2:
				return antlersHat;
			case 3:
				return antlersHat2;
			default:
				break;
		}
		return null;
	}
	
}

