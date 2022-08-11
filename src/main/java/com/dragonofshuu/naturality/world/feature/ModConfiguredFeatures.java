package com.dragonofshuu.naturality.world.feature;

import java.util.List;

import com.dragonofshuu.naturality.NaturalityMod;
import com.dragonofshuu.naturality.block.ModBlocks;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModConfiguredFeatures {
    
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = 
        DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, NaturalityMod.MODID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_TOFITE_ORES = Suppliers.memoize(() -> List.of(
        OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TOFITE_ORE.get().defaultBlockState()),
        OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TOFITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_TOFITE_ORES = Suppliers.memoize(() -> List.of(
        OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHERRACK_TOFITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> END_TOFITE_ORES = Suppliers.memoize(() -> List.of(
        OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.ENDSTONE_TOFITE_ORE.get().defaultBlockState())
    ));

    public static final RegistryObject<ConfiguredFeature<?, ?>> TOFITE_ORE = CONFIGURED_FEATURES.register("tofite_ore", 
        () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_TOFITE_ORES.get(), 7)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_TOFITE_ORE = CONFIGURED_FEATURES.register("nether_tofite_ore", 
        () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_TOFITE_ORES.get(), 9)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> END_TOFITE_ORE = CONFIGURED_FEATURES.register("end_tofite_ore", 
        () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(END_TOFITE_ORES.get(), 9)));

    public static void register(IEventBus bus) {
        CONFIGURED_FEATURES.register(bus);
    }
}
