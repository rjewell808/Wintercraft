package gruntpie224.wintercraft.helper;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class WCSounds {
	
	public static SoundEvent snd_present_rip;
	
	public static SoundEvent snd_gingerbread_death;
	public static SoundEvent snd_gingerbread_hit;
	
	public static SoundEvent snd_minisnowgolem_death;
	public static SoundEvent snd_minisnowgolem_hurt;
	public static SoundEvent snd_minisnowgolem_say;
	public static SoundEvent snd_minisnowgolem_step;
	
	public static SoundEvent snd_disk_jingle;
	public static SoundEvent snd_disk_halls;
	
	public static void initSounds()
	{
		snd_present_rip = new SoundEvent(new ResourceLocation("wc", "rip"));
		
		snd_gingerbread_death = new SoundEvent(new ResourceLocation("wc", "gingerbread_death"));
		snd_gingerbread_hit = new SoundEvent(new ResourceLocation("wc", "gingerbread_hurt"));
		
		snd_minisnowgolem_death = new SoundEvent(new ResourceLocation("wc", "snow_golem_death"));
		snd_minisnowgolem_hurt = new SoundEvent(new ResourceLocation("wc", "snow_golem_hurt"));
		snd_minisnowgolem_say = new SoundEvent(new ResourceLocation("wc", "snow_golem_say"));
		snd_minisnowgolem_step = new SoundEvent(new ResourceLocation("wc", "snow_golem_step"));
		
		snd_disk_jingle = new SoundEvent(new ResourceLocation("wc", "disk_jingle"));
		snd_disk_halls = new SoundEvent(new ResourceLocation("wc", "disk_halls"));
	}
}	
