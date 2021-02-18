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
public class HomSpeakTwoProcedure extends MaltinmysticismModElements.ModElement {
	public HomSpeakTwoProcedure(MaltinmysticismModElements instance) {
		super(instance, 74);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure HomSpeakTwo!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure HomSpeakTwo!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure HomSpeakTwo!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure HomSpeakTwo!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure HomSpeakTwo!");
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
			message = (String) "Why are some potatoes poisonous?";
		} else if (((Rannum) == 1)) {
			message = (String) "What is a soul made from?";
		} else if (((Rannum) == 2)) {
			message = (String) "Why are souls needed?";
		} else if (((Rannum) == 3)) {
			message = (String) "I could go for some cake...";
		} else if (((Rannum) == 4)) {
			message = (String) "What are portals made from?";
		} else if (((Rannum) == 5)) {
			message = (String) "How do enderpearls work?";
		} else if (((Rannum) == 6)) {
			message = (String) "Just give me some paper and I will get started on some research.";
		} else if (((Rannum) == 7)) {
			message = (String) "I'm looking forward to doing some research!";
		} else if (((Rannum) == 8)) {
			message = (String) "What makes water blue? Why do biomes change its colour?";
		} else if (((Rannum) == 9)) {
			message = (String) "Where do I go when I die?";
		} else if (((Rannum) == 10)) {
			message = (String) "Today is a nice day! I can feel it!";
		} else if (((Rannum) == 11)) {
			message = (String) "Hand me a book and I'll get to some research right away!";
		}
		if (((Entity) world
				.getEntitiesWithinAABB(PlayerEntity.class,
						new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d), z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)), null)
				.stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof PlayerEntity && !((Entity) world
						.getEntitiesWithinAABB(PlayerEntity.class,
								new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d), z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).world.isRemote) {
			((PlayerEntity) ((Entity) world
					.getEntitiesWithinAABB(PlayerEntity.class,
							new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d), z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null))).sendStatusMessage(
							new StringTextComponent((((entity.getDisplayName().getString())) + "" + (((":") + "" + ((message)))))), (false));
		}
	}
}
