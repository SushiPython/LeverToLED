package us.sushipython.levertoled.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.material.Lever;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class leverflick implements Listener {
    private void sendGet(String url) throws Exception {


        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //Request header

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
    }
    @EventHandler
    public void onPull(PlayerInteractEvent event) throws Exception {
        System.out.println(event.getClickedBlock().getType());
        if(event.getClickedBlock().getType() == Material.LEVER){
            Block block = event.getClickedBlock();
            Lever lever = (Lever) block.getState().getData();
            if (lever.isPowered() == true) {
                System.out.println("On");
                sendGet("http://localhost:8080/on");
            } else if (!lever.isPowered()) {
                System.out.println("off");
                sendGet("http://localhost:8080/off");
            }
        }
    }
}
