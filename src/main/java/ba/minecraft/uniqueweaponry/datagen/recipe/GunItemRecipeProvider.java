package ba.minecraft.uniqueweaponry.datagen.recipe;

import java.util.function.Consumer;

import ba.minecraft.uniqueweaponry.common.item.GrenadeItems;
import ba.minecraft.uniqueweaponry.common.item.GunItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

public class GunItemRecipeProvider extends RecipeProvider {
	
	public GunItemRecipeProvider(DataGenerator dataGen) {
		super(dataGen.getPackOutput());
	}
	
	@Override
	protected void buildRecipes(RecipeOutput recipeOutput) {

		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, GunItems.WEBBER.get(), 1)
	    	.define('S', Items.STRING)
	    	.define('G', Items.GUNPOWDER)
	    	.define('R', Items.REDSTONE)
	    	.define('I', Items.IRON_INGOT)
	    	.pattern(" R ")
	    	.pattern("SGS")
	    	.pattern(" I ")
	    	.unlockedBy(getHasName(Items.STRING), has(Items.STRING))
	    	.save(recipeOutput);
		
	}
	
}
