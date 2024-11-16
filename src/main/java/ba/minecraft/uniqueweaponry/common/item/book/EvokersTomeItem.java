package ba.minecraft.uniqueweaponry.common.item.book;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryModConfig;
import ba.minecraft.uniqueweaponry.common.helpers.ModResourceKey;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.EvokerFangs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EvokersTomeItem extends Item {
    
	// Defines that this item will be registered as uniqueweaponry:evokers_tome
	private static final ResourceKey<Item> RES_KEY = ModResourceKey.createItemKey("evokers_tome");

    public EvokersTomeItem() {
        super(createProperties());
    }
    
    private static Properties createProperties() {
        Properties properties = new Properties();
        properties.setId(RES_KEY);
        properties.stacksTo(1);
        return properties;
    }
    
	@Override
    public InteractionResult use(Level level, Player player, InteractionHand usedHand) {

        // Get reference to a tome that was used.
        ItemStack tome = player.getItemInHand(usedHand);
        
        // IF: Code is executing on client side.
        if(level.isClientSide) {
     
        	// Do nothing.
            return InteractionResult.SUCCESS;
        }
        
        // Play casting sound.
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.EVOKER_CAST_SPELL, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        
        // Get the player's look vector
        Vec3 lookVec = player.getLookAngle();
        
        // Position offset multiplier for each fang
        double distanceBetweenFangs = 1.0; // Adjust this to control the spacing between the fangs

        for (int i = 0; i < 7; i++) {
            // Calculate the position for each fang in a straight line
            double offsetX = player.getX() + lookVec.x * (i + 1) * distanceBetweenFangs;
            double offsetY = player.getY() + 0.5;  // Lift the fangs a bit off the ground
            double offsetZ = player.getZ() + lookVec.z * (i + 1) * distanceBetweenFangs;
            
            // Create instance of EvokerFangs
            EvokerFangs fang = new EvokerFangs(level, offsetX, offsetY, offsetZ, player.getYRot(), i, player);
            fang.setOwner(player); // Set the player as the owner of the fangs
            
            // Add it to the level
            level.addFreshEntity(fang);
        }
        
        // Set a cooldown of 3 seconds (60 ticks)
        player.getCooldowns().addCooldown(tome, UniqueWeaponryModConfig.EVOKERS_TOME_COOLDOWN * 20);
              
        // Award stat that item is used.
        player.awardStat(Stats.ITEM_USED.get(this));

        // Indicate that use was successful.
        return InteractionResult.SUCCESS_SERVER;
    }
}