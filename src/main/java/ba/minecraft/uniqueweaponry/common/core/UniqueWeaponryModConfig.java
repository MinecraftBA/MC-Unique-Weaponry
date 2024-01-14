package ba.minecraft.uniqueweaponry.common.core;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = UniqueWeaponryMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class UniqueWeaponryModConfig
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    static final ForgeConfigSpec SPEC;
    
    private static final ForgeConfigSpec.IntValue FLASH_GRENADE_SECONDS_DURATION_CONFIG;
    private static final ForgeConfigSpec.IntValue FLASH_GRENADE_BLAST_RADIUS_CONFIG;
    
    private static final ForgeConfigSpec.IntValue FREEZE_GRENADE_SECONDS_DURATION_CONFIG;
    private static final ForgeConfigSpec.IntValue FREEZE_GRENADE_BLAST_RADIUS_CONFIG;
    
    private static final ForgeConfigSpec.IntValue IGNITE_GRENADE_SECONDS_DURATION_CONFIG;
    private static final ForgeConfigSpec.IntValue IGNITE_GRENADE_BLAST_RADIUS_CONFIG;

    public static int FLASH_GRENADE_SECONDS_DURATION;
    public static int FLASH_GRENADE_BLAST_RADIUS;
    
    public static int FREEZE_GRENADE_SECONDS_DURATION;
    public static int FREEZE_GRENADE_BLAST_RADIUS;
    
    public static int IGNITE_GRENADE_SECONDS_DURATION;
    public static int IGNITE_GRENADE_BLAST_RADIUS;
    
    static 
    {
    	BUILDER.push("Configs for Unique Weaponry Mod");

    	BUILDER.pop();

    	FLASH_GRENADE_SECONDS_DURATION_CONFIG = BUILDER.comment("Defines for how many seconds will the mobs be flashed.")
	            .defineInRange("Flash Grenade duration", 5, 1, 60);
    	
    	FLASH_GRENADE_BLAST_RADIUS_CONFIG = BUILDER.comment("Defines radius in blocks of flash grenade area of effect.")
	            .defineInRange("Flash Grenade blast radius", 8, 4, 32);
    	
    	FREEZE_GRENADE_SECONDS_DURATION_CONFIG = BUILDER.comment("Defines for how many seconds will the mobs be frozen")
	            .defineInRange("Freeze Grenade duration", 30, 1, 60);
    	
    	FREEZE_GRENADE_BLAST_RADIUS_CONFIG = BUILDER.comment("Defines radius in blocks of freeze grenade area of effect")
	            .defineInRange("Freeze Grenade blast radius", 8, 4, 32);

    	IGNITE_GRENADE_SECONDS_DURATION_CONFIG = BUILDER.comment("Defines for how many seconds will the mobs be ignited")
	            .defineInRange("Ignite Grenade duration", 5, 1, 60);
    	
    	IGNITE_GRENADE_BLAST_RADIUS_CONFIG = BUILDER.comment("Defines radius in blocks of ignite grenade area of effect")
	            .defineInRange("Ignite Grenade blast radius", 8, 4, 32);
    	
    	SPEC = BUILDER.build();
    }
    
    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
    	FLASH_GRENADE_SECONDS_DURATION = FLASH_GRENADE_SECONDS_DURATION_CONFIG.get();
    	FLASH_GRENADE_BLAST_RADIUS = FLASH_GRENADE_BLAST_RADIUS_CONFIG.get();
    	
    	FREEZE_GRENADE_SECONDS_DURATION = FREEZE_GRENADE_SECONDS_DURATION_CONFIG.get();
    	FLASH_GRENADE_BLAST_RADIUS = FREEZE_GRENADE_BLAST_RADIUS_CONFIG.get();
    	
    	IGNITE_GRENADE_SECONDS_DURATION = IGNITE_GRENADE_SECONDS_DURATION_CONFIG.get();
    	FLASH_GRENADE_BLAST_RADIUS = IGNITE_GRENADE_BLAST_RADIUS_CONFIG.get();
    }
}
