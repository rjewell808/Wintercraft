package gruntpie224.wintercraft.entity;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.entity.monster.EntityAlbinoReindeer;
import gruntpie224.wintercraft.entity.monster.EntityGingerbread;
import gruntpie224.wintercraft.entity.monster.EntityMiniSnowGolem;
import gruntpie224.wintercraft.entity.passive.EntityElf;
import gruntpie224.wintercraft.entity.passive.EntityPenguin;
import gruntpie224.wintercraft.entity.passive.EntityPolarBear;
import gruntpie224.wintercraft.entity.passive.EntityReindeer;
import gruntpie224.wintercraft.entity.passive.EntitySnowMan;
import gruntpie224.wintercraft.helper.config.ConfigHandler;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

public class EntityBase {

	
	static int startEntityId = ConfigHandler.mobIDCustom ? ConfigHandler.mobID : EntityRegistry.findGlobalUniqueEntityId();
	public static Item customSpawner;
	
	public static int getUniqueEntityId(){	
		
		do{
			startEntityId++;
		}
		while(EntityList.getStringFromID(startEntityId) != null);
		return startEntityId++;
	}
	
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor){
		int id = getUniqueEntityId();
		EntityList.idToClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, primaryColor, secondaryColor));
	}
	
	public static void Init(){
			
			//customSpawner = new CustomSpawner().setUnlocalizedName("custom_spawner");
				//GameRegistry.registerItem(customSpawner, "custom_spawner");
				//WinterItems.registerRender(customSpawner);
				
				
			EntityRegistry.registerGlobalEntityID(EntityGingerbread.class, "WinterGingerBreadMan", getUniqueEntityId());
				EntityRegistry.findGlobalUniqueEntityId();
				EntityRegistry.registerEgg(EntityGingerbread.class, 0Xc67d2f, 0X723b00);
				LanguageRegistry.instance().addStringLocalization("entity.WinterGingerBreadMan.name", "GingerbreadMan");
						
			EntityRegistry.registerGlobalEntityID(EntityMiniSnowGolem.class, "WinterMiniSnowGolem", getUniqueEntityId());
				EntityRegistry.findGlobalUniqueEntityId();
				EntityRegistry.registerEgg(EntityMiniSnowGolem.class, 0Xeaf1f1, 0X82e2e5);
				LanguageRegistry.instance().addStringLocalization("entity.WinterMiniSnowGolem.name", "Mini Snow Golem");
						
			EntityRegistry.registerGlobalEntityID(EntityAlbinoReindeer.class, "WinterAlbinoReindeer", getUniqueEntityId());
				EntityRegistry.findGlobalUniqueEntityId();
				EntityRegistry.registerEgg(EntityAlbinoReindeer.class, 0XFF2B32, 0XEEE5FF);
				LanguageRegistry.instance().addStringLocalization("entity.WinterAlbinoReindeer.name", "Albino Reindeer");
				
			EntityRegistry.registerGlobalEntityID(EntityPolarBear.class, "WinterPolarbear", getUniqueEntityId());
				EntityRegistry.findGlobalUniqueEntityId();
				EntityRegistry.registerEgg(EntityPolarBear.class, 0XB4B4B5, 0XCFD3D5);
				LanguageRegistry.instance().addStringLocalization("entity.WinterPolarbear.name", "Polarbear");
						
			EntityRegistry.registerGlobalEntityID(EntityPenguin.class, "WinterPenguin", getUniqueEntityId());
				EntityRegistry.findGlobalUniqueEntityId();
				EntityRegistry.registerEgg(EntityPenguin.class, 0X1b1d43, 0Xcbced8);
				LanguageRegistry.instance().addStringLocalization("entity.WinterPenguin.name", "Penguin");
			
			EntityRegistry.registerGlobalEntityID(EntityReindeer.class, "WinterReindeer", getUniqueEntityId());
				EntityRegistry.findGlobalUniqueEntityId();
				EntityRegistry.registerEgg(EntityReindeer.class, 0X835A18, 0XC8994E);
				LanguageRegistry.instance().addStringLocalization("entity.WinterReindeer.name", "Reindeer");	
			
			EntityRegistry.registerGlobalEntityID(EntityElf.class, "WinterElf", getUniqueEntityId());
				EntityRegistry.findGlobalUniqueEntityId();
				EntityRegistry.registerEgg(EntityElf.class,0X49B74B, 0XFF7070);
				LanguageRegistry.instance().addStringLocalization("entity.WinterElf.name", "Elf [WIP]");		
								
			EntityRegistry.registerGlobalEntityID(EntitySnowMan.class, "WinterUsefulSnowMan", getUniqueEntityId());
					EntityRegistry.findGlobalUniqueEntityId();
					EntityRegistry.registerEgg(EntitySnowMan.class,0XC0C0C0, 0X585858);
					LanguageRegistry.instance().addStringLocalization("entity.WinterUseSnowMan.name", "Snow Man");
			
			
		if(ConfigHandler.winterMobs)
		 {	
			if(ConfigHandler.hostileMobs){	
				EntityRegistry.addSpawn(EntityGingerbread.class, 50, 1, 2, EnumCreatureType.MONSTER,BiomeGenBase.forest, BiomeGenBase.taiga,BiomeGenBase.coldTaiga,BiomeGenBase.birchForest);
							
				EntityRegistry.addSpawn(EntityMiniSnowGolem.class, 55, 2, 4, EnumCreatureType.MONSTER, BiomeGenBase.icePlains,BiomeGenBase.frozenOcean,BiomeGenBase.frozenRiver,BiomeGenBase.coldBeach);
							
				EntityRegistry.addSpawn(EntityAlbinoReindeer.class, 6, 1, 1, EnumCreatureType.CREATURE, BiomeGenBase.icePlains);
			}
			
			if(ConfigHandler.neutralMobs){
				EntityRegistry.addSpawn(EntityPolarBear.class, 60, 2, 4, EnumCreatureType.CREATURE, BiomeGenBase.taiga,BiomeGenBase.icePlains, BiomeGenBase.iceMountains,BiomeGenBase.frozenOcean);
			
				EntityRegistry.addSpawn(EntityPenguin.class, 75, 2, 4, EnumCreatureType.CREATURE, BiomeGenBase.icePlains, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver);				
			}
			
			if(ConfigHandler.peacefulMobs){
				EntityRegistry.addSpawn(EntityReindeer.class, 30, 2, 4, EnumCreatureType.CREATURE, BiomeGenBase.taiga,BiomeGenBase.iceMountains);
			}
		}				

	}

}
