package sodiumdev.gui.base;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public interface GuiBase {
    int slots = 27;

    Inventory getInventory();
    void setInventory(Inventory inv);

    ItemStack[] getContentsOfInventory();
    void setContentsOfInventory(ItemStack[] contents);
}
