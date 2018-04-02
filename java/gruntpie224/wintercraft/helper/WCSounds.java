package gruntpie224.wintercraft.helper;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class WCSounds {
	
	public static SoundEvent snd_present_rip;
	
	public static void initSounds()
	{
		snd_present_rip = new SoundEvent(new ResourceLocation("wc", "rip"));
	}
}	
