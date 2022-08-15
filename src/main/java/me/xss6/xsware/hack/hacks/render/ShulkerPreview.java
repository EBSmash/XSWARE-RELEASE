package me.xss6.xsware.hack.hacks.render;

import me.xss6.xsware.hack.Hack;

@Hack.Registration(name = "Shulker Preview", description = "lets u see shulker contents", category = Hack.Category.RENDER, isListening = false)
public class ShulkerPreview extends Hack {

    public static ShulkerPreview INSTACE;

    public ShulkerPreview() {
        INSTACE = this;
    }

}
