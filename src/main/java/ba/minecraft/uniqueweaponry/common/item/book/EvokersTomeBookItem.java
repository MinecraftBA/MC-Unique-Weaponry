package ba.minecraft.uniqueweaponry.common.item.book;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryModConfig;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.EvokerFangs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EvokersTomeBookItem extends Item {
    
    public EvokersTomeBookItem() {
        super(createProperties());
    }
    
    private static Properties createProperties() {
        Properties properties = new Properties();
        properties.stacksTo(1);
        return properties;
    }
    
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player user, InteractionHand usedHand) {

        // Get reference to a tome that was used.
        ItemStack tome = user.getItemInHand(usedHand);
        
        // Play casting sound.
        level.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.EVOKER_CAST_SPELL, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        
        // If: Code is executing on server side.
        if (!level.isClientSide) {

            // Get the player's look vector
            Vec3 lookVec = user.getLookAngle();
            
            // Position offset multiplier for each fang
            double distanceBetweenFangs = 1.0; // Adjust this to control the spacing between the fangs

            for (int i = 0; i < 7; i++) {
                // Calculate the position for each fang in a straight line
                double offsetX = user.getX() + lookVec.x * (i + 1) * distanceBetweenFangs;
                double offsetY = user.getY() + 0.5;  // Lift the fangs a bit off the ground
                double offsetZ = user.getZ() + lookVec.z * (i + 1) * distanceBetweenFangs;
                
                // Create instance of EvokerFangs
                EvokerFangs fang = new EvokerFangs(level, offsetX, offsetY, offsetZ, user.getYRot(), i, user);
                fang.setOwner(user); // Set the player as the owner of the fangs
                
                // Add it to the level
                level.addFreshEntity(fang);
            }
            
            // Set a cooldown of 3 seconds (60 ticks)
            user.getCooldowns().addCooldown(this, UniqueWeaponryModConfig.EVOKERS_TOME_COOLDOWN);
        }
              
        // Award stat that item is used.
        user.awardStat(Stats.ITEM_USED.get(this));

        // Indicate that use was successful.
        return InteractionResultHolder.sidedSuccess(tome, level.isClientSide());
    }
}