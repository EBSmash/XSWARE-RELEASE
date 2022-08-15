package me.xss6.xsware.hack.hacks.render;

import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.setting.type.DoubleSetting;

/**
 * @author XSS6
 * @since 03/05/2021
 */
@Hack.Registration(name = "Item Physics", description = "Apply physics to items", category = Hack.Category.RENDER, isListening = false)
public class ItemPhysics extends Hack{
    public static ItemPhysics INSTANCE;

    public ItemPhysics(){
        INSTANCE = this;
    }

    public DoubleSetting Scaling = new DoubleSetting("Scaling", 0.5, 0.0, 10.0, this);
}
