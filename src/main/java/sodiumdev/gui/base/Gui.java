package sodiumdev.gui.base;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Gui extends AbstractGui {
    public Gui(Inventory inv, String title) {
        if (inv.getSize() != slots) {
            inv = Bukkit.createInventory(null, slots, title);
        }
        this.inv = inv;
    }

    public Gui(Inventory inv) {
        this(inv, "Gui");
    }
}
