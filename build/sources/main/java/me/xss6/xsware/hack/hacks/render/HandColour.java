package me.xss6.xsware.hack.hacks.render;

import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.setting.type.ColourSetting;
import me.xss6.xsware.util.elements.Colour;

@Hack.Registration(name = "Hand Colour", description = "colours hands", category = Hack.Category.RENDER, isListening = false)
public class HandColour extends Hack {

    public static HandColour INSTANCE;

    public HandColour() {
        INSTANCE = this;
    }

    public ColourSetting colour = new ColourSetting("Colour", new Colour(255, 255, 255, 150), this);

}
