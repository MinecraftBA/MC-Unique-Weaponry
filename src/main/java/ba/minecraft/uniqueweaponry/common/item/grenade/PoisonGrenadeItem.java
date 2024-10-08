package ba.minecraft.uniqueweaponry.common.item.grenade;

import ba.minecraft.uniqueweaponry.common.entity.grenade.PoisonGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.item.grenade.base.BaseGrenadeItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class PoisonGrenadeItem extends BaseGrenadeItem<PoisonGrenadeEntity>{

	@Override
	public PoisonGrenadeEntity CreateEntity(LivingEntity thrower, Level level) {
		return new PoisonGrenadeEntity(thrower, level);
	}

	@Override
	public PoisonGrenadeEntity CreateEntity(double x, double y, double z, Level level) {
		return new PoisonGrenadeEntity(x, y, z, level);
	}

}
