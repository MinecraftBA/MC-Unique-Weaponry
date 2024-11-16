package ba.minecraft.uniqueweaponry.common.helpers;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

public final class ModResourceKey {

    public static ResourceKey<EntityType<?>> createEntityTypeKey(String resLocId) {
        return ResourceKey.create(Registries.ENTITY_TYPE, ModResourceLocation.Create(resLocId));
    }
    
    public static ResourceKey<Item> createItemKey(String resLocId) {
        return ResourceKey.create(Registries.ITEM, ModResourceLocation.Create(resLocId));
    }
    
}
