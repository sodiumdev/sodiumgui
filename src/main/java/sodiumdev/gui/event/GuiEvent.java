package sodiumdev.gui.event;

import org.jetbrains.annotations.NotNull;

public abstract class GuiEvent {
    private String name;
    private final boolean async;

    public GuiEvent() {
        this(false);
    }

    public GuiEvent(boolean isAsync) {
        this.async = isAsync;
    }

    @NotNull
    public String getEventName() {
        if (name == null) { name = getClass().getSimpleName(); }
        return name;
    }

    @NotNull
    public abstract GuiHandlerList getHandlers();

    public final boolean isAsynchronous() {
        return async;
    }

    public enum Result {
        DENY,
        DEFAULT,
        ALLOW
    }
}
