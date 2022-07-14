
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mugrootbeer.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.mcreator.mugrootbeer.item.SassafrassrootsItem;
import net.mcreator.mugrootbeer.item.RawAluminumItem;
import net.mcreator.mugrootbeer.item.MugRootBeerItem;
import net.mcreator.mugrootbeer.item.EmptyCanItem;
import net.mcreator.mugrootbeer.item.AluminumBarItem;
import net.mcreator.mugrootbeer.MugRootbeerMod;

public class MugRootbeerModItems {
	public static Item RAW_ALUMINUM;
	public static Item ALUMINUM_BAR;
	public static Item ALUMINUM_ORE;
	public static Item EMPTY_CAN;
	public static Item SASSAFRAS_LOG;
	public static Item SASSAFRASS_PLANK;
	public static Item SASSAFRASSROOTS;
	public static Item MUG_ROOT_BEER;
	public static Item SASSAFRASSLEAVES;
	public static Item SASSSAPLING;

	public static void load() {
		RAW_ALUMINUM = Registry.register(Registry.ITEM, new ResourceLocation(MugRootbeerMod.MODID, "raw_aluminum"), new RawAluminumItem());
		ALUMINUM_BAR = Registry.register(Registry.ITEM, new ResourceLocation(MugRootbeerMod.MODID, "aluminum_bar"), new AluminumBarItem());
		ALUMINUM_ORE = Registry.register(Registry.ITEM, new ResourceLocation(MugRootbeerMod.MODID, "aluminum_ore"),
				new BlockItem(MugRootbeerModBlocks.ALUMINUM_ORE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
		EMPTY_CAN = Registry.register(Registry.ITEM, new ResourceLocation(MugRootbeerMod.MODID, "empty_can"), new EmptyCanItem());
		SASSAFRAS_LOG = Registry.register(Registry.ITEM, new ResourceLocation(MugRootbeerMod.MODID, "sassafras_log"),
				new BlockItem(MugRootbeerModBlocks.SASSAFRAS_LOG, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
		SASSAFRASS_PLANK = Registry.register(Registry.ITEM, new ResourceLocation(MugRootbeerMod.MODID, "sassafrass_plank"),
				new BlockItem(MugRootbeerModBlocks.SASSAFRASS_PLANK, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
		SASSAFRASSROOTS = Registry.register(Registry.ITEM, new ResourceLocation(MugRootbeerMod.MODID, "sassafrassroots"), new SassafrassrootsItem());
		MUG_ROOT_BEER = Registry.register(Registry.ITEM, new ResourceLocation(MugRootbeerMod.MODID, "mug_root_beer"), new MugRootBeerItem());
		SASSAFRASSLEAVES = Registry.register(Registry.ITEM, new ResourceLocation(MugRootbeerMod.MODID, "sassafrassleaves"),
				new BlockItem(MugRootbeerModBlocks.SASSAFRASSLEAVES, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
		SASSSAPLING = Registry.register(Registry.ITEM, new ResourceLocation(MugRootbeerMod.MODID, "sasssapling"),
				new BlockItem(MugRootbeerModBlocks.SASSSAPLING, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	}
}
