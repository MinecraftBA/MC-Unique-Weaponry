package ba.minecraft.uniqueweaponry.common.entity.grenade.base;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public abstract class BaseGrenadeEntity extends ThrowableItemProjectile {

	public BaseGrenadeEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
		super(entityType, level);
	}

	public BaseGrenadeEntity(EntityType<? extends ThrowableItemProjectile> entityType, LivingEntity pShooter, Level pLevel) {
		super(entityType, pShooter, pLevel);
	}
	
	/**
	 * Override to specify radius of blast area.
	 * @return Blast area radius.
	 */
	protected abstract int getBlastRadius();

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
	
	private AABB getHitArea(HitResult hitResult) {
		
		// Get location where grenade hit the ground.
		Vec3 hitLocation = hitResult.getLocation();

		// Get blast radius.
		int radius = getBlastRadius();

		// Create boundaries of blast area.
		AABB area = AABB.ofSize(hitLocation, radius, radius, radius);
		
		return area;
	}
	
	protected List<LivingEntity> getAffectedMobs(HitResult hitResult){

		// Get grenade hit area.
		AABB area = getHitArea(hitResult);

		// Get reference to a level where grenade has exploded.
		Level level = this.level();
		
		// Get list of all living entities in the area.
		List<LivingEntity> mobs = level.getEntitiesOfClass(LivingEntity.class, area);

		return  mobs;
	}
	
	protected List<BlockPos> getAreaPositions(AABB area) {

		// Create list that will hold position.
		List<BlockPos> positions = new ArrayList<BlockPos>();
		
		// Iterate through all possible x coordinates in the affected area.
		for(int x = (int)area.minX; x < area.maxX; x++) {

			// Iterate through all possible y coordinates in the affected area.
			for(int y = (int)area.minY; y < area.maxY; y++) {

				// Iterate through all possible z coordinates in the affected area.
				for(int z = (int)area.minZ; z < area.maxZ; z++) {
					
					// Create block position on the coordinates.
					BlockPos position = new BlockPos((int)x, (int)y, (int)z);
					
					// Add it to the list.
					positions.add(position);
					
				}

			}

		}
		
		return positions;
	}
	
	protected List<BlockPos> getAffectedBlockPositions(HitResult hitResult, Block block) {

		// Create boundaries of hit area.
		AABB area = getHitArea(hitResult);
		
		// Get reference to a level where grenade has exploded.
		Level level = this.level();
		
		// Get list of all affected positions.
		List<BlockPos> positions = getAreaPositions(area);
		
		// Create empty list for positions that contain desired block.
		List<BlockPos> filteredPositions = new ArrayList<BlockPos>();
		
		// Iterate through list of all positions.
		for(BlockPos position : positions) {
			
			// Get blockstate on position.
			BlockState blockState = level.getBlockState(position);
		
			// IF: It is desired block.
			if(blockState.is(block)) 
			{
				// Add it to the list.
				filteredPositions.add(position);
			}
		}
		
		return filteredPositions;
	}
	
	protected void explode(SoundEvent soundEvent) {
		
		// Get reference to a level where grenade is exploding.
		Level level = this.level();
		
		// Play explosion sound.
		level.playSound((Player)null, this.getX(), this.getY(), this.getZ(), soundEvent, SoundSource.NEUTRAL, 10.0F, 1.0F);

		// Create explosion event without damage.
	    level.explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 0.0F, Level.ExplosionInteraction.NONE);
	}
}
