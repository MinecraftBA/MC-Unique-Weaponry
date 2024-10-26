package ba.minecraft.uniqueweaponry.common.item.grenade;

import ba.minecraft.uniqueweaponry.common.entity.grenade.FreezeGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.item.grenade.base.BaseGrenadeItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FreezeGrenadeItem extends BaseGrenadeItem<FreezeGrenadeEntity> {

	@Override
	public FreezeGrenadeEntity CreateEntity(LivingEntity thrower, Level level, ItemStack itemStack) {
		return new FreezeGrenadeEntity(thrower, level, itemStack);
	}

	@Override
	public FreezeGrenadeEntity CreateEntity(double x, double y, double z, Level level, ItemStack itemStack) {
		return new FreezeGrenadeEntity(x, y, z, level, itemStack);
	}
	
}	