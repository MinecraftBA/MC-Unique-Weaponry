package ba.minecraft.uniqueweaponry.common.item.grenade;

import ba.minecraft.uniqueweaponry.common.entity.grenade.LevitateGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.item.grenade.base.BaseGrenadeItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LevitateGrenadeItem extends BaseGrenadeItem<LevitateGrenadeEntity> {

	@Override
	public LevitateGrenadeEntity CreateEntity(LivingEntity thrower, Level level, ItemStack itemStack) {
		return new LevitateGrenadeEntity(thrower, level, itemStack);
	}

	@Override
	public LevitateGrenadeEntity CreateEntity(double x, double y, double z, Level level, ItemStack itemStack) {
		return new LevitateGrenadeEntity(x, y, z, level, itemStack);
	}
	
}