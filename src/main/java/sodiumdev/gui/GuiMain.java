package sodiumdev.gui;

import org.bukkit.Bukkit;
import org.bukkit.inventory.InventoryView;
import org.bukkit.plugin.java.JavaPlugin;
import sodiumdev.gui.event.GuiEventManager;

import java.util.HashSet;
import java.util.Set;

public final class GuiMain extends JavaPlugin {
    private GuiEventManager manager;
    public static final Set<InventoryView> viewSet = new HashSet<>();

    @Override
    public void onEnable() {
        this.manager = new GuiEventManager();

        this.manager.registerGuiEvents(new GraphicalUserInterfaceListener(), this);

        Bukkit.getPluginManager().registerEvents(new LazyAssListener(this.manager), this);
    }

    @Override
    public void onDisable() {
    }
}
