package ba.minecraft.uniqueweaponry.common.item.gun;

import ba.minecraft.uniqueweaponry.common.entity.projectile.CobwebProjectileEntity;
import ba.minecraft.uniqueweaponry.common.helpers.ModResourceKey;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class WebberItem extends Item {

	// Defines that this item will be registered as uniqueweaponry:webber
	private static final ResourceKey<Item> RES_KEY = ModResourceKey.createItemKey("webber");

	public WebberItem() {
		super(createProperties());
	}

	private static Properties createProperties() {
		Properties properties = new Properties();
		properties.setId(RES_KEY);
		properties.stacksTo(1);
		return properties;
	}

	@Override
	public InteractionResult use(Level level, Player shooter, InteractionHand usedHand) {

		// Get reference to shooter inventory.
		Inventory inventory = shooter.getInventory();

		ItemStack cobWebItemStack = null;
		
		// Iterate through all items in inventory.
		for(ItemStack itemStack : inventory.items) {
			
			// IF: Item stack is stack of cobweb.
			if(itemStack.is(Items.COBWEB)){

				// Save reference to found CobWeb item stack.
				cobWebItemStack = itemStack;

				// IF: It is not creative mode.
				if(!shooter.getAbilities().instabuild) {
					
					// Reduce quantity of stack by 1.
					itemStack.shrink(1);

				} 
				
				// Break the for loop.
				break;
			}
		}
		
		// IF: Cobweb was not found.
		if(cobWebItemStack == null) {
			// Indicate that use was not successful.
			return InteractionResult.FAIL;
		}
		
		// Play throwing sound.
		level.playSound((Player)null, shooter.getX(), shooter.getY(), shooter.getZ(), SoundEvents.FISHING_BOBBER_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
		
		// IF: Code is executing on server side.
		if (!level.isClientSide) {

			// Create instance of grenade entity.
			CobwebProjectileEntity cobweb = new CobwebProjectileEntity(level, shooter, cobWebItemStack);
			
			// Shoot grenade.
			cobweb.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0.0F, 4.0F, 0.0F);
          	  
			// Add it to the level.
			level.addFreshEntity(cobweb);
		}
		      
		// Award stat that item is used.
		shooter.awardStat(Stats.ITEM_USED.get(this));

		// Incidate that use was successful.
		return InteractionResult.SUCCESS;
	}
	
	

}
