package net.v40955.v40955_amogus_mod.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.v40955.v40955_amogus_mod.entity.client.ModModelLayers;
import net.v40955.v40955_amogus_mod.entity.client.amogus;
import net.v40955.v40955_amogus_mod.v40955_amogus_mod;

@Mod.EventBusSubscriber(modid = v40955_amogus_mod.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD,value= Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.AMOGUS_LAYER, amogus::createBodyLayer);
    }

}
