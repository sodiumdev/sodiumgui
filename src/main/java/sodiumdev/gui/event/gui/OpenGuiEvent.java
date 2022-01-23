package sodiumdev.gui.event.gui;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;
import sodiumdev.gui.base.Gui;
import sodiumdev.gui.base.OpenGui;
import sodiumdev.gui.event.GuiEvent;
import sodiumdev.gui.event.GuiHandlerList;

public class OpenGuiEvent extends GuiEvent {
    private final OpenGui gui;
    private final HumanEntity player;

    public OpenGuiEvent(OpenGui gui, HumanEntity player) {
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
}
