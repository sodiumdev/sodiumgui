package sodiumdev.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import sodiumdev.gui.base.Gui;
import sodiumdev.gui.base.OpenGui;
import sodiumdev.gui.base.helper.GuiHelper;
import sodiumdev.gui.event.GuiEventHandler;
import sodiumdev.gui.event.GuiEventManager;
import sodiumdev.gui.event.GuiListener;
import sodiumdev.gui.event.gui.ClickedOnGuiItemEvent;
import sodiumdev.gui.event.gui.CloseGuiEvent;
import sodiumdev.gui.event.gui.OpenGuiEvent;

public class LazyAssListener implements Listener, GuiListener {
    private final GuiEventManager m;
    public static OpenGui _gui;

    public LazyAssListener(GuiEventManager m) { this.m = m; }

    @EventHandler
    public void onGuiOpen(InventoryOpenEvent e) { OpenGui gui = new OpenGui(e.getView()); m.callEvent(new OpenGuiEvent(gui, e.getPlayer())); GuiMain.viewSet.add(gui.getInventoryView()); }

    @EventHandler
    public void onGuiClose(InventoryCloseEvent e) { if (GuiMain.viewSet.contains(e.getView())) { m.callEvent(new CloseGuiEvent(new OpenGui(e.getView()), e.getPlayer())); GuiMain.viewSet.remove(e.getView()); } }

    @EventHandler
    public void onItemGuiShit(InventoryClickEvent e) { if (e.getAction() == InventoryAction.PICKUP_ALL && GuiMain.viewSet.contains(e.getView())) m.callEvent(new ClickedOnGuiItemEvent(new OpenGui(e.getView()), e.getCurrentItem())); }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Gui gui = GuiHelper.createGui(Bukkit.createInventory(null, 27, "swag"));
        gui = GuiHelper.setItemAtGuiAt(gui, 1, new ItemStack(Material.EMERALD_BLOCK));
        _gui = GuiHelper.openGui(e.getPlayer(), gui);
    }
}
