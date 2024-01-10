package ba.minecraft.uniqueweaponry.common.entity;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryMod;
import ba.minecraft.uniqueweaponry.common.entity.grenade.FlashGrenadeEntity;
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

}
