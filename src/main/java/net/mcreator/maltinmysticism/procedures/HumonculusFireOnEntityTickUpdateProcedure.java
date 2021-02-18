package net.mcreator.maltinmysticism.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.maltinmysticism.entity.HumonculusSlimeEntity;
import net.mcreator.maltinmysticism.entity.HumonculusSkeleEntity;
import net.mcreator.maltinmysticism.entity.HumonculusMushroomEntity;
import net.mcreator.maltinmysticism.entity.HumonculusFireEntity;
import net.mcreator.maltinmysticism.entity.HumonculusEnderEntity;
import net.mcreator.maltinmysticism.MaltinmysticismModElements;

import java.util.Map;

@MaltinmysticismModElements.ModElement.Tag
public class HumonculusFireOnEntityTickUpdateProcedure extends MaltinmysticismModElements.ModElement {
	public HumonculusFireOnEntityTickUpdateProcedure(MaltinmysticismModElements instance) {
		super(instance, 100);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure HumonculusFireOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getPersistentData().getDouble("loottimer")) >= 2000)) {
			entity.getPersistentData().putDouble("loottimer", 0);
			if ((entity instanceof HumonculusFireEntity.CustomEntity)) {
				{
					final ItemStack _setstack = new ItemStack(Items.BLAZE_ROD, (int) (1));
					final int _sltid = (int) (0);
					_setstack.setCount((int) 1);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
						}
					});
				}
			}
			if ((entity instanceof HumonculusSlimeEntity.CustomEntity)) {
				{
					final ItemStack _setstack = new ItemStack(Items.SLIME_BALL, (int) (1));
					final int _sltid = (int) (0);
					_setstack.setCount((int) 1);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
						}
					});
				}
			}
			if ((entity instanceof HumonculusEnderEntity.CustomEntity)) {
				{
					final ItemStack _setstack = new ItemStack(Items.ENDER_PEARL, (int) (1));
					final int _sltid = (int) (0);
					_setstack.setCount((int) 1);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
						}
					});
				}
			}
			if ((entity instanceof HumonculusSkeleEntity.CustomEntity)) {
				{
					final ItemStack _setstack = new ItemStack(Items.BONE, (int) (1));
					final int _sltid = (int) (0);
					_setstack.setCount((int) 1);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
						}
					});
				}
			}
			if ((entity instanceof HumonculusMushroomEntity.CustomEntity)) {
				if ((Math.random() > 0.5)) {
					{
						final ItemStack _setstack = new ItemStack(Blocks.BROWN_MUSHROOM, (int) (1));
						final int _sltid = (int) (0);
						_setstack.setCount((int) 1);
						entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				} else {
					{
						final ItemStack _setstack = new ItemStack(Blocks.RED_MUSHROOM, (int) (1));
						final int _sltid = (int) (0);
						_setstack.setCount((int) 1);
						entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
			}
		} else {
			entity.getPersistentData().putDouble("loottimer", (1 + (entity.getPersistentData().getDouble("loottimer"))));
		}
	}
}
