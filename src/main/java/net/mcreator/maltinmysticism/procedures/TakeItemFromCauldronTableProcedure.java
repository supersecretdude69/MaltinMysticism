package net.mcreator.maltinmysticism.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.maltinmysticism.MaltinmysticismModElements;

import java.util.function.Supplier;
import java.util.Map;

@MaltinmysticismModElements.ModElement.Tag
public class TakeItemFromCauldronTableProcedure extends MaltinmysticismModElements.ModElement {
	public TakeItemFromCauldronTableProcedure(MaltinmysticismModElements instance) {
		super(instance, 57);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure TakeItemFromCauldronTable!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double RepeatTimer = 0;
		RepeatTimer = (double) 1;
		if (entity instanceof ServerPlayerEntity) {
			Container _current = ((ServerPlayerEntity) entity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					((Slot) ((Map) invobj).get((int) (1))).putStack(ItemStack.EMPTY);
					_current.detectAndSendChanges();
				}
			}
		}
		for (int index0 = 0; index0 < (int) (16); index0++) {
			if (entity instanceof ServerPlayerEntity) {
				Container _current = ((ServerPlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						((Slot) ((Map) invobj).get((int) ((RepeatTimer)))).putStack(ItemStack.EMPTY);
						_current.detectAndSendChanges();
					}
				}
			}
			RepeatTimer = (double) ((RepeatTimer) + 1);
		}
	}
}
