package net.v40955.v40955_amogus_mod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.v40955.v40955_amogus_mod.entity.custom.AmogusEntity;
import net.v40955.v40955_amogus_mod.v40955_amogus_mod;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>>ENTITY_TYPES=
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, v40955_amogus_mod.MOD_ID);
    public static final RegistryObject<EntityType<AmogusEntity>> AMOGUS =
            ENTITY_TYPES.register("amogus", ()-> EntityType.Builder.of(AmogusEntity::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("amogus"));
    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

}
