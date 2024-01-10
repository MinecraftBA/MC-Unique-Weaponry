package ba.minecraft.uniqueweaponry.common.item.grenade;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import ba.minecraft.uniqueweaponry.common.entity.grenade.FlashGrenadeEntity;

public abstract class BaseGrenadeItem extends Item {

	public BaseGrenadeItem() {
		super(createProperties());
	}

	private static Properties createProperties() {
		Properties properties = new Properties();
		properties.stacksTo(MAX_STACK_SIZE);
		return properties;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
	    
		ItemStack itemstack = player.getItemInHand(usedHand);
	      
	      level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));

	      if (!level.isClientSide) {
	          FlashGrenadeEntity grenade = new FlashGrenadeEntity(level, player);
	          grenade.setItem(itemstack);
	          grenade.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 2.0F);

	          //snowball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
          	  
	          level.addFreshEntity(grenade);
	       }
	      
	      player.awardStat(Stats.ITEM_USED.get(this));
	      
	      if (!player.getAbilities().instabuild) {
	         itemstack.shrink(1);
	      }

	      return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}
	
	
}
