package dev.arrokoth.legacy_rocket_model;

import micdoodle8.mods.galacticraft.api.prefab.entity.EntitySpaceshipBase;
import micdoodle8.mods.galacticraft.core.client.render.entities.RenderTier1Rocket;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

/**
 * @author Arrokoth
 * @project LegacyRocketModel
 * @copyright Copyright © 2024 Arrokoth All Rights Reserved.
 */

@SideOnly(Side.CLIENT)
public class LegacyRenderTier2Rocket extends Render<EntitySpaceshipBase> {
    private ResourceLocation rocketTexture;

    protected ModelBase modelRocket;

    public LegacyRenderTier2Rocket(RenderManager manager, ModelBase spaceshipModel, String textureDomain, String texture) {
        this(manager, new ResourceLocation(textureDomain, "textures/model/" + texture + ".png"));
        this.modelRocket = spaceshipModel;
    }

    private LegacyRenderTier2Rocket(RenderManager manager, ResourceLocation texture) {
        super(manager);
        this.rocketTexture = texture;
        this.shadowSize = 0.9F;
    }

    @Override
    public void doRender(EntitySpaceshipBase entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GL11.glPushMatrix();
        float var24 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks;
        float var25 = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks;
        GL11.glTranslatef((float)x, (float)y + 1.5F + 2 / 16F, (float)z);
        GL11.glRotatef(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-var24, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(-var25, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(0.0F, entity.getRenderOffsetY(), 0.0F);
        float var28 = entity.rollAmplitude - partialTicks;
        if (var28 > 0.0F) {
            float i = entity.getLaunched() ? (float)(5 - MathHelper.floor((float)(entity.timeUntilLaunch / 85))) / 10.0F : 0.3F;
            GL11.glRotatef(MathHelper.sin(var28) * var28 * i * partialTicks, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(MathHelper.sin(var28) * var28 * i * partialTicks, 1.0F, 0.0F, 1.0F);
        }

        this.bindEntityTexture(entity);
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        this.modelRocket.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();

    }

    public boolean shouldRender(EntitySpaceshipBase rocket, ICamera camera, double camX, double camY, double camZ) {
        AxisAlignedBB axisalignedbb = rocket.getRenderBoundingBox().grow(0.6, 1.0, 0.6);
        return rocket.isInRangeToRender3d(camX, camY, camZ) && camera.isBoundingBoxInFrustum(axisalignedbb);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySpaceshipBase entity) {
        return rocketTexture;
    }
}
