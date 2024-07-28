package ba.minecraft.uniqueweaponry.common.entity.grenade;

import java.util.List;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryModConfig;
import ba.minecraft.uniqueweaponry.common.entity.GrenadeEntityTypes;
import ba.minecraft.uniqueweaponry.common.entity.grenade.base.BaseGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.helpers.ModResourceLocation;
import ba.minecraft.uniqueweaponry.common.item.GrenadeItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class LevitateGrenadeEntity extends BaseGrenadeEntity {

	// Defines that this entity will be registered as uniqueweaponry:flash_grenade
	private static final ResourceLocation ENTITY_LOC = ModResourceLocation.Create("gravity_grenade");

	public static EntityType<LevitateGrenadeEntity> createType() {

		Builder<LevitateGrenadeEntity> builder = Builder.of(LevitateGrenadeEntity::new, MobCategory.MISC);

		builder.sized(0.5F, 0.5F);
		builder.clientTrackingRange(20);
		builder.updateInterval(20);

		String id = ENTITY_LOC.toString();

		EntityType<LevitateGrenadeEntity> entityType = builder.build(id);

		return entityType;
	}

	public LevitateGrenadeEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
		super(entityType, level);
	}

	public LevitateGrenadeEntity(Level level, LivingEntity thrower) {
		super(GrenadeEntityTypes.GRAVITY_GRENADE.get(), thrower, level);
	}

	public LevitateGrenadeEntity(Level level) {
		super(GrenadeEntityTypes.GRAVITY_GRENADE.get(), level);
	}

	@Override
	protected Item getDefaultItem() {
		return GrenadeItems.GRAVITY_GRENADE.get();
	}

	@Override
	protected int getBlastRadius() {
		return UniqueWeaponryModConfig.GRAVITY_GRENADE_BLAST_RADIUS;
	}

	@Override
	protected void onHit(HitResult hitResult) {

		// Make explosion audio/visual effects.
		explode(SoundEvents.GENERIC_EXPLODE.get());

		// Get affected mobs.
		List<LivingEntity> mobs = getAffectedMobs(hitResult);

		// Iterate through mobs
		for (LivingEntity mob : mobs) {

			// Create instance of blindness effect.
			MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.LEVITATION, UniqueWeaponryModConfig.GRAVITY_GRENADE_SECONDS_DURATION * 20);

			// Apply effect to mob.
			mob.addEffect(effectInstance);
		}

		// Call mandatory base class code.
		super.onHit(hitResult);

	}

}