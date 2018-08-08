package gruntpie224.wintercraft.blocks;

import gruntpie224.wintercraft.helper.WCSounds;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockPresent extends BlockBasic {
	public BlockPresent(String name, Material material) {
		super(name, material, SoundType.CLOTH);
	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		worldIn.playSound(player, pos, WCSounds.snd_present_rip, SoundCategory.BLOCKS, 1F, 1F);
	}	
	
	@Override
	protected boolean canSilkHarvest()
    {
        return true;
    }
}
