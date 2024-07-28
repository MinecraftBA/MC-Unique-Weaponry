package ba.minecraft.uniqueweaponry.common.entity;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryMod;
import ba.minecraft.uniqueweaponry.common.entity.grenade.FlashGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.entity.grenade.FreezeGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.entity.grenade.LevitateGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.entity.grenade.IgniteGrenadeEntity;
import ba.minecraft.uniqueweaponry.common.entity.grenade.PoisonGrenadeEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class GrenadeEntityTypes {

	private GrenadeEntityTypes() {}

	public static final DeferredRegister<EntityType<?>> REGISTRY = 
			DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, UniqueWeaponryMod.MODID);

	public static final RegistryObject<EntityType<FlashGrenadeEntity>> FLASH_GRENADE =
			REGISTRY.register("flash_grenade", () -> FlashGrenadeEntity.createType());
	
	public static final RegistryObject<EntityType<IgniteGrenadeEntity>> IGNITE_GRENADE =
			REGISTRY.register("ignite_grenade", () -> IgniteGrenadeEntity.createType());
	
	public static final RegistryObject<EntityType<FreezeGrenadeEntity>> FREEZE_GRENADE =
			REGISTRY.register("freeze_grenade", () -> FreezeGrenadeEntity.createType());
	
	public static final RegistryObject<EntityType<PoisonGrenadeEntity>> POISON_GRENADE =
			REGISTRY.register("poison_grenade", () -> PoisonGrenadeEntity.createType());
	
	public static final RegistryObject<EntityType<LevitateGrenadeEntity>> GRAVITY_GRENADE =
			REGISTRY.register("gravity_grenade", () -> LevitateGrenadeEntity.createType());

}
