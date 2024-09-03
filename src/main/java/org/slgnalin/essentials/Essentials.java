package org.slgnalin.essentials;

import org.bukkit.plugin.java.JavaPlugin;
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
    public void onEnable() {

        getCommand("teleport-request").setExecutor(new TeleportRequestCommand(teleportRequestManager));

        getLogger().info("Plugin initialised");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled");
    }

    public static Essentials getInstance(){
        return getPlugin(Essentials.class);
    }

}
