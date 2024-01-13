package ba.minecraft.uniqueweaponry.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryMod;
import ba.minecraft.uniqueweaponry.datagen.lang.EnUsLanguageProvider;
import ba.minecraft.uniqueweaponry.datagen.recipe.*;

@EventBusSubscriber(modid = UniqueWeaponryMod.MODID, bus = Bus.MOD)
public final class ModDataGenerators {

	@SubscribeEvent
	public static void gatherData(final GatherDataEvent event) {
		
		// Get reference to running instance of data generator.
		DataGenerator dataGen = event.getGenerator();
		
		// Get reference to existing file helper.
		//ExistingFileHelper exFileHelper = event.getExistingFileHelper();
		
		// Registration of recipes provided by mod
		dataGen.addProvider(event.includeServer(), new GrenadeItemRecipeProvider(dataGen));

		// Item model providers
		//dataGen.addProvider(event.includeClient(), new GrenadeItemModelProvider(dataGen, exFileHelper));
		
		// Language providers
		dataGen.addProvider(event.includeClient(), new EnUsLanguageProvider(dataGen));
	}
	
}
