
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mugrootbeer.init;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.core.Registry;

import net.mcreator.mugrootbeer.world.features.plants.SasssaplingFeature;
import net.mcreator.mugrootbeer.world.features.ores.AluminumOreFeature;
import net.mcreator.mugrootbeer.world.features.SassafrasstreeFeature;
import net.mcreator.mugrootbeer.MugRootbeerMod;

import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;

import java.util.function.Predicate;

public class MugRootbeerModFeatures {
	public static void load() {
		register("aluminum_ore", AluminumOreFeature.FEATURE, AluminumOreFeature.CONFIGURED_FEATURE, AluminumOreFeature.GENERATE_BIOMES,
				GenerationStep.Decoration.UNDERGROUND_ORES);
		register("sassafrasstree", SassafrasstreeFeature.FEATURE, SassafrasstreeFeature.CONFIGURED_FEATURE, SassafrasstreeFeature.GENERATE_BIOMES,
				GenerationStep.Decoration.SURFACE_STRUCTURES);
		register("sasssapling", SasssaplingFeature.FEATURE, SasssaplingFeature.CONFIGURED_FEATURE, SasssaplingFeature.GENERATE_BIOMES,
				GenerationStep.Decoration.VEGETAL_DECORATION);
	}

	private static void register(String registryName, Feature feature, ConfiguredFeature<?, ?> configFeature, Predicate<BiomeSelectionContext> biomes,
			GenerationStep.Decoration genStep) {
		Registry.register(Registry.FEATURE, new ResourceLocation(MugRootbeerMod.MODID, registryName), feature);
		ResourceKey<ConfiguredFeature<?, ?>> configFeatKey = ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY,
				new ResourceLocation(MugRootbeerMod.MODID, registryName));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, configFeatKey.location(), configFeature);
		BiomeModifications.addFeature(biomes, genStep, configFeatKey);
	}
}
