package ba.minecraft.uniqueweaponry.common.item.grenade;

import ba.minecraft.uniqueweaponry.common.entity.grenade.FreezeGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.helpers.ModResourceKey;
import ba.minecraft.uniqueweaponry.common.item.grenade.base.BaseGrenadeItem;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FreezeGrenadeItem extends BaseGrenadeItem<FreezeGrenadeEntity> {

	// Defines that this item will be registered as uniqueweaponry:freeze_grenade
	private static final ResourceKey<Item> RES_KEY = ModResourceKey.createItemKey("freeze_grenade");

	public FreezeGrenadeItem() {
		super(RES_KEY);
	}
	
	@Override
	public FreezeGrenadeEntity CreateEntity(LivingEntity thrower, Level level, ItemStack itemStack) {
		return new FreezeGrenadeEntity(thrower, level, itemStack);
	}

	@Override
	public FreezeGrenadeEntity CreateEntity(double x, double y, double z, Level level, ItemStack itemStack) {
		return new FreezeGrenadeEntity(x, y, z, level, itemStack);
	}
	
}	