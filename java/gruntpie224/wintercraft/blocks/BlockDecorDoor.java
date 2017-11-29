package gruntpie224.wintercraft.blocks;

import java.util.Random;

import javax.swing.Icon;

import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDecorDoor extends BlockDoor
{
	public Item placerItem = WinterItems.decor_door_item;
	
	public BlockDecorDoor(Material par2Material)
    {
		super(par2Material);
		float f = 0.5F;
		float f1 = 1.0F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
		this.setStepSound(soundTypeWood);
    }
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? null : this.getItem();
    }
	
	@Override
	public Item getItem(World worldIn, BlockPos pos)
    {
        return this.getItem();
    }
	
	private Item getItem()
    {
        return WinterItems.decor_door_item;
    }

}