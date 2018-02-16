package wintercraft.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import wintercraft.Wintercraft;
import wintercraft.helper.achievements.WinterAch;
import wintercraft.render.tileEntity.TileEntitySnowGlobe;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;

public class BlockSnowGlobeBlock extends BlockContainer{

	int tick = 0;
	private boolean isCorrupt; 
	
	protected BlockSnowGlobeBlock(Material p_i45386_1_,boolean corrupt) {
		super(p_i45386_1_);	
		float f = 0.5F;
		this.setBlockBounds(0.25F, 0, 0.25F, 0.75F, 0.5F, 0.75F);
		this.isCorrupt = corrupt;
	}
	
	@Override
	public boolean onBlockActivated(World par2World, int par2, int par3, int par4, EntityPlayer par3EntityPlayer, int par6, float par7, float par8, float par9)
	{
		if(!isCorrupt){
			if (!par2World.isRaining() && !par3EntityPlayer.worldObj.isRemote && tick <= 0){
				WorldServer worldserver = MinecraftServer.getServer().worldServers[0];
				WorldInfo worldinfo = worldserver.getWorldInfo();
				
				worldinfo.setRaining(true);
				par2World.playSoundAtEntity(par3EntityPlayer, "wintercraft:snowGlobe", 0.5F, 0.8F);
				par2World.addWeatherEffect(new EntityLightningBolt(par2World, par3EntityPlayer.posX + 20, par3EntityPlayer.posY + 70, par3EntityPlayer.posZ));
				par2World.addWeatherEffect(new EntityLightningBolt(par2World, par3EntityPlayer.posX - 20, par3EntityPlayer.posY + 70, par3EntityPlayer.posZ));
				par2World.addWeatherEffect(new EntityLightningBolt(par2World, par3EntityPlayer.posX, par3EntityPlayer.posY + 70, par3EntityPlayer.posZ + 20));
				par2World.addWeatherEffect(new EntityLightningBolt(par2World, par3EntityPlayer.posX, par3EntityPlayer.posY + 70, par3EntityPlayer.posZ - 20));
				par3EntityPlayer.addStat(WinterAch.snowGlobe, 1);
				par3EntityPlayer.addChatMessage(new ChatComponentText("\u00a7o\u00a78The clouds darken..."));
				tick = 3;
			}else{
				if(!par3EntityPlayer.worldObj.isRemote){
					par2World.playSoundAtEntity(par3EntityPlayer, "wintercraft:snowGlobeTap", 1.5F, 0.8F);
					par3EntityPlayer.addChatMessage(new ChatComponentText("It is already snowing/raining..."));
				}
			}
	   
		}else{
			if(!par3EntityPlayer.worldObj.isRemote){
				for(int i=0;i<4;i++){
					par2World.addWeatherEffect(new EntityLightningBolt(par2World, par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ));
				}
				par2World.setBlock(par2, par3, par4, Blocks.air);
				float f = 3.0F;
				par2World.createExplosion(par3EntityPlayer, (double)par2, (double)par3, (double)par4, f, true);
				par3EntityPlayer.addStat(WinterAch.snowGlobeBad, 1);
			}
		}
		return true;
	}
	
	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		
		 double d0 = (double)par2 + 0.6D;
	        double d1 = (double)par3 + 0.3D;
	        double d2 = (double)par4 + 0.325D;
	        double d3 = 0.0199999988079071D;
	        double d4 = 0.27000001072883606D;
	    super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
	
	    if(tick > 0){
			tick--;
		}
	    
	    for (int l = par2 - 2; l <= par2 + 2; ++l)
	    {
	        for (int i1 = par4 - 2; i1 <= par4 + 2; ++i1)
	        {
	            if (l > par2 - 2 && l < par2 + 2 && i1 == par4 - 1)
	            {
	                i1 = par4 + 2;
	            }
	
	            if (par5Random.nextInt(30) == 0 && par1World.isRaining())
	            {
	                for (int j1 = par3; j1 <= par3 + 1; ++j1)
	                {
	                		par1World.spawnParticle("snowshovel", d0 - (par5Random.nextInt(8) / 10) - 0.1D, d1 + d3, d2 + d4- (par5Random.nextInt(8) / 10) - 0.1D, 0.0D, 0.0D, 0.0D);
	                	}
	                }
	            }
	        }
	    }

	/**
	* The type of render function that is called for this block
	*/
	public int getRenderType()
	{
	return -2;
	}
	
	/**
	* Is this block (a) opaque and (B) a full 1m cube? This determines whether or not to render the shared face of two
	* adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	*/
	public boolean isOpaqueCube()
	{
	return false;
	}
	
	/**
	 * 
	* If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	*/
	public boolean renderAsNormalBlock()
	{
	return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntitySnowGlobe();
	}
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5));
    }

}
