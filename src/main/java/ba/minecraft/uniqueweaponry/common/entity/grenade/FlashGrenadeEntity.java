package ba.minecraft.uniqueweaponry.common.entity.grenade;

import java.util.List;

import ba.minecraft.uniqueweaponry.common.entity.GrenadeEntityTypes;
import ba.minecraft.uniqueweaponry.common.entity.grenade.base.BaseGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.helpers.ModResourceLocation;
import ba.minecraft.uniqueweaponry.common.item.GrenadeItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;

public final class FlashGrenadeEntity extends BaseGrenadeEntity {

	// Defines that this entity will be registered as experimentalmod:rpg
	private static final ResourceLocation ENTITY_LOC = 
			new ModResourceLocation("flash_grenade");

	public static EntityType<FlashGrenadeEntity> createType() {
		
		Builder<FlashGrenadeEntity> builder = Builder.of(FlashGrenadeEntity::new, MobCategory.MISC);

		builder.sized(0.5F, 0.5F);
		builder.clientTrackingRange(20);
		builder.updateInterval(20);
		
		String id = ENTITY_LOC.toString();
		
		EntityType<FlashGrenadeEntity> entityType = builder.build(id);

		return entityType;
	}
	
	public FlashGrenadeEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
		super(entityType, level);
	}
	
	public FlashGrenadeEntity(Level level, LivingEntity thrower) {
		super(GrenadeEntityTypes.FLASH_GRENADE.get(), thrower, level);
	}

	public FlashGrenadeEntity(Level level) {
		super(GrenadeEntityTypes.FLASH_GRENADE.get(), level);
	}

	@Override
	protected Item getDefaultItem() {
		return GrenadeItems.FLASH_GRENADE.get();
	}

	@Override
	protected void onHit(HitResult result) {
		
		// Get location where grenade hit the ground.
		var hitLocation = result.getLocation();
		
		// Create boundaries of hit area.
		AABB area = AABB.ofSize(hitLocation, 16, 16, 16);
		
		// Get list of all entities in the area.
		List<Entity> entities = this.level().getEntities(this, area);
		
		// Iterate through list of all entities in the area.
		for(Entity entity : entities) {
			
			// IF: Entity is living entity.
			if(entity instanceof LivingEntity) {
				
				// Cast entity as living entity.
				LivingEntity livingEntity = (LivingEntity) entity;
				
				// Create instance of blindness effect.
				MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.BLINDNESS, 5 * 20);
				
				// Apply it to mob.
				livingEntity.addEffect(effectInstance);
			}
		}
		
		// Call mandatory base class code.
		super.onHit(result);
		
		
	}

}
