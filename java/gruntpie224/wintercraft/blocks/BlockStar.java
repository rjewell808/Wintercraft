package gruntpie224.wintercraft.blocks;

import static net.minecraftforge.common.EnumPlantType.Plains;

import java.util.Random;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.helper.PlayerTickHandler;
import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterSpecialBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class BlockStar extends BlockBush{

	Random generator = new Random();
	
	private boolean isActivated = false;
	
	public BlockStar(Material par2Material) {
		super(par2Material);
		this.setCreativeTab(Wintercraft.wintercraftTab);
		this.setLightLevel(0.9375F);
	}
	
	@Override
	public void onBlockAdded(World par1World, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(par1World, pos, state);
        
        if (
        	(compare(par1World, pos.getX(), pos.getY() - 1, pos.getZ(), Blocks.leaves) || compare(par1World, pos.getX(), pos.getY() - 1, pos.getZ(), WinterBlocks.lights_block))
        	//Layer 2
        	&compare(par1World, pos.getX(), pos.getY() - 2, pos.getZ(),Blocks.log)
        	&compare(par1World, pos.getX() - 1, pos.getY() - 2, pos.getZ(), WinterBlocks.lights_block)
        	&compare(par1World, pos.getX() + 1, pos.getY() - 2, pos.getZ(), WinterBlocks.lights_block)
        	&compare(par1World, pos.getX(), pos.getY() - 2, pos.getZ() - 1, WinterBlocks.lights_block)
        	&compare(par1World, pos.getX(), pos.getY() - 2, pos.getZ() + 1, WinterBlocks.lights_block)
        	
        	//Layer 3
        	&compare(par1World, pos.getX(), pos.getY() - 3, pos.getZ(), Blocks.log)
        	&compare(par1World, pos.getX() - 1, pos.getY() - 3, pos.getZ(), WinterBlocks.lights_block)
            &compare(par1World, pos.getX() + 1, pos.getY() - 3, pos.getZ(), WinterBlocks.lights_block)
            &compare(par1World, pos.getX(), pos.getY() - 3, pos.getZ() - 1, WinterBlocks.lights_block)
            &compare(par1World, pos.getX(), pos.getY() - 3, pos.getZ() + 1, WinterBlocks.lights_block)
            &compare(par1World, pos.getX() + 1, pos.getY() - 3, pos.getZ() - 1, WinterBlocks.lights_block)
            &compare(par1World, pos.getX() + 1, pos.getY() - 3, pos.getZ() + 1, WinterBlocks.lights_block)
            &compare(par1World, pos.getX() - 1, pos.getY() - 3, pos.getZ() - 1, WinterBlocks.lights_block)
            &compare(par1World, pos.getX() - 1, pos.getY() - 3, pos.getZ() + 1, WinterBlocks.lights_block)
            
            //Layer 4
        	&compare(par1World, pos.getX(), pos.getY() - 4, pos.getZ(), Blocks.log)
        	&(compare(par1World, pos.getX() - 1, pos.getY() - 4, pos.getZ(), WinterSpecialBlocks.ornament) || compare(par1World, pos.getX() - 1, pos.getY() - 4, pos.getZ(), WinterSpecialBlocks.ornament_rare))
            &(compare(par1World, pos.getX() + 1, pos.getY() - 4, pos.getZ(), WinterSpecialBlocks.ornament) || compare(par1World, pos.getX() + 1, pos.getY() - 4, pos.getZ(), WinterSpecialBlocks.ornament_rare))
            &(compare(par1World, pos.getX(), pos.getY() - 4, pos.getZ() - 1, WinterSpecialBlocks.ornament) || compare(par1World, pos.getX(), pos.getY() - 4, pos.getZ() - 1, WinterSpecialBlocks.ornament_rare))
            &(compare(par1World, pos.getX(), pos.getY() - 4, pos.getZ() + 1, WinterSpecialBlocks.ornament) || compare(par1World, pos.getX(), pos.getY() - 4, pos.getZ() + 1, WinterSpecialBlocks.ornament_rare))
            &(compare(par1World, pos.getX() + 1, pos.getY() - 4, pos.getZ() - 1, WinterSpecialBlocks.ornament) || compare(par1World, pos.getX() + 1, pos.getY() - 4, pos.getZ() - 1, WinterSpecialBlocks.ornament_rare))
            &(compare(par1World, pos.getX() + 1, pos.getY() - 4, pos.getZ() + 1, WinterSpecialBlocks.ornament) || compare(par1World, pos.getX() + 1, pos.getY() - 4, pos.getZ() + 1, WinterSpecialBlocks.ornament_rare))
            &(compare(par1World, pos.getX() - 1, pos.getY() - 4, pos.getZ() - 1, WinterSpecialBlocks.ornament) || compare(par1World, pos.getX() - 1, pos.getY() - 4, pos.getZ() - 1, WinterSpecialBlocks.ornament_rare))
            &(compare(par1World, pos.getX() - 1, pos.getY() - 4, pos.getZ() + 1, WinterSpecialBlocks.ornament) || compare(par1World, pos.getX() - 1, pos.getY() - 4, pos.getZ() + 1, WinterSpecialBlocks.ornament_rare))
        	
            &compare(par1World, pos.getX(), pos.getY() - 5, pos.getZ(), Blocks.log)
        	
        	//Layer 6
        	&compare(par1World, pos.getX(), pos.getY() - 6, pos.getZ(), Blocks.wool)
        	&compare(par1World, pos.getX() - 1, pos.getY() - 6, pos.getZ(), Blocks.wool)
            &compare(par1World, pos.getX() + 1, pos.getY() - 6, pos.getZ(), Blocks.wool)
            &compare(par1World, pos.getX(), pos.getY() - 6, pos.getZ() - 1, Blocks.wool)
            &compare(par1World, pos.getX(), pos.getY() - 6, pos.getZ() + 1, Blocks.wool)
            &compare(par1World, pos.getX() + 1, pos.getY() - 6, pos.getZ() - 1, Blocks.wool)
            &compare(par1World, pos.getX() + 1, pos.getY() - 6, pos.getZ() + 1, Blocks.wool)
            &compare(par1World, pos.getX() - 1, pos.getY() - 6, pos.getZ() - 1, Blocks.wool)
            &compare(par1World, pos.getX() - 1, pos.getY() - 6, pos.getZ() + 1, Blocks.wool)
            )
        	
           {
        	if (!par1World.isRemote)
            {
                PlayerTickHandler.presentTimer = true;
                PlayerTickHandler.starPos.push(pos);
                isActivated = true;
                par1World.playSoundEffect((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, "wc:star", 1.0F, par1World.rand.nextFloat() * 0.1F + 0.9F);              
       	 	  }
            }
        }
	
	@Override
	public void breakBlock(World parWorld, BlockPos pos, IBlockState state)
    {
		if(!parWorld.isRemote){
			for(int i=0;i<PlayerTickHandler.starPos.size();i++){
				if(PlayerTickHandler.starPos.get(i) == pos){
					PlayerTickHandler.starPos.remove(i);
					isActivated = false;
				}
			}
		}
    }
	
	private boolean compare(World world, int x, int y, int z, Block block2)
	{
		//System.out.println("Block 1: " + world.getBlockState(new BlockPos(x, y, z)).getBlock());
		//System.out.println("Block 2: " + block2);
		//System.out.println("Block 2 State: " + block2.getBlockState());
		//System.out.println("Block 2 Base State: " + block2.getBlockState().getBaseState());
		return world.getBlockState(new BlockPos(x, y, z)).getBlock()  == block2;
	}

	@Override
	public void randomDisplayTick(World par1World, BlockPos pos, IBlockState state, Random par5Random)
	{
	 	int x = pos.getX();
	 	int y = pos.getY();
	 	int z = pos.getZ();
		
		double d0 = (double)x + 0.5D;
        double d1 = (double)y + 0.6D;
        double d2 = (double)z + 0.25D;
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;
	    super.randomDisplayTick(par1World, pos, state, par5Random);

	    if(PlayerTickHandler.presentTimer == true && isActivated){
		    for (int l = x - 2; l <= x + 2; ++l)
		    {
		        for (int i1 = z - 2; i1 <= z + 2; ++i1)
		        {
		            if (l > x - 2 && l < x + 2 && i1 == z - 1)
		            {
		                i1 = z + 2;
		            }
	
		            if (par5Random.nextInt(5) == 0)
		            {
		                for (int j1 = y; j1 <= y + 2; ++j1)
		                {
		                	par1World.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, d0, d1 + d3, d2 + d4, 0.0D, 0.5D, 0.0D);
		                }
                	}
                }
            }
        }
    }
	
	@Override
	protected boolean canPlaceBlockOn(Block par1)
    {
		 return par1 == Blocks.leaves || par1 == WinterBlocks.lights_block;
    }
	
	@Override
	public Item getItemDropped(IBlockState state, Random par2Random, int par3)
	{
		return Items.glowstone_dust;
	}
	
	@Override
    public int quantityDropped(Random par1Random)
    {
        return par1Random.nextInt(4)+1;
    }
    
    protected boolean canSilkHarvest()
    {
        return true;
    }
    
}
