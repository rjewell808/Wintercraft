package wintercraft.helper.gui;


import wintercraft.helper.tileEntity.TileEntityFreezer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getTileEntity(x, y, z);
		switch(id)
		{
			case 0: return new ContainerFreezer(player.inventory, (TileEntityFreezer) tile_entity); 
		}
		
		return null;
	}
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getTileEntity(x, y, z);
		switch(id)
		{
			case 0: return new GuiFreezer(player.inventory, (TileEntityFreezer) tile_entity);
		}
		return null;
	}
}