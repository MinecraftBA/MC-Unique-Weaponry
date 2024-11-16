package ba.minecraft.uniqueweaponry.common.entity.grenade;

import java.util.List;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryModConfig;
import ba.minecraft.uniqueweaponry.common.entity.GrenadeEntityTypes;
import ba.minecraft.uniqueweaponry.common.entity.grenade.base.BaseGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.helpers.ModResourceKey;
import ba.minecraft.uniqueweaponry.common.item.GrenadeItems;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class FlashGrenadeEntity extends BaseGrenadeEntity {

	// Defines that this entity will be registered as uniqueweaponry:flash_grenade
	private static final ResourceKey<EntityType<?>> ENTITY_RES_KEY = ModResourceKey.createEntityTypeKey("flash_grenade");

	public static EntityType<FlashGrenadeEntity> createType() {

		Builder<FlashGrenadeEntity> builder = Builder.of(FlashGrenadeEntity::new, MobCategory.MISC);

		builder.sized(0.5F, 0.5F);
		builder.clientTrackingRange(20);
		builder.updateInterval(20);
		
		EntityType<FlashGrenadeEntity> entityType = builder.build(ENTITY_RES_KEY);

		return entityType;
	}

	public FlashGrenadeEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
		super(entityType, level);
	}

	public FlashGrenadeEntity(LivingEntity thrower, Level level, ItemStack itemStack) {
		super(GrenadeEntityTypes.FLASH_GRENADE.get(), thrower, level, itemStack);
	}
	
	public FlashGrenadeEntity(double x, double y, double z, Level level, ItemStack itemStack) {
		super(GrenadeEntityTypes.FLASH_GRENADE.get(), x, y, z, level, itemStack);
	}

	public FlashGrenadeEntity(Level level) {
		super(GrenadeEntityTypes.FLASH_GRENADE.get(), level);
	}

	@Override
	protected Item getDefaultItem() {
		return GrenadeItems.FLASH_GRENADE.get();
	}

	@Override
	protected int getBlastRadius() {
		return UniqueWeaponryModConfig.FLASH_GRENADE_BLAST_RADIUS;
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
			MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.BLINDNESS, UniqueWeaponryModConfig.FLASH_GRENADE_SECONDS_DURATION * 20);

			// Apply effect to mob.
			mob.addEffect(effectInstance);
		}

		// Call mandatory base class code.
		super.onHit(hitResult);

	}

}
