package gruntpie224.wintercraft.helper;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class WCSounds {
	
	public static SoundEvent snd_present_rip;
	
	public static SoundEvent snd_gingerbread_death;
	public static SoundEvent snd_gingerbread_hit;
	
	public static void initSounds()
	{
		snd_present_rip = new SoundEvent(new ResourceLocation("wc", "rip"));
		
		snd_gingerbread_death = new SoundEvent(new ResourceLocation("wc", "gingerbread_death"));
		snd_gingerbread_hit = new SoundEvent(new ResourceLocation("wc", "gingerbread_hurt"));
	}
}	
