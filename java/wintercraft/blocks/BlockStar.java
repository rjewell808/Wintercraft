package wintercraft.blocks;

import static net.minecraftforge.common.EnumPlantType.Plains;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import wintercraft.Wintercraft;
import wintercraft.helper.ConnectionHandler;
import wintercraft.helper.IceEventHandler;
import wintercraft.helper.PlayerTickHandler;
import wintercraft.helper.achievements.WinterAch;
import wintercraft.items.WinterItems;

public class BlockStar extends BlockBush{

	Random generator = new Random();
	protected BlockStar(Material par2Material) {
		super(par2Material);
		this.setCreativeTab(Wintercraft.WintercraftTab);
		this.setLightLevel(0.9375F);
	}
	
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);

        if (
        	((par1World.getBlock(par2, par3 - 1, par4) == Blocks.leaves || par1World.getBlock(par2, par3 - 1, par4) == WinterBlocks.lightsBlock))
        	//Layer 2
        	&par1World.getBlock(par2, par3 - 2, par4) == Blocks.log
        	&par1World.getBlock(par2 - 1, par3 - 2, par4) == WinterBlocks.lightsBlock
        	&par1World.getBlock(par2 + 1, par3 - 2, par4) == WinterBlocks.lightsBlock
        	&par1World.getBlock(par2, par3 - 2, par4 - 1) == WinterBlocks.lightsBlock
        	&par1World.getBlock(par2, par3 - 2, par4 + 1) == WinterBlocks.lightsBlock
        	
        	//Layer 3
        	&par1World.getBlock(par2, par3 - 3, par4) == Blocks.log
        	&par1World.getBlock(par2 - 1, par3 - 3, par4) == WinterBlocks.lightsBlock
            &par1World.getBlock(par2 + 1, par3 - 3, par4) == WinterBlocks.lightsBlock
            &par1World.getBlock(par2, par3 - 3, par4 - 1) == WinterBlocks.lightsBlock
            &par1World.getBlock(par2, par3 - 3, par4 + 1) == WinterBlocks.lightsBlock
            &par1World.getBlock(par2 + 1, par3 - 3, par4 - 1) == WinterBlocks.lightsBlock
            &par1World.getBlock(par2 + 1, par3 - 3, par4 + 1) == WinterBlocks.lightsBlock
            &par1World.getBlock(par2 - 1, par3 - 3, par4 - 1) == WinterBlocks.lightsBlock
            &par1World.getBlock(par2 - 1, par3 - 3, par4 + 1) == WinterBlocks.lightsBlock
            
            //Layer 4
        	&par1World.getBlock(par2, par3 - 4, par4) == Blocks.log
        	&((par1World.getBlock(par2 - 1, par3 - 4, par4) == WinterSpecialBlocks.ornament || par1World.getBlock(par2 - 1, par3 - 4, par4) == WinterSpecialBlocks.ornamentRare))
            &((par1World.getBlock(par2 + 1, par3 - 4, par4) == WinterSpecialBlocks.ornament || par1World.getBlock(par2 + 1, par3 - 4, par4) == WinterSpecialBlocks.ornamentRare))
            &((par1World.getBlock(par2, par3 - 4, par4 - 1) == WinterSpecialBlocks.ornament || par1World.getBlock(par2, par3 - 4, par4 - 1) == WinterSpecialBlocks.ornamentRare))
            &((par1World.getBlock(par2, par3 - 4, par4 + 1) == WinterSpecialBlocks.ornament || par1World.getBlock(par2, par3 - 4, par4 + 1) == WinterSpecialBlocks.ornamentRare))
            &((par1World.getBlock(par2 + 1, par3 - 4, par4 - 1) == WinterSpecialBlocks.ornament || par1World.getBlock(par2 + 1, par3 - 4, par4 - 1) == WinterSpecialBlocks.ornamentRare))
            &((par1World.getBlock(par2 + 1, par3 - 4, par4 + 1) == WinterSpecialBlocks.ornament || par1World.getBlock(par2 + 1, par3 - 4, par4 + 1) == WinterSpecialBlocks.ornamentRare))
            &((par1World.getBlock(par2 - 1, par3 - 4, par4 - 1) == WinterSpecialBlocks.ornament || par1World.getBlock(par2 - 1, par3 - 4, par4 - 1) == WinterSpecialBlocks.ornamentRare))
            &((par1World.getBlock(par2 - 1, par3 - 4, par4 + 1) == WinterSpecialBlocks.ornament || par1World.getBlock(par2 - 1, par3 - 4, par4 + 1) == WinterSpecialBlocks.ornamentRare))
        	
            &par1World.getBlock(par2, par3 - 5, par4) == Blocks.log
        	
        	//Layer 6
        	&par1World.getBlock(par2, par3 - 6, par4) == Blocks.wool
        	&par1World.getBlock(par2 - 1, par3 - 6, par4) == Blocks.wool
            &par1World.getBlock(par2 + 1, par3 - 6, par4) == Blocks.wool
            &par1World.getBlock(par2, par3 - 6, par4 - 1) == Blocks.wool
            &par1World.getBlock(par2, par3 - 6, par4 + 1) == Blocks.wool
            &par1World.getBlock(par2 + 1, par3 - 6, par4 - 1) == Blocks.wool
            &par1World.getBlock(par2 + 1, par3 - 6, par4 + 1) == Blocks.wool
            &par1World.getBlock(par2 - 1, par3 - 6, par4 - 1) == Blocks.wool
            &par1World.getBlock(par2 - 1, par3 - 6, par4 + 1) == Blocks.wool
            )
        	
           {
            if (!par1World.isRemote)
            {
                PlayerTickHandler.presentTimer = true;
                for(int i=0;i<PlayerTickHandler.starY.length;i++){
                	if(PlayerTickHandler.starY[i] == 888 && !this.checkStarSpecial(par2, par3, par4)){
		                PlayerTickHandler.starX[i] = par2;
		                PlayerTickHandler.starY[i] = par3;
		                PlayerTickHandler.starZ[i] = par4;
		                par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "wintercraft:star", 1.0F, par1World.rand.nextFloat() * 0.1F + 0.9F);
		                break;
                	}
                }
       	 	  }
            }
        }
	public void breakBlock(World parWorld, int par2, int par3, int par4, Block p_149749_5_, int p_149749_6_)
    {
		if(!parWorld.isRemote){
			for(int i=0;i<PlayerTickHandler.starY.length;i++){
				if(PlayerTickHandler.starY[i] != 888){
					if(PlayerTickHandler.starX[i] == par2 && PlayerTickHandler.starY[i] == par3 && PlayerTickHandler.starZ[i] == par4){
						PlayerTickHandler.starX[i] = 888;
						PlayerTickHandler.starY[i] = 888;
						PlayerTickHandler.starZ[i] = 888;
					}
				}
			}
		}
    }
	
	public void onBlockDestroyedByPlayer(World parWorld, int x, int y, int z, int p_149664_5_) {
		if(!parWorld.isRemote){
			/*if(this.checkStarSpecial(x, y, z)){
				for(int i=0;i<PlayerTickHandler.starY.length;i++){
					if(PlayerTickHandler.starX[i] == x && PlayerTickHandler.starY[i] == y && PlayerTickHandler.starZ[i] == z){
						PlayerTickHandler.starX[i] = 888;
						PlayerTickHandler.starX[i] = 888;
						PlayerTickHandler.starX[i] = 888;
		        	}else{
						System.out.println("Star: " + i + " Not-Reset");
						System.out.println(PlayerTickHandler.starX[i] + " : " + x);
						System.out.println(PlayerTickHandler.starY[i] + " : " + y);
						System.out.println(PlayerTickHandler.starZ[i] + " : " + z);
						break;
					}
		        }
			}*/
		}
	}
	
	public Boolean checkStarSpecial(int x, int y, int z){
		for(int i=0;i<PlayerTickHandler.starY.length;i++){
			if(PlayerTickHandler.starY[i] != 888){
	        	if(PlayerTickHandler.starX[i] == x && PlayerTickHandler.starY[i] == y && PlayerTickHandler.starZ[i] == z){
	        		return true;
	        	}
			}
        }
		return false;
	}

	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
	 	double d0 = (double)par2 + 0.5D;
        double d1 = (double)par3 + 0.6D;
        double d2 = (double)par4 + 0.25D;
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;
	    super.randomDisplayTick(par1World, par2, par3, par4, par5Random);

	    if(PlayerTickHandler.presentTimer == true && this.checkStarSpecial(par2, par3, par4)){
		    for (int l = par2 - 2; l <= par2 + 2; ++l)
		    {
		        for (int i1 = par4 - 2; i1 <= par4 + 2; ++i1)
		        {
		            if (l > par2 - 2 && l < par2 + 2 && i1 == par4 - 1)
		            {
		                i1 = par4 + 2;
		            }
	
		            if (par5Random.nextInt(5) == 0)
		            {
		                for (int j1 = par3; j1 <= par3 + 2; ++j1)
		                {
		                	par1World.spawnParticle("mobSpellAmbient", d0, d1 + d3, d2 + d4, 0.0D, 0.5D, 0.0D);
		                }
                	}
                }
            }
        }
    }
	
	@Override
	protected boolean canPlaceBlockOn(Block par1)
    {
		 return par1 == Blocks.leaves || par1 == WinterBlocks.lightsBlock;
    }
	
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return Items.glowstone_dust;
	}
	
    public int quantityDropped(Random par1Random)
    {
        return par1Random.nextInt(4)+1;
    }
    protected boolean canSilkHarvest()
    {
        return true;
    }
    
    @Override
    public void registerBlockIcons(IIconRegister reg)
    {
    	this.blockIcon = reg.registerIcon("Wintercraft:star");
    }
    
}
