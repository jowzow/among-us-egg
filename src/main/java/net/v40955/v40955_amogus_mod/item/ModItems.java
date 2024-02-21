package net.v40955.v40955_amogus_mod.item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.v40955.v40955_amogus_mod.v40955_amogus_mod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, v40955_amogus_mod.MOD_ID);
    public static final RegistryObject<Item>RED_AMOGUS = ITEMS.register("red_amogus",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item>AMOGUS_SPAWN_EGG = ITEMS.register("amogus_spawn_egg",
            () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
