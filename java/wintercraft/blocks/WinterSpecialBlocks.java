package wintercraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class WinterSpecialBlocks {

	public static Block candle;
	public static Block decorDoor;
	public static Block ornament;
	public static Block ornamentRare;
	public static Block lightsBlockWall;
	public static Block fruitCake;
	
	public static void Init(FMLPreInitializationEvent event){
		candle = new BlockCandle(1, Material.cloth).setHardness(0.4F).setStepSound(Block.soundTypeCloth).setBlockName("candleItem");
		ornament = new BlockOrnament(1, Material.glass).setHardness(0.2F).setStepSound(Block.soundTypeGlass).setBlockName("ornamentItem").setBlockTextureName("ornamentItem");
		ornamentRare = new BlockOrnamentRare(1, Material.glass).setHardness(0.2F).setStepSound(Block.soundTypeGlass).setBlockName("ornamentRareItem").setBlockTextureName("ornamentRareItem");
		decorDoor = new BlockDecorDoor(Material.wood).setHardness(3.0F).setStepSound(Block.soundTypeWood).setBlockName("decorDoor");
		lightsBlockWall = new BlockWallLights().setHardness(0.3F).setLightLevel(0.7F).setStepSound(Block.soundTypeCloth).setBlockName("wallLights").setBlockTextureName("wallLights");
		fruitCake = new BlockFruitCake().setHardness(0.5F).setStepSound(Block.soundTypeCloth).setBlockName("fruitCake");
		
		GameRegistry.registerBlock(decorDoor, "decorDoor");
		GameRegistry.registerBlock(ornament, ItemOrnamentBlock.class, "ornamentBlock");
		GameRegistry.registerBlock(ornamentRare, ItemOrnamentRareBlock.class, "ornamentRareBlock");
		GameRegistry.registerBlock(candle, ItemCandleBlock.class, "candle");
		GameRegistry.registerBlock(lightsBlockWall, "lightsBlockWall");
		GameRegistry.registerBlock(fruitCake, "fruitCake");
	}	
}
