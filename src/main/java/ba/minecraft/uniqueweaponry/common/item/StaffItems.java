package ba.minecraft.uniqueweaponry.common.item;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryMod;
import ba.minecraft.uniqueweaponry.common.item.staff.SkullcasterItem;
import ba.minecraft.uniqueweaponry.common.item.staff.InfernalScepterStaffItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class StaffItems {
	
	private StaffItems() {}
	
	public static final DeferredRegister<Item> REGISTRY = 
			DeferredRegister.create(ForgeRegistries.ITEMS, UniqueWeaponryMod.MODID);
	
	public static final RegistryObject<SkullcasterItem> SKULLCASTER = 
			REGISTRY.register("skullcaster", () -> new SkullcasterItem());
	
	public static final RegistryObject<InfernalScepterStaffItem> INFERNAL_SCEPTER = 
			REGISTRY.register("infernal_scepter", () -> new InfernalScepterStaffItem());
	
}
