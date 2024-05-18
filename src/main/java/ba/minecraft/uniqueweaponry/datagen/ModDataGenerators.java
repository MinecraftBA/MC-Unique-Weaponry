package ba.minecraft.uniqueweaponry.datagen;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import java.util.concurrent.CompletableFuture;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryMod;
import ba.minecraft.uniqueweaponry.datagen.lang.EnUsLanguageProvider;
import ba.minecraft.uniqueweaponry.datagen.recipe.*;

@EventBusSubscriber(modid = UniqueWeaponryMod.MODID, bus = Bus.MOD)
public final class ModDataGenerators {

	@SubscribeEvent
	public static void gatherData(final GatherDataEvent event) {
		
		// Get reference to running instance of data generator and lookup provider.
		DataGenerator dataGen = event.getGenerator();
		CompletableFuture<Provider> lookupProvider = event.getLookupProvider();
		
		// Get reference to existing file helper.
		//ExistingFileHelper exFileHelper = event.getExistingFileHelper();
		
		// Registration of recipes provided by mod
		dataGen.addProvider(event.includeServer(), new ModItemRecipeProvider(dataGen, lookupProvider));
		
		// Language providers
		dataGen.addProvider(event.includeClient(), new EnUsLanguageProvider(dataGen));
	}
	
}
