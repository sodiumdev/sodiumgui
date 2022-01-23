package sodiumdev.gui.base;

import org.bukkit.inventory.InventoryView;

public interface OpenGuiBase extends GuiBase {
    InventoryView getInventoryView();
    void setInventoryView(InventoryView inv);

    OpenGui setDisplayName(String str);

    boolean shouldCloseOnEscape();
    void setShouldCloseOnEscape(boolean bool);
}
