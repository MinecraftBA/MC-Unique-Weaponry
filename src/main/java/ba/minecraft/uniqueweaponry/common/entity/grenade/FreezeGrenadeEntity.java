package ba.minecraft.uniqueweaponry.common.entity.grenade;

import java.util.List;

import ba.minecraft.uniqueweaponry.common.entity.GrenadeEntityTypes;
import ba.minecraft.uniqueweaponry.common.entity.grenade.base.BaseGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.helpers.ModResourceLocation;
import ba.minecraft.uniqueweaponry.common.item.GrenadeItems;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;

public class FreezeGrenadeEntity  extends BaseGrenadeEntity {

	// Defines that this entity will be registered as experimentalmod:rpg
	private static final ResourceLocation ENTITY_LOC = new ModResourceLocation("freeze_grenade");

	public static EntityType<FreezeGrenadeEntity> createType() {

		Builder<FreezeGrenadeEntity> builder = Builder.of(FreezeGrenadeEntity::new, MobCategory.MISC);

		builder.sized(0.5F, 0.5F);
		builder.clientTrackingRange(20);
		builder.updateInterval(20);

		String id = ENTITY_LOC.toString();

		EntityType<FreezeGrenadeEntity> entityType = builder.build(id);

		return entityType;
	}

	public FreezeGrenadeEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
		super(entityType, level);
	}

	public FreezeGrenadeEntity(Level level, LivingEntity thrower) {
		super(GrenadeEntityTypes.FREEZE_GRENADE.get(), thrower, level);
	}

	public FreezeGrenadeEntity(Level level) {
		super(GrenadeEntityTypes.FREEZE_GRENADE.get(), level);
	}

	@Override
	protected Item getDefaultItem() {
		return GrenadeItems.FREEZE_GRENADE.get();
	}
	
	@Override
	protected int getBlastRadius() {
		return 8;
	}

	@Override
	protected void onHit(HitResult hitResult) {

		// Make explosion audio/visual effects.
		explode(SoundEvents.GENERIC_EXPLODE);

		// Get list of block positions for air in affected area.
		List<BlockPos> airPositions = getAffectedBlockPositions(hitResult, Blocks.AIR);
		
		// Iterate through all positions.
		for(BlockPos position : airPositions) {
			
			// Get reference to level.
			Level level = this.level();
			
			// Set powder snow instead of air.
			level.setBlock(position, Blocks.POWDER_SNOW.defaultBlockState(), Block.UPDATE_ALL);
		}

		// Call mandatory base class code.
		super.onHit(hitResult);

	}

}

