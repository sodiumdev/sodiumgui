package sodiumdev.gui.event.gui;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import sodiumdev.gui.base.Gui;
import sodiumdev.gui.base.OpenGui;
import sodiumdev.gui.event.GuiEvent;
import sodiumdev.gui.event.GuiHandlerList;

public class ClickedOnGuiItemEvent extends GuiEvent {
    private final ItemStack item;
    private final OpenGui gui;

    public ClickedOnGuiItemEvent(OpenGui gui, ItemStack item) {
        this.gui = gui;
        this.item = item;
    }

    private static final GuiHandlerList HANDLERS = new GuiHandlerList();

    public static GuiHandlerList getHandlerList() {
        return HANDLERS;
    }

    public ItemStack getItem() {
        return this.item;
    }

    public OpenGui getGui() {
        return this.gui;
    }

    @Override
    public @NotNull GuiHandlerList getHandlers() {
        return HANDLERS;
    }
}
