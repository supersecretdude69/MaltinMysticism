package net.mcreator.maltinmysticism.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.maltinmysticism.MaltinmysticismModElements;

import java.util.Map;

@MaltinmysticismModElements.ModElement.Tag
public class ConditionSNotittingProcedure extends MaltinmysticismModElements.ModElement {
	public ConditionSNotittingProcedure(MaltinmysticismModElements instance) {
		super(instance, 81);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ConditionSNotitting!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getPersistentData().getBoolean("sit")) == (false))) {
			return (true);
		}
		return (false);
	}
}
