
package net.mcreator.maltinmysticism.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.maltinmysticism.itemgroup.MaltinAlchemyItemGroup;
import net.mcreator.maltinmysticism.MaltinmysticismModElements;

import java.util.List;

@MaltinmysticismModElements.ModElement.Tag
public class ArtificialFruitMeatItem extends MaltinmysticismModElements.ModElement {
	@ObjectHolder("maltinmysticism:artificial_fruit_meat")
	public static final Item block = null;
	public ArtificialFruitMeatItem(MaltinmysticismModElements instance) {
		super(instance, 89);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(MaltinAlchemyItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(20).saturation(0.7999999999999999f).setAlwaysEdible().meat().build()));
			setRegistryName("artificial_fruit_meat");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Combines the fruit and meat into one! This is the perfect meal for a human!"));
		}
	}
}
