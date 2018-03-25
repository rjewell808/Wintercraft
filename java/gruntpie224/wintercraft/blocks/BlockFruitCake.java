package gruntpie224.wintercraft.blocks;

import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.block.BlockCake;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFruitCake extends BlockCake{
	
	public BlockFruitCake(String name)
	{
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.blockSoundType = SoundType.CLOTH;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        this.eatCake(worldIn, pos, state, playerIn);
        return true;
    }

	@Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
    {
        this.eatCake(worldIn, pos, worldIn.getBlockState(pos), playerIn);
    }
	
	private void eatCake(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        if (player.canEat(false))
        {
            player.getFoodStats().addStats(2, 0.1F);
            int i = ((Integer)state.getValue(BITES)).intValue();

            if (i < 6)
            {
                worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 3);
                player.addPotionEffect(new PotionEffect(Potion.getPotionById(5), 30 * 20, 1));
            }
            else
            {
                worldIn.setBlockToAir(pos);
            }
        }
    }
	
	@SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return WinterItems.fruit_cake_item;
    }
}
