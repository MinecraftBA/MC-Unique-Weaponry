package ba.minecraft.uniqueweaponry.common.item.gun;

import ba.minecraft.uniqueweaponry.common.entity.projectile.CobwebProjectileEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Inventory;
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
	public InteractionResultHolder<ItemStack> use(Level level, Player shooter, InteractionHand usedHand) {

		// Get reference to a gun that was used.
		ItemStack gun = shooter.getItemInHand(usedHand);

		boolean hasCobWeb = false;
		
		// IF: Shooter is not in creative mode.
		if (!shooter.getAbilities().instabuild) {

			// Get reference to shooter inventory.
			Inventory inventory = shooter.getInventory();

			// Iterate through all items in inventory.
			for(ItemStack itemStack : inventory.items) {
				
				// IF: Item stack is stack of cobweb.
				if(itemStack.is(Items.COBWEB)){
					
					// Reduce quantity of stack by 1.
					itemStack.shrink(1);
					
					// We set variable to true to indicate that cobweb was found in inventory.
					hasCobWeb = true;
					
					// Break the for loop.
					break;
				}
			}

		}
		
		// IF: Cobweb was not found.
		if(!hasCobWeb) {
			// Indicate that use was not successful.
			return InteractionResultHolder.fail(gun);
		}
		
		// Play throwing sound.
		level.playSound((Player)null, shooter.getX(), shooter.getY(), shooter.getZ(), SoundEvents.FISHING_BOBBER_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
		
		// IF: Code is executing on server side.
		if (!level.isClientSide) {

			// Create instance of grenade entity.
			CobwebProjectileEntity cobweb = new CobwebProjectileEntity(level, shooter);;
			
			// Shoot grenade.
			cobweb.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0.0F, 4.0F, 0.0F);
          	  
			// Add it to the level.
			level.addFreshEntity(cobweb);
		}
		      
		// Award stat that item is used.
		shooter.awardStat(Stats.ITEM_USED.get(this));

		// Incidate that use was successful.
		return InteractionResultHolder.sidedSuccess(gun, level.isClientSide());
	}
	
	

}
