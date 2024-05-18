package ba.minecraft.uniqueweaponry.datagen.recipe;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

import ba.minecraft.uniqueweaponry.common.item.GrenadeItems;
import ba.minecraft.uniqueweaponry.common.item.GunItems;

public final class ModItemRecipeProvider extends RecipeProvider {
	
	public ModItemRecipeProvider(DataGenerator dataGen, CompletableFuture<Provider> lookupProvider) {
		super(dataGen.getPackOutput(), lookupProvider);
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
