package com.dragonofshuu.naturality;

import com.dragonofshuu.naturality.block.ModBlocks;
import com.dragonofshuu.naturality.item.ModItems;
import com.dragonofshuu.naturality.world.feature.ModConfiguredFeatures;
import com.dragonofshuu.naturality.world.feature.ModPlacedFeatures;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NaturalityMod.MODID)
public class NaturalityMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "naturality";
    // Directly reference a slf4j logger
    // private static final Logger LOGGER = LogUtils.getLogger();

    public NaturalityMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.registerToBus(modEventBus);
        ModBlocks.registerToBus(modEventBus);

        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    // @SubscribeEvent
    // public void onServerStarting(ServerStartingEvent event)
    // {
    //     // Do something when the server starts
    //     LOGGER.info("HELLO from server starting");
    // }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
