package sodiumdev.gui.base;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import sodiumdev.gui.GuiMain;

import java.util.Objects;
import java.util.UUID;

public class OpenGui extends Gui implements OpenGuiBase {
    private InventoryView view;
    private boolean close;
    private final UUID id;

    public OpenGui(@NotNull InventoryView inv, String title, boolean close) {
        super(inv.getTopInventory(), title);
        this.close = close;
        this.view = inv;
        this.id = UUID.randomUUID();
        this.inv = this.view.getTopInventory();
        GuiMain.viewSet.add(inv);
    }

    public OpenGui(@NotNull InventoryView inv) {
        this(inv, "Gui", true);
    }

    public OpenGui(@NotNull Gui gui, Player pl) {
        this(Objects.requireNonNull(pl.openInventory(gui.getInventory())), "Gui", true);
    }

    public UUID getId() { return id; }

    @Override
    public OpenGui setDisplayName(String str) {
        Inventory temp = this.inv;
        this.inv = Bukkit.createInventory(null, slots, str);
        this.inv.setContents(temp.getContents());
        this.inv.setStorageContents(temp.getStorageContents());
        this.inv.setMaxStackSize(temp.getMaxStackSize());
        return this;
    }

    public String getDisplayName() {
        return this.view.getTitle();
    }

    @Override
    public Inventory getInventory() {
        return this.inv;
    }

    @Override
    public void setInventory(Inventory inv) { this.inv = inv; }

    @Override
    public ItemStack[] getContentsOfInventory() {
        return this.inv.getContents();
    }

    @Override
    public void setContentsOfInventory(ItemStack[] contents) { this.inv.setContents(contents); }

    @Override
    public boolean shouldCloseOnEscape() {
        return this.close;
    }

    @Override
    public void setShouldCloseOnEscape(boolean bool) {
        this.close = bool;
    }

    @Override
    public InventoryView getInventoryView() {
        return this.view;
    }

    @Override
    public void setInventoryView(InventoryView inv) {
        this.view = inv;
    }
}
