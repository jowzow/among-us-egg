package net.v40955.v40955_amogus_mod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

import net.v40955.v40955_amogus_mod.entity.custom.AmogusEntity;
import net.v40955.v40955_amogus_mod.v40955_amogus_mod;

public class AmogusRenderer extends MobRenderer<AmogusEntity, amogus<AmogusEntity>>{


    public AmogusRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new amogus<>(pContext.bakeLayer(ModModelLayers.AMOGUS_LAYER)), 0.5f);
    }

    @Override
    public void render(AmogusEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()){
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }



        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(AmogusEntity pEntity) {
        return new ResourceLocation(v40955_amogus_mod.MOD_ID, "textures/entity/texture_amogus.png");
    }
}
