package ba.minecraft.uniqueweaponry.common.event.creativeModeTab;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryMod;
import ba.minecraft.uniqueweaponry.common.item.BookItems;
import ba.minecraft.uniqueweaponry.common.item.GrenadeItems;
import ba.minecraft.uniqueweaponry.common.item.GunItems;
import ba.minecraft.uniqueweaponry.common.item.StaffItems;

@EventBusSubscriber(modid = UniqueWeaponryMod.MODID, bus = Bus.MOD)
public final class BuildCreativeModeTabContentsEventHandler {

	@SubscribeEvent()
	public static void onBuildCreativeModeTabContents(final BuildCreativeModeTabContentsEvent event) {

		ResourceKey<CreativeModeTab> tabKey = event.getTabKey();

		if(tabKey == CreativeModeTabs.COMBAT) {
			event.accept(GrenadeItems.FLASH_GRENADE);
			event.accept(GrenadeItems.FREEZE_GRENADE);
			event.accept(GrenadeItems.IGNITE_GRENADE);
			event.accept(GrenadeItems.POISON_GRENADE);
			event.accept(GrenadeItems.LEVITATE_GRENADE);
			event.accept(GunItems.WEBBER);
			event.accept(BookItems.EVOKERS_TOME);
			event.accept(StaffItems.WITHER_STAFF);
		}

	}
}