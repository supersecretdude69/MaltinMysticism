
package net.mcreator.maltinmysticism.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.maltinmysticism.item.ItemLapizPowderItem;
import net.mcreator.maltinmysticism.MaltinmysticismModElements;

@MaltinmysticismModElements.ModElement.Tag
public class MaltinAlchemyItemGroup extends MaltinmysticismModElements.ModElement {
	public MaltinAlchemyItemGroup(MaltinmysticismModElements instance) {
		super(instance, 21);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmaltin_alchemy") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ItemLapizPowderItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
