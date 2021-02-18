
package net.mcreator.maltinmysticism.item;

@MaltinmysticismModElements.ModElement.Tag
public class MeatDollSkinItem extends MaltinmysticismModElements.ModElement {

	@ObjectHolder("maltinmysticism:meat_doll_skin")
	public static final Item block = null;

	public MeatDollSkinItem(MaltinmysticismModElements instance) {
		super(instance, 95);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(MaltinAlchemyItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("meat_doll_skin");
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

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("It is hollow."));
		}

	}

}
