package ba.minecraft.uniqueweaponry.common.item.grenade;

import ba.minecraft.uniqueweaponry.common.entity.grenade.IgniteGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.item.grenade.base.BaseGrenadeItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class IgniteGrenadeItem extends BaseGrenadeItem<IgniteGrenadeEntity> {

	@Override
	public IgniteGrenadeEntity CreateEntity(LivingEntity thrower, Level level) {
		return new IgniteGrenadeEntity(thrower, level);
	}

	@Override
	public IgniteGrenadeEntity CreateEntity(double x, double y, double z, Level level) {
		return new IgniteGrenadeEntity(x, y, z, level);
	}
	
}
