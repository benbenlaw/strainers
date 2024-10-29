package com.benbenlaw.strainers.block.entity.client;

import com.benbenlaw.opolisutilities.util.RenderUtil;
import com.benbenlaw.strainers.block.entity.StrainerTankBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.material.Fluid;

import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class StrainerTankBlockEntityRenderer implements BlockEntityRenderer<StrainerTankBlockEntity> {

    public StrainerTankBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(StrainerTankBlockEntity entity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {

        FluidTank fluidTank = entity.FLUID_TANK;
        if (!fluidTank.isEmpty()) {
            FluidStack fluidStack = fluidTank.getFluid();
            VertexConsumer buffer = pBufferSource.getBuffer(Sheets.translucentCullBlockSheet());
            PoseStack.Pose last = pPoseStack.last();
            renderFluid(last, buffer, entity, fluidStack.getFluid(), fluidTank.getFluidAmount() / (float) fluidTank.getCapacity(), pPackedLight);
        }

    }

    private static void renderFluid(PoseStack.Pose pose, VertexConsumer consumer, BlockEntity entity, Fluid fluid, float fillAmount, int packedLight) {
        int color = IClientFluidTypeExtensions.of(fluid).getTintColor(fluid.defaultFluidState(), entity.getLevel(), entity.getBlockPos());
        //if (color == -1) color = 0xffffff;
        renderFluid(pose, consumer, fluid, fillAmount, color, packedLight);
    }



    public static void renderFluid(PoseStack.Pose pose, VertexConsumer consumer, Fluid fluid, float fillAmount, int color, int packedLight) {
        // Get fluid texture
        IClientFluidTypeExtensions props = IClientFluidTypeExtensions.of(fluid);
        TextureAtlasSprite texture = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(props.getStillTexture());

        float fluidHeight = (14 * fillAmount) / 16.0f;
        float inset = 0.0625F;
        float faceSize = 14 / 16.0f;

        // Sides
        RenderUtil.renderFace(Direction.SOUTH, pose, consumer, texture, inset, inset, inset, faceSize, fluidHeight, color, packedLight);
        RenderUtil.renderFace(Direction.NORTH, pose, consumer, texture, inset, inset, inset, faceSize, fluidHeight, color, packedLight);
        RenderUtil.renderFace(Direction.EAST, pose, consumer, texture, inset, inset, inset, faceSize, fluidHeight, color, packedLight);
        RenderUtil.renderFace(Direction.WEST, pose, consumer, texture, inset, inset, inset, faceSize, fluidHeight, color, packedLight);
        RenderUtil.renderFace(Direction.UP, pose, consumer, texture, inset, inset, inset + fluidHeight, faceSize, faceSize, color, packedLight);

        RenderUtil.renderFace(Direction.DOWN, pose, consumer, texture, inset, inset, 1 - inset , faceSize, faceSize, color, packedLight);

    }

}
