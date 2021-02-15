package net.mcreator.maltinmysticism.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.maltinmysticism.item.SiliconPowderItem;
import net.mcreator.maltinmysticism.item.ItemSaltItem;
import net.mcreator.maltinmysticism.item.ItemLapizPowderItem;
import net.mcreator.maltinmysticism.item.ItemIronDustItem;
import net.mcreator.maltinmysticism.item.ItemGoldDustItem;
import net.mcreator.maltinmysticism.item.ItemCoalPowderItem;
import net.mcreator.maltinmysticism.item.DryMushroomPowderItem;
import net.mcreator.maltinmysticism.block.BlockMortarandpestleBlock;
import net.mcreator.maltinmysticism.block.BlockDestillerBlock;
import net.mcreator.maltinmysticism.MaltinmysticismModElements;

import java.util.Map;

@MaltinmysticismModElements.ModElement.Tag
public class Use_MortarandpestleProcedure extends MaltinmysticismModElements.ModElement {
	public Use_MortarandpestleProcedure(MaltinmysticismModElements instance) {
		super(instance, 20);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Use_Mortarandpestle!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure Use_Mortarandpestle!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure Use_Mortarandpestle!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure Use_Mortarandpestle!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Use_Mortarandpestle!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlockDestillerBlock.block.getDefaultState().getBlock())) {
			if ((new ItemStack(Items.WATER_BUCKET, (int) (1))
					.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Items.WATER_BUCKET, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(Items.BUCKET, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				for (int index0 = 0; index0 < (int) ((2 + Math.round((Math.random() * 3)))); index0++) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(ItemSaltItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD, x, y, z, (int) 5, 1, 1, 1, 0.1);
				}
			}
			if ((new ItemStack(Items.POTION, (int) (1))
					.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Items.POTION, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				for (int index1 = 0; index1 < (int) ((1 + Math.round((Math.random() * 1)))); index1++) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(ItemSaltItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD, x, y, z, (int) 5, 1, 1, 1, 0.1);
				}
			}
			if ((new ItemStack(Blocks.BROWN_MUSHROOM, (int) (1))
					.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
				for (int index2 = 0; index2 < (int) ((1 + Math.round((Math.random() * 2)))); index2++) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(DryMushroomPowderItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Blocks.BROWN_MUSHROOM, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD, x, y, z, (int) 5, 1, 1, 1, 0.1);
				}
			}
			if ((new ItemStack(Blocks.RED_MUSHROOM, (int) (1))
					.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
				for (int index3 = 0; index3 < (int) ((1 + Math.round((Math.random() * 2)))); index3++) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(DryMushroomPowderItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Blocks.RED_MUSHROOM, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD, x, y, z, (int) 5, 1, 1, 1, 0.1);
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlockMortarandpestleBlock.block.getDefaultState()
				.getBlock())) {
			if ((new ItemStack(Items.COAL, (int) (1))
					.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Items.COAL, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
				for (int index4 = 0; index4 < (int) ((1 + Math.round((Math.random() * 1)))); index4++) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(ItemCoalPowderItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.break")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.break")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
			}
			if ((new ItemStack(Items.CHARCOAL, (int) (1))
					.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Items.CHARCOAL, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
				for (int index5 = 0; index5 < (int) ((1 + Math.round((Math.random() * 1)))); index5++) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(ItemCoalPowderItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.break")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.break")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
			}
			if ((new ItemStack(Items.LAPIS_LAZULI, (int) (1))
					.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Items.LAPIS_LAZULI, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
				for (int index6 = 0; index6 < (int) ((1 + Math.round((Math.random() * 1)))); index6++) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(ItemLapizPowderItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.break")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.break")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
			}
			if ((new ItemStack(Items.IRON_INGOT, (int) (1))
					.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Items.IRON_INGOT, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
				for (int index7 = 0; index7 < (int) ((1 + Math.round((Math.random() * 3)))); index7++) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(ItemIronDustItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.break")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.break")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
			}
			if ((new ItemStack(Items.GOLD_INGOT, (int) (1))
					.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Items.GOLD_INGOT, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
				for (int index8 = 0; index8 < (int) ((1 + Math.round((Math.random() * 3)))); index8++) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(ItemGoldDustItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.break")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.break")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
			}
			if ((new ItemStack(Items.BLAZE_ROD, (int) (1))
					.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Items.BLAZE_ROD, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
				for (int index9 = 0; index9 < (int) ((2 + Math.round((Math.random() * 4)))); index9++) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(Items.BLAZE_POWDER, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.break")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.break")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
			}
			if ((new ItemStack(Items.BONE, (int) (1))
					.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Items.BONE, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
				for (int index10 = 0; index10 < (int) ((3 + Math.round((Math.random() * 4)))); index10++) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(Items.BONE_MEAL, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.break")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.break")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
			}
			if ((new ItemStack(Blocks.STONE, (int) (1))
					.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Blocks.STONE, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
				for (int index11 = 0; index11 < (int) ((5 + Math.round((Math.random() * 4)))); index11++) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(SiliconPowderItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.break")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.break")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
			}
			if ((new ItemStack(Blocks.SAND, (int) (1))
					.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Blocks.SAND, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
				for (int index12 = 0; index12 < (int) ((2 + Math.round((Math.random() * 3)))); index12++) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(SiliconPowderItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.break")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.gravel.break")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
			}
		}
	}
}
