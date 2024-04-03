package com.benbenlaw.strainers.block.entity.client;

import com.benbenlaw.strainers.block.entity.StrainerTankBlockEntity;
import com.benbenlaw.strainers.block.entity.WoodenStrainerBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

import java.util.Objects;

public class StrainerMeshEntityRenderer implements BlockEntityRenderer<WoodenStrainerBlockEntity> {

    public StrainerMeshEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(WoodenStrainerBlockEntity entity, float ticks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int light, int overlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

        ItemStack mesh = entity.getItemStackHandler().getStackInSlot(1);


        if (!mesh.isEmpty()) {
            poseStack.pushPose();

            // Render the mesh item on all four sides of the block
            for (Direction direction : Direction.values()) {
                if (direction == Direction.UP || direction == Direction.DOWN) {
                    continue; // Skip rendering on top and bottom sides
                }

                poseStack.pushPose();
                poseStack.translate(0f, 1.23f, 0f); // Adjust y position for the top side
                poseStack.scale(1.9f,1.9f,1.9f);

                // Apply transformations for rendering on the current side
                switch (direction) {
                    case NORTH:
                        poseStack.translate(0.26, 0.0, 0.02f); // Adjust x position for the north side
                        break;
                    case SOUTH:
                        poseStack.translate(0.26, 0.0, 0.5f); // Adjust x position for the south side
                        break;
                    case WEST:
                        poseStack.translate(0.5, 0.0, 0.26);
                        poseStack.mulPose(new Quaternionf().rotateY((float) Math.toRadians(90)));// Adjust z position for the west side
                        break;
                    case EAST:
                        poseStack.translate(0.02f, 0.0, 0.26); // Adjust z position for the east side
                        poseStack.mulPose(new Quaternionf().rotateY((float) Math.toRadians(-90)));// Adjust z position for the west side

                        break;
                }

                BakedModel model = itemRenderer.getModel(mesh, null, null, 0);
                itemRenderer.render(mesh, ItemDisplayContext.GROUND, false, poseStack, multiBufferSource, getLightLevel(entity.getLevel(), entity.getBlockPos().above()), overlay, model);
                poseStack.popPose();
            }

            poseStack.popPose();
        }
    }


    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }

}
