package gruntpie224.wintercraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGift extends TileEntity{
	public int stack;
	public int item;
	public int meta;
	public String giver = "This gift is empty.";
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound par1)
	{
	   super.writeToNBT(par1);
	   par1.setInteger("stack", stack);
	   par1.setInteger("item", item);
	   par1.setInteger("meta", meta);
	   par1.setString("giver", giver);
	   
	   return par1;
	}

	@Override
	public void readFromNBT(NBTTagCompound par1)
	{
	   super.readFromNBT(par1);
	   this.stack = par1.getInteger("stack");
	   this.item = par1.getInteger("item");
	   this.meta = par1.getInteger("meta");
	   this.giver = par1.getString("giver");
	}
}
