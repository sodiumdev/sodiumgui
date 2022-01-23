package sodiumdev.gui.event.gui;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Cancellable;
import org.jetbrains.annotations.NotNull;
import sodiumdev.gui.base.OpenGui;
import sodiumdev.gui.base.helper.GuiHelper;
import sodiumdev.gui.event.GuiEvent;
import sodiumdev.gui.event.GuiHandlerList;

public class CloseGuiEvent extends GuiEvent implements Cancellable {
    private final OpenGui gui;
    private final HumanEntity player;
    private boolean cancelled = false;

    public CloseGuiEvent(OpenGui gui, HumanEntity player) {
        this.gui = gui;
        this.player = player;
    }

    private static final GuiHandlerList HANDLERS = new GuiHandlerList();

    public static GuiHandlerList getHandlerList() {
        return HANDLERS;
    }

    public OpenGui getGui() {
        return this.gui;
    }

    public HumanEntity getPlayer() {
        return player;
    }

    @Override
    public @NotNull GuiHandlerList getHandlers() {
        return HANDLERS;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
        if (cancel) {
            GuiHelper.openGui(this.player, this.gui);
        }
    }
}