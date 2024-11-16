package ba.minecraft.uniqueweaponry.common.core;

import com.mojang.logging.LogUtils;

import ba.minecraft.uniqueweaponry.common.entity.GrenadeEntityTypes;
import ba.minecraft.uniqueweaponry.common.entity.ProjectileEntityTypes;
import ba.minecraft.uniqueweaponry.common.item.BookItems;
import ba.minecraft.uniqueweaponry.common.item.GrenadeItems;
import ba.minecraft.uniqueweaponry.common.item.GunItems;
import ba.minecraft.uniqueweaponry.common.item.StaffItems;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStoppedEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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

    public UniqueWeaponryMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        // Registration of mod provided items.
        GrenadeItems.REGISTRY.register(modEventBus);
        GunItems.REGISTRY.register(modEventBus);
        BookItems.REGISTRY.register(modEventBus);
        StaffItems.REGISTRY.register(modEventBus);
        
        // Registration of mod provided entity types
    	GrenadeEntityTypes.REGISTRY.register(modEventBus);
    	ProjectileEntityTypes.REGISTRY.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        context.registerConfig(ModConfig.Type.SERVER, UniqueWeaponryModConfig.SPEC, MODID + "-server.toml");
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    	DispenserBlock.registerProjectileBehavior(GrenadeItems.FLASH_GRENADE.get());
    	DispenserBlock.registerProjectileBehavior(GrenadeItems.FREEZE_GRENADE.get());
    	DispenserBlock.registerProjectileBehavior(GrenadeItems.IGNITE_GRENADE.get());
    	DispenserBlock.registerProjectileBehavior(GrenadeItems.LEVITATE_GRENADE.get());
    	DispenserBlock.registerProjectileBehavior(GrenadeItems.POISON_GRENADE.get());
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
