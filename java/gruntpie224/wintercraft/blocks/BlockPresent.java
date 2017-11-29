package gruntpie224.wintercraft.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPresent extends BlockBaseBlock{
	
	public BlockPresent(Material par2Material) {
		super(par2Material);

	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		worldIn.playSoundAtEntity(player, "wc:rip", 1F, 1F);
	}	

	@Override
	public Item getItemDropped(IBlockState state, Random r, int fortune)
	{
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
	
	protected boolean canSilkHarvest()
    {
        return true;
    }

}
