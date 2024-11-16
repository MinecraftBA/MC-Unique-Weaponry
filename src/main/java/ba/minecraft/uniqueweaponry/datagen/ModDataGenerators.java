package ba.minecraft.uniqueweaponry.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

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
		
		PackOutput packOutput = dataGen.getPackOutput();

		// Registration of recipes provided by mod
		dataGen.addProvider(event.includeServer(), bindRegistries(ModItemRecipeProvider.Runner::new, lookupProvider));

		// Language providers
		dataGen.addProvider(event.includeClient(), new EnUsLanguageProvider(packOutput));
	}
	
    private static <T extends DataProvider> DataProvider.Factory<T> bindRegistries(BiFunction<PackOutput, CompletableFuture<HolderLookup.Provider>, T> factory, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        return $packOutput -> factory.apply($packOutput, lookupProvider);
    }
}
