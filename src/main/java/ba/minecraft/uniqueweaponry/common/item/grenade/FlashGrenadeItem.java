package ba.minecraft.uniqueweaponry.common.item.grenade;

import ba.minecraft.uniqueweaponry.common.entity.grenade.FlashGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.item.grenade.base.BaseGrenadeItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public final class FlashGrenadeItem extends BaseGrenadeItem<FlashGrenadeEntity> {

	@Override
	public FlashGrenadeEntity CreateEntity(Level level, LivingEntity thrower) {
		return new FlashGrenadeEntity(level, thrower);
	}
	
}
