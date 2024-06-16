package ba.minecraft.uniqueweaponry.common.helpers;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryMod;
import net.minecraft.resources.ResourceLocation;

public final class ModResourceLocation {

	public static ResourceLocation Create(String path) {
		return ResourceLocation.fromNamespaceAndPath(UniqueWeaponryMod.MODID, path);
	}

}
