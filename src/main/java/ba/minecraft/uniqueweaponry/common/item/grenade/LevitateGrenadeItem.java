package ba.minecraft.uniqueweaponry.common.item.grenade;

import ba.minecraft.uniqueweaponry.common.entity.grenade.LevitateGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.item.grenade.base.BaseGrenadeItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class LevitateGrenadeItem extends BaseGrenadeItem<LevitateGrenadeEntity> {

	@Override
	public LevitateGrenadeEntity CreateEntity(Level level, LivingEntity thrower) {
		return new LevitateGrenadeEntity(level, thrower);
	}
	
}