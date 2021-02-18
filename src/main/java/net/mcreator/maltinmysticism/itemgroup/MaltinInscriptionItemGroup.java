
package net.mcreator.maltinmysticism.itemgroup;

@MaltinmysticismModElements.ModElement.Tag
public class MaltinInscriptionItemGroup extends MaltinmysticismModElements.ModElement {

	public MaltinInscriptionItemGroup(MaltinmysticismModElements instance) {
		super(instance, 61);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmaltin_inscription") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(InscriptionTabletItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;

}
