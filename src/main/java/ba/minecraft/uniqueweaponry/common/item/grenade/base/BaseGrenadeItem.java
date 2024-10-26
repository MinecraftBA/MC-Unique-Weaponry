package ba.minecraft.uniqueweaponry.common.item.grenade.base;

import ba.minecraft.uniqueweaponry.common.entity.grenade.base.BaseGrenadeEntity;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;

public abstract class BaseGrenadeItem<T extends BaseGrenadeEntity> extends Item implements ProjectileItem {

	public BaseGrenadeItem() {
		super(createProperties());
	}

	private static Properties createProperties() {
		Properties properties = new Properties();
		properties.stacksTo(16);
		return properties;
	}

	public abstract T CreateEntity(LivingEntity thrower, Level level);
	
	public abstract T CreateEntity(double x, double y, double z, Level level, ItemStack itemStack);

	@Override
	public InteractionResult use(Level level, Player thrower, InteractionHand usedHand) {

		// Get reference to grenade held in hand.
		ItemStack itemStack = thrower.getItemInHand(usedHand);

		// Play throwing sound.
		level.playSound((Player) null, thrower.getX(), thrower.getY(), thrower.getZ(), SoundEvents.TRIDENT_THROW,
				SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));

		// IF: Code is executing on server side.
		if (!level.isClientSide) {

			// Create instance of grenade entity.
			T grenade = CreateEntity(thrower, level);

			// Set grenade item that is being thrown.
			grenade.setItem(itemStack);

			// Shoot grenade.
			grenade.shootFromRotation(thrower, thrower.getXRot(), thrower.getYRot(), 0.0F, 1.5F, 1.0F);

			// Add it to the level.
			level.addFreshEntity(grenade);
		}

		// Award stat that item is used.
		thrower.awardStat(Stats.ITEM_USED.get(this));

		// IF: It is not in creative mode.
		if (!thrower.getAbilities().instabuild) {

			// Reduce quantity in inventory by one.
			itemStack.shrink(1);
		}

		// Incidate that use was successful.
		return InteractionResult.SUCCESS;
	}

	@Override
	public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {

		// Create instance of grenade entity.
		T grenade = CreateEntity(position.x(), position.y(), position.z(), level, itemStack);
		
		return grenade;
	}

	
}
