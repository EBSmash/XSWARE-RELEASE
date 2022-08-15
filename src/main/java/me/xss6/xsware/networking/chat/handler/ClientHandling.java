package me.xss6.xsware.networking.chat.handler;

import me.xss6.xsware.XSWARE;
import me.xss6.xsware.networking.chat.Packet;
import me.xss6.xsware.networking.chat.packets.client.NewClientPacket;
import me.xss6.xsware.networking.chat.packets.ping.PingUpPacket;
import net.minecraft.client.Minecraft;

import java.io.IOException;

/**
 * @author XSS6
 * @since 30/05/2021
 */

public class ClientHandling {
    public String token;
    private final Minecraft mc = Minecraft.getMinecraft();

    public ClientHandling(){
        token = "";
    }

    public void newClient(){
        try {
            Packet packetClient = new NewClientPacket(); // TODO fix null
            String[] data = packetClient.run();
            if(data[0].equals("server") && data[1].equals("newclient")){
               if(data[2].equals("false")){ // loads token
                   this.token = XSWARE.CONFIG_MANAGER.loadIRCtoken();
               }
               else if(data[2].equals("true")){ // saves token
                   this.token = data[3];
                   XSWARE.CONFIG_MANAGER.saveIRCtoken(this.token);
               }
            }
            if(!token.isEmpty()){
                Packet packetUp = new PingUpPacket();
                data = packetUp.run(token);
                if(data[0].equals("server") && data[1].equals("pingup")){
                    XSWARE.LOGGER.info("IRC chat init complete");
                }else {
                    XSWARE.LOGGER.error("IRC chat not didnt init");
                }
            }
        }catch (IOException e){
            XSWARE.LOGGER.error("Exception in loading new client for IRC " + e);
        }
    }
}
