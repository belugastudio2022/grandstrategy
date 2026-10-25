package com.example.grandstrategy.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.TranslationTextComponent;

/**
 * Starter realm-management screen. The labels and tab bar are placeholders for later steps.
 */
public class RealmOverviewScreen extends Screen {
    private static final int PANEL_WIDTH = 360;
    private static final int PANEL_HEIGHT = 190;

    public RealmOverviewScreen() {
        super(new TranslationTextComponent("screen.grandstrategy.realm_overview.title"));
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        // Dim the game world, then draw a dark panel with a subtle border.
        this.renderBackground(matrixStack);

        final int left = (this.width - PANEL_WIDTH) / 2;
        final int top = (this.height - PANEL_HEIGHT) / 2;
        final int right = left + PANEL_WIDTH;
        final int bottom = top + PANEL_HEIGHT;

        fill(matrixStack, left - 1, top - 1, right + 1, bottom + 1, 0xFF596575);
        fill(matrixStack, left, top, right, bottom, 0xF0121720);

        drawCenteredString(matrixStack, this.font, this.title,
                this.width / 2, top + 12, 0xFFFFFFFF);

        // Header divider.
        fill(matrixStack, left + 12, top + 31, right - 12, top + 32, 0xFF394454);

        // Placeholder tabs. They are labels only in Step 1; click behaviour comes later.
        final int tabY = top + 43;
        drawString(matrixStack, this.font,
                new TranslationTextComponent("gui.grandstrategy.realm_overview.tab.overview"),
                left + 14, tabY, 0xFFFFFFFF);
        drawString(matrixStack, this.font,
                new TranslationTextComponent("gui.grandstrategy.realm_overview.tab.economy"),
                left + 101, tabY, 0xFFB9C4D2);
        drawString(matrixStack, this.font,
                new TranslationTextComponent("gui.grandstrategy.realm_overview.tab.diplomacy"),
                left + 184, tabY, 0xFFB9C4D2);
        drawString(matrixStack, this.font,
                new TranslationTextComponent("gui.grandstrategy.realm_overview.tab.military"),
                left + 278, tabY, 0xFFB9C4D2);

        fill(matrixStack, left + 12, top + 62, right - 12, top + 63, 0xFF303A48);

        drawString(matrixStack, this.font,
                new TranslationTextComponent("gui.grandstrategy.realm_overview.welcome"),
                left + 14, top + 79, 0xFFE8EDF5);
        drawString(matrixStack, this.font,
                new TranslationTextComponent("gui.grandstrategy.realm_overview.hint"),
                left + 14, top + 98, 0xFFAFBAC8);
        drawString(matrixStack, this.font,
                new TranslationTextComponent("gui.grandstrategy.realm_overview.placeholder"),
                left + 14, top + 121, 0xFF8996A7);

        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    /** Keep the world running while this non-container strategy screen is open. */
    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
