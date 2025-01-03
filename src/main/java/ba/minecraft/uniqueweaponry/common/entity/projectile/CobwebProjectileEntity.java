package ba.minecraft.uniqueweaponry.common.entity.projectile;

import ba.minecraft.uniqueweaponry.common.entity.ProjectileEntityTypes;
import ba.minecraft.uniqueweaponry.common.entity.projectile.CobwebProjectileEntity;
import ba.minecraft.uniqueweaponry.common.helpers.ModResourceKey;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class CobwebProjectileEntity extends ThrowableItemProjectile{
	
	private static final ResourceKey<EntityType<?>> ENTITY_RES_KEY = ModResourceKey.createEntityTypeKey("cobweb");

	public static EntityType<CobwebProjectileEntity> createType() {

		Builder<CobwebProjectileEntity> builder = Builder.of(CobwebProjectileEntity::new, MobCategory.MISC);

		builder.sized(0.5F, 0.5F);
		builder.clientTrackingRange(20);
		builder.updateInterval(20);

		EntityType<CobwebProjectileEntity> entityType = builder.build(ENTITY_RES_KEY);

		return entityType;
	}
	
	public CobwebProjectileEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
		super(entityType, level);
	}

	public CobwebProjectileEntity(Level level, LivingEntity thrower, ItemStack itemStack) {
		super(ProjectileEntityTypes.COBWEB.get(), thrower, level, itemStack);
	}

	public CobwebProjectileEntity(Level level) {
		super(ProjectileEntityTypes.COBWEB.get(), level);
	}
	
	@Override
	protected Item getDefaultItem() { 
		return Items.COBWEB;
	}
	
	@Override
	protected void onHitEntity(EntityHitResult hitResult) {

		// Get reference to current level.
		Level level = this.level();

		// IF: Code is executing on client side.
		if(level.isClientSide()) {
			// Do nothing.
			return;
		}
		
		// Get target that was hit.
		Entity target = hitResult.getEntity();
		
		// IF: Target is not a living entity.
		if(!(target instanceof LivingEntity)) {
			
			// Do nothing.
			return;
		}
		
		// Get block position of target.
		BlockPos position = target.blockPosition();
		
		// Get information about block at expected spawn location.
		BlockState block = level.getBlockState(position);
		
		// IF: Above position is taken by some other non-air block.
		if(!block.isAir()){
			
			// Do nothing.
			return;
		}
		
		// Spawn cobweb on block above hit block.
		level.setBlock(position, Blocks.COBWEB.defaultBlockState(), Block.UPDATE_ALL);

		super.onHitEntity(hitResult);
	}

	@Override
	protected void onHitBlock(BlockHitResult hitResult) {
		
		// Get reference to current level.
		Level level = this.level();

		// IF: Code is executing on client side.
		if(level.isClientSide()) {
			// Do nothing.
			return;
		}

		// Get position of hit block.
		BlockPos blockPos = hitResult.getBlockPos();

		// Get direction in which block was hit.
		Direction direction = hitResult.getDirection();
		
		// Position where cobweb should be spawned.
		BlockPos spawnBlockPos = null;
		
		switch(direction)
		{
			case WEST:
				spawnBlockPos = blockPos.west();
			break;
			case EAST:
				spawnBlockPos = blockPos.east();
			break;
			case UP:
				spawnBlockPos = blockPos.above();
			break;
			case DOWN:
				spawnBlockPos = blockPos.below();
			break;
			case NORTH:
				spawnBlockPos = blockPos.north();
			break;
			case SOUTH:
				spawnBlockPos = blockPos.south();
			break;
		}
		
		// Get information about block at expected spawn location.
		BlockState block = level.getBlockState(spawnBlockPos);
		
		// IF: Above position is taken by some other non-air block.
		if(!block.isAir()){
			
			// Do nothing.
			return;
		}
		
		// Spawn cobweb on block above hit block.
		level.setBlock(spawnBlockPos, Blocks.COBWEB.defaultBlockState(), Block.UPDATE_ALL);

		// Call mandatory base class code.
		super.onHitBlock(hitResult);
	}

}
