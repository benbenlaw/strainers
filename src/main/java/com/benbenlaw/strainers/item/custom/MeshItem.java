package com.benbenlaw.strainers.item.custom;

import net.minecraft.world.item.Item;

public class MeshItem extends Item {
    public MeshItem(Properties properties) {
        super(properties);
    }


    // LEGACY MESH TOOLTIP

    /*
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {

        if(Screen.hasShiftDown()) {

            int damage = stack.getMaxDamage();
            MutableComponent tier = null;

            if (stack.is(ModTags.Items.TIER_1_MESHES)) {
                tier = Component.translatable("tooltips.strainers.tier_1_mesh");
            }
            if (stack.is(ModTags.Items.TIER_2_MESHES)) {
                tier = Component.translatable("tooltips.strainers.tier_2_mesh");
            }
            if (stack.is(ModTags.Items.TIER_3_MESHES)) {
                tier = Component.translatable("tooltips.strainers.tier_3_mesh");
            }
            if (stack.is(ModTags.Items.TIER_4_MESHES)) {
                tier = Component.translatable("tooltips.strainers.tier_4_mesh");
            }
            if (stack.is(ModTags.Items.TIER_5_MESHES)) {
                tier = Component.translatable("tooltips.strainers.tier_5_mesh");
            }
            if (stack.is(ModTags.Items.TIER_6_MESHES)) {
                tier = Component.translatable("tooltips.strainers.tier_6_mesh");
            }

            components.add(tier);
            components.add(Component.literal("Max Uses: "+ damage));

        } else {
            components.add(Component.translatable("tooltips.strainers.upgrade"));
        }

        super.appendHoverText(stack, level, components, tooltipFlag);
    }

     */

}
