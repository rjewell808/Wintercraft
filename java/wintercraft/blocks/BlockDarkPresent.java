package wintercraft.blocks;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import wintercraft.Wintercraft;
import wintercraft.entity.monster.EntityGingerbread;
import wintercraft.entity.monster.EntityMiniSnowGolem;
import wintercraft.helper.tileEntity.TileEntityDarkPresent;
import wintercraft.helper.tileEntity.TileEntityGift;
import wintercraft.items.WinterItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDarkPresent extends BlockContainer{
	Random random = new Random();
	@SideOnly(Side.CLIENT)
	private IIcon iconPresentTop;
	@SideOnly(Side.CLIENT)
	private IIcon iconPresentBottom;
	
	private int rewardAmount = 4;
	private int rewardType = 0;
	public BlockDarkPresent(Material par2Material) {
		super(par2Material);
		this.setCreativeTab(Wintercraft.WintercraftTab);
	}
	
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
		TileEntityDarkPresent tile = (TileEntityDarkPresent) par1World.getTileEntity(par2, par3, par4);
		tile.rewardType = random.nextInt(4);
		tile.goodReward = random.nextInt(4);
		
		//System.out.println("Reward Type: " + tile.rewardType);
		//System.out.println("Good Reward: " + tile.goodReward);
    }

	public void onBlockHarvested(World par1World, int par2, int par3, int par4, int par5, EntityPlayer par6EntityPlayer) {
		if(!par6EntityPlayer.capabilities.isCreativeMode){
			TileEntityDarkPresent tile = (TileEntityDarkPresent) par1World.getTileEntity(par2, par3, par4);
			rewardType = tile.goodReward;
			par1World.playSoundAtEntity(par6EntityPlayer, "wintercraft:rip", 1F, 1F);
			
			//Bad Outcomes
			if(tile.rewardType == 1 || tile.rewardType == 2 || tile.rewardType == 3){ 
				rewardAmount = 0;
				//Mini Snow Golems Spawn
				if(tile.goodReward == 0){
					for(int i=random.nextInt(8 - 5) + 5;i>0;i--){
						if (!par1World.isRemote)
					    {
							double posX = par6EntityPlayer.posX + 0.5D+random.nextInt(2 + 3) - 3;
							double posY = par6EntityPlayer.posY + random.nextInt(2);
							double posZ = par6EntityPlayer.posZ + 0.5D+random.nextInt(2 + 3) - 3;
							
							EntityMiniSnowGolem entitysnowgolem = new EntityMiniSnowGolem(par1World);
							entitysnowgolem.setLocationAndAngles(posX, posY, posZ, 0.0F, 0.0F);
						    par1World.spawnEntityInWorld(entitysnowgolem);
					    }
					}
				}else
				//Lightning Strikes
				if(tile.goodReward == 1){
					if (!par1World.isRemote)
				    {
						for(int i=0;i<=random.nextInt(2)+1;i++){
							par1World.addWeatherEffect(new EntityLightningBolt(par1World, par6EntityPlayer.posX, par6EntityPlayer.posY, par6EntityPlayer.posZ));
							EntityLightningBolt entitybolt = new EntityLightningBolt(par1World, 0D, 0D, 0D);
							entitybolt.setLocationAndAngles(par6EntityPlayer.posX, par6EntityPlayer.posY, par6EntityPlayer.posZ, 0, 0.0F);
						    par1World.spawnEntityInWorld(entitybolt);
						}
				    }
				}else
				//Spawn Gingerbread Men
				if(tile.goodReward == 2){
					for(int i=random.nextInt(8 - 5) + 5;i>0;i--){
						if (!par1World.isRemote)
					    {
							double posX = par6EntityPlayer.posX + 0.5D+random.nextInt(2 + 3) - 3;
							double posY = par6EntityPlayer.posY + random.nextInt(2);
							double posZ = par6EntityPlayer.posZ + 0.5D+random.nextInt(2 + 3) - 3;
							
							EntityGingerbread entitygingerbread = new EntityGingerbread(par1World);
							entitygingerbread.setLocationAndAngles(posX, posY, posZ, 0.0F, 0.0F);
						    par1World.spawnEntityInWorld(entitygingerbread);
					    }
					}
				}
			  else
				//Spawns Live TNT
				if(tile.goodReward == 3){
					for(int i=random.nextInt(5 - 3) + 3;i>0;i--){
						if (!par1World.isRemote)
					    {
							System.out.println("SPAWN TNT");
							double posX = par6EntityPlayer.posX + 0.5D+random.nextInt(2 + 3) - 3;
							double posY = par6EntityPlayer.posY + random.nextInt(2);
							double posZ = par6EntityPlayer.posZ + 0.5D+random.nextInt(2 + 3) - 3;
							
							this.func_150114_a(par1World, (int)posX, (int)posY, (int)posZ, 1, par6EntityPlayer);
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
	 public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	    {
			TileEntityDarkPresent tile = (TileEntityDarkPresent) world.getTileEntity(x, y, z);
			
	        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
	        int count = quantityDropped(metadata, fortune, world.rand);
	        Item idDropped = null;
	        int metaDropped = 0;
	        
	        for(int i = 0; i < count; i++)
	        {
	        	if(rewardType == 0){
	                switch(i){
	                	case 0:
	                		idDropped = WinterItems.refBoots;
	                		break;
	                	case 1:
	                		idDropped = WinterItems.refLegs;
	                		break;
	                	case 2:
	                		idDropped = WinterItems.refPlate;
	                		break;
	                	case 3:
	                		idDropped = WinterItems.refHelmet;
	                		break;
	                }
	        	}else
        		if(rewardType == 1){
	                switch(i){
	                	case 0:
	                		idDropped = WinterItems.crystalBoots;
	                		break;
	                	case 1:
	                		idDropped = WinterItems.crystalLegs;
	                		break;
	                	case 2:
	                		idDropped = WinterItems.crystalPlate;
	                		break;
	                	case 3:
	                		idDropped = WinterItems.crystalHelmet;
	                		break;
	                }
	        	}else
	        		if(rewardType == 2){
		                switch(i){
		                	case 0:
		                		idDropped = Item.getItemFromBlock(WinterBlocks.snowGlobeBlock);
		                		break;
		                	case 1:
		                		idDropped = Item.getItemFromBlock(WinterBlocks.adventCalendar);
		                		break;
		                	case 2:
		                		idDropped = WinterItems.iceStaff;
		                		break;
		                	case 3:
		                		idDropped = WinterItems.candyCaneSword;
		                		break;
		                }
	        	}else
	        		if(rewardType == 3){
		                switch(i){
		                	case 0:
		                		idDropped = Item.getItemFromBlock(WinterBlocks.christmasPresent);
		                		break;
		                	case 1:
		                		idDropped = Item.getItemFromBlock(WinterBlocks.christmasPresent);
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
		        if (idDropped != null) {
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
	public Item getItemDropped(int metadata, Random rand, int fortune){
		return null;
	}

	 @SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2){
		return par1 == 1 ? this.iconPresentTop : (par1 == 0 ? this.iconPresentBottom : this.blockIcon);
	}
		
	public IIcon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5){
		if (par5 == 1)
		{
			return this.iconPresentTop;
		}
		else if (par5 == 0)
		{
			return this.iconPresentBottom;
		}
		else
		{
		return this.blockIcon;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{  
		this.blockIcon = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5) + "_side");
		this.iconPresentTop = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5) + "_top");
		this.iconPresentBottom = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5) + "_side");
	}
	
	protected boolean canSilkHarvest()
    {
        return true;
    } 
 
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityDarkPresent();
	}
}
