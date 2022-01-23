package sodiumdev.gui.event;

import org.bukkit.event.*;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class RegisteredGuiListener {
    private final GuiListener listener;
    private final EventPriority priority;
    private final Plugin plugin;
    private final GuiEventExecutor executor;
    private final boolean ignoreCancelled;

    public RegisteredGuiListener(@NotNull final GuiListener listener, @NotNull final GuiEventExecutor executor, @NotNull final EventPriority priority, @NotNull final Plugin plugin, final boolean ignoreCancelled) {
        this.listener = listener;
        this.priority = priority;
        this.plugin = plugin;
        this.executor = executor;
        this.ignoreCancelled = ignoreCancelled;
    }

    @NotNull
    public GuiListener getListener() {
        return listener;
    }

    @NotNull
    public Plugin getPlugin() {
        return plugin;
    }

    @NotNull
    public EventPriority getPriority() {
        return priority;
    }

    public void callEvent(@NotNull final GuiEvent event) throws EventException {
        if (event instanceof Cancellable) {
            if (((Cancellable) event).isCancelled() && isIgnoringCancelled()) {
                return;
            }
        }
        executor.execute(listener, event);
    }

    public boolean isIgnoringCancelled() {
        return ignoreCancelled;
    }
}
