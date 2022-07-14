package net.mcreator.mugrootbeer.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.mugrootbeer.MugRootbeerMod;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;

import java.util.Map;
import java.util.HashMap;

public class SasssaplingPlantRightClickedProcedure {
	public SasssaplingPlantRightClickedProcedure() {
		UseBlockCallback.EVENT.register((player, level, hand, hitResult) -> {
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("world", level);
			dependencies.put("entity", player);
			dependencies.put("x", player.getX());
			dependencies.put("y", player.getY());
			dependencies.put("z", player.getZ());
			execute(dependencies);
			return InteractionResult.PASS;
		});
	}

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MugRootbeerMod.LOGGER.warn("Failed to load dependency world for procedure SasssaplingPlantRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MugRootbeerMod.LOGGER.warn("Failed to load dependency x for procedure SasssaplingPlantRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MugRootbeerMod.LOGGER.warn("Failed to load dependency y for procedure SasssaplingPlantRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MugRootbeerMod.LOGGER.warn("Failed to load dependency z for procedure SasssaplingPlantRightClicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MugRootbeerMod.LOGGER.warn("Failed to load dependency entity for procedure SasssaplingPlantRightClicked!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BONE_MEAL) {
			if (world instanceof Level _level) {
				if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, new BlockPos((int) x, (int) y, (int) z))
						|| BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, new BlockPos((int) x, (int) y, (int) z), null)) {
					if (!_level.isClientSide())
						_level.levelEvent(2005, new BlockPos((int) x, (int) y, (int) z), 0);
				}
			}
			((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
			world.setBlock(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("mug_rootbeer", "soup"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos((int) x, (int) y, (int) z), new BlockPos((int) x, (int) y, (int) z),
							new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		}
	}
}
