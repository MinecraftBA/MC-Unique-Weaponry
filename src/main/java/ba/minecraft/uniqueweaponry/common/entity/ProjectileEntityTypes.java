package ba.minecraft.uniqueweaponry.common.entity;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryMod;
import ba.minecraft.uniqueweaponry.common.entity.grenade.FlashGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.entity.projectile.CobwebProjectileEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ProjectileEntityTypes {
	
	private ProjectileEntityTypes() {}

	public static final DeferredRegister<EntityType<?>> REGISTRY = 
			DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, UniqueWeaponryMod.MODID);

	public static final RegistryObject<EntityType<CobwebProjectileEntity>> COBWEB =
			REGISTRY.register("cobweb", () -> CobwebProjectileEntity.createType());
}
