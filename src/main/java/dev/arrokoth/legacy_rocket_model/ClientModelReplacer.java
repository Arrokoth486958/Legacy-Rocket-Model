package dev.arrokoth.legacy_rocket_model;

import micdoodle8.mods.galacticraft.planets.mars.client.model.ModelTier2Rocket;
import micdoodle8.mods.galacticraft.planets.mars.entities.EntityTier2Rocket;
import net.minecraft.client.model.ModelBase;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Arrokoth
 * @project LegacyRocketModel
 * @copyright Copyright © 2024 Arrokoth All Rights Reserved.
 */

@SideOnly(Side.CLIENT)
public class ClientModelReplacer {
    public static void replace() {
        RenderingRegistry.registerEntityRenderingHandler(EntityTier2Rocket.class, manager -> new LegacyRenderTier2Rocket(manager, new ModelTier2Rocket(), "galacticraftplanets", "rocket_t2"));
    }

    private static void replaceModelDefault() {
    }
}
