package ba.minecraft.uniqueweaponry.datagen.recipe;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import ba.minecraft.uniqueweaponry.common.item.GrenadeItems;

public final class GrenadeItemRecipeProvider extends RecipeProvider {
	
	public GrenadeItemRecipeProvider(DataGenerator dataGen) {
		super(dataGen.getPackOutput());
	}
	
	@Override
	protected void buildRecipes(RecipeOutput recipeOutput) {

		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, GrenadeItems.FLASH_GRENADE.get(), 1)
	    	.define('D', Items.GLOWSTONE_DUST)
	    	.define('G', Items.GUNPOWDER)
	    	.define('R', Items.REDSTONE)
	    	.define('I', Items.IRON_INGOT)
	    	.pattern(" R ")
	    	.pattern("IDI")
	    	.pattern(" G ")
	    	.unlockedBy(getHasName(Items.GLOWSTONE_DUST), has(Items.GLOWSTONE_DUST))
	    	.save(recipeOutput);
	
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, GrenadeItems.IGNITE_GRENADE.get(), 1)
	    	.define('F', Items.FIRE_CHARGE)
	    	.define('G', Items.GUNPOWDER)
	    	.define('R', Items.REDSTONE)
	    	.define('I', Items.IRON_INGOT)
	    	.pattern(" R ")
	    	.pattern("IFI")
	    	.pattern(" G ")
	    	.unlockedBy(getHasName(Items.FIRE_CHARGE), has(Items.FIRE_CHARGE))
	    	.save(recipeOutput);
		
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, GrenadeItems.FREEZE_GRENADE.get(), 1)
	    	.define('C', Items.ICE)
	    	.define('G', Items.GUNPOWDER)
	    	.define('R', Items.REDSTONE)
	    	.define('I', Items.IRON_INGOT)
	    	.pattern(" R ")
	    	.pattern("ICI")
	    	.pattern(" G ")
	    	.unlockedBy(getHasName(Items.ICE), has(Items.ICE))
	    	.save(recipeOutput);

	}
	
}
