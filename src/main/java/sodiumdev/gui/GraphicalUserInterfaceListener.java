package sodiumdev.gui;

import sodiumdev.gui.event.GuiEventHandler;
import sodiumdev.gui.event.GuiListener;
import sodiumdev.gui.event.gui.CloseGuiEvent;

import static sodiumdev.gui.LazyAssListener._gui;

public class GraphicalUserInterfaceListener implements GuiListener {
    @GuiEventHandler
    public void onTest(CloseGuiEvent event) {
        if (event.getGui().getId() == _gui.getId() && !event.getGui().shouldCloseOnEscape()) {
            event.setCancelled(true);
        }
    }
}
