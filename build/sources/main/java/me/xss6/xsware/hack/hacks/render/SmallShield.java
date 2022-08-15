package me.xss6.xsware.hack.hacks.render;

import me.xss6.xsware.hack.Hack;

@Hack.Registration(name = "Small Shield", description = "shields block my epic gamer view", category = Hack.Category.RENDER, isListening = false)
public class SmallShield extends Hack {

    @Override
    public void onUpdate() {
        mc.entityRenderer.itemRenderer.equippedProgressOffHand = -1;
    }

}
