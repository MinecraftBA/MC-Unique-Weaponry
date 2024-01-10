package ba.minecraft.uniqueweaponry.datagen.model.item;

import ba.minecraft.uniqueweaponry.common.item.GrenadeItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public final class GrenadeItemModelProvider extends BaseItemModelProvider {

	public GrenadeItemModelProvider(DataGenerator dataGen, ExistingFileHelper exFileHelper) {
		super(dataGen, exFileHelper);
	}

	@Override
	protected void registerModels() {
		spawnEgg(GrenadeItems.FLASH_GRENADE.get());
	}

}