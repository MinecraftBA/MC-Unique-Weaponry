package ba.minecraft.uniqueweaponry.common.item.staff;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryModConfig;
import ba.minecraft.uniqueweaponry.common.helpers.ModResourceKey;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class SkullcasterItem extends Item {

	// Defines that this item will be registered as uniqueweaponry:skullcaster
	private static final ResourceKey<Item> RES_KEY = ModResourceKey.createItemKey("skullcaster");

    public SkullcasterItem() {
        super(createProperties());
    }
    
    private static Properties createProperties() {
        Properties properties = new Properties();
        properties.setId(RES_KEY);
        properties.stacksTo(1);
        properties.rarity(Rarity.RARE);
        return properties;
    }
    
    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {

    	// Get reference to item in hand.
    	ItemStack itemStack = player.getItemInHand(hand);

    	// IF: Code is executing on client side.
    	if(level.isClientSide) {
    		
    		// Do nothing.
            return InteractionResult.SUCCESS;
    	}
    	
    	// Get reference to cooldowns for player.
    	ItemCooldowns cooldowns = player.getCooldowns();
    	
    	// IF: Item is on cooldown.
    	if(cooldowns.isOnCooldown(itemStack)) {

    		// Do nothing.
            return InteractionResult.SUCCESS_SERVER;
    	}
    	
        // Get the player's eye position to shoot from the eyes
        Vec3 eyePosition = player.getEyePosition(1.0F);

        // Base direction where the player is looking
        Vec3 baseDirection = player.getLookAngle();

        // Create a new Wither Skull entity
        WitherSkull witherSkull = new WitherSkull(level, player, baseDirection);
        witherSkull.setPos(eyePosition.x, eyePosition.y, eyePosition.z);
        witherSkull.setOwner(player);

        // Get direction at which player is looking.
        Vec3 direction = player.getLookAngle();

        // Set the direction of the Wither Skull
        witherSkull.shoot(direction.x, direction.y, direction.z, 1.5F, 0.0F);

        // Add the Wither Skull to the world
        level.addFreshEntity(witherSkull);

        // Play sound and spawn particle effect
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.WITHER_SHOOT, player.getSoundSource(), 1.0F, 1.0F);

        // Add particle at position of casting.
        level.addParticle(ParticleTypes.SMOKE, eyePosition.x, eyePosition.y, eyePosition.z, 10, 0.1D, 0.1D);

        // Apply the cooldown to the item
        cooldowns.addCooldown(itemStack, UniqueWeaponryModConfig.SKULLCASTER_COOLDOWN * 20);

        // Award stat that item is used.
        player.awardStat(Stats.ITEM_USED.get(this));

        return InteractionResult.SUCCESS_SERVER;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}