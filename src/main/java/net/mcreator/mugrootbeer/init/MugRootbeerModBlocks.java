
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mugrootbeer.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.mcreator.mugrootbeer.block.SasssaplingBlock;
import net.mcreator.mugrootbeer.block.SassafrassleavesBlock;
import net.mcreator.mugrootbeer.block.SassafrassPlankBlock;
import net.mcreator.mugrootbeer.block.SassafrasLogBlock;
import net.mcreator.mugrootbeer.block.AluminumOreBlock;
import net.mcreator.mugrootbeer.MugRootbeerMod;

public class MugRootbeerModBlocks {
	public static Block ALUMINUM_ORE;
	public static Block SASSAFRAS_LOG;
	public static Block SASSAFRASS_PLANK;
	public static Block SASSAFRASSLEAVES;
	public static Block SASSSAPLING;

	public static void load() {
		ALUMINUM_ORE = Registry.register(Registry.BLOCK, new ResourceLocation(MugRootbeerMod.MODID, "aluminum_ore"), new AluminumOreBlock());
		SASSAFRAS_LOG = Registry.register(Registry.BLOCK, new ResourceLocation(MugRootbeerMod.MODID, "sassafras_log"), new SassafrasLogBlock());
		SASSAFRASS_PLANK = Registry.register(Registry.BLOCK, new ResourceLocation(MugRootbeerMod.MODID, "sassafrass_plank"),
				new SassafrassPlankBlock());
		SASSAFRASSLEAVES = Registry.register(Registry.BLOCK, new ResourceLocation(MugRootbeerMod.MODID, "sassafrassleaves"),
				new SassafrassleavesBlock());
		SASSSAPLING = Registry.register(Registry.BLOCK, new ResourceLocation(MugRootbeerMod.MODID, "sasssapling"), new SasssaplingBlock());
	}

	public static void clientLoad() {
		AluminumOreBlock.clientInit();
		SassafrasLogBlock.clientInit();
		SassafrassPlankBlock.clientInit();
		SassafrassleavesBlock.clientInit();
		SasssaplingBlock.clientInit();
	}
}
