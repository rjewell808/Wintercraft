package gruntpie224.wintercraft.helper.gui;

import gruntpie224.wintercraft.tileentity.TileEntityFreezer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiProxy implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity te = world.getTileEntity(pos);
		
		if (te instanceof TileEntityFreezer)
		{
			return new FreezerContainer(player.inventory, (TileEntityFreezer) te);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity te = world.getTileEntity(pos);
		
		if (te instanceof TileEntityFreezer)
		{
			TileEntityFreezer crock_te = (TileEntityFreezer) te;
			return new FreezerGUIContainer(player.inventory, crock_te, new FreezerContainer(player.inventory, crock_te));
		}
		return null;
	}

}
