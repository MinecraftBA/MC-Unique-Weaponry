package ba.minecraft.uniqueweaponry.common.entity.projectile;

import ba.minecraft.uniqueweaponry.common.entity.projectile.CobwebProjectileEntity;
import ba.minecraft.uniqueweaponry.common.helpers.ModResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class CobwebProjectileEntity extends ThrowableItemProjectile{
	
	private static final ResourceLocation ENTITY_LOC = new ModResourceLocation("cobweb");
	
	public static EntityType<CobwebProjectileEntity> createType() {

		Builder<CobwebProjectileEntity> builder = Builder.of(CobwebProjectileEntity::new, MobCategory.MISC);

		builder.sized(0.5F, 0.5F);
		builder.clientTrackingRange(20);
		builder.updateInterval(20);

		String id = ENTITY_LOC.toString();

		EntityType<CobwebProjectileEntity> entityType = builder.build(id);

		return entityType;
	}
	
	public CobwebProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, double pX, double pY,
			double pZ, Level pLevel) {
		super(pEntityType, pX, pY, pZ, pLevel);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Item getDefaultItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
