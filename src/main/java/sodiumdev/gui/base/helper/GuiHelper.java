package sodiumdev.gui.base.helper;

import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import sodiumdev.gui.base.Gui;
import sodiumdev.gui.base.OpenGui;

import java.util.Arrays;
import java.util.Objects;

public class GuiHelper {
    @Contract("_ -> new")
    public static @NotNull Gui createGui(Inventory inv) {
        return new Gui(inv);
    }

    @Contract("_, _ -> new")
    public static @NotNull OpenGui openGui(@NotNull HumanEntity pl, @NotNull Gui gui) {
        return new OpenGui(Objects.requireNonNull(pl.openInventory(gui.getInventory())));
    }

    public static void closeGui(@NotNull HumanEntity pl, @NotNull OpenGui gui) {
        if (pl.getOpenInventory() == gui.getInventoryView()) pl.closeInventory();
    }

    @Contract("_, _, _ -> param1")
    public static @NotNull Gui setItemAtGuiAt(@NotNull Gui gui, int i, ItemStack to) {
        Inventory contents = gui.getInventory();
        contents.setItem(i, to);
        gui.setInventory(contents);
        return gui;
    }

    public static ItemStack getItemAtGuiAt(@NotNull Gui gui, int i) {
        Inventory contents = gui.getInventory();
        return contents.getItem(i);
    }

    @Contract("_, _ -> param1")
    public static @NotNull Gui multiplyItemCountsAtGuiBy(@NotNull Gui gui, int to) {
        ItemStack[] contents = Arrays.stream(gui.getContentsOfInventory()).peek(x -> x.setAmount(x.getAmount()*to)).toArray(ItemStack[]::new);
        gui.setContentsOfInventory(contents);
        return gui;
    }

    @Contract("_, _ -> param1")
    public static @NotNull Gui addToItemCountsAtGui(@NotNull Gui gui, int to) {
        ItemStack[] contents = Arrays.stream(gui.getContentsOfInventory()).peek(x -> x.setAmount(x.getAmount()+to)).toArray(ItemStack[]::new);
        gui.setContentsOfInventory(contents);
        return gui;
    }

    @Contract("_, _, _ -> param1")
    public static @NotNull Gui multiplyItemCountsAtGuiAtBy(@NotNull Gui gui, int i, int to) throws NullPointerException {
        Inventory contents = gui.getInventory();
        ItemStack item = contents.getItem(i);
        item.setAmount(item.getAmount()*to);
        contents.setItem(i, item);
        gui.setInventory(contents);
        return gui;
    }

    @Contract("_, _, _ -> param1")
    public static @NotNull Gui addToItemCountsAtGuiAt(@NotNull Gui gui, int i, int to) throws NullPointerException {
        Inventory contents = gui.getInventory();
        ItemStack item = contents.getItem(i);
        item.setAmount(item.getAmount()+to);
        contents.setItem(i, item);
        gui.setInventory(contents);
        return gui;
    }
}
