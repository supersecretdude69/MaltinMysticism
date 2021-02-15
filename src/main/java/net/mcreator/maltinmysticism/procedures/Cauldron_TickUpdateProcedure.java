package net.mcreator.maltinmysticism.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.maltinmysticism.particle.ParticleBubbleYellowParticle;
import net.mcreator.maltinmysticism.particle.ParticleBubbleWhiteParticle;
import net.mcreator.maltinmysticism.particle.ParticleBubbleRedParticle;
import net.mcreator.maltinmysticism.particle.ParticleBubblePurpleParticle;
import net.mcreator.maltinmysticism.particle.ParticleBubbleGreyParticle;
import net.mcreator.maltinmysticism.particle.ParticleBubbleGreenParticle;
import net.mcreator.maltinmysticism.particle.ParticleBubbleBlueParticle;
import net.mcreator.maltinmysticism.particle.ParticleBubbleBlackParticle;
import net.mcreator.maltinmysticism.block.BlockCauldronYellowBlock;
import net.mcreator.maltinmysticism.block.BlockCauldronWhiteBlock;
import net.mcreator.maltinmysticism.block.BlockCauldronRedBlock;
import net.mcreator.maltinmysticism.block.BlockCauldronPurpleBlock;
import net.mcreator.maltinmysticism.block.BlockCauldronGreyBlock;
import net.mcreator.maltinmysticism.block.BlockCauldronGreenBlock;
import net.mcreator.maltinmysticism.block.BlockCauldronBlueBlock;
import net.mcreator.maltinmysticism.block.BlockCauldronBlackBlock;
import net.mcreator.maltinmysticism.MaltinmysticismModElements;

import java.util.Map;

@MaltinmysticismModElements.ModElement.Tag
public class Cauldron_TickUpdateProcedure extends MaltinmysticismModElements.ModElement {
	public Cauldron_TickUpdateProcedure(MaltinmysticismModElements instance) {
		super(instance, 10);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure Cauldron_TickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure Cauldron_TickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure Cauldron_TickUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Cauldron_TickUpdate!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean Boiling = false;
		Boiling = (boolean) (false);
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.LAVA.getDefaultState().getBlock())) {
			Boiling = (boolean) (true);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.LAVA.getDefaultState().getBlock())) {
			Boiling = (boolean) (true);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.BUBBLE_COLUMN.getDefaultState()
				.getBlock())) {
			Boiling = (boolean) (true);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.FIRE.getDefaultState().getBlock())) {
			Boiling = (boolean) (true);
		}
		if (((Boiling) == (true))) {
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlockCauldronBlueBlock.block.getDefaultState()
					.getBlock())) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleBubbleBlueParticle.particle, x, (y + 0.5), x, (int) 3, 0.3, 0.3, 0.3, 0);
				}
			} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlockCauldronGreenBlock.block.getDefaultState()
					.getBlock())) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleBubbleGreenParticle.particle, x, (y + 0.5), z, (int) 3, 0.3, 0.3, 0.3, 0);
				}
			} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlockCauldronRedBlock.block.getDefaultState()
					.getBlock())) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleBubbleRedParticle.particle, x, (y + 0.5), z, (int) 3, 0.3, 0.3, 0.3, 0);
				}
			} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlockCauldronPurpleBlock.block.getDefaultState()
					.getBlock())) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleBubblePurpleParticle.particle, x, (y + 0.5), z, (int) 3, 0.3, 0.3, 0.3, 0);
				}
			} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlockCauldronYellowBlock.block.getDefaultState()
					.getBlock())) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleBubbleYellowParticle.particle, x, (y + 0.5), z, (int) 3, 0.3, 0.3, 0.3, 0);
				}
			} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlockCauldronBlackBlock.block.getDefaultState()
					.getBlock())) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleBubbleBlackParticle.particle, x, (y + 0.5), z, (int) 3, 0.3, 0.3, 0.3, 0);
				}
			} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlockCauldronWhiteBlock.block.getDefaultState()
					.getBlock())) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleBubbleWhiteParticle.particle, x, (y + 0.5), z, (int) 3, 0.3, 0.3, 0.3, 0);
				}
			} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlockCauldronGreyBlock.block.getDefaultState()
					.getBlock())) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleBubbleGreyParticle.particle, x, (y + 0.5), z, (int) 3, 0.3, 0.3, 0.3, 0);
				}
			}
		}
	}
}
