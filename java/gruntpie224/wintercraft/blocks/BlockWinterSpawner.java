package gruntpie224.wintercraft.blocks;

import java.util.Random;

import gruntpie224.wintercraft.Wintercraft;
import net.minecraft.block.BlockMobSpawner;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;



public class BlockWinterSpawner extends BlockMobSpawner
{
	String mobName;

	public BlockWinterSpawner(String mob)
	{
		mobName = mob;
		this.setCreativeTab(Wintercraft.wintercraftTab);
	}
	
	@Override
    public TileEntity createNewTileEntity(World world, int i)
	{
        TileEntityMobSpawner spawner = new TileEntityMobSpawner();
        spawner.getSpawnerBaseLogic().setEntityName(mobName);

        return spawner;
    }
}