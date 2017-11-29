package gruntpie224.wintercraft.init;

import gruntpie224.wintercraft.WintercraftReference;
import gruntpie224.wintercraft.blocks.BlockCandle;
import gruntpie224.wintercraft.blocks.BlockDecorDoor;
import gruntpie224.wintercraft.blocks.BlockFruitCake;
import gruntpie224.wintercraft.blocks.BlockOrnament;
import gruntpie224.wintercraft.blocks.BlockOrnamentRare;
import gruntpie224.wintercraft.blocks.BlockWallLights;
import gruntpie224.wintercraft.blocks.ItemCandleBlock;
import gruntpie224.wintercraft.blocks.ItemOrnamentBlock;
import gruntpie224.wintercraft.blocks.ItemOrnamentRareBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WinterSpecialBlocks {

	public static Block candle;
	public static Block decor_door_block;
	public static Block ornament;
	public static Block ornament_rare;
	public static Block lights_wall;
	public static Block fruit_cake_block;
	
	public static void Init(){
		
		candle = new BlockCandle(1, Material.gourd).setHardness(0.4F).setStepSound(Block.soundTypeStone).setUnlocalizedName("candle_block");
		ornament = new BlockOrnament(1, Material.glass).setHardness(0.2F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("ornament_item");
		ornament_rare = new BlockOrnamentRare(1, Material.glass).setHardness(0.2F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("ornament_rare");
		decor_door_block = new BlockDecorDoor(Material.wood).setHardness(3.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("decor_door_block");
		lights_wall = new BlockWallLights().setHardness(0.3F).setLightLevel(0.7F).setStepSound(Block.soundTypeCloth).setUnlocalizedName("lights_wall");
		fruit_cake_block = new BlockFruitCake().setHardness(0.5F).setStepSound(Block.soundTypeCloth).setUnlocalizedName("fruit_cake_block");
		
		GameRegistry.registerBlock(decor_door_block, "decor_door_block");
		GameRegistry.registerBlock(ornament, ItemOrnamentBlock.class, "ornament_block");
		GameRegistry.registerBlock(ornament_rare, ItemOrnamentRareBlock.class, "ornament_block_rare");
		GameRegistry.registerBlock(candle, ItemCandleBlock.class, "candle_block");
		GameRegistry.registerBlock(lights_wall, "lights_wall");
		GameRegistry.registerBlock(fruit_cake_block, "fruit_cake_block");		
	}	
	
	public static void registerRenders()
	{
		registerRender(candle);
		registerRender(ornament_rare);
		registerRender(ornament);
		registerRender(lights_wall);
		registerRender(decor_door_block);
		registerRender(fruit_cake_block);
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(WintercraftReference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
