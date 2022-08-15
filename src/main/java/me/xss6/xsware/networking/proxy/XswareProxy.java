package me.xss6.xsware.networking.proxy;


import me.xss6.xsware.XSWARE;
import me.xss6.xsware.event.events.PacketEvent;
import me.xss6.xsware.event.processor.CommitEvent;
import me.xss6.xsware.event.processor.EventPriority;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.Socket;

/**
 * @author XSS6
 * @since 14/07/2021
 */

public final class XswareProxy {
    public final String host;
    public final int port;
    public final Mode mode;

    public XswareProxy(final int port, @NotNull final String host, final Mode mode){
        this.port = port;
        this.host = host;
        this.mode = mode;
        XSWARE.EVENT_PROCESSOR.addEventListener(this);
    }

    public final Socket bind() throws IOException {
        return new Socket(host, port);
    }

    public static String[] getData(Socket socket) throws IOException {
        InputStream stream = socket.getInputStream();
        BufferedReader r = new BufferedReader(new InputStreamReader(stream));
        return r.readLine().split(":");
    }

    public static void sendData(Socket socket, String data) throws IOException {
        OutputStream stream = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(stream, true);
        writer.println(data);
    }


    @CommitEvent(priority = EventPriority.HIGH)
    public final void cPacketEvent(PacketEvent.Send event){
        if(mode.equals(Mode.CLIENT)){
            CPacketHandler cPacketHandler = new CPacketHandler(event);
        }
    }

    public enum Mode {
        CLIENT,
        SERVER
    }
}
