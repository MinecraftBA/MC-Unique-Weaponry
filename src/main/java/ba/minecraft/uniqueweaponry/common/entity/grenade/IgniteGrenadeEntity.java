package ba.minecraft.uniqueweaponry.common.entity.grenade;

import java.util.List;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryModConfig;
import ba.minecraft.uniqueweaponry.common.entity.GrenadeEntityTypes;
import ba.minecraft.uniqueweaponry.common.entity.grenade.base.BaseGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.helpers.ModResourceKey;
import ba.minecraft.uniqueweaponry.common.item.GrenadeItems;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class IgniteGrenadeEntity extends BaseGrenadeEntity {

	// Defines that this entity will be registered as uniqueweaponry:ignite_grenade
	private static final ResourceKey<EntityType<?>> ENTITY_RES_KEY = ModResourceKey.createEntityTypeKey("ignite_grenade");

	public static EntityType<IgniteGrenadeEntity> createType() {

		Builder<IgniteGrenadeEntity> builder = Builder.of(IgniteGrenadeEntity::new, MobCategory.MISC);

		builder.sized(0.5F, 0.5F);
		builder.clientTrackingRange(20);
		builder.updateInterval(20);

		EntityType<IgniteGrenadeEntity> entityType = builder.build(ENTITY_RES_KEY);

		return entityType;
	}

	public IgniteGrenadeEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
		super(entityType, level);
	}

	public IgniteGrenadeEntity(LivingEntity thrower, Level level) {
		super(GrenadeEntityTypes.IGNITE_GRENADE.get(), thrower, level);
	}
	
	public IgniteGrenadeEntity(double x, double y, double z, Level level, ItemStack itemStack) {
		super(GrenadeEntityTypes.IGNITE_GRENADE.get(), x, y, z, level, itemStack);
	}

	public IgniteGrenadeEntity(Level level) {
		super(GrenadeEntityTypes.IGNITE_GRENADE.get(), level);
	}

	@Override
	protected Item getDefaultItem() {
		return GrenadeItems.IGNITE_GRENADE.get();
	}

	@Override
	protected int getBlastRadius() {
		return UniqueWeaponryModConfig.IGNITE_GRENADE_BLAST_RADIUS;
	}

	@Override
	protected void onHit(HitResult hitResult) {

		// Make explosion audio/visual effects.
		explode(SoundEvents.FIRECHARGE_USE);

		// Get affected mobs.
		List<LivingEntity> mobs = getAffectedMobs(hitResult);

		// Iterate through mobs
		for (LivingEntity mob : mobs) {

			// Set mob on fire.
			mob.igniteForSeconds(UniqueWeaponryModConfig.IGNITE_GRENADE_SECONDS_DURATION);

		}

		// Call mandatory base class code.
		super.onHit(hitResult);

	}

}
