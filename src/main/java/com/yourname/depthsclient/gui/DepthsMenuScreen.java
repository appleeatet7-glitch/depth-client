package com.yourname.depthsclient.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class DepthsMenuScreen extends Screen {

    public DepthsMenuScreen() {
        super(Text.literal("Depths Client Menu"));
    }

    @Override
    protected void init() {
        super.init();
        // Add buttons and widgets here
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20, 16777215);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }
}
