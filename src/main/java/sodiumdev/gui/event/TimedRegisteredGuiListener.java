package sodiumdev.gui.event;

import org.bukkit.event.EventException;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TimedRegisteredGuiListener extends RegisteredGuiListener {
    private int count;
    private long totalTime;
    private Class<? extends GuiEvent> eventClass;
    private boolean multiple = false;

    public TimedRegisteredGuiListener(@NotNull final GuiListener pluginListener, @NotNull final GuiEventExecutor eventExecutor, @NotNull final EventPriority eventPriority, @NotNull final Plugin registeredPlugin, final boolean listenCancelled) {
        super(pluginListener, eventExecutor, eventPriority, registeredPlugin, listenCancelled);
    }

    @Override
    public void callEvent(@NotNull GuiEvent event) throws EventException {
        if (event.isAsynchronous()) {
            super.callEvent(event);
            return;
        }
        count++;
        Class<? extends GuiEvent> newEventClass = event.getClass();
        if (this.eventClass == null) {
            this.eventClass = newEventClass;
        } else if (!this.eventClass.equals(newEventClass)) {
            multiple = true;
            this.eventClass = getCommonSuperclass(newEventClass, this.eventClass).asSubclass(GuiEvent.class);
        }
        long start = System.nanoTime();
        super.callEvent(event);
        totalTime += System.nanoTime() - start;
    }

    @NotNull
    private static Class<?> getCommonSuperclass(@NotNull Class<?> class1, @NotNull Class<?> class2) {
        while (!class1.isAssignableFrom(class2)) {
            class1 = class1.getSuperclass();
        }
        return class1;
    }

    public void reset() {
        count = 0;
        totalTime = 0;
    }

    public int getCount() {
        return count;
    }
    public long getTotalTime() {
        return totalTime;
    }
    @Nullable
    public Class<? extends GuiEvent> getEventClass() {
        return eventClass;
    }
    public boolean hasMultiple() {
        return multiple;
    }
}
