package me.xss6.xsware.networking.chat.packets.client;

import me.xss6.xsware.networking.chat.Packet;
import me.xss6.xsware.networking.chat.Sockets;

import java.io.IOException;
import java.net.Socket;

/**
 * @author XSS6
 * @since 20/05/2021
 */

public class GetClientFromUidPacket extends Packet {
    @Override
    public String[] run(String... arguments) throws IOException {
        Socket s = Sockets.createConnection();
        Sockets.sendData(s, "client:getclientuuid:"+arguments[0]);
        String[] data = Sockets.getData(s);
        s.close();
        return data;
    }
}
