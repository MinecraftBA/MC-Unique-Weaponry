package ba.minecraft.uniqueweaponry.common.item.grenade;

import ba.minecraft.uniqueweaponry.common.entity.grenade.PoisonGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.item.grenade.base.BaseGrenadeItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PoisonGrenadeItem extends BaseGrenadeItem<PoisonGrenadeEntity>{

	@Override
	public PoisonGrenadeEntity CreateEntity(LivingEntity thrower, Level level, ItemStack itemStack) {
		return new PoisonGrenadeEntity(thrower, level, itemStack);
	}

	@Override
	public PoisonGrenadeEntity CreateEntity(double x, double y, double z, Level level, ItemStack itemStack) {
		return new PoisonGrenadeEntity(x, y, z, level, itemStack);
	}

}
