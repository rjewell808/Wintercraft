package wintercraft;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import wintercraft.helper.FeatureConfig;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.event.FMLInitializationEvent;

public class BiomeControl {

	public static int month;
	public static int day;
	public static int year;
	
	public static void Init(FMLInitializationEvent event){
	
	month = Calendar.getInstance().get(Calendar.MONTH);
	day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	year = Calendar.getInstance().get(Calendar.YEAR);
	
	if (month == 11 || month == 0 || FeatureConfig.snowAll == true){
		
		if (FeatureConfig.snowMonth == true || FeatureConfig.snowAll == true){	
		
		BiomeGenBase.beach.temperature = 0.0F;
			BiomeGenBase.beach.setEnableSnow();	
		
		BiomeGenBase.birchForest.temperature = 0.0F;
			BiomeGenBase.birchForest.setEnableSnow();
			
		//Birch Forest M Mutation
		BiomeGenBase.getBiome(BiomeGenBase.birchForest.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.birchForest.biomeID + 128).setEnableSnow();
			
		BiomeGenBase.birchForestHills.temperature = 0.0F;
			BiomeGenBase.birchForestHills.setEnableSnow();
			
		//Birch Forest Hills M Mutation
		BiomeGenBase.getBiome(BiomeGenBase.birchForestHills.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.birchForestHills.biomeID + 128).setEnableSnow();
			
		BiomeGenBase.coldBeach.temperature = 0.0F;
			BiomeGenBase.coldBeach.setEnableSnow();
			
		BiomeGenBase.coldTaiga.temperature = 0.0F;
			BiomeGenBase.coldTaiga.setEnableSnow();
			
		//Cold Taiga M Mutation
		BiomeGenBase.getBiome(BiomeGenBase.coldTaiga.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.coldTaiga.biomeID + 128).setEnableSnow();
			
		BiomeGenBase.coldTaigaHills.temperature = 0.0F;
			BiomeGenBase.coldTaigaHills.setEnableSnow();
			
		BiomeGenBase.deepOcean.temperature = 0.0F;
			BiomeGenBase.deepOcean.setEnableSnow();
			
		BiomeGenBase.desert.temperature = 0.0F;
			BiomeGenBase.desert.setEnableSnow();
			
		//Desert M Mutation
		BiomeGenBase.getBiome(BiomeGenBase.desert.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.desert.biomeID + 128).setEnableSnow();	
		
		BiomeGenBase.desertHills.temperature = 0.0F;
			BiomeGenBase.desertHills.setEnableSnow();
			
		BiomeGenBase.extremeHills.temperature = 0.0F;
			BiomeGenBase.extremeHills.setEnableSnow();
			
		//Extreme Hills M Mutation
		BiomeGenBase.getBiome(BiomeGenBase.extremeHills.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.extremeHills.biomeID + 128).setEnableSnow();
			
		BiomeGenBase.extremeHillsEdge.temperature = 0.0F;
			BiomeGenBase.extremeHillsEdge.setEnableSnow();
			
		BiomeGenBase.extremeHillsPlus.temperature = 0.0F;
			BiomeGenBase.extremeHillsPlus.setEnableSnow();
			
		//Extreme Hills+ Mutation
		BiomeGenBase.getBiome(BiomeGenBase.extremeHillsPlus.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.extremeHillsPlus.biomeID + 128).setEnableSnow();
			
		BiomeGenBase.forest.temperature = 0.0F;
			BiomeGenBase.forest.setEnableSnow();
			
		//Flower Forest Mutation
		BiomeGenBase.getBiome(BiomeGenBase.forest.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.forest.biomeID + 128).setEnableSnow();
			
		BiomeGenBase.forestHills.temperature = 0.0F;
			BiomeGenBase.forestHills.setEnableSnow();
			
		BiomeGenBase.frozenOcean.temperature = 0.0F;
			BiomeGenBase.frozenOcean.setEnableSnow();
			
		BiomeGenBase.frozenRiver.temperature = 0.0F;
			BiomeGenBase.frozenRiver.setEnableSnow();
		
		BiomeGenBase.iceMountains.temperature = 0.0F;
			BiomeGenBase.iceMountains.setEnableSnow();
			
		BiomeGenBase.icePlains.temperature = 0.0F;
			BiomeGenBase.icePlains.setEnableSnow();
			
		//Ice Plains Spikes Mutation
		BiomeGenBase.getBiome(BiomeGenBase.icePlains.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.icePlains.biomeID + 128).setEnableSnow();
			
		BiomeGenBase.jungle.temperature = 0.0F;
			BiomeGenBase.jungle.setEnableSnow();
			
		//Jungle M Mutation
		BiomeGenBase.getBiome(BiomeGenBase.jungle.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.jungle.biomeID + 128).setEnableSnow();
			
		BiomeGenBase.jungleEdge.temperature = 0.0F;
			BiomeGenBase.jungleEdge.setEnableSnow();
			
		//Jungle Edge M Mutation
		BiomeGenBase.getBiome(BiomeGenBase.jungleEdge.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.jungleEdge.biomeID + 128).setEnableSnow();
			
		BiomeGenBase.jungleHills.temperature = 0.0F;
			BiomeGenBase.jungleHills.setEnableSnow();
		
		BiomeGenBase.megaTaiga.temperature = 0.0F;
			BiomeGenBase.megaTaiga.setEnableSnow();
			
		//Mega Spruce Taiga Mutation
		BiomeGenBase.getBiome(BiomeGenBase.megaTaiga.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.megaTaiga.biomeID + 128).setEnableSnow();
			
		BiomeGenBase.megaTaigaHills.temperature = 0.0F;
			BiomeGenBase.megaTaigaHills.setEnableSnow();
			
		//Mega Spruce Taiga Hills Mutation
		BiomeGenBase.getBiome(BiomeGenBase.megaTaigaHills.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.megaTaigaHills.biomeID + 128).setEnableSnow();
			
		BiomeGenBase.mesa.temperature = 0.0F;
			BiomeGenBase.mesa.setEnableSnow();
			
		//Mesa(Bryce) Mutation
		BiomeGenBase.getBiome(BiomeGenBase.mesa.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.mesa.biomeID + 128).setEnableSnow();
			
		BiomeGenBase.mesaPlateau.temperature = 0.0F;
			BiomeGenBase.mesaPlateau.setEnableSnow();
			
		//Plateau M Mutation
		BiomeGenBase.getBiome(BiomeGenBase.mesaPlateau.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.mesaPlateau.biomeID + 128).setEnableSnow();
			
		BiomeGenBase.mesaPlateau_F.temperature = 0.0F;
			BiomeGenBase.mesaPlateau_F.setEnableSnow();
			
		//Plateau_F M Mutation
		BiomeGenBase.getBiome(BiomeGenBase.mesaPlateau_F.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.mesaPlateau_F.biomeID + 128).setEnableSnow();
			
		BiomeGenBase.mushroomIsland.temperature = 0.0F;
			BiomeGenBase.mushroomIsland.setEnableSnow();	
			
		BiomeGenBase.mushroomIslandShore.temperature = 0.0F;
			BiomeGenBase.mushroomIslandShore.setEnableSnow();
			
		BiomeGenBase.ocean.temperature = 0.0F;
			BiomeGenBase.ocean.setEnableSnow();
			
		BiomeGenBase.plains.temperature = 0.0F;
			BiomeGenBase.plains.setEnableSnow();
		
		//Sunflower Plains Mutation
		BiomeGenBase.getBiome(BiomeGenBase.plains.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.plains.biomeID + 128).setEnableSnow();
			
		BiomeGenBase.river.temperature = 0.0F;
			BiomeGenBase.river.setEnableSnow();
			
		BiomeGenBase.roofedForest.temperature = 0.0F;
			BiomeGenBase.roofedForest.setEnableSnow();
			
		//Roofed Forest M Mutation
		BiomeGenBase.getBiome(BiomeGenBase.roofedForest.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.roofedForest.biomeID + 128).setEnableSnow();
			
		BiomeGenBase.savanna.temperature = 0.0F;
			BiomeGenBase.savanna.setEnableSnow();
			
		//Savanna M Mutation
		BiomeGenBase.getBiome(BiomeGenBase.savanna.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.savanna.biomeID + 128).setEnableSnow();
			
		BiomeGenBase.savannaPlateau.temperature = 0.0F;
			BiomeGenBase.savannaPlateau.setEnableSnow();
			
		//Savanna Plateau M Mutation
		BiomeGenBase.getBiome(BiomeGenBase.savannaPlateau.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.savannaPlateau.biomeID + 128).setEnableSnow();
			
		BiomeGenBase.swampland.temperature = 0.0F;
			BiomeGenBase.swampland.setEnableSnow();
			
		//Swampland M Mutation
		BiomeGenBase.getBiome(BiomeGenBase.swampland.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.swampland.biomeID + 128).setEnableSnow();
			
		BiomeGenBase.taiga.temperature = 0.0F;
			BiomeGenBase.taiga.setEnableSnow();
			
		//Taiga Mutation
		BiomeGenBase.getBiome(BiomeGenBase.taiga.biomeID + 128).temperature = 0.0F;
			BiomeGenBase.getBiome(BiomeGenBase.taiga.biomeID + 128).setEnableSnow();
			
		BiomeGenBase.taigaHills.temperature = 0.0F;
			BiomeGenBase.taigaHills.setEnableSnow();

		}
	}
			
	}

}
                          