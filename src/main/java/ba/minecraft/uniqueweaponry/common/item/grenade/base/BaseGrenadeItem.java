package ba.minecraft.uniqueweaponry.common.item.grenade.base;

import ba.minecraft.uniqueweaponry.common.entity.grenade.base.BaseGrenadeEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class BaseGrenadeItem<T extends BaseGrenadeEntity> extends Item {

	public BaseGrenadeItem() {
		super(createProperties());
	}

	private static Properties createProperties() {
		Properties properties = new Properties();
		properties.stacksTo(MAX_STACK_SIZE);
		return properties;
	}
	
	public abstract T CreateEntity(Level level, LivingEntity thrower);

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player thrower, InteractionHand usedHand) {
	    
		ItemStack itemstack = thrower.getItemInHand(usedHand);
	      
	      level.playSound((Player)null, thrower.getX(), thrower.getY(), thrower.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));

	      if (!level.isClientSide) {
	          T grenade = CreateEntity(level, thrower);
	          grenade.setItem(itemstack);
	          grenade.shootFromRotation(thrower, thrower.getXRot(), thrower.getYRot(), 0.0F, 3.0F, 2.0F);

	          //snowball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
          	  
	          level.addFreshEntity(grenade);
	       }
	      
	      thrower.awardStat(Stats.ITEM_USED.get(this));
	      
	      if (!thrower.getAbilities().instabuild) {
	         itemstack.shrink(1);
	      }

	      return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}
	
	
}
