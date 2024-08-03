package ba.minecraft.uniqueweaponry.common.item.grenade;

import ba.minecraft.uniqueweaponry.common.entity.grenade.FlashGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.item.grenade.base.BaseGrenadeItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class FlashGrenadeItem extends BaseGrenadeItem<FlashGrenadeEntity> {

	@Override
	public FlashGrenadeEntity CreateEntity(LivingEntity thrower, Level level) {
		return new FlashGrenadeEntity(thrower, level);
	}

	@Override
	public FlashGrenadeEntity CreateEntity(double x, double y, double z, Level level) {
		return new FlashGrenadeEntity(x, y, z, level);
	}
	
}
