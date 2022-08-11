package com.dragonofshuu.naturality.block;

import com.dragonofshuu.naturality.NaturalityMod;
import com.dragonofshuu.naturality.item.ModItems;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import com.google.common.base.Supplier;

import java.util.function.Function;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = 
        DeferredRegister.create(ForgeRegistries.BLOCKS, NaturalityMod.MODID);
    public static final DeferredRegister<Item> ITEMS = ModItems.ITEMS;


    // --- Items ---
    public static final RegistryObject<Block> TOFITE_ORE = register(
        "tofite_ore", 
        () -> new TofiteOre(BlockBehaviour.Properties
                .of(Material.STONE, MaterialColor.COLOR_PURPLE)
                .sound(SoundType.STONE)
                .strength(3)
                .requiresCorrectToolForDrops()
            ), 
        object -> () -> new BlockItem(object.get(), new Item.Properties()
            .tab(CreativeModeTab.TAB_BUILDING_BLOCKS)
            .food(new FoodProperties.Builder()
                .nutrition(2)
                .saturationMod(0)
                .build()
                )
            )
        );

    public static final RegistryObject<Block> DEEPSLATE_TOFITE_ORE = register(
        "deepslate_tofite_ore", 
        () -> new TofiteOre(BlockBehaviour.Properties
                .of(Material.STONE, MaterialColor.COLOR_PURPLE)
                .sound(SoundType.STONE)
                .strength(5.0F, 4.0F)
                .requiresCorrectToolForDrops()
            ), 
        object -> () -> new BlockItem(object.get(), new Item.Properties()
            .tab(CreativeModeTab.TAB_BUILDING_BLOCKS)
            .food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(0)
                .build()
                )
            )
        );

    public static final RegistryObject<Block> NETHERRACK_TOFITE_ORE = register(
    "netherrack_tofite_ore", 
    () -> new TofiteOre(BlockBehaviour.Properties
            .of(Material.STONE, MaterialColor.NETHER)
            .sound(SoundType.STONE)
            .strength(5.0F, 4.0F)
            .requiresCorrectToolForDrops()
        ), 
    object -> () -> new BlockItem(object.get(), new Item.Properties()
        .tab(CreativeModeTab.TAB_BUILDING_BLOCKS)
        .food(new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0)
            .build()
            )
        )
    );    

    public static final RegistryObject<Block> ENDSTONE_TOFITE_ORE = register(
        "endstone_tofite_ore", 
        () -> new TofiteOre(BlockBehaviour.Properties
                .of(Material.STONE, MaterialColor.SAND)
                .sound(SoundType.STONE)
                .strength(5.0F, 4.0F)
                .requiresCorrectToolForDrops()
            ), 
        object -> () -> new BlockItem(object.get(), new Item.Properties()
            .tab(CreativeModeTab.TAB_BUILDING_BLOCKS)
            .food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0)
                .build()
                )
            )
        );  

    public static final RegistryObject<Block> TOFITE_BLOCK = register(
        "tofite_block", 
        () -> new Block(BlockBehaviour.Properties
                .of(Material.METAL, MaterialColor.COLOR_PURPLE)
                .sound(SoundType.STONE)
                .strength(5)
                .requiresCorrectToolForDrops()
            ), 
        object -> () -> new BlockItem(object.get(), new Item.Properties()
            .tab(CreativeModeTab.TAB_BUILDING_BLOCKS)
            .food(new FoodProperties.Builder()
                .nutrition(20)
                .saturationMod(10)
                .build()
                )
            )
        );

    // --- Default stuff ---
    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block) {
		return BLOCKS.register(name, block);
	}
	
	private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block, 
			Function<RegistryObject<T>, Supplier<? extends Item>> item ) {
		RegistryObject<T> obj = registerBlock(name, block);
		ITEMS.register(name, item.apply(obj));
		return obj;
	}

    public static void registerToBus(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}