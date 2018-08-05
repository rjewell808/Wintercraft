package gruntpie224.wintercraft.proxy;

import gruntpie224.wintercraft.entity.EntityBase;
import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterItems;
import gruntpie224.wintercraft.render.models.ModelAntlers;
import gruntpie224.wintercraft.render.models.ModelSantaHat;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy{
	@Override
	public void preInit(FMLPreInitializationEvent event){
		super.preInit(event);
		EntityBase.initModels();
	}
	
	@Override
	public void init(FMLInitializationEvent event){
		super.init(event);
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event){
		super.postInit(event);
	}
	
	@Override
	public void serverStarting(FMLServerStartingEvent event){
		super.serverStarting(event);
	}
	
	@Override
	public void serverStopping(FMLServerStoppingEvent event){
		super.serverStopping(event);
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{
		WinterItems.initModels();
		WinterBlocks.initModels();
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
