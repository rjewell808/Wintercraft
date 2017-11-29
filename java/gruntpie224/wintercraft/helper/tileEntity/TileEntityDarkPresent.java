package gruntpie224.wintercraft.helper.tileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDarkPresent extends TileEntity {
	public int rewardType;
	public int goodReward;
	
	@Override
	public void writeToNBT(NBTTagCompound par1)
	{
	   super.writeToNBT(par1);
	   par1.setInteger("rewardType", rewardType);
	   par1.setInteger("goodReward", goodReward);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1)
	{
	   super.readFromNBT(par1);
	   this.rewardType = par1.getInteger("rewardType");
	   this.goodReward = par1.getInteger("goodReward");
	}
	
	@Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tagCompound = new NBTTagCompound();
        writeToNBT(tagCompound);
        return new S35PacketUpdateTileEntity(pos, 1, tagCompound);
    }
 
 
    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        NBTTagCompound tag = pkt.getNbtCompound();
        readFromNBT(tag);
    }
}
