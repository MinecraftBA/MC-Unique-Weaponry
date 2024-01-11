package ba.minecraft.uniqueweaponry.common.entity.grenade;

import java.util.List;

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

public class IgniteGrenadeEntity extends BaseGrenadeEntity {

	// Defines that this entity will be registered as experimentalmod:rpg
	private static final ResourceLocation ENTITY_LOC = new ModResourceLocation("ignite_grenade");

	public static EntityType<IgniteGrenadeEntity> createType() {

		Builder<IgniteGrenadeEntity> builder = Builder.of(IgniteGrenadeEntity::new, MobCategory.MISC);

		builder.sized(0.5F, 0.5F);
		builder.clientTrackingRange(20);
		builder.updateInterval(20);

		String id = ENTITY_LOC.toString();

		EntityType<IgniteGrenadeEntity> entityType = builder.build(id);

		return entityType;
	}

	public IgniteGrenadeEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
		super(entityType, level);
	}

	public IgniteGrenadeEntity(Level level, LivingEntity thrower) {
		super(GrenadeEntityTypes.FLASH_GRENADE.get(), thrower, level);
	}

	public IgniteGrenadeEntity(Level level) {
		super(GrenadeEntityTypes.FLASH_GRENADE.get(), level);
	}

	@Override
	protected Item getDefaultItem() {
		return GrenadeItems.FLASH_GRENADE.get();
	}

	@Override
	protected void onHit(HitResult hitResult) {

		// Make explosion audio/visual effects.
		explode(SoundEvents.GENERIC_EXPLODE);

		// Get affected mobs.
		List<LivingEntity> mobs = getAffectedMobs(hitResult);

		// Iterate through mobs
		for (LivingEntity mob : mobs) {

			// Create instance of blindness effect.
			MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.BLINDNESS, 5 * 20);

			// Apply effect to mob.
			mob.addEffect(effectInstance);
		}

		// Call mandatory base class code.
		super.onHit(hitResult);

	}

}
