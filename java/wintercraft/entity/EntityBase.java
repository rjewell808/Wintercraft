package wintercraft.entity;

import wintercraft.Wintercraft;
import wintercraft.entity.monster.EntityAlbinoReindeer;
import wintercraft.entity.monster.EntityGingerbread;
import wintercraft.entity.monster.EntityMiniSnowGolem;
import wintercraft.entity.passive.EntityElf;
import wintercraft.entity.passive.EntityPenguin;
import wintercraft.entity.passive.EntityPolarBear;
import wintercraft.entity.passive.EntityReindeer;
import wintercraft.entity.passive.EntitySnowMan;
import wintercraft.helper.FeatureConfig;
import wintercraft.helper.items.ItemsConfig;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class EntityBase {

	
	static int startEntityId = FeatureConfig.mobIDCustom ? FeatureConfig.mobID : EntityRegistry.findGlobalUniqueEntityId();
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
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, primaryColor, secondaryColor));
	}
	
	public static void Init(){
			
	 if(FeatureConfig.winterMobs == true){	
			customSpawner = new CustomSpawner().setUnlocalizedName("customSpawner").setTextureName("Wintercraft:customSpawner");
				GameRegistry.registerItem(customSpawner, "Spawn");
			
			EntityRegistry.registerGlobalEntityID(EntityGingerbread.class, "GingerBreadMan", getUniqueEntityId());
				EntityRegistry.findGlobalUniqueEntityId();
					LanguageRegistry.instance().addStringLocalization("entity.GingerBreadMan.name", "GingerbreadMan");
						
			EntityRegistry.registerGlobalEntityID(EntityMiniSnowGolem.class, "MiniSnowGolem", getUniqueEntityId());
				EntityRegistry.findGlobalUniqueEntityId();
					LanguageRegistry.instance().addStringLocalization("entity.MiniSnowGolem.name", "Mini Snow Golem");
						
			EntityRegistry.registerGlobalEntityID(EntityAlbinoReindeer.class, "AlbinoReindeer", getUniqueEntityId());
				EntityRegistry.findGlobalUniqueEntityId();
					LanguageRegistry.instance().addStringLocalization("entity.AlbinoReindeer.name", "Albino Reindeer");
					
			EntityRegistry.registerGlobalEntityID(EntityPolarBear.class, "Polarbear", getUniqueEntityId());
				EntityRegistry.findGlobalUniqueEntityId();
					LanguageRegistry.instance().addStringLocalization("entity.Polarbear.name", "Polarbear");
						
			EntityRegistry.registerGlobalEntityID(EntityPenguin.class, "Penguin", getUniqueEntityId());
				EntityRegistry.findGlobalUniqueEntityId();
					LanguageRegistry.instance().addStringLocalization("entity.Penguin.name", "Penguin");
							
			EntityRegistry.registerGlobalEntityID(EntitySnowMan.class, "UsefulSnowMan", getUniqueEntityId());
					EntityRegistry.findGlobalUniqueEntityId();
						LanguageRegistry.instance().addStringLocalization("entity.SnowMan.name", "Snow Man");
						
			EntityRegistry.registerGlobalEntityID(EntityReindeer.class, "Reindeer", getUniqueEntityId());
						EntityRegistry.findGlobalUniqueEntityId();
							LanguageRegistry.instance().addStringLocalization("entity.Reindeer.name", "Reindeer");
									
			EntityRegistry.registerGlobalEntityID(EntityElf.class, "Elf", startEntityId);
					EntityRegistry.findGlobalUniqueEntityId();
						LanguageRegistry.instance().addStringLocalization("entity.Elf.name", "Elf [WIP]");	
				
				
			if(FeatureConfig.hostileMobs == true){	
				EntityRegistry.addSpawn(EntityGingerbread.class, 50, 1, 2, EnumCreatureType.monster,BiomeGenBase.forest, BiomeGenBase.taiga,BiomeGenBase.coldTaiga,BiomeGenBase.birchForest);
							
				EntityRegistry.addSpawn(EntityMiniSnowGolem.class, 55, 2, 4, EnumCreatureType.monster, BiomeGenBase.icePlains,BiomeGenBase.frozenOcean,BiomeGenBase.frozenRiver,BiomeGenBase.coldBeach);
							
				EntityRegistry.addSpawn(EntityAlbinoReindeer.class, 6, 1, 1, EnumCreatureType.creature, BiomeGenBase.icePlains);
			}
			
			if(FeatureConfig.neutralMobs == true){
				EntityRegistry.addSpawn(EntityPolarBear.class, 60, 2, 4, EnumCreatureType.creature, BiomeGenBase.taiga,BiomeGenBase.icePlains, BiomeGenBase.iceMountains,BiomeGenBase.frozenOcean);

				EntityRegistry.addSpawn(EntityPenguin.class, 75, 2, 4, EnumCreatureType.creature, BiomeGenBase.icePlains, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver);				
			}
			
			if(FeatureConfig.peacefulMobs == true){
				EntityRegistry.addSpawn(EntityReindeer.class, 30, 2, 4, EnumCreatureType.creature, BiomeGenBase.taiga,BiomeGenBase.iceMountains);
			}
	
		}				

	}

}
