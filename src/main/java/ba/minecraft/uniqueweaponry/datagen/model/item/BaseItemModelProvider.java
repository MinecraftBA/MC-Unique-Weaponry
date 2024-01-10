package ba.minecraft.uniqueweaponry.datagen.model.item;

import ba.minecraft.uniqueweaponry.common.core.UniqueWeaponryMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class BaseItemModelProvider extends ItemModelProvider {

	public BaseItemModelProvider(DataGenerator dataGen, ExistingFileHelper exFileHelper) {
		super(dataGen.getPackOutput(), UniqueWeaponryMod.MODID, exFileHelper);
	}
	
	protected ItemModelBuilder blockItem(BlockItem item) {
		ResourceLocation registryName = ForgeRegistries.ITEMS.getKey(item);
		String path = registryName.getPath();
		return withExistingParent(path, modLoc("block/" + path));
	}

	protected ItemModelBuilder blockGenerated(BlockItem item) {
		ResourceLocation registryName = ForgeRegistries.ITEMS.getKey(item);
		String path = registryName.getPath();
		ResourceLocation textureLocation = modLoc("block/" + path);
		return withExistingParent(path, mcLoc("item/generated")).texture("layer0", textureLocation);
	}

	protected ItemModelBuilder generated(Item item) {
		ResourceLocation registryName = ForgeRegistries.ITEMS.getKey(item);
		String path = registryName.getPath();
		ResourceLocation textureLocation = modLoc("item/" + path);
		return withExistingParent(path, mcLoc("item/generated")).texture("layer0", textureLocation);
	}

	protected ItemModelBuilder spawnEgg(Item item) {
		ResourceLocation registryName = ForgeRegistries.ITEMS.getKey(item);
		String path = registryName.getPath();
		return withExistingParent(path, mcLoc("item/template_spawn_egg"));
	}

}
