package ba.minecraft.uniqueweaponry.common.entity.grenade;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.level.Level;

public abstract class BaseGrenadeEntity extends ThrowableItemProjectile {

	public BaseGrenadeEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
		super(entityType, level);
	}

	public BaseGrenadeEntity(EntityType<FlashGrenadeEntity> entityType, LivingEntity pShooter, Level pLevel) {
		super(entityType, pShooter, pLevel);
	}
}
