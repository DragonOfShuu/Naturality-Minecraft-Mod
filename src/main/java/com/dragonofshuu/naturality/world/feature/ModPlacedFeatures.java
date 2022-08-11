package com.dragonofshuu.naturality.world.feature;

import java.util.List;

import com.dragonofshuu.naturality.NaturalityMod;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = 
        DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, NaturalityMod.MODID);

    public static final RegistryObject<PlacedFeature> TOFITE_ORE = PLACED_FEATURES.register("tofite_ore_placed", 
        () -> new PlacedFeature(ModConfiguredFeatures.TOFITE_ORE.getHolder().get(),
            commonOrePlacement(7, // Veins per chunk
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-54), VerticalAnchor.absolute(80)) // Height range
    )));
    
    public static final RegistryObject<PlacedFeature> NETHER_TOFITE_ORE = PLACED_FEATURES.register("nether_tofite_ore_placed", 
        () -> new PlacedFeature(ModConfiguredFeatures.NETHER_TOFITE_ORE.getHolder().get(),
            commonOrePlacement(7, // Veins per chunk
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-54), VerticalAnchor.absolute(80)) // Height range
    )));

    public static final RegistryObject<PlacedFeature> END_TOFITE_ORE = PLACED_FEATURES.register("end_tofite_ore_placed", 
        () -> new PlacedFeature(ModConfiguredFeatures.END_TOFITE_ORE.getHolder().get(),
            commonOrePlacement(7, // Veins per chunk
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-54), VerticalAnchor.absolute(80)) // Height range
    )));

    // Vanilla functions
    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    // Get da ores on da bus
    public static void register(IEventBus bus) {
        PLACED_FEATURES.register(bus);
    }
}
