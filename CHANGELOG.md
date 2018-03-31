# Changelog

## [Wintercraft-2.0.0] - UNRELEASED
For MC 1.12.2

### Changed
- Updated to 1.12.2
- Increased Candle brightness
- Candle textures are based on Concrete Powder colors
- Candle particles altered
- Increased Fruit Cake strength potion duration
- Increased Ice Shard droprate from Ice
- Ice Shards/Ice Chunks can be used as fuel in Freezer
- Iced Cobble/Iced Stone resemble properties of Cobble/Stone more
- Went to traditional config system
  - Found at config/wintercraft.cfg
- Always snowing option simplified
  - Either it's on or off, no time based system anymore
  
### Fixed
- Ornament bounding box
- Candle bounding box
- Snow Stairs drop when broken in Creative mode
- Can't change config settings for a server

### Removed
- Wintercraft Polar Bears for Vanilla Polar Bears

## [Wintercraft-1.1.4.2] - 2016-11-28
For MC 1.8.9 / 1.8
### Changed
- Updated to 1.8.9

### Fixed
- Freezer cannot be opened
- Wintercraft logo not showing up in Mods section

## [Wintercraft-1.1.4.1] - 2016-11-23
For MC 1.8
### Fixed
- Server crash on startup

## [Wintercraft-1.1.4] - 2016-11-23
For MC 1.8
### Added
- Forge's in-game config editor

### Changed
- Updated to 1.8
- General code optimization
- Hot Chocolate model now renders like a normal item
- Clicking on leaves with Christmas Lights won't drop the lights anymore
- Freezer block is now transparent
- Fireplace model updated
- Various Ornament textures changes
- Ornament achievement can also be gained by picking up one as well as crafting one
- Christmas trees were limited to only 10 but can supoprt as many as you'd like
- Gingerbread Man drop rate altered
- Gingerbread Man rare music disk drop has been changed to 1.5% and must be at night
- Mini Snow Golem rare music disk drop has been changed to 1.5% and must be at night
- You can now craft every colored candle the same way
- Lowered Freezer, Snow Stairs, and Fireplace's hardness a bit
- Snow Stairs can be broken with shovels now
- Balanced Wintercraft Food satutation

### Fixed
- Graphics issue when placing leaves with Christmas Lights next to each other
- Rare and normal Ornament Achievements couldn't be obtained with anything other than Red/Creeper Ornaments
- Candles sound like wool
- Breaking Snow Stairs doesn't return the item

## [Wintercraft-1.1.3] - 2015-08-31
For MC 1.7.10
### Fixed
- Death by Albino Reindeer shows code name
- Multiple doors are dropped when breaking top section of the door
- Snow Globe only works once per server until they restart

## [Wintercraft-1.1.2] - 2014-12-21
For MC 1.7.10 / 1.7.2
### Added
- Config options to enable hostile, neutral, and peaceful mobs
- Setting up a Christmas tree tips
- Description for Antlers

### Changed
- Polar Bear bounding box is now smaller
- Candy Cane Sword item description
- Christmas Cookie no longer has a colored name

### Fixed
- You can't search for the Christmas Cookie in creative mode
- There can only be 1 Christmas tree in a world at a time (Up to 10 trees now!)
- Dark Presents will spam the console when spawned/broken (Fixed for real this time)
- Game crash when placing Fruit Cake

## [Wintercraft-1.1.1] - 2014-12-13
For MC 1.7.10 / 1.7.2

### Added
- Crating recipe to receive Candy Canes from Candy Cane Logs
- "Naughty Weather!" and "Cold Topic!" achievements
- Config options to change the spawn rate of Igloos, Candy Canes, and Elf Houses
- Special gold Santa Hat texture for Team Members and Beta Testers
  - Can be disabled in the config
- Config option to enable Auto Mob IDs or using custom IDs
- Furance recipes to melt Iced Cobble and Iced Stone
- Tips System for people who may be confused on certain mechanics
  - Can be disabled in the config
### Changes
- General code optimization
- Marshmallow texture
- Iron stick recipe gives 6 now
- Rocky Snowball recipe
- Wintercraft acievement layout
- Star particles to only appear on the tree that will spawn the presents
- Santa Hat model texture
- Elf House spawn rate is higher
- Certain Freezer fuels will last longer
- Present/Christmas Present item drops
- Wintercraft entity IDs to be automatically assigned to any open ID

### Fixed
- Chiller Stick recipe still exists
- Dying Candles doesn't consume dye that was used
- Candle block isn't centered
- Taking lights off of leaves can crash the game if you restart the world
- Santa is placing presents at a previous Christmas tree location
- Bad Ice Staff explosion causes invisible blocks
- Marshmallow spelling
- Santa Hat model has a jagged line and out of place segment
- Snow Globe doesn't work after using it once
- Dark Presents spam console when spawned/broken
- Wall Lights Block name showing up as tile.wallLights.name
- Snow Man's name showing up as entity.UsefulSnowMan.name
- Snow Man Head bounding box is too small
- No recipes for Refined Ice and Crystal ARmor

### Removed
- Unnecessary textures

## [Wintercraft-1.1.0] - 2014-11-29
## Added
- Albino Reindeer mob
- Elf House structure
- Giant Candy Cane structure
- Cane Cane Log
- Gift Box
  - Trade with your friends by giving them gifts!
  - Now finished!
- Iced Cobble
- Fireplace
- Advent Calendar
- Christmas Countdown Calendar
- Empty Stocking Decor
  - Added a recipe to get Full Stocking Decor
- Rare mob ornaments
- 16 more ornaments
  - New colors!
- Ice Skates
- Antlers and Antlers Hat
- Raw / Cooked Venison
- Candy Cane Axe
- Config option to toggle Wintercraft structure coordinates in console
- Config to change Wintercraft Mob IDs
  - Helps when Wintercraft is conflicting with other mods
- Mini Snow Golem belly animation
- "The Star on Top", "Special Decor" achievements
- Model / particles for Snow Globe
- Santa sound effect
- Anvil repair ability to Chiseled, Refined, and Crystal Ice Tools
- Particle effect to Star when it's active
- Another Rocky Snowball recipe with gravel
- Candle & Ornament items to place instead of placing the block directly
  - Like how Sugar Cane works
  - Makes things easier code-wise
- Candles to Creative tabs as they weren't getting noticed
- Cocoa Beans frop to Gingerbread Man

## Changed
- Updated to 1.7.10 / 1.7.2
- Updated many textures
- Freezer fuels include Wintercraft Ice and Packed Ice now
- Ice Staff also gives Mining Fatigue effect
- Wintercraft mobs spawn in the newer biomes
- Snow Slabs are more like Snow
- Star drops glowstone when broken
- Chiseld Ice tool set recipe to also accept Iced Cobble
- Snow Brick recipe to give 4 bricks
- Ornaments so that they will fall if the block above them is removed
- Getting Lights from Spruce Light Blocks to be more visible when they come off
- Light Block so they drop when punched
- Putting Lights on leaves will turn it to a Spruce Light Block
  - When removed, the leaves will return to original state
- Ice recipe to give 2 Ice Blocks
- Mini Snow Golem spawn rate is higher
- Penguin sounds to be quieter
- Reindeer spawn rate is lower
- Snow Slab texture
- Freezer freeze tiem takes longer
- Freezer takes new blocks as input
- Icecream effects to last for 45 effects
- Snow Man Head recipe
- Stocking recipe to give 4
- Candle recipe to give 3
- Wreath recipe
- Presents from Santa spawn under the tree instead of put in player inventory
- Snow Globe is a block now
- Candy Cane hunger to fill 1.5
- Wintercraft creative tab icon
- Reindeer drop Venison
- Snow Globe texture
- Crystal Ice Sword / Axe recipe to normal sword / axe recipe
- Candles are less bright
- Candy Cane Sword takes more durability when used for Candy Canes
- "Christmas",  "Snow Globe", "Ice Staff", "Ice Staff Bad" achievements
- Hardness of lights when on walls
- Sound when placing lights
- Names of some items / blocks
- Ornaments now use metadata
- Ice drops 0 - 2 Ice Shards when broken

## Fixed
- Freezer gets messed up with Optifine installed
- Polar Bear hitboxes are too large
- Snow Stairs have weird lighting
- Santa event restarts even if he didn't visit
- Santa Armor leaves the bonus effect on even when taking the armor off
- Igloo spawns 1 block too high
- Shift-clicking on Freezer doesn't work
- Refined-Ice / Crystal Armor don't have textures
- "Bad Staff" achievement trigger doesn't work
- Snow Man Head doesn't face the player when placed
- Freezer GUI
- Ornaments can be placed under each other
- Lights replace other lights when placing on the opposite side of a corner
- Lights on walls get replaced by a block that is placed in front of it
- Breeding Reindeer uses a Carrot-on-a-Stick instead of Carrots
- Refined-Ice / Crystal Armor don't show up in the Creative tab
- Game crashes when using the Ice Staff on non-mob entities such as minecarts
- Able to spam the Snow Globe
- Snow Slabs show as Snow Slab.name
- Buckets aren't returned when used in the Freezer
- Green Candle is a seperate block

## Removed
- Special Golden Hat for team members
- Chiller Stick
- Chiller Stick achievement
- Magic Fire
- Magic Snow
- Magic Portal Block
- Unfinished North Pole dimension
- Seperate blue ornament
- Seperate green ornamanet
- Seperate green candle block
- Winter Ice generation

## [Wintercraft-1.0.3] - 2013-12-18

## [Wintercraft-1.0.2] - 2013-12-08

## [Wintercraft-1.0.1] - 2013-12-04

## [Wintercraft-1.0.0] - 2013-12-03

(Wil update older versions later)
