package sodiumdev.gui.event;

import org.bukkit.event.EventException;
import org.jetbrains.annotations.NotNull;

public interface GuiEventExecutor {
    void execute(@NotNull GuiListener listener, @NotNull GuiEvent event) throws EventException;
}
