package ba.minecraft.uniqueweaponry.datagen.lang;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryMod;
import ba.minecraft.uniqueweaponry.common.entity.GrenadeEntityTypes;
import ba.minecraft.uniqueweaponry.common.entity.ProjectileEntityTypes;
import ba.minecraft.uniqueweaponry.common.item.BookItems;
import ba.minecraft.uniqueweaponry.common.item.GrenadeItems;
import ba.minecraft.uniqueweaponry.common.item.GunItems;
import ba.minecraft.uniqueweaponry.common.item.StaffItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public final class EnUsLanguageProvider extends LanguageProvider {

	public EnUsLanguageProvider(PackOutput packOutput) {
		super(packOutput, UniqueWeaponryMod.MODID, "en_us");
	}

	@Override
	protected void addTranslations() {

		addGrenadeItems();
		addGrenadeEntities();
		addGunItems();
		addProjectileEntities();
		addBookItems();
		addStaffItems();
		
	}

	private void addGrenadeItems() {
		add(GrenadeItems.FLASH_GRENADE.get(), "Flash Grenade");
		add(GrenadeItems.FREEZE_GRENADE.get(), "Freeze Grenade");
		add(GrenadeItems.LEVITATE_GRENADE.get(), "Levitate Grenade");
		add(GrenadeItems.IGNITE_GRENADE.get(), "Ignite Grenade");
		add(GrenadeItems.POISON_GRENADE.get(), "Poison Grenade");
	}
	
	private void addGrenadeEntities() {
		add(GrenadeEntityTypes.FLASH_GRENADE.get(), "Flash Grenade");
		add(GrenadeEntityTypes.FREEZE_GRENADE.get(), "Freeze Grenade");
		add(GrenadeEntityTypes.LEVITATE_GRENADE.get(), "Levitate Grenade");
		add(GrenadeEntityTypes.IGNITE_GRENADE.get(), "Ignite Grenade");
		add(GrenadeEntityTypes.POISON_GRENADE.get(), "Poison Grenade");
	}
	
	
	private void addGunItems() {
		add(GunItems.WEBBER.get(), "Webber");
	}
	
	private void addProjectileEntities() {
		add(ProjectileEntityTypes.COBWEB.get(), "Cobweb");
	}
	
	private void addBookItems() {
		add(BookItems.EVOKERS_TOME.get(), "Evoker's Tome");
	}
	
	private void addStaffItems() {
		add(StaffItems.SKULLCASTER.get(), "Skullcaster");
		add(StaffItems.INFERNAL_SCEPTER.get(), "Infernal Scepter");
	}
	
}
