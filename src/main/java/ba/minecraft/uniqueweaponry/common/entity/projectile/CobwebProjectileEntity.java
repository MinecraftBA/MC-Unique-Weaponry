package ba.minecraft.uniqueweaponry.common.entity.projectile;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryModConfig;
import ba.minecraft.uniqueweaponry.common.entity.ProjectileEntityTypes;
import ba.minecraft.uniqueweaponry.common.entity.projectile.CobwebProjectileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class CobwebProjectileEntity extends ThrowableItemProjectile{
	
	private static final ResourceLocation ENTITY_LOC = new ResourceLocation("cobweb");
	
	public static EntityType<CobwebProjectileEntity> createType() {

		Builder<CobwebProjectileEntity> builder = Builder.of(CobwebProjectileEntity::new, MobCategory.MISC);

		builder.sized(0.5F, 0.5F);
		builder.clientTrackingRange(20);
		builder.updateInterval(20);

		String id = ENTITY_LOC.toString();

		EntityType<CobwebProjectileEntity> entityType = builder.build(id);

		return entityType;
	}
	
	public CobwebProjectileEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
		super(entityType, level);
	}

	public CobwebProjectileEntity(Level level, LivingEntity thrower) {
		super(ProjectileEntityTypes.COBWEB.get(), thrower, level);
	}

	public CobwebProjectileEntity(Level level) {
		super(ProjectileEntityTypes.COBWEB.get(), level);
	}
	
	@Override
	protected Item getDefaultItem() { 
		return Items.COBWEB;
	}
	
	protected int getBlastRadius() {
		return UniqueWeaponryModConfig.FREEZE_GRENADE_BLAST_RADIUS;
	}

	@Override
	protected void onHit(HitResult hitResult) {


			// Get mob standing block position.
			Vec3 position = hitResult.getLocation();
			
			BlockPos blockPos = new BlockPos((int)position.x, (int)position.y, (int)position.z);
			
			// Get reference to current level.
			Level level = this.level();
			

				// Set powder snow on blocks.
				level.setBlock(blockPos, Blocks.COBWEB.defaultBlockState(), Block.UPDATE_ALL);
			
			
		

		// Call mandatory base class code.
		super.onHit(hitResult);

	}

	

}
