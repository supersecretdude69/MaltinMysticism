
package net.mcreator.maltinmysticism.item;

@MaltinmysticismModElements.ModElement.Tag
public class WhiteChalkItem extends MaltinmysticismModElements.ModElement {

	@ObjectHolder("maltinmysticism:white_chalk")
	public static final Item block = null;

	public WhiteChalkItem(MaltinmysticismModElements instance) {
		super(instance, 34);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(MaltinInscriptionItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("white_chalk");
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
