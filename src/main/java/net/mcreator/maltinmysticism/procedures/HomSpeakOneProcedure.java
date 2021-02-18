package net.mcreator.maltinmysticism.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.maltinmysticism.MaltinmysticismModElements;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

@MaltinmysticismModElements.ModElement.Tag
public class HomSpeakOneProcedure extends MaltinmysticismModElements.ModElement {
	public HomSpeakOneProcedure(MaltinmysticismModElements instance) {
		super(instance, 73);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure HomSpeakOne!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure HomSpeakOne!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure HomSpeakOne!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure HomSpeakOne!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure HomSpeakOne!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double Rannum = 0;
		String message = "";
		Rannum = (double) Math.round((10 * Math.random()));
		if (((Rannum) == 0)) {
			message = (String) "But... where do the essence jars come from?";
		} else if (((Rannum) == 1)) {
			message = (String) "It's alchemy, not magic!";
		} else if (((Rannum) == 2)) {
			message = (String) "The life of an alchemist awaits!";
		} else if (((Rannum) == 3)) {
			message = (String) "Just tell me what to do!";
		} else if (((Rannum) == 4)) {
			message = (String) "Who needs safety equipment anyway!";
		} else if (((Rannum) == 5)) {
			message = (String) "I wonder how zombies can still move even though they're undead...";
		} else if (((Rannum) == 6)) {
			message = (String) "Does a skeleton have a soul?";
		} else if (((Rannum) == 7)) {
			message = (String) "Do villagers have souls?";
		} else if (((Rannum) == 8)) {
			message = (String) "Do animals have souls?";
		} else if (((Rannum) == 9)) {
			message = (String) "Do plants have souls?";
		} else if (((Rannum) == 10)) {
			message = (String) "Do I have a soul?";
		} else if (((Rannum) == 11)) {
			message = (String) "Do you have a soul?";
		}
		if (((Entity) world
				.getEntitiesWithinAABB(PlayerEntity.class,
						new AxisAlignedBB(x - (4 / 2d), y - (4 / 2d), z - (4 / 2d), x + (4 / 2d), y + (4 / 2d), z + (4 / 2d)), null)
				.stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof PlayerEntity && !((Entity) world
						.getEntitiesWithinAABB(PlayerEntity.class,
								new AxisAlignedBB(x - (4 / 2d), y - (4 / 2d), z - (4 / 2d), x + (4 / 2d), y + (4 / 2d), z + (4 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).world.isRemote) {
			((PlayerEntity) ((Entity) world
					.getEntitiesWithinAABB(PlayerEntity.class,
							new AxisAlignedBB(x - (4 / 2d), y - (4 / 2d), z - (4 / 2d), x + (4 / 2d), y + (4 / 2d), z + (4 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null))).sendStatusMessage(
							new StringTextComponent((((entity.getDisplayName().getString())) + "" + (((":") + "" + ((message)))))), (false));
		}
	}
}
