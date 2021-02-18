package net.mcreator.maltinmysticism.procedures;

import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.maltinmysticism.MaltinmysticismModElements;

import java.util.function.Supplier;
import java.util.Map;

@MaltinmysticismModElements.ModElement.Tag
public class TakeFromInscriptionBenchShiftProcedure extends MaltinmysticismModElements.ModElement {
	public TakeFromInscriptionBenchShiftProcedure(MaltinmysticismModElements instance) {
		super(instance, 66);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure TakeFromInscriptionBenchShift!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double RepeatTimer = 0;
		RepeatTimer = (double) 1;
		{
			Entity _ent = entity;
			if (_ent instanceof ServerPlayerEntity) {
				Container _current = ((ServerPlayerEntity) _ent).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						((Slot) ((Map) invobj).get((int) (0))).decrStackSize((int) (0));
						_current.detectAndSendChanges();
					}
				}
			}
		}
		for (int index0 = 0; index0 < (int) (4); index0++) {
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							((Slot) ((Map) invobj).get((int) ((RepeatTimer)))).decrStackSize((int) (1));
							_current.detectAndSendChanges();
						}
					}
				}
			}
			RepeatTimer = (double) ((RepeatTimer) + 1);
		}
	}
}
