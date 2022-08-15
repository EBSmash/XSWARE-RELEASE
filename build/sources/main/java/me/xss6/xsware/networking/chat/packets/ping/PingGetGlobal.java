package me.xss6.xsware.networking.chat.packets.ping;

import me.xss6.xsware.networking.chat.Packet;
import me.xss6.xsware.networking.chat.Sockets;

import java.io.IOException;
import java.net.Socket;

/**
 * @author XSS6
 * @since 20/05/2021
 */

public class PingGetGlobal extends Packet {
    public String[] run(String key) throws IOException {
        String client = mc.player.getName() + ":" + mc.player.getUniqueID();
        Socket s = Sockets.createConnection();
        Sockets.sendData(s, "client:pinggetglobal:"+client+":"+key);
        String[] data = Sockets.getData(s);
        s.close();
        return data;
    }
}
