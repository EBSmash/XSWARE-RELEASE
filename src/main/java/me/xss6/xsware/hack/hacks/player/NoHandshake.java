package me.xss6.xsware.hack.hacks.player;



import io.netty.buffer.Unpooled;
import me.xss6.xsware.event.events.PacketEvent;
import me.xss6.xsware.event.processor.CommitEvent;
import me.xss6.xsware.event.processor.EventPriority;
import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.hack.HackPriority;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;

/**
 * XSS6 moment
 * @author Ronald(K3B)Jones SKIDDED
 * @since 07/05/2005
 */

@Hack.Registration(name = "No Handshake", description = "Do not shake hand", category = Hack.Category.PLAYER, priority = HackPriority.Low)
public class NoHandshake extends Hack {

    @CommitEvent(priority = EventPriority.LOW)
    public void onPacketSend(PacketEvent.Send event) {
        CPacketCustomPayload packet;
        if (event.getPacket() instanceof FMLProxyPacket && !mc.isSingleplayer()) {
            event.setCancelled(true);
        }
        if (event.getPacket() instanceof CPacketCustomPayload && (packet = (CPacketCustomPayload)event.getPacket()).getChannelName().equals("MC|Brand")) {
            packet.data = new PacketBuffer(Unpooled.buffer()).writeString("vanilla");
        }
    }
}
