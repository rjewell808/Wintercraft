package gruntpie224.wintercraft.blocks;

import java.util.Random;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.helper.achievements.WinterAch;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSnowGlobeBlock extends BlockBaseBlock{

	private int tick = 0;
	private boolean isCorrupt; 
	
	public BlockSnowGlobeBlock(Material material,boolean corrupt) 
	{
		super(material);	
		float f = 0.5F;
		this.setBlockBounds(0.15F, 0, 0.15F, 0.85F, 0.75F, 0.85F);
		this.isCorrupt = corrupt;
		if(corrupt) this.setCreativeTab(null);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		/*
		if(!par2World.isRemote){
			System.out.println("Tick:" + tick);
			System.out.println("Server:" + !par2World.isRemote);
			System.out.println("Rain:" + !par2World.isRaining());
			
			WorldServer worldserver = MinecraftServer.getServer().worldServers[0];
	        WorldInfo worldinfo = worldserver.getWorldInfo();
			
	        
	        int i = (300 + (new Random()).nextInt(600)) * 20;
	        
	        worldinfo.setRainTime(i);
	        worldinfo.setRaining(true);
	        worldinfo.setThundering(false);
		}
		*/
		
		if(!worldIn.isRemote){
			WorldServer worldserver = MinecraftServer.getServer().worldServers[0];
	        WorldInfo worldinfo = worldserver.getWorldInfo();		
			
			if(!isCorrupt){
				if (!worldinfo.isRaining()){
					
					int i = (300 + (new Random()).nextInt(600)) * 20;
					
					worldinfo.setRainTime(i);
			        worldinfo.setRaining(true);
			        worldinfo.setThundering(false);
			        
			        worldIn.playSoundAtEntity(playerIn, "wc:snowGlobe", 0.5F, 0.8F);
					worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, playerIn.posX + 20, playerIn.posY + 70, playerIn.posZ));
					worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, playerIn.posX - 20, playerIn.posY + 70, playerIn.posZ));
					worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, playerIn.posX, playerIn.posY + 70, playerIn.posZ + 20));
					worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, playerIn.posX, playerIn.posY + 70, playerIn.posZ - 20));
					playerIn.addStat(WinterAch.snowGlobe, 1);
					playerIn.addChatMessage(new ChatComponentText("\u00a7o\u00a78The clouds darken..."));
					tick = 3;
				}else{
					worldIn.playSoundAtEntity(playerIn, "wc:snowGlobeTap", 1.5F, 0.8F);
					playerIn.addChatMessage(new ChatComponentText("It is already snowing/raining..."));
				}
		   
			}else{
				for(int i=0;i<4;i++){
					worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ));
				}
				worldIn.setBlockToAir(pos);
				float f = 3.0F;
				worldIn.createExplosion(playerIn, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), f, true);
				playerIn.addStat(WinterAch.snowGlobeBad, 1);
			}
		}
		return true;
	}
	
	@Override
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		
		 double d0 = (double)pos.getX() + 0.6D;
	        double d1 = (double)pos.getY() + 0.4D;
	        double d2 = (double)pos.getZ() + 0.325D;
	        double d3 = 0.0199999988079071D;
	        double d4 = 0.27000001072883606D;
	    super.randomDisplayTick(worldIn, pos, state, rand);
	
	    if(tick > 0){
			tick--;
		}
	    
	    for (int l = pos.getX() - 2; l <= pos.getX() + 2; ++l)
	    {
	        for (int i1 = pos.getZ() - 2; i1 <= pos.getZ() + 2; ++i1)
	        {
	            if (l > pos.getX() - 2 && l < pos.getX() + 2 && i1 == pos.getZ() - 1)
	            {
	                i1 = pos.getZ() + 2;
	            }
	
	            if (rand.nextInt(30) == 0 && worldIn.isRaining())
	            {
	                for (int j1 = pos.getY(); j1 <= pos.getY() + 1; ++j1)
	                {
	                		worldIn.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, d0 - (rand.nextInt(8) / 10) - 0.1D, d1, d2 + d4- (rand.nextInt(8) / 10) - 0.1D, 0.0D, 0.0D, 0.0D, new int[0]);                     
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
		return 3;
	}
	
	@SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
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
}
