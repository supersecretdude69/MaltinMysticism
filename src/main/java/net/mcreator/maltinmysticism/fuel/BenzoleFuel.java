
package net.mcreator.maltinmysticism.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.maltinmysticism.item.ItemBenzoleItem;
import net.mcreator.maltinmysticism.MaltinmysticismModElements;

@MaltinmysticismModElements.ModElement.Tag
public class BenzoleFuel extends MaltinmysticismModElements.ModElement {
	public BenzoleFuel(MaltinmysticismModElements instance) {
		super(instance, 65);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(ItemBenzoleItem.block, (int) (1)).getItem())
			event.setBurnTime(3000);
	}
}
