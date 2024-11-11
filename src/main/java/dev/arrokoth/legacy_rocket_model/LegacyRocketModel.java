package dev.arrokoth.legacy_rocket_model;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = LegacyRocketModel.MOD_ID, name = LegacyRocketModel.NAME, version = LegacyRocketModel.VERSION, dependencies = "required-after:galacticraftplanets")
public class LegacyRocketModel {
    public static final String MOD_ID = "legacy_rocket_model";
    public static final String NAME = "Legacy rocket model";
    public static final String VERSION = "1.0.0";

    @SideOnly(Side.CLIENT)
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ClientModelReplacer.replace();
    }

    @SideOnly(Side.CLIENT)
    @EventHandler
    public void init(FMLInitializationEvent event) {
    }
}
