package ba.minecraft.uniqueweaponry.common.helpers;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryMod;
import net.minecraft.resources.ResourceLocation;

public final class ModResourceLocation extends ResourceLocation {

	public ModResourceLocation(String path) {
		super(UniqueWeaponryMod.MODID, path);
	}

}
