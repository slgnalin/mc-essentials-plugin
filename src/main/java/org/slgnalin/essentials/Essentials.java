package org.slgnalin.essentials;

import org.bukkit.plugin.java.JavaPlugin;
import org.slgnalin.essentials.command.TeleportAcceptCommand;
import org.slgnalin.essentials.command.TeleportCancelCommand;
import org.slgnalin.essentials.command.TeleportDenyCommand;
import org.slgnalin.essentials.command.TeleportRequestCommand;
import org.slgnalin.essentials.manager.TeleportRequestManager;
import org.slgnalin.essentials.manager.TeleportRequestManagerImpl;

public final class Essentials extends JavaPlugin {
    private TeleportRequestManager teleportRequestManager;

    @Override
    public void onLoad() {
        this.teleportRequestManager = new TeleportRequestManagerImpl();
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled");
    }

    @Override
    public void onEnable() {

        registerCommands();

        getLogger().info("Plugin initialised");
    }

    private void registerCommands() {
        getCommand("teleport-request").setExecutor(new TeleportRequestCommand(teleportRequestManager));
        getCommand("teleport-accept").setExecutor(new TeleportAcceptCommand(teleportRequestManager));
        getCommand("teleport-cancel").setExecutor(new TeleportCancelCommand(teleportRequestManager));
        getCommand("teleport-deny").setExecutor(new TeleportDenyCommand(teleportRequestManager));
    }

    public static Essentials getInstance() {
        return getPlugin(Essentials.class);
    }

}
