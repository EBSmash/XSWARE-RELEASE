package me.xss6.xsware.hack.hacks.misc;

import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.setting.type.KeySetting;
import me.xss6.xsware.util.InventoryUtil;
import me.xss6.xsware.util.MouseUtil;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/**
 * @author XSS6
 * @since 02/05/2021
 */

@Hack.Registration(name = "Key Pearl", description = "uses packets to through shit", category = Hack.Category.MISC)
public class KeyPearl extends Hack {

    KeySetting key = new KeySetting("Key", Keyboard.KEY_NONE, this);
    //BooleanSetting middleClick = new BooleanSetting("MiddleClick", true, this);

    private boolean isButtonDown = false;

    int slot;
    int oldSlot;

    @Override
    public void onUpdate() {
        if (key.getKey() < -1) {
            if (Mouse.isButtonDown(MouseUtil.convertToMouse(key.getKey()))) {
                if (!isButtonDown && mc.currentScreen == null) {
                    this.pearl();
                }
                isButtonDown = true;
            } else {
                isButtonDown = false;
            }
        } else if (key.getKey() > -1) {
            if (Keyboard.isKeyDown(key.getKey())) {
                if (!isButtonDown && mc.currentScreen == null) {
                    this.pearl();
                }
                isButtonDown = true;
            } else {
                isButtonDown = false;
            }
        }
    }

    private void pearl() {
        oldSlot = mc.player.inventory.currentItem;
        slot = InventoryUtil.findHotbarBlock(ItemEnderPearl.class);
        if(slot == -1) return;
        mc.player.connection.sendPacket(new CPacketHeldItemChange(slot));
        mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
        mc.player.connection.sendPacket(new CPacketHeldItemChange(oldSlot));
    }
}
