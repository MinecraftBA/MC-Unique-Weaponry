package ba.minecraft.uniqueweaponry.client.event.entity;

import ba.minecraft.uniqueweaponry.common.entity.GrenadeEntityTypes;
import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryMod;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UniqueWeaponryMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class RegisterRenderersEventHandler {

	@SubscribeEvent
    public static void onRegisterRenderers(final RegisterRenderers event) {

		// Throwable entities
		event.registerEntityRenderer(GrenadeEntityTypes.FLASH_GRENADE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(GrenadeEntityTypes.FREEZE_GRENADE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(GrenadeEntityTypes.IGNITE_GRENADE.get(), ThrownItemRenderer::new);
		
	}
	
}
