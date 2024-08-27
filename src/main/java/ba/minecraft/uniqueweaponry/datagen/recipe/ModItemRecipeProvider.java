package ba.minecraft.uniqueweaponry.datagen.recipe;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

import ba.minecraft.uniqueweaponry.common.item.BookItems;
import ba.minecraft.uniqueweaponry.common.item.GrenadeItems;
import ba.minecraft.uniqueweaponry.common.item.GunItems;
import ba.minecraft.uniqueweaponry.common.item.StaffItems;

public final class ModItemRecipeProvider extends RecipeProvider {
	
	public ModItemRecipeProvider(PackOutput packOutput, CompletableFuture<Provider> lookupProvider) {
		super(packOutput, lookupProvider);
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
		
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, GrenadeItems.POISON_GRENADE.get(), 1)
	    	.define('S', Items.SPIDER_EYE)
	    	.define('G', Items.GUNPOWDER)
	    	.define('R', Items.REDSTONE)
	    	.define('I', Items.IRON_INGOT)
	    	.pattern(" R ")
	    	.pattern("ISI")
	    	.pattern(" G ")
	    	.unlockedBy(getHasName(Items.SPIDER_EYE), has(Items.SPIDER_EYE))
	    	.save(recipeOutput);
		
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, GrenadeItems.LEVITATE_GRENADE.get(), 1)
	    	.define('O', Items.OBSIDIAN)
	    	.define('G', Items.GUNPOWDER)
	    	.define('R', Items.REDSTONE)
	    	.define('I', Items.IRON_INGOT)
	    	.pattern(" R ")
	    	.pattern("IOI")
	    	.pattern(" G ")
	    	.unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
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
		
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, BookItems.EVOKERS_TOME.get(), 1)
    	.define('B', Items.BOOK)
    	.define('T', Items.TOTEM_OF_UNDYING)
    	.define('A', Items.AMETHYST_SHARD)
    	.define('E', Items.EMERALD)
    	.pattern("   ")
    	.pattern("EAB")
    	.pattern(" T ")
    	.unlockedBy(getHasName(Items.TOTEM_OF_UNDYING), has(Items.TOTEM_OF_UNDYING))
    	.save(recipeOutput);
		
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, StaffItems.SKULLCASTER.get(), 1)
    	.define('W', Items.WITHER_SKELETON_SKULL)
    	.define('N', Items.NETHER_STAR)
    	.define('B', Items.BONE)
    	.define('E', Items.NETHER_BRICK)
    	.pattern(" W ")
    	.pattern("BNB")
    	.pattern(" E ")
    	.unlockedBy(getHasName(Items.NETHER_STAR), has(Items.WITHER_SKELETON_SKULL))
    	.save(recipeOutput);
		
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, StaffItems.INFERNAL_SCEPTER.get(), 1)
    	.define('I', Items.NETHERITE_INGOT)
    	.define('N', Items.NETHER_STAR)
    	.define('W', StaffItems.SKULLCASTER.get())
    	.pattern("INI")
    	.pattern("NWN")
    	.pattern("INI")
    	.unlockedBy(getHasName(Items.NETHERITE_INGOT), has(StaffItems.SKULLCASTER.get()))
    	.save(recipeOutput);
	}
	
}
