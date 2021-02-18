
package net.mcreator.maltinmysticism.item;

@MaltinmysticismModElements.ModElement.Tag
public class SkinItem extends MaltinmysticismModElements.ModElement {

	@ObjectHolder("maltinmysticism:skin")
	public static final Item block = null;

	public SkinItem(MaltinmysticismModElements instance) {
		super(instance, 93);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(MaltinAlchemyItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("skin");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
