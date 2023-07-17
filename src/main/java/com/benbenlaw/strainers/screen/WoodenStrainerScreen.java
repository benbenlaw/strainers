package com.benbenlaw.strainers.screen;

import com.benbenlaw.strainers.Strainers;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class WoodenStrainerScreen extends AbstractContainerScreen<WoodenStrainerMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Strainers.MOD_ID, "textures/gui/wooden_strainer_gui.png");

    public WoodenStrainerScreen(WoodenStrainerMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(@NotNull GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, this.imageWidth, this.imageHeight);

    //    if(menu.isCrafting()) {
    //        guiGraphics.blit(TEXTURE, x + 85, y + 41, 176, 0, 8, menu.getScaledProgress());
    //    }

        if (menu.isCrafting()) {
            int l = this.menu.getScaledProgress()   ;
            guiGraphics.blit(TEXTURE, x + 85, y + 35, 176, 14, menu.getScaledProgress() + 1, 16);
        }


    }




}
