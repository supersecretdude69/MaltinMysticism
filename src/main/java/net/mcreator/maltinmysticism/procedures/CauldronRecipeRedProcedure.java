package net.mcreator.maltinmysticism.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.IProperty;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.maltinmysticism.item.VialPotionHealthItem;
import net.mcreator.maltinmysticism.item.SiliconPowderItem;
import net.mcreator.maltinmysticism.item.ItemSilverDustItem;
import net.mcreator.maltinmysticism.item.ItemIronDustItem;
import net.mcreator.maltinmysticism.item.ItemGoldDustItem;
import net.mcreator.maltinmysticism.item.GlassVialItem;
import net.mcreator.maltinmysticism.block.BlockCauldronRedBlock;
import net.mcreator.maltinmysticism.block.BlockCauldronEmptyBlock;
import net.mcreator.maltinmysticism.MaltinmysticismModElements;

import java.util.Map;

@MaltinmysticismModElements.ModElement.Tag
public class CauldronRecipeRedProcedure extends MaltinmysticismModElements.ModElement {
	public CauldronRecipeRedProcedure(MaltinmysticismModElements instance) {
		super(instance, 32);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure CauldronRecipeRed!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure CauldronRecipeRed!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure CauldronRecipeRed!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure CauldronRecipeRed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure CauldronRecipeRed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((BlockCauldronRedBlock.block.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())) {
			if ((((new Object() {
				public String getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "contents"))).equals("lava"))) {
				if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemIronDustItem.block, (int) (1)).getItem())) {
					if (!world.getWorld().isRemote) {
						world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill_fish")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						world.getWorld().playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill_fish")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("contents", "lava-iron");
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(ItemIronDustItem.block, (int) (1));
						((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
					}
				}
			} else if ((((new Object() {
				public String getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "contents"))).equals("lava"))) {
				if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(SiliconPowderItem.block, (int) (1)).getItem())) {
					if (!world.getWorld().isRemote) {
						world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill_fish")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						world.getWorld().playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill_fish")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("contents", "glass");
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(SiliconPowderItem.block, (int) (1));
						((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
					}
				}
			} else if ((((new Object() {
				public String getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "contents"))).equals("iron-water"))) {
				if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(Items.RED_DYE, (int) (1)).getItem())) {
					if (!world.getWorld().isRemote) {
						world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill_fish")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						world.getWorld().playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill_fish")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("contents", "redstone");
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(Items.RED_DYE, (int) (1));
						((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
					}
				}
			} else if ((((new Object() {
				public String getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "contents"))).equals("lava-iron"))) {
				if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemGoldDustItem.block, (int) (1)).getItem())) {
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(ItemGoldDustItem.block, (int) (1));
						((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
					}
					if (!world.getWorld().isRemote) {
						world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill_fish")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						world.getWorld().playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill_fish")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("contents", "silver");
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
			} else if ((((new Object() {
				public String getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "contents"))).equals("silver"))) {
				if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(Items.STICK, (int) (1)).getItem())) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = BlockCauldronEmptyBlock.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_bs.has(_property))
								_bs = _bs.with(_property, (Comparable) entry.getValue());
						}
						TileEntity _te = world.getTileEntity(_bp);
						CompoundNBT _bnbt = null;
						if (_te != null) {
							_bnbt = _te.write(new CompoundNBT());
							_te.remove();
						}
						world.setBlockState(_bp, _bs, 3);
						if (_bnbt != null) {
							_te = world.getTileEntity(_bp);
							if (_te != null) {
								try {
									_te.read(_bnbt);
								} catch (Exception ignored) {
								}
							}
						}
					}
					if (!world.getWorld().isRemote) {
						world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill_fish")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						world.getWorld().playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill_fish")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("contents", "");
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, (y + 1), z,
								new ItemStack(ItemSilverDustItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
			} else if ((((new Object() {
				public String getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "contents"))).equals("redstone"))) {
				if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(Items.STICK, (int) (1)).getItem())) {
					if (!world.getWorld().isRemote) {
						world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill_fish")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						world.getWorld().playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill_fish")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, (y + 1), z, new ItemStack(Items.REDSTONE, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("contents", "");
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = BlockCauldronEmptyBlock.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_bs.has(_property))
								_bs = _bs.with(_property, (Comparable) entry.getValue());
						}
						TileEntity _te = world.getTileEntity(_bp);
						CompoundNBT _bnbt = null;
						if (_te != null) {
							_bnbt = _te.write(new CompoundNBT());
							_te.remove();
						}
						world.setBlockState(_bp, _bs, 3);
						if (_bnbt != null) {
							_te = world.getTileEntity(_bp);
							if (_te != null) {
								try {
									_te.read(_bnbt);
								} catch (Exception ignored) {
								}
							}
						}
					}
				}
			} else if ((((new Object() {
				public String getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "contents"))).equals("health-vial"))) {
				if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(GlassVialItem.block, (int) (1)).getItem())) {
					if (!world.getWorld().isRemote) {
						world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill_fish")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						world.getWorld().playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill_fish")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(GlassVialItem.block, (int) (1));
						((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
					}
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(VialPotionHealthItem.block, (int) (1));
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("contents", "");
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = BlockCauldronEmptyBlock.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_bs.has(_property))
								_bs = _bs.with(_property, (Comparable) entry.getValue());
						}
						TileEntity _te = world.getTileEntity(_bp);
						CompoundNBT _bnbt = null;
						if (_te != null) {
							_bnbt = _te.write(new CompoundNBT());
							_te.remove();
						}
						world.setBlockState(_bp, _bs, 3);
						if (_bnbt != null) {
							_te = world.getTileEntity(_bp);
							if (_te != null) {
								try {
									_te.read(_bnbt);
								} catch (Exception ignored) {
								}
							}
						}
					}
				}
			}
		}
	}
}
