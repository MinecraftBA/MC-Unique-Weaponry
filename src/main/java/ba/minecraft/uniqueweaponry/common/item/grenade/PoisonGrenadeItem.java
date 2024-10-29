package ba.minecraft.uniqueweaponry.common.item.grenade;

import ba.minecraft.uniqueweaponry.common.entity.grenade.PoisonGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.helpers.ModResourceKey;
import ba.minecraft.uniqueweaponry.common.item.grenade.base.BaseGrenadeItem;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PoisonGrenadeItem extends BaseGrenadeItem<PoisonGrenadeEntity>{

	// Defines that this item will be registered as uniqueweaponry:poison_grenade
	private static final ResourceKey<Item> RES_KEY = ModResourceKey.createItemKey("poison_grenade");

	public PoisonGrenadeItem() {
		super(RES_KEY);
	}
	
	@Override
	public PoisonGrenadeEntity CreateEntity(LivingEntity thrower, Level level, ItemStack itemStack) {
		return new PoisonGrenadeEntity(thrower, level, itemStack);
	}

	@Override
	public PoisonGrenadeEntity CreateEntity(double x, double y, double z, Level level, ItemStack itemStack) {
		return new PoisonGrenadeEntity(x, y, z, level, itemStack);
	}

}
