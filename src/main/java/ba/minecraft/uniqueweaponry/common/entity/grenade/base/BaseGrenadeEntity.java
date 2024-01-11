package ba.minecraft.uniqueweaponry.common.entity.grenade.base;

import java.util.List;

import ba.minecraft.uniqueweaponry.common.entity.grenade.FlashGrenadeEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public abstract class BaseGrenadeEntity extends ThrowableItemProjectile {

	public BaseGrenadeEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
		super(entityType, level);
	}

	public BaseGrenadeEntity(EntityType<FlashGrenadeEntity> entityType, LivingEntity pShooter, Level pLevel) {
		super(entityType, pShooter, pLevel);
	}

	@Override
	protected void onHit(HitResult result) {
		
		// Call required base class code.
		super.onHit(result);
      
		// Get reference to a level where hit was done.
		Level level = this.level();

		// IF: Code is not executing on client side.
		if (!level.isClientSide) {
    	  
			// Broadcast death event = 3 (net.minecraft.world.entity.EntityEvent)
			this.level().broadcastEntityEvent(this, (byte)3);
         
			// Remove entity from the world.
			this.discard();
		}
	}
	
	protected List<LivingEntity> getAffectedMobs(HitResult hitResult){

		// Get location where grenade hit the ground.
		Vec3 hitLocation = hitResult.getLocation();

		// Create boundaries of hit area.
		AABB area = AABB.ofSize(hitLocation, 16, 16, 16);

		//List<Entity> entities = this.level().getEntities(this, area);

		// Get reference to a level where grenade has exploded.
		Level level = this.level();
		
		// Get list of all living entities in the area.
		List<LivingEntity> mobs = level.getEntitiesOfClass(LivingEntity.class, area);

		return  mobs;
	}
	
}
