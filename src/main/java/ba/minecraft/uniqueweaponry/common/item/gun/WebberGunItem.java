package ba.minecraft.uniqueweaponry.common.item.gun;

import ba.minecraft.uniqueweaponry.common.entity.projectile.CobwebProjectileEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class WebberGunItem extends Item {

	public WebberGunItem() {
		super(createProperties());
	}

	private static Properties createProperties() {
		Properties properties = new Properties();
		properties.stacksTo(1);
		return properties;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player thrower, InteractionHand usedHand) {
		
		ItemStack itemStack = new ItemStack(Items.COBWEB,1);
		
		// Play throwing sound.
		level.playSound((Player)null, thrower.getX(), thrower.getY(), thrower.getZ(), SoundEvents.FISHING_BOBBER_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
		
		// IF: Code is executing on server side.
		if (!level.isClientSide) {

			// Create instance of grenade entity.
			CobwebProjectileEntity cobweb = new CobwebProjectileEntity(level, thrower);;
	          
			// Set grenade item that is being thrown.
			cobweb.setItem(itemStack);
			
			
			// Shoot grenade.
			cobweb.shootFromRotation(thrower, thrower.getXRot(), thrower.getYRot(), 0.0F, 1.5F, 1.0F);
          	  
			// Add it to the level.
			level.addFreshEntity(cobweb);
		}
		      
		// Award stat that item is used.
		thrower.awardStat(Stats.ITEM_USED.get(this));
	      

		// Incidate that use was successful.
		return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
	}
	
	

}
