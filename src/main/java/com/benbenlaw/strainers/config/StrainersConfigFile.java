package com.benbenlaw.strainers.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class StrainersConfigFile {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> showMeshesInWorld;
    public static final ForgeConfigSpec.ConfigValue<Boolean> showItemBeingStrainerInWorld;


    static {
        BUILDER.push("Strainers Config File");

        showMeshesInWorld = BUILDER.comment("Show the strainer meshes in the world, default = true")
                .define("Show Meshes", true);

        showItemBeingStrainerInWorld = BUILDER.comment("Show items in / on the strainer in the world, default = true")
                .define("Show Items ", true);


        BUILDER.pop();
        SPEC = BUILDER.build();

    }
}
