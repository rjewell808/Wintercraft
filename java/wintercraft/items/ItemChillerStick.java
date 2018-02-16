package wintercraft.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import wintercraft.blocks.WinterBlocks;

public class ItemChillerStick extends ItemBaseItem{

	public ItemChillerStick() {
		super();
		this.maxStackSize = 1;
		this.bFull3D = true;
		setMaxDamage(64);
		}
	
	
		public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
		
		{
			Block i2 = par3World.getBlock(par4, par5, par6);
			if (par7 == 0)
		{
				par5--;
		}
			if (par7 == 1)
		{
				par5++;
		}
			if (par7 == 2)
		{
				par6--;
		}
			if (par7 == 3)
		{
				par6++;
		}
			if (par7 == 4)
		{
				par4--;
		}
			if (par7 == 5)
		{
				par4++;
		}
			if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
		{
				return false;
		}
			Block i1 = par3World.getBlock(par4, par5, par6);
			if (i1 == Blocks.air && i2 == WinterBlocks.magicSnow)
		{
				par3World.playSoundEffect(par4 + 0.5D, par5 + 0.5D, par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
				par3World.setBlock(par4, par5, par6, Blocks.fire);
				par1ItemStack.damageItem(1, par2EntityPlayer);
		}
			else if(!par2EntityPlayer.worldObj.isRemote){
				
				par2EntityPlayer.addChatMessage(new ChatComponentText("Try on Magic Snow..."));
			}
			return true;
		}
		}