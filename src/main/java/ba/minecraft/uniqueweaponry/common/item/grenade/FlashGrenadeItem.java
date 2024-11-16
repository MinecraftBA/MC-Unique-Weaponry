package ba.minecraft.uniqueweaponry.common.item.grenade;

import ba.minecraft.uniqueweaponry.common.entity.grenade.FlashGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.helpers.ModResourceKey;
import ba.minecraft.uniqueweaponry.common.item.grenade.base.BaseGrenadeItem;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FlashGrenadeItem extends BaseGrenadeItem<FlashGrenadeEntity> {

	// Defines that this item will be registered as uniqueweaponry:flash_grenade
	private static final ResourceKey<Item> RES_KEY = ModResourceKey.createItemKey("flash_grenade");

	public FlashGrenadeItem() {
		super(RES_KEY);
	}

	@Override
	public FlashGrenadeEntity CreateEntity(LivingEntity thrower, Level level, ItemStack itemStack) {
		return new FlashGrenadeEntity(thrower, level, itemStack);
	}

	@Override
	public FlashGrenadeEntity CreateEntity(double x, double y, double z, Level level, ItemStack itemStack) {
		return new FlashGrenadeEntity(x, y, z, level, itemStack);
	}
	
}
