package com.dragonofshuu.naturality.item;
import com.dragonofshuu.naturality.NaturalityMod;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, NaturalityMod.MODID);
    
    public static final RegistryObject<Item> TOFITE = ITEMS.register("tofite", 
    () -> new Item
            (new Item.Properties()
                .food(new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationMod(3)
                    .build()
                )
                .tab(CreativeModeTab.TAB_FOOD)
            )
        );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
