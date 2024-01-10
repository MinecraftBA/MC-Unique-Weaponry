package ba.minecraft.uniqueweaponry.datagen.lang;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryMod;
import ba.minecraft.uniqueweaponry.common.item.GrenadeItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public final class EnUsLanguageProvider extends LanguageProvider {

	public EnUsLanguageProvider(DataGenerator dataGen) {
		super(dataGen.getPackOutput(), UniqueWeaponryMod.MODID, "en_us");
	}

	@Override
	protected void addTranslations() {
		addGrenadeItems();
	}

	private void addGrenadeItems() {
		add(GrenadeItems.FLASH_GRENADE.get(), "Flash Grenade");
	}
}
