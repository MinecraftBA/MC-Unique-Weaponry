package ba.minecraft.uniqueweaponry.common.item;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryMod;
import ba.minecraft.uniqueweaponry.common.item.grenade.FlashGrenadeItem;
import ba.minecraft.uniqueweaponry.common.item.grenade.FreezeGrenadeItem;
import ba.minecraft.uniqueweaponry.common.item.grenade.LevitateGrenadeItem;
import ba.minecraft.uniqueweaponry.common.item.grenade.IgniteGrenadeItem;
import ba.minecraft.uniqueweaponry.common.item.grenade.PoisonGrenadeItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class GrenadeItems {
	
	private GrenadeItems() {}
	
	public static final DeferredRegister<Item> REGISTRY = 
			DeferredRegister.create(ForgeRegistries.ITEMS, UniqueWeaponryMod.MODID);
	
	public static final RegistryObject<FlashGrenadeItem> FLASH_GRENADE = 
			REGISTRY.register("flash_grenade", () -> new FlashGrenadeItem());
	
	public static final RegistryObject<IgniteGrenadeItem> IGNITE_GRENADE = 
			REGISTRY.register("ignite_grenade", () -> new IgniteGrenadeItem());
	
	public static final RegistryObject<FreezeGrenadeItem> FREEZE_GRENADE = 
			REGISTRY.register("freeze_grenade", () -> new FreezeGrenadeItem());
	
	public static final RegistryObject<PoisonGrenadeItem> POISON_GRENADE = 
			REGISTRY.register("poison_grenade", () -> new PoisonGrenadeItem());
	
	public static final RegistryObject<LevitateGrenadeItem> LEVITATE_GRENADE = 
			REGISTRY.register("gravity_grenade", () -> new LevitateGrenadeItem());

}
