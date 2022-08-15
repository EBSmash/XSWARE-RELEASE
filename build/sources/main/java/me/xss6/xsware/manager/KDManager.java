package me.xss6.xsware.manager;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.xss6.xsware.XSWARE;
import me.xss6.xsware.event.events.DeathEvent;
import me.xss6.xsware.event.events.PacketEvent;
import me.xss6.xsware.event.processor.CommitEvent;
import me.xss6.xsware.hack.hacks.chat.AutoEz;
import me.xss6.xsware.hack.hacks.chat.TotemPopCounter;
import me.xss6.xsware.util.ClientMessage;
import me.xss6.xsware.util.Globals;
import me.xss6.xsware.util.MathsUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class KDManager implements Globals {
    public final ConcurrentHashMap<String, Integer> targets = new ConcurrentHashMap<>();

    private double totalDeaths;
    private double totalKills;
    private int currentKills;
    private String kdString = ChatFormatting.RED +  "[" + ChatFormatting.GOLD + "KD" + ChatFormatting.RED + "] " + ChatFormatting.RESET;

    public int getCurrentKills() {
        return currentKills;
    }

    public String getKD() {
        if (totalDeaths == 0) {
            return "" + totalKills;
        }
        return "" + MathsUtil.round(totalKills / totalDeaths, 2);
    }

    public String getTotalKills() {
        return "" + totalKills;
    }

    public String getTotalDeaths() {
        return "" + totalDeaths;
    }

    public KDManager() {
        XSWARE.EVENT_PROCESSOR.addEventListener(this);
    }

    public void addDeath() {
        totalDeaths++;
        if(TotemPopCounter.INSTANCE.kdMessages.getValue()){
            ClientMessage.sendMessage(kdString + "Your KD is " + getKD() + "!");
        }
        currentKills = 0;
    }

    public void onUpdate() {
        targets.forEach((name, timeout) -> {
            if (timeout <= 0) {
                targets.remove(name);
            } else {
                targets.put(name, timeout - 1);
            }

        });
    }

    @SubscribeEvent
    public void onAttackEntity(AttackEntityEvent event) {
        if (event.getTarget() instanceof EntityPlayer && !XSWARE.FRIEND_MANAGER.isFriend(event.getEntityPlayer().getName())) {
            this.targets.put(event.getTarget().getName(), 20);
        }
    }

    @CommitEvent
    public void onSendAttackPacket(PacketEvent.Send event) {
        CPacketUseEntity packet;
        if (event.getPacket() instanceof CPacketUseEntity && (packet = event.getPacket()).getAction() == CPacketUseEntity.Action.ATTACK && packet.getEntityFromWorld(mc.world) instanceof EntityPlayer && !XSWARE.FRIEND_MANAGER.isFriend(Objects.requireNonNull(packet.getEntityFromWorld(mc.world)).getName())) {
            this.targets.put(Objects.requireNonNull(packet.getEntityFromWorld(mc.world)).getName(), 20);
        }
    }

    @CommitEvent
    public void onEntityDeath(DeathEvent event) {
        if (this.targets.containsKey(event.player.getName())) {
            totalKills++;
            currentKills++;
            if(TotemPopCounter.INSTANCE.kdMessages.getValue()){
                ClientMessage.sendMessage(kdString + "Your KD is " + getKD() + "!");
            }
            AutoEz.INSTANCE.announceDeath();
            this.targets.remove(event.player.getName());
        }
    }

}
