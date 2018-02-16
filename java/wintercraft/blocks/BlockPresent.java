package wintercraft.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import wintercraft.Wintercraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPresent extends BlockBaseBlock{
	
	@SideOnly(Side.CLIENT)
	private IIcon iconPresentTop;
	@SideOnly(Side.CLIENT)
	private IIcon iconPresentBottom;
	
	public BlockPresent(Material par2Material) {
		super(par2Material);

	}
	
	public void onBlockHarvested(World par1World, int par2, int par3, int par4, int par5, EntityPlayer par6EntityPlayer) {
		par1World.playSoundAtEntity(par6EntityPlayer, "wintercraft:rip", 1F, 1F);

	}
	

	@Override
	public Item getItemDropped(int metadata, Random r, int fortune){
	Item d = null;
	int randomItem, randomDrop;
	randomDrop = r.nextInt(99);
	randomItem = r.nextInt(20);
	System.out.println(randomDrop);
	System.out.println(randomItem);
	
	 if(randomDrop<=40 && randomDrop>=21){
		if (randomItem == 20){
			d=Items.diamond;
		}
		else if (randomItem == 19){
			d=Items.golden_apple;
		}
		else if (randomItem == 18){
			d=Items.emerald;
		}
		else if (randomItem == 17){
			d=Items.diamond_pickaxe;
		}
		else if (randomItem == 16){
			d=Items.diamond_shovel;
		}
		else if (randomItem == 15){
			d=Items.diamond_sword;
		}
		else if (randomItem == 14){
			d=Items.diamond_hoe;
		}
		else if (randomItem == 13){
			d=Items.nether_star;
		}
		else if (randomItem == 12){
			d=Items.ender_eye;
		}
		else if (randomItem == 11){
			d=Items.diamond_horse_armor;
		}
		else if (randomItem == 10){
			d=Items.name_tag;
		}
		else if (randomItem == 9){
			d=Items.tnt_minecart;
		}
		else if (randomItem == 8){
			d=Items.iron_door;
		}
		else if (randomItem == 7){
			d=Item.getItemFromBlock(Blocks.obsidian);
		}
		else if (randomItem == 6){
			d=Items.pumpkin_pie;
		}
		else if (randomItem == 5){
			d=Items.experience_bottle;
		}
		else if (randomItem == 4){
			d=Items.diamond_helmet;
		}
		else if (randomItem == 3){
			d=Items.diamond_chestplate;
		}
		else if (randomItem == 2){
			d=Items.diamond_leggings;
		}
		else if (randomItem == 1){
			d=Items.diamond_boots;
		}
		else if (randomItem == 0){
			d=Items.milk_bucket;
		}
		
	}else if(randomDrop<=100 && randomDrop>=41){
		if (randomItem == 20){
			d=Items.gold_ingot;
		}
		else if (randomItem == 19){
			d=Items.iron_ingot;
		}
		else if (randomItem == 18) {
			d=Items.blaze_rod;
		}
		else if (randomItem == 17) {
			d=Items.minecart;
		}
		else if (randomItem == 16) {
			d=Items.iron_horse_armor;
		}
		else if (randomItem == 15) {
			d=Items.ender_pearl;
		}
		else if (randomItem == 14) {
			d=Item.getItemFromBlock(Blocks.melon_block);
		}
		else if (randomItem == 13) {
			d=Items.cake;
		}
		else if (randomItem == 12) {
			d=Items.iron_helmet;
		}
		else if (randomItem == 11) {
			d=Items.iron_chestplate;
		}
		else if (randomItem == 10) {
			d=Items.iron_leggings;
		}
		else if (randomItem == 9) {
			d=Items.iron_boots;
		}
		else if (randomItem == 8) {
			d=Items.iron_pickaxe;
		}
		else if (randomItem == 7) {
			d=Items.iron_shovel;
		}
		else if (randomItem == 6) {
			d=Items.lead;
		}
		else if (randomItem == 5) {
			d=Items.iron_axe;
		}
		else if (randomItem == 4) {
			d=Items.clock;
		}
		else if (randomItem == 3) {
			d=Items.shears;
		}
		else if (randomItem == 2) {
			d=Items.flint_and_steel;
		}
		else if (randomItem == 1) {
			d=Items.flower_pot;
		}
		else if (randomItem == 0) {
			d=Items.carrot_on_a_stick;
		}
		
		
	}else if(randomDrop<=20 && randomDrop>=0){
		if (randomItem == 20){
			d=Items.stick;
		}
		else if (randomItem == 19){
			d=Item.getItemFromBlock(Blocks.log);
		}
		else if (randomItem == 18){
			d=Items.wooden_pickaxe;
		}
		else if (randomItem == 17){
			d=Items.arrow;
		}
		else if (randomItem == 16){
			d=Items.coal;
		}
		else if (randomItem == 15){
			d=Items.dye;
		}
		else if (randomItem == 14){
			d=Items.feather;
		}
		else if (randomItem == 13){
			d=Item.getItemFromBlock(Blocks.torch);
		}
		else if (randomItem == 12){
			d=Items.sign;
		}
		else if (randomItem == 11){
			d=Item.getItemFromBlock(Blocks.glass);
		}
		else if (randomItem == 10){
			d=Item.getItemFromBlock(Blocks.pumpkin);
		}
		else if (randomItem == 9){
			d=Items.apple;
		}
		else if (randomItem == 8){
			d=Items.leather_leggings;
		}
		else if (randomItem == 7){
			d=Items.leather_helmet;
		}
		else if (randomItem == 6){
			d=Items.leather_boots;
		}
		else if (randomItem == 5){
			d=Items.leather_chestplate;
		}
		else if (randomItem == 4){
			d=Items.wheat;
		}
		else if (randomItem == 3){
			d=Items.sugar;
		}
		else if (randomItem == 2){
			d=Items.wooden_hoe;
		}
		else if (randomItem == 1){
			d=Items.gunpowder;
		}
		else if (randomItem == 0){
			d=Items.fish;
		}
	}else{
	d=null;
	}
	return d;
	}

	@SideOnly(Side.CLIENT)

	/**
	* From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	*/
	public IIcon getIcon(int par1, int par2)
	{
	return par1 == 1 ? this.iconPresentTop : (par1 == 0 ? this.iconPresentBottom : this.blockIcon);
	}
	
	public IIcon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
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

	/**
	* When this method is called, your block should register all the icons it needs with the given IconRegister. This
	* is the only chance you get to register icons.
	*/
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
	  
	//Trying Something making it easier to make dirt blocks
	this.blockIcon = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5) + "_side");
	this.iconPresentTop = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5) + "_top");
	this.iconPresentBottom = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5) + "_side");
	}
	
	 protected boolean canSilkHarvest()
    {
        return true;
    }

}
