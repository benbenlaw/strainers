package com.benbenlaw.strainers.block.entity.client;

import com.benbenlaw.opolisutilities.util.RenderUtil;
import com.benbenlaw.strainers.block.entity.StrainerTankBlockEntity;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class StrainerTankBlockEntityRenderer implements BlockEntityRenderer<StrainerTankBlockEntity> {

    public StrainerTankBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(StrainerTankBlockEntity entity, float ticks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int light, int overlay) {

        if (!entity.getFluidStack().isEmpty()) {

            FluidStack fluid = entity.getFluidStack();

            VertexConsumer buffer = multiBufferSource.getBuffer(Sheets.translucentCullBlockSheet());

            PoseStack.Pose last = poseStack.last();

            renderFluid(last.pose(), last.normal(),buffer, entity, fluid.getFluid(), entity.FLUID_TANK.getFluidAmount()/ (float) entity.FLUID_TANK.getCapacity(), light);
        }

    }

    private static void renderFluid(Matrix4f pose, Matrix3f normal, VertexConsumer consumer, BlockEntity entity, Fluid fluid, float fillAmount, int packedLight) {
        int color = IClientFluidTypeExtensions.of(fluid).getTintColor(fluid.defaultFluidState(), entity.getLevel(), entity.getBlockPos());
        //if (color == -1) color = 0xffffff;
        renderFluid(pose, normal, consumer, fluid, fillAmount, color, packedLight);
    }


    public static void renderFluid(Matrix4f pose, Matrix3f normal, VertexConsumer consumer, Fluid fluid, float fillAmount, int color, int packedLight) {
        // Get fluid texture
        IClientFluidTypeExtensions props = IClientFluidTypeExtensions.of(fluid);
        TextureAtlasSprite texture = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(props.getStillTexture());

        // Get sizes
        float fluidHeight = (14 * fillAmount) / 16.0f;
        float inset = 0.0625F;
        float faceSize = 14 / 16.0f;


        // Top
        RenderUtil.renderFace(Direction.UP, pose, normal, consumer, texture, inset, inset, inset + fluidHeight, faceSize, faceSize, color, packedLight);

        // Sides
        RenderUtil.renderFace(Direction.SOUTH, pose, normal, consumer, texture, inset, inset, inset, faceSize, fluidHeight, color, packedLight);
        RenderUtil.renderFace(Direction.NORTH, pose, normal, consumer, texture, inset, inset, inset, faceSize, fluidHeight, color, packedLight);
        RenderUtil.renderFace(Direction.EAST, pose, normal, consumer, texture, inset, inset, inset, faceSize, fluidHeight, color, packedLight);
        RenderUtil.renderFace(Direction.WEST, pose, normal, consumer, texture, inset, inset, inset, faceSize, fluidHeight, color, packedLight);
    }









}
