package ba.minecraft.uniqueweaponry.common.item.grenade;

import ba.minecraft.uniqueweaponry.common.entity.grenade.GravityGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.item.grenade.base.BaseGrenadeItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class GravityGrenadeItem extends BaseGrenadeItem<GravityGrenadeEntity> {

	@Override
	public GravityGrenadeEntity CreateEntity(Level level, LivingEntity thrower) {
		return new GravityGrenadeEntity(level, thrower);
	}
	
}