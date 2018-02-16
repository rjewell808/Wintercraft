package wintercraft.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;
import wintercraft.Wintercraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemChristmasMusicDisk extends ItemRecord{

    public ItemChristmasMusicDisk(String recordName) {
		super(recordName);
		this.setCreativeTab(Wintercraft.WintercraftTab);
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
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5));
    
    }
}