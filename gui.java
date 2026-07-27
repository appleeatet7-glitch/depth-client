package com.yourname.depthsclient.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DepthsMenuScreen extends Screen {

    private static final Text TITLE = Text.literal("Depths Client");
    private int selectedTab = 0;

    private final String[] tabs = new String[] {
            "Combat", "Player", "Render", "Movement", "Misc", "World"
    };

    public DepthsMenuScreen() {
        super(TITLE);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);

        int centerX = this.width / 2;
        int centerY = this.height / 2;

        int panelX = centerX - 210;
        int panelY = centerY - 140;
        int panelW = 420;
        int panelH = 280;

        int bg = 0xFF071421;
        int sidebar = 0xFF0B2238;
        int accent = 0xFF39C7E6;
        int tabIdle = 0xFF12324F;
        int tabActive = 0xFF1D4E78;
        int text = 0xFFEAF7FF;

        // Main panel
        context.fill(panelX, panelY, panelX + panelW, panelY + panelH, bg);
        context.fill(panelX, panelY, panelX + panelW, panelY + 4, accent);

        // Left sidebar
        int sidebarW = 120;
        context.fill(panelX, panelY + 4, panelX + sidebarW, panelY + panelH, sidebar);

        // Title
        context.drawTextWithShadow(this.textRenderer, TITLE, panelX + 140, panelY + 18, text);

        // Tabs
        int tabX = panelX + 12;
        int tabY = panelY + 48;
        int tabH = 26;
        int tabGap = 6;

        for (int i = 0; i < tabs.length; i++) {
            int tabColor = (i == selectedTab) ? tabActive : tabIdle;
            context.fill(tabX, tabY + i * (tabH + tabGap), tabX + 96, tabY + i * (tabH + tabGap) + tabH, tabColor);
            context.drawTextWithShadow(
                    this.textRenderer,
                    tabs[i],
                    tabX + 12,
                    tabY + i * (tabH + tabGap) + 9,
                    text
            );
        }

        // Content area
        int contentX = panelX + sidebarW + 14;
        int contentY = panelY + 48;
        int contentW = panelW - sidebarW - 26;
        int contentH = panelH - 60;

        context.fill(contentX, contentY, contentX + contentW, contentY + contentH, 0xFF0A1A2A);
        context.fill(contentX, contentY, contentX + contentW, contentY + 2, accent);

        context.drawTextWithShadow(
                this.textRenderer,
                Text.literal("Selected Tab: " + tabs[selectedTab]),
                contentX + 14,
                contentY + 14,
                text
        );

        context.drawTextWithShadow(
                this.textRenderer,
                Text.literal("This is a safe client GUI shell."),
                contentX + 14,
                contentY + 34,
                0xFFB5D7E8
        );

        context.drawTextWithShadow(
                this.textRenderer,
                Text.literal("Add toggles, settings, and layouts later."),
                contentX + 14,
                contentY + 50,
                0xFFB5D7E8
        );

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        int panelX = centerX - 210;
        int panelY = centerY - 140;

        int tabX = panelX + 12;
        int tabY = panelY + 48;
        int tabH = 26;
        int tabGap = 6;

        for (int i = 0; i < tabs.length; i++) {
            int y1 = tabY + i * (tabH + tabGap);
            int y2 = y1 + tabH;
            if (mouseX >= tabX && mouseX <= tabX + 96 && mouseY >= y1 && mouseY <= y2) {
                selectedTab = i;
                return true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }
}
