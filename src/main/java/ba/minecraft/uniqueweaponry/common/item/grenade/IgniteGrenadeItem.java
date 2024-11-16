package ba.minecraft.uniqueweaponry.common.item.grenade;

import ba.minecraft.uniqueweaponry.common.entity.grenade.IgniteGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.helpers.ModResourceKey;
import ba.minecraft.uniqueweaponry.common.item.grenade.base.BaseGrenadeItem;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class IgniteGrenadeItem extends BaseGrenadeItem<IgniteGrenadeEntity> {

	// Defines that this item will be registered as uniqueweaponry:ignite_grenade
	private static final ResourceKey<Item> RES_KEY = ModResourceKey.createItemKey("ignite_grenade");

	public IgniteGrenadeItem() {
		super(RES_KEY);
	}
	
	@Override
	public IgniteGrenadeEntity CreateEntity(LivingEntity thrower, Level level, ItemStack itemStack) {
		return new IgniteGrenadeEntity(thrower, level, itemStack);
	}

	@Override
	public IgniteGrenadeEntity CreateEntity(double x, double y, double z, Level level, ItemStack itemStack) {
		return new IgniteGrenadeEntity(x, y, z, level, itemStack);
	}
	
}
