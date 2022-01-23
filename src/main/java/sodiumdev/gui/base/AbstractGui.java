package sodiumdev.gui.base;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class AbstractGui implements GuiBase {
    Inventory inv;

    @Override
    public Inventory getInventory() {
        return this.inv;
    }

    @Override
    public void setInventory(Inventory inv) {
        this.inv = inv;
    }

    @Override
    public ItemStack[] getContentsOfInventory() {
        return this.inv.getContents();
    }

    @Override
    public void setContentsOfInventory(ItemStack[] contents) {
        this.inv.setContents(contents);
    }
}
