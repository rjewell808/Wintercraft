package gruntpie224.wintercraft.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.entity.monster.EntityGingerbread;
import gruntpie224.wintercraft.entity.monster.EntityMiniSnowGolem;
import gruntpie224.wintercraft.helper.tileEntity.TileEntityDarkPresent;
import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDarkPresent extends BlockContainer{
	Random random = new Random();
	
	private int rewardAmount = 4;
	private int rewardType = 0;
	public BlockDarkPresent(Material par2Material) {
		super(par2Material);
		this.setCreativeTab(Wintercraft.wintercraftTab);
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
		TileEntityDarkPresent tile = (TileEntityDarkPresent) worldIn.getTileEntity(pos);
		tile.rewardType = random.nextInt(4);
		tile.goodReward = random.nextInt(4);
		
		//System.out.println("Reward Type: " + tile.rewardType);
		//System.out.println("Good Reward: " + tile.goodReward);
    }

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) 
	{
		if(!player.capabilities.isCreativeMode){
			TileEntityDarkPresent tile = (TileEntityDarkPresent) worldIn.getTileEntity(pos);
			rewardType = tile.goodReward;
			worldIn.playSoundAtEntity(player, "wc:rip", 1F, 1F);
			
			//Bad Outcomes
			if(tile.rewardType == 1 || tile.rewardType == 2 || tile.rewardType == 3){ 
				rewardAmount = 0;
				//Mini Snow Golems Spawn
				if(tile.goodReward == 0){
					for(int i=random.nextInt(8 - 5) + 5;i>0;i--){
						if (!worldIn.isRemote)
					    {
							double posX = player.posX + 0.5D+random.nextInt(2 + 3) - 3;
							double posY = player.posY + random.nextInt(2);
							double posZ = player.posZ + 0.5D+random.nextInt(2 + 3) - 3;
							
							EntityMiniSnowGolem entitysnowgolem = new EntityMiniSnowGolem(worldIn);
							entitysnowgolem.setLocationAndAngles(posX, posY, posZ, 0.0F, 0.0F);
							worldIn.spawnEntityInWorld(entitysnowgolem);
					    }
					}
				}else
				//Lightning Strikes
				if(tile.goodReward == 1){
					if (!worldIn.isRemote)
				    {
						for(int i=0;i<=random.nextInt(2)+1;i++){
							worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, player.posX, player.posY, player.posZ));
							EntityLightningBolt entitybolt = new EntityLightningBolt(worldIn, 0D, 0D, 0D);
							entitybolt.setLocationAndAngles(player.posX, player.posY, player.posZ, 0, 0.0F);
							worldIn.spawnEntityInWorld(entitybolt);
						}
				    }
				}else
				//Spawn Gingerbread Men
				if(tile.goodReward == 2){
					for(int i=random.nextInt(8 - 5) + 5;i>0;i--){
						if (!worldIn.isRemote)
					    {
							double posX = player.posX + 0.5D+random.nextInt(2 + 3) - 3;
							double posY = player.posY + random.nextInt(2);
							double posZ = player.posZ + 0.5D+random.nextInt(2 + 3) - 3;
							
							EntityGingerbread entitygingerbread = new EntityGingerbread(worldIn);
							entitygingerbread.setLocationAndAngles(posX, posY, posZ, 0.0F, 0.0F);
							worldIn.spawnEntityInWorld(entitygingerbread);
					    }
					}
				}
			  else
				//Spawns Live TNT
				if(tile.goodReward == 3){
					for(int i=random.nextInt(5 - 3) + 3;i>0;i--){
						if (!worldIn.isRemote)
					    {
							System.out.println("SPAWN TNT");
							double posX = player.posX + 0.5D+random.nextInt(2 + 3) - 3;
							double posY = player.posY + random.nextInt(2);
							double posZ = player.posZ + 0.5D+random.nextInt(2 + 3) - 3;
							
							this.func_150114_a(worldIn, (int)posX, (int)posY, (int)posZ, 1, player);
					    }
					}
				}
			}else{
				rewardAmount = 4;
			}
		}
	}	
	
	public void func_150114_a(World p_150114_1_, int p_150114_2_, int p_150114_3_, int p_150114_4_, int p_150114_5_, EntityLivingBase p_150114_6_)
    {
        if (!p_150114_1_.isRemote)
        {
            if ((p_150114_5_ & 1) == 1)
            {
                EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(p_150114_1_, (double)((float)p_150114_2_ + 0.5F), (double)((float)p_150114_3_ + 0.5F), (double)((float)p_150114_4_ + 0.5F), p_150114_6_);
                p_150114_1_.spawnEntityInWorld(entitytntprimed);
                p_150114_1_.playSoundAtEntity(entitytntprimed, "game.tnt.primed", 1.0F, 1.0F);
            }
        }
    }
	
	@Override
	public int getRenderType()
    {
        return 3;
    }
	
	@Override
	public boolean isOpaqueCube()
    {
        return true;
    }
	
	@Override
    public boolean isFullCube()
    {
        return true;
    }
	 @Override
	 public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
		TileEntityDarkPresent tile = (TileEntityDarkPresent) world.getTileEntity(pos);
		
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        int count = this.quantityDropped(random);
        Item idDropped = null;
        int metaDropped = 0;
        
        for(int i = 0; i < count; i++)
        {
        	if(rewardType == 0){
                switch(i){
                	case 0:
                		idDropped = WinterItems.ref_boots;
                		break;
                	case 1:
                		idDropped = WinterItems.ref_legs;
                		break;
                	case 2:
                		idDropped = WinterItems.ref_plate;
                		break;
                	case 3:
                		idDropped = WinterItems.ref_helmet;
                		break;
                }
        	}else
    		if(rewardType == 1){
                switch(i){
                	case 0:
                		idDropped = WinterItems.cry_boots;
                		break;
                	case 1:
                		idDropped = WinterItems.cry_legs;
                		break;
                	case 2:
                		idDropped = WinterItems.cry_plate;
                		break;
                	case 3:
                		idDropped = WinterItems.cry_helmet;
                		break;
                }
        	}else
        		if(rewardType == 2){
	                switch(i){
	                	case 0:
	                		idDropped = Item.getItemFromBlock(WinterBlocks.snow_globe);
	                		break;
	                	case 1:
	                		idDropped = Item.getItemFromBlock(WinterBlocks.calendar_advent);
	                		break;
	                	case 2:
	                		idDropped = WinterItems.ice_staff;
	                		break;
	                	case 3:
	                		idDropped = WinterItems.candy_cane_sword;
	                		break;
	                }
        	}else
        		if(rewardType == 3){
	                switch(i){
	                	case 0:
	                		idDropped = Item.getItemFromBlock(WinterBlocks.winter_present);
	                		break;
	                	case 1:
	                		idDropped = Item.getItemFromBlock(WinterBlocks.winter_present);
	                		break;
	                	case 2:
	                		idDropped = Item.getItemFromBlock(WinterBlocks.present);
	                		break;
	                	case 3:
	                		idDropped = Item.getItemFromBlock(WinterBlocks.present);
	                		break;
	                }
	        	}	
            
			// Adds the block to the return list
	        if (idDropped != null)
	        {
                ret.add(new ItemStack(idDropped, 1, metaDropped));
	        }
        }
        return ret;
    }
	
	@Override
    public int quantityDropped(Random par1Random)
    {
		return rewardAmount;
    }
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
		return null;
	}
	
	@Override
	protected boolean canSilkHarvest()
    {
        return true;
    } 
 
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityDarkPresent();
	}
}
