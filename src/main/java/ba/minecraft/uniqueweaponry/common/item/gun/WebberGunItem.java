package ba.minecraft.uniqueweaponry.common.item.gun;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.item.ItemEntity;
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
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
		ItemStack itemStack = new ItemStack(Items.COBWEB,1);
		
		ItemEntity entity = new ItemEntity(itemStack);
		
		return super.use(pLevel, pPlayer, pUsedHand);
	}
	
	

}
