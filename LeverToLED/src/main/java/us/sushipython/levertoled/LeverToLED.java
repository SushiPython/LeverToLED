package us.sushipython.levertoled;

import org.bukkit.plugin.java.JavaPlugin;
import us.sushipython.levertoled.events.leverflick;

public final class LeverToLED extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new leverflick(), this);
    }
}
