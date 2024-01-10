package ba.minecraft.uniqueweaponry.datagen.recipe;

import java.util.function.Consumer;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import ba.minecraft.uniqueweaponry.common.item.GrenadeItems;

public final class GrenadeItemRecipeProvider extends RecipeProvider {
	
	public GrenadeItemRecipeProvider(DataGenerator dataGen) {
		super(dataGen.getPackOutput());
	}
	
	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
	      ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, GrenadeItems.FLASH_GRENADE.get(), 1)
	      .define('S', Items.SPIDER_EYE)
		  .define('G', Items.GUNPOWDER)
		  .define('R', Items.REDSTONE)
	      .pattern(" R ")
	      .pattern("GSG")
	      .pattern(" G ")
	      .unlockedBy(getHasName(Items.GUNPOWDER), has(Items.GUNPOWDER))
	      .save(consumer);
	}
	
}
