package gruntpie224.wintercraft.helper.gui;


import gruntpie224.wintercraft.helper.tileEntity.TileEntityFreezer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	private static final int GUIID_MBE_31 = 31;
	public static int getGuiID() {return GUIID_MBE_31;}

	// Gets the server side element for the given gui id this should return a container
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID != getGuiID()) {
			System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
		}

		BlockPos xyz = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(xyz);
		if (tileEntity instanceof TileEntityFreezer) {
			TileEntityFreezer tileInventoryFurnace = (TileEntityFreezer) tileEntity;
			System.out.println("Container Created");
			return new ContainerFreezer(player.inventory, tileInventoryFurnace);
		}
		return null;
	}

	// Gets the client side element for the given gui id this should return a gui
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID != getGuiID()) {
			System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
		}

		BlockPos xyz = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(xyz);
		if (tileEntity instanceof TileEntityFreezer) {
			TileEntityFreezer tileInventoryFurnace = (TileEntityFreezer) tileEntity;
			return new GuiFreezer(player.inventory, tileInventoryFurnace);
		}
		return null;
	}
}