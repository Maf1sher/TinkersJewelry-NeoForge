package dev.ferriarnus.tinkersjewelry.client;

import dev.ferriarnus.tinkersjewelry.GemAttributes;
import dev.ferriarnus.tinkersjewelry.menu.SubSpaceMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

public class SubSpaceScreen extends AbstractContainerScreen<SubSpaceMenu> {
    private static final ResourceLocation CONTAINER_BACKGROUND = ResourceLocation.parse("textures/gui/container/generic_54.png");
    private int containerRows;

    public SubSpaceScreen(SubSpaceMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        containerRows = Mth.floor(playerInventory.player.getAttribute(GemAttributes.SUBSPACE).getValue());
        this.imageHeight = 114 + this.containerRows * 18;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics, mouseX, mouseY);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(CONTAINER_BACKGROUND, i, j, 0, 0, this.imageWidth, this.containerRows * 18 + 17);
        guiGraphics.blit(CONTAINER_BACKGROUND, i, j + this.containerRows * 18 + 17, 0, 126, this.imageWidth, 96);
    }
}
