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
    private static final ForgeConfigSpec.IntValue FREEZE_GRENADE_SECONDS_DURATION_CONFIG;
    private static final ForgeConfigSpec.IntValue IGNITE_GRENADE_SECONDS_DURATION_CONFIG;
   
    public static int FLASH_GRENADE_SECONDS_DURATION;
    public static int FREEZE_GRENADE_SECONDS_DURATION;
    public static int IGNITE_GRENADE_SECONDS_DURATION;

    static 
    {
    	BUILDER.push("Configs for Unique Weaponry Mod");

    	BUILDER.pop();

    	FLASH_GRENADE_SECONDS_DURATION_CONFIG = BUILDER.comment("Defines for how many seconds will the mobs be flashed")
	            .defineInRange("Flash Grenade duration", 0, 6, 60);
    	
    	FREEZE_GRENADE_SECONDS_DURATION_CONFIG = BUILDER.comment("Defines for how many seconds will the mobs be frozen")
	            .defineInRange("Freeze Grenade duration", 0, 30, 60);

    	IGNITE_GRENADE_SECONDS_DURATION_CONFIG = BUILDER.comment("Defines for how many seconds will the mobs be ignited")
	            .defineInRange("Ignite Grenade duration", 0, 6, 60);
    	
    	SPEC = BUILDER.build();
    }
    
    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
    	FLASH_GRENADE_SECONDS_DURATION = FLASH_GRENADE_SECONDS_DURATION_CONFIG.get();
    	FREEZE_GRENADE_SECONDS_DURATION = FREEZE_GRENADE_SECONDS_DURATION_CONFIG.get();
    	IGNITE_GRENADE_SECONDS_DURATION = IGNITE_GRENADE_SECONDS_DURATION_CONFIG.get();
    }
}
