package net.v40955.v40955_amogus_mod;


import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.v40955.v40955_amogus_mod.item.ModItems;
import net.v40955.v40955_amogus_mod.loot.MobLootModifiers;
import org.slf4j.Logger;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(v40955_amogus_mod.MOD_ID)
public class v40955_amogus_mod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "v40955_amogus_mod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public v40955_amogus_mod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);


        MobLootModifiers.register(modEventBus);


        modEventBus.addListener(this::commonSetup);


        MinecraftForge.EVENT_BUS.register(this);


        modEventBus.addListener(this::addCreative);


        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.RED_AMOGUS);
            event.accept(ModItems.AMOGUS_SPAWN_EGG);
        }

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {


    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }

    // An example config class. This is not required, but it's a good idea to have one to keep your config organized.
    // Demonstrates how to use Forge's config APIs
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Config
    {
        private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

        private static final ForgeConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER
                .comment("Whether to log the dirt block on common setup")
                .define("logDirtBlock", true);

        private static final ForgeConfigSpec.IntValue MAGIC_NUMBER = BUILDER
                .comment("A magic number")
                .defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);

        public static final ForgeConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
                .comment("What you want the introduction message to be for the magic number")
                .define("magicNumberIntroduction", "The magic number is... ");

        // a list of strings that are treated as resource locations for items
        private static final ForgeConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
                .comment("A list of items to log on common setup.")
                .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), Config::validateItemName);

        static final ForgeConfigSpec SPEC = BUILDER.build();

        public static boolean logDirtBlock;
        public static int magicNumber;
        public static String magicNumberIntroduction;
        public static Set<Item> items;

        private static boolean validateItemName(final Object obj)
        {
            return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));
        }

        @SubscribeEvent
        static void onLoad(final ModConfigEvent event)
        {
            logDirtBlock = LOG_DIRT_BLOCK.get();
            magicNumber = MAGIC_NUMBER.get();
            magicNumberIntroduction = MAGIC_NUMBER_INTRODUCTION.get();

            // convert the list of strings into a set of items
            items = ITEM_STRINGS.get().stream()
                    .map(itemName -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemName)))
                    .collect(Collectors.toSet());
        }
    }
}
