package net.cloudedarctrooper.templar_addons_mod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.cloudedarctrooper.templar_addons_mod.TemplarAddonsMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ManaInfusionStationScreen extends AbstractContainerScreen<ManaInfusionStationMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(TemplarAddonsMod.MODID, "textures/gui/mana_infusion_station.png");

    private static final ResourceLocation REPEAT_BUTTON_DEFAULT =
            new ResourceLocation(TemplarAddonsMod.MODID, "textures/gui/sprites/container/repeat_button_unselected.png");

    private static final ResourceLocation REPEAT_BUTTON_MOUSE =
            new ResourceLocation(TemplarAddonsMod.MODID, "textures/gui/sprites/container/repeat_button_selected.png");

    private static final ResourceLocation REPEAT_BUTTON_SELECT =
            new ResourceLocation(TemplarAddonsMod.MODID, "textures/gui/sprites/container/repeat_button_highlighted.png");

    public ManaInfusionStationScreen(ManaInfusionStationMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelX = 8 - SCREEN_X_OFFSET;
        this.inventoryLabelY = this.cImageHeight - 94 - SCREEN_Y_OFFSET;
        this.titleLabelX = 8 - SCREEN_X_OFFSET;
        this.titleLabelY = 6 - SCREEN_Y_OFFSET;
    }


    private final int cImageWidth = 234;
    private final int cImageHeight = 245;

    private final int SCREEN_Y_OFFSET = (cImageHeight - imageHeight)/2;
    private final int SCREEN_X_OFFSET = (cImageWidth - imageWidth)/2;

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - cImageWidth) / 2;
        int y = (height - cImageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, cImageWidth, cImageHeight);

        renderProgressBar(guiGraphics, x, y);

        renderManaBars(guiGraphics, x, y);
    }

    private void renderProgressBar(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(TEXTURE, x + 179, y + 91, 0, cImageHeight, menu.getScaledProgress(), 5);
        }
    }

    private void renderManaBars(GuiGraphics guiGraphics, int x, int y) {
        guiGraphics.blit(TEXTURE, x + 207, y + 82-(menu.getScaledT3ManaLevel()), cImageWidth, 40-menu.getScaledT3ManaLevel(), 9, menu.getScaledT3ManaLevel());

        guiGraphics.blit(TEXTURE, x + 193, y + 82-(menu.getScaledT2ManaLevel()), cImageWidth, 81-menu.getScaledT2ManaLevel(), 9, menu.getScaledT2ManaLevel());

        guiGraphics.blit(TEXTURE, x + 179, y + 82-(menu.getScaledT1ManaLevel()), cImageWidth, 122-menu.getScaledT1ManaLevel(), 9, menu.getScaledT1ManaLevel());

    }


    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
