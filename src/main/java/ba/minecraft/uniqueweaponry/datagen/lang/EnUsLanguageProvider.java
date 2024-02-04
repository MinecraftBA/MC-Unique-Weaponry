package ba.minecraft.uniqueweaponry.datagen.lang;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryMod;
import ba.minecraft.uniqueweaponry.common.entity.GrenadeEntityTypes;
import ba.minecraft.uniqueweaponry.common.entity.ProjectileEntityTypes;
import ba.minecraft.uniqueweaponry.common.item.GrenadeItems;
import ba.minecraft.uniqueweaponry.common.item.GunItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public final class EnUsLanguageProvider extends LanguageProvider {

	public EnUsLanguageProvider(DataGenerator dataGen) {
		super(dataGen.getPackOutput(), UniqueWeaponryMod.MODID, "en_us");
	}

	@Override
	protected void addTranslations() {

		addGrenadeItems();
		addGrenadeEntities();
		addGunItems();
		addProjectileEntities();
		
	}

	private void addGrenadeItems() {
		add(GrenadeItems.FLASH_GRENADE.get(), "Flash Grenade");
		add(GrenadeItems.IGNITE_GRENADE.get(), "Ignite Grenade");
		add(GrenadeItems.FREEZE_GRENADE.get(), "Freeze Grenade");
	}
	
	private void addGrenadeEntities() {
		add(GrenadeEntityTypes.FLASH_GRENADE.get(), "Flash Grenade");
		add(GrenadeEntityTypes.IGNITE_GRENADE.get(), "Ignite Grenade");
		add(GrenadeEntityTypes.FREEZE_GRENADE.get(), "Freeze Grenade");
	}
	
	
	private void addGunItems() {
		add(GunItems.WEBBER.get(), "Webber");
	}
	
	private void addProjectileEntities() {
		add(ProjectileEntityTypes.COBWEB.get(), "Cobweb");
	}
	
}
