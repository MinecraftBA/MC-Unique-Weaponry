package ba.minecraft.uniqueweaponry.common.item;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryMod;
import ba.minecraft.uniqueweaponry.common.item.staff.WitherStaffStaffItem;
import ba.minecraft.uniqueweaponry.common.item.staff.NetherGodStaffItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class StaffItems {
	
	private StaffItems() {}
	
	public static final DeferredRegister<Item> REGISTRY = 
			DeferredRegister.create(ForgeRegistries.ITEMS, UniqueWeaponryMod.MODID);
	
	public static final RegistryObject<WitherStaffStaffItem> WITHER_STAFF = 
			REGISTRY.register("wither_staff", () -> new WitherStaffStaffItem());
	
	public static final RegistryObject<NetherGodStaffItem> NETHER_GOD = 
			REGISTRY.register("nether_god", () -> new NetherGodStaffItem());
	
}
