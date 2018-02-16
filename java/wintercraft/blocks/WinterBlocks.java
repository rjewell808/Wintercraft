package wintercraft.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import wintercraft.Wintercraft;
import wintercraft.helper.tileEntity.TileEntityGift;
import wintercraft.items.ItemSnowSlab;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class WinterBlocks {
	
	
	public static Block snowBrick;
	public static Block singleSnowSlab;
	public static Block doubleSnowSlab;
	public static Block snowStairs;
	public static Block star;
	public static Block fruitCakeBricks;
	public static Block freezer;
	public static Block freezerActive;
	public static Block present;
	public static Block christmasPresent;
	public static Block wreath;
	public static Block winterIce;
	public static Block lightsBlock;
	public static Block miniGolemSpawner;
	public static Block icedStone;
	public static Block stocking;
	public static Block stockingFull;
	public static Block gift;
	public static Block snowManHead;
	public static Block magicSnow;
	public static Block calendar;
	public static Block candyCaneBlock;
	public static Block adventCalendar;
	public static Block darkPresent;
	public static Block snowGlobeBlock;
	public static Block fireplace;
	public static Block fireplaceActive;
	public static Block icedCobble;
	public static Block corruptSnowGlobeBlock;
	
	public static void Init(FMLPreInitializationEvent event){
		
	star = new BlockStar(Material.glass).setHardness(0.8F).setStepSound(Block.soundTypeGlass).setBlockName("star");	
	winterIce = new BlockWinterIce().setHardness(0.5F).setLightOpacity(3).setStepSound(Block.soundTypeGlass).setBlockName("winterIce");	
	icedStone = new BlockBaseBlock(Material.rock).setHardness(1.3F).setStepSound(Block.soundTypeStone).setBlockName("icedStone");
	snowBrick = new BlockBaseBlock(Material.rock).setHardness(1.3F).setStepSound(Block.soundTypeSnow).setBlockName("snowBricks");
	snowStairs = new BlockSnowStairs(Blocks.snow, 0).setHardness(0.5F).setBlockName("snowStairs");	
	magicSnow = new BlockBaseBlock(Material.ground).setHardness(1.3F).setStepSound(Block.soundTypeSnow).setBlockName("magicSnow");
	fruitCakeBricks = new BlockBaseBlock(Material.rock).setHardness(2.5F).setStepSound(Block.soundTypeStone).setBlockName("fruitCakeBricks");	
	lightsBlock = new BlockLightsBlock(Material.leaves).setHardness(0.6F).setLightLevel(0.7F).setStepSound(Block.soundTypeGrass).setBlockName("lightsBlock");
	freezer = new BlockFreezer(false).setHardness(3.0F).setStepSound(Block.soundTypeGlass).setCreativeTab(Wintercraft.WintercraftTab).setBlockName("freezer");
	freezerActive = new BlockFreezer(true).setHardness(3.0F).setLightLevel(0.8F).setStepSound(Block.soundTypeGlass).setBlockName("freezer");
	wreath = new BlockWreath().setHardness(0.3F).setStepSound(Block.soundTypeGrass).setBlockName("wreath").setBlockTextureName("wreath");
	stocking = new BlockStocking(false).setHardness(0.2F).setStepSound(Block.soundTypeCloth).setBlockName("stocking").setBlockTextureName("stocking");	
	stockingFull = new BlockStocking(true).setHardness(0.2F).setStepSound(Block.soundTypeCloth).setBlockName("stockingFull").setBlockTextureName("stockingFull");	
	snowManHead = new BlockSnowManHead(1, Material.ground).setHardness(0.2F).setStepSound(Block.soundTypeSnow).setBlockName("snowManHead");
	miniGolemSpawner = new BlockWinterSpawner("MiniSnowGolem").setHardness(5.5F).setStepSound(Block.soundTypeMetal).setBlockName("winterSpawner");						
	gift = new BlockGift(Material.cloth).setHardness(0.2F).setStepSound(Block.soundTypeCloth).setBlockName("gift");	
	singleSnowSlab = new BlockSnowSlab(false).setHardness(0.5F).setResistance(7.5F).setStepSound(Block.soundTypeSnow).setBlockName("snowSlabDouble").setCreativeTab(Wintercraft.WintercraftTab);		
	doubleSnowSlab = new BlockSnowSlab(true).setHardness(0.6F).setResistance(7.5F).setStepSound(Block.soundTypeSnow).setBlockName("snowSlabSingle");
	calendar = new BlockCalendar().setHardness(0.3F).setStepSound(Block.soundTypeGrass).setBlockName("calendar").setBlockTextureName("calendarcalendar");
	candyCaneBlock = new BlockCandyCaneBlock().setHardness(1.5F).setStepSound(Block.soundTypeGlass).setBlockName("candyCaneBlock").setCreativeTab(Wintercraft.WintercraftTab);
	adventCalendar = new BlockAdventCalendar().setHardness(0.3F).setStepSound(Block.soundTypeGrass).setBlockName("adventCalendar");
	darkPresent = new BlockDarkPresent(Material.cloth).setHardness(0.2F).setStepSound(Block.soundTypeCloth).setBlockName("darkPresent");
	snowGlobeBlock = new BlockSnowGlobeBlock(Material.glass,false).setHardness(0.5F).setStepSound(Block.soundTypeGlass).setBlockName("snowGlobeBlock").setCreativeTab(Wintercraft.WintercraftTab);;
	corruptSnowGlobeBlock = new BlockSnowGlobeBlock(Material.glass,true).setHardness(0.5F).setStepSound(Block.soundTypeGlass).setBlockName("snowGlobeBlock");
	fireplace = new BlockFirePlace(Material.wood,false).setHardness(3.0F).setStepSound(Block.soundTypeWood).setBlockName("fireplace").setCreativeTab(Wintercraft.WintercraftTab);
	fireplaceActive = new BlockFirePlace(Material.wood,true).setHardness(3.0F).setLightLevel(1.0F).setStepSound(Block.soundTypeWood).setBlockName("fireplace");
	icedCobble = new BlockBaseBlock(Material.rock).setHardness(1.1F).setStepSound(Block.soundTypeStone).setBlockName("icedCobble");
	christmasPresent = new BlockChristmasPresent(Material.cloth).setHardness(0.2F).setStepSound(Block.soundTypeCloth).setBlockName("christmasPresent");
	present = new BlockPresent(Material.cloth).setHardness(0.2F).setStepSound(Block.soundTypeCloth).setBlockName("present");
	
	GameRegistry.registerBlock(star, "star");
	GameRegistry.registerBlock(christmasPresent, "christmasPresent");
	GameRegistry.registerBlock(present, "present");
	GameRegistry.registerBlock(gift, "gift");
	GameRegistry.registerBlock(darkPresent, "darkPresent");
	GameRegistry.registerBlock(winterIce, "winterIce");
	GameRegistry.registerBlock(icedStone, "icedStone");
	GameRegistry.registerBlock(icedCobble, "icedCobble");
	//GameRegistry.registerBlock(magicSnow, "magicSnow");
	GameRegistry.registerBlock(candyCaneBlock, "candyCaneBlock");
	GameRegistry.registerBlock(fruitCakeBricks, "fruitCakeBricks");
	GameRegistry.registerBlock(snowBrick, "snowBrick");
	GameRegistry.registerBlock(snowStairs, "snowStairs");
	GameRegistry.registerBlock(singleSnowSlab, ItemSnowSlab.class, "singleSnowSlab");
	GameRegistry.registerBlock(doubleSnowSlab, ItemSnowSlab.class, "doubleSnowSlab");
	//GameRegistry.registerBlock(magicFire, "magicFire");
	//GameRegistry.registerBlock(magicPortal, "magicPortal");
	GameRegistry.registerBlock(lightsBlock, "lightsBlock");
	GameRegistry.registerBlock(freezer,"freezer");
	GameRegistry.registerBlock(freezerActive, "freezerActive");
	GameRegistry.registerBlock(wreath, "wreath");
	GameRegistry.registerBlock(stocking, "stocking");
	GameRegistry.registerBlock(stockingFull, "stockingFull");
	GameRegistry.registerBlock(calendar, "calendar");
	GameRegistry.registerBlock(adventCalendar, "adventCalendar");
	GameRegistry.registerBlock(snowManHead, "snowManHead");
	GameRegistry.registerBlock(miniGolemSpawner, "miniGolemSpawner");
	GameRegistry.registerBlock(snowGlobeBlock, "snowGlobeBlock");
	GameRegistry.registerBlock(corruptSnowGlobeBlock, "corruptSnowGlobeBlock");
	GameRegistry.registerBlock(fireplace, "fireplace");
	GameRegistry.registerBlock(fireplaceActive, "fireplaceActive");
	
	GameRegistry.registerTileEntity(TileEntityGift.class, "stringID");
	
				
	}
	
	
}

