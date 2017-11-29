package gruntpie224.wintercraft;

import java.util.Calendar;

import gruntpie224.wintercraft.helper.config.ConfigHandler;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeControl {

	public static int month;
	public static int day;
	public static int year;
	
	public static void Init()
	{
	
		month = Calendar.getInstance().get(Calendar.MONTH);
		day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		year = Calendar.getInstance().get(Calendar.YEAR);
		
		if (((month == 11 || month == 0) && ConfigHandler.snowMonth == true) || ConfigHandler.snowAll == true)
		{
				for(int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++)
				{
					if(BiomeGenBase.getBiome(i) != null)
					{
						BiomeGenBase.getBiome(i).temperature = 0.0F;
					}
				}

		}	
			
	}

}
                          