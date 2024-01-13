package ba.minecraft.uniqueweaponry.common.core;

import com.mojang.logging.LogUtils;

import ba.minecraft.uniqueweaponry.common.entity.GrenadeEntityTypes;
import ba.minecraft.uniqueweaponry.common.item.GrenadeItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStoppedEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(UniqueWeaponryMod.MODID)
public class UniqueWeaponryMod
{
    public static final String MODID = "uniqueweaponry";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public UniqueWeaponryMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Registration of mod provided items.
        GrenadeItems.REGISTRY.register(modEventBus);
        
        // Registration of mod provided entity types
    	GrenadeEntityTypes.REGISTRY.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, UniqueWeaponryModConfig.SPEC, MODID + "-server.toml");
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("Unique Weaponry loading...");
    }

    @SubscribeEvent
    public void onServerStarted(ServerStartedEvent event)
    {
        LOGGER.info("Unique Weaponry loaded!");
    }
    
    @SubscribeEvent
    public void onServerStopping(ServerStoppingEvent event)
    {
        LOGGER.info("Unique Weaponry unloading...");
    }

    @SubscribeEvent
    public void onServerStopped(ServerStoppedEvent event)
    {
        LOGGER.info("Unique Weaponry unloaded!");
    }
}
