
package net.mcreator.mugrootbeer.block;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.RenderType;

import net.mcreator.mugrootbeer.procedures.SasssaplingUpdateTickProcedure;
import net.mcreator.mugrootbeer.procedures.SasssaplingPlantRightClickedProcedure;
import net.mcreator.mugrootbeer.init.MugRootbeerModBlocks;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import java.util.Random;
import java.util.List;
import java.util.Collections;

public class SasssaplingBlock extends FlowerBlock {
	public SasssaplingBlock() {
		super(MobEffects.MOVEMENT_SPEED, 100,
				BlockBehaviour.Properties.of(Material.PLANT).randomTicks().noCollission().sound(SoundType.GRASS).instabreak());
		FlammableBlockRegistry.getDefaultInstance().add(this, 100, 60);
	}

	@Override
	public int getEffectDuration() {
		return 100;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, Random random) {
		super.tick(blockstate, world, pos, random);
		SasssaplingUpdateTickProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("x", pos.getX())
				.put("y", pos.getY()).put("z", pos.getZ()).put("world", world).build());
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		SasssaplingPlantRightClickedProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("x", pos.getX())
				.put("y", pos.getY()).put("z", pos.getZ()).put("world", world).put("entity", entity).build());
		return InteractionResult.SUCCESS;
	}

	@Environment(EnvType.CLIENT)
	public static void clientInit() {
		BlockRenderLayerMap.INSTANCE.putBlock(MugRootbeerModBlocks.SASSSAPLING, RenderType.cutoutMipped());
	}
}
