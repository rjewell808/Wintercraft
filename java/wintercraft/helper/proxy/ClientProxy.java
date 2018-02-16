package wintercraft.helper.proxy;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import wintercraft.blocks.WinterBlocks;
import wintercraft.blocks.WinterSpecialBlocks;
import wintercraft.entity.monster.EntityAlbinoReindeer;
import wintercraft.entity.monster.EntityGingerbread;
import wintercraft.entity.monster.EntityMiniSnowGolem;
import wintercraft.entity.passive.EntityElf;
import wintercraft.entity.passive.EntityPenguin;
import wintercraft.entity.passive.EntityPolarBear;
import wintercraft.entity.passive.EntityReindeer;
import wintercraft.entity.passive.EntitySnowMan;
import wintercraft.entity.projectiles.EntityIceball;
import wintercraft.entity.projectiles.EntityRockySnowball;
import wintercraft.entity.projectiles.EntityRockySnowballGolem;
import wintercraft.helper.gui.RenderFreezer;
import wintercraft.helper.tileEntity.TileEntityFirePlace;
import wintercraft.helper.tileEntity.TileEntitySnowManHead;
import wintercraft.items.EntityStaff;
import wintercraft.items.WinterItems;
import wintercraft.render.CandleRenderer;
import wintercraft.render.CoffeeRenderer;
import wintercraft.render.FirePlaceRenderer;
import wintercraft.render.OrnamentRareRenderer;
import wintercraft.render.OrnamentRenderer;
import wintercraft.render.SnowGlobeRenderer;
import wintercraft.render.SnowManHeadRenderer;
import wintercraft.render.item.ItemOrnamentRareRenderer;
import wintercraft.render.item.ItemOrnamentRenderer;
import wintercraft.render.item.ItemSnowManHeadRenderer;
import wintercraft.render.mobs.RenderAlbinoReindeer;
import wintercraft.render.mobs.RenderElf;
import wintercraft.render.mobs.RenderGingerbread;
import wintercraft.render.mobs.RenderMiniSnowGolem;
import wintercraft.render.mobs.RenderPenguin;
import wintercraft.render.mobs.RenderPolarBear;
import wintercraft.render.mobs.RenderReindeer;
import wintercraft.render.mobs.RenderSnowManPet;
import wintercraft.render.models.ModelAntlers;
import wintercraft.render.models.ModelElf;
import wintercraft.render.models.ModelGingerbread;
import wintercraft.render.models.ModelMiniSnowGolem;
import wintercraft.render.models.ModelPenguin;
import wintercraft.render.models.ModelPolarBear;
import wintercraft.render.models.ModelReindeer;
import wintercraft.render.models.ModelSantaHat;
import wintercraft.render.models.ModelSnowManPet;
import wintercraft.render.tileEntity.TileEntityCandle;
import wintercraft.render.tileEntity.TileEntityOrnament;
import wintercraft.render.tileEntity.TileEntityOrnamentRare;
import wintercraft.render.tileEntity.TileEntitySnowGlobe;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenderThings() {
	//Candles
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCandle.class, new CandleRenderer());
	
	//Ornaments
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOrnament.class, new OrnamentRenderer());
	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(WinterSpecialBlocks.ornament), new ItemOrnamentRenderer());
	
	//Rare Ornaments
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOrnamentRare.class, new OrnamentRareRenderer());
	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(WinterSpecialBlocks.ornamentRare), new ItemOrnamentRareRenderer());
	
	//Head
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySnowManHead.class, new SnowManHeadRenderer());
	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(WinterBlocks.snowManHead), new ItemSnowManHeadRenderer());
	
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySnowGlobe.class, new SnowGlobeRenderer());
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFirePlace.class, new FirePlaceRenderer());
	
	RenderingRegistry.registerBlockHandler(2105, RenderFreezer.INSTANCE);
	
	RenderingRegistry.registerEntityRenderingHandler(EntityRockySnowball.class, new RenderSnowball(WinterItems.rockySnowball));
	RenderingRegistry.registerEntityRenderingHandler(EntityIceball.class, new RenderSnowball(WinterItems.iceBall));
	RenderingRegistry.registerEntityRenderingHandler(EntityStaff.class, new RenderSnowball(WinterItems.iceBall));
	RenderingRegistry.registerEntityRenderingHandler(EntityRockySnowballGolem.class, new RenderSnowball(WinterItems.iceBall));
	
	MinecraftForgeClient.registerItemRenderer(WinterItems.coffee, (IItemRenderer) new CoffeeRenderer());
	
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
		return santaHat;
	}
	
}

