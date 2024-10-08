package ba.minecraft.uniqueweaponry.common.item.staff;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryModConfig;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class SkullcasterStaffItem extends Item {

    private static final int COOLDOWN_TICKS = UniqueWeaponryModConfig.SKULLCASTER_COOLDOWN; // 2 seconds (20 ticks per second)

    public SkullcasterStaffItem() {
        super(createProperties());
    }
    
    private static Properties createProperties() {
        Properties properties = new Properties();
        properties.stacksTo(1);
        properties.rarity(Rarity.RARE);
        return properties;
    }
    

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (!world.isClientSide) {
            if (!player.getCooldowns().isOnCooldown(this)) {
                // Get the player's eye position to shoot from the eyes
                Vec3 eyePosition = player.getEyePosition(1.0F);

                // Base direction where the player is looking
                Vec3 baseDirection = player.getLookAngle();

                // Shoot multiple Wither Skulls in slightly different directions
                    // Create a new Wither Skull entity
                    WitherSkull witherSkull = new WitherSkull(world, player, baseDirection);
                    witherSkull.setPos(eyePosition.x, eyePosition.y, eyePosition.z);
                    
                    Vec3 direction = player.getLookAngle();
                    // Adjust direction for each skull


                    // Set the direction of the Wither Skull
                    witherSkull.shoot(direction.x, direction.y, direction.z, 1.5F, 0.0F);

                    // Ensure the Wither Skull is invulnerable (blue and more powerful)
                    
                    // Add the Wither Skull to the world
                    world.addFreshEntity(witherSkull);

                // Play sound and spawn particle effect
                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.WITHER_SHOOT, player.getSoundSource(), 1.0F, 1.0F);
                ((ServerPlayer) player).level().addParticle(ParticleTypes.SMOKE, eyePosition.x, eyePosition.y, eyePosition.z, 10, 0.1D, 0.1D);

                // Apply the cooldown to the item
                player.getCooldowns().addCooldown(this, COOLDOWN_TICKS);
            }
        }

        return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}