package net.v40955.v40955_amogus_mod.event;


import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.v40955.v40955_amogus_mod.entity.ModEntities;
import net.v40955.v40955_amogus_mod.entity.custom.AmogusEntity;
import net.v40955.v40955_amogus_mod.v40955_amogus_mod;

@Mod.EventBusSubscriber(modid = v40955_amogus_mod.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.AMOGUS.get(), AmogusEntity.createAttribuites().build());
    }

}
