package me.xss6.xsware.hack.hacks.render;

import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.setting.type.ColourSetting;
import me.xss6.xsware.util.elements.Colour;

/**
 * @author XSS6
 * @since 28/04/2021
 */

@Hack.Registration(name = "Hausemaster Esp", description = "makes everyones skin hause", category = Hack.Category.RENDER, isListening = false)
public class Hausemaster extends Hack {

    public static Hausemaster INSTANCE;

    public Hausemaster(){
        INSTANCE = this;
    }

    public ColourSetting texture = new ColourSetting("Texture",new Colour(255,255,255, 255), this);

}
