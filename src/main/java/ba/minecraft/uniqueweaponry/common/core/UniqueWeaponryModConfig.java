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
    private static final ForgeConfigSpec.IntValue IGNITE_GRENADE_SECONDS_DURATION_CONFIG;
    private static final ForgeConfigSpec.IntValue FREEZE_GRENADE_SECONDS_DURATION_CONFIG;
   
    
    public static int IGNITE_GRENADE_SECONDS_DURATION;
    
    public static int FLASH_GRENADE_SECONDS_DURATION;
    
    public static int FREEZE_GRENADE_SECONDS_DURATION;

    static {
    	BUILDER.push("Configs for Unique Weaponry Mod");

    	BUILDER.pop();
    	
    	IGNITE_GRENADE_SECONDS_DURATION_CONFIG = BUILDER.comment("Defines how many seconds the player will be on fire")
	            .defineInRange("Ignite Grenade Seconds Duration", 0, 5, 20);
    	
    	FLASH_GRENADE_SECONDS_DURATION_CONFIG = BUILDER.comment("Defines how many seconds the player will be blind")
	            .defineInRange("Flash Grenade Seconds Duration", 0, 5, 20);
    	
    	FREEZE_GRENADE_SECONDS_DURATION_CONFIG = BUILDER.comment("Defines how many seconds the player will be freeze")
	            .defineInRange("Freeze Grenade Seconds Duration", 0, 30, 60);
    	
    	SPEC = BUILDER.build();
    }
    
    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
    	
    	IGNITE_GRENADE_SECONDS_DURATION = IGNITE_GRENADE_SECONDS_DURATION_CONFIG.get();
    	
    	FREEZE_GRENADE_SECONDS_DURATION = FREEZE_GRENADE_SECONDS_DURATION_CONFIG.get();
    	
    	FLASH_GRENADE_SECONDS_DURATION = FLASH_GRENADE_SECONDS_DURATION_CONFIG.get();
    }
}
