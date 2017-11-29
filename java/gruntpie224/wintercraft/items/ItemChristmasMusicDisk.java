package gruntpie224.wintercraft.items;

import gruntpie224.wintercraft.Wintercraft;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;

public class ItemChristmasMusicDisk extends ItemRecord{

    public ItemChristmasMusicDisk(String recordName) {
		super(recordName);
		this.setCreativeTab(Wintercraft.wintercraftTab);
		this.maxStackSize = 1;
    }
    /*
    public String getRecordTitle()
    {
       if(this.recordName == "wintercraft:jingleBells")
    	   return "Kevin MacLeod - Jingle Bells";
       
        return "Kevin MacLeod - " + this.recordName;
    }
    */
    @Override
    public ResourceLocation getRecordResource(String name)
    {
        return new ResourceLocation(recordName);
    }
}