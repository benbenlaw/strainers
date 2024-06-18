package com.benbenlaw.strainers.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class StrainersConfigFile {

    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.ConfigValue<Boolean> showMeshesInWorld;
    public static final ModConfigSpec.ConfigValue<Boolean> showItemBeingStrainerInWorld;


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
