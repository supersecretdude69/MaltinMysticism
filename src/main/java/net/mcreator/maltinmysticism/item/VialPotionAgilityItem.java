
package net.mcreator.maltinmysticism.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.maltinmysticism.procedures.DrinkPotionProcedure;
import net.mcreator.maltinmysticism.itemgroup.MaltinAlchemyItemGroup;
import net.mcreator.maltinmysticism.MaltinmysticismModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@MaltinmysticismModElements.ModElement.Tag
public class VialPotionAgilityItem extends MaltinmysticismModElements.ModElement {
	@ObjectHolder("maltinmysticism:vial_potion_agility")
	public static final Item block = null;
	public VialPotionAgilityItem(MaltinmysticismModElements instance) {
		super(instance, 41);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(MaltinAlchemyItemGroup.tab).maxStackSize(16).rarity(Rarity.COMMON));
			setRegistryName("vial_potion_agility");
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
			list.add(new StringTextComponent("Increased the speed and jump-height of the user."));
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				DrinkPotionProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}
	}
}