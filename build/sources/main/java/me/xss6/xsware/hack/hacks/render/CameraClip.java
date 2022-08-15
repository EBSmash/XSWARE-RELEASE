package me.xss6.xsware.hack.hacks.render;

import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.setting.type.DoubleSetting;

@Hack.Registration(name = "Camera Clip", description = "f5 mode", category = Hack.Category.RENDER, isListening = false)
public class CameraClip extends Hack {

    public static CameraClip INSTANCE;

    public CameraClip() {
        INSTANCE = this;
    }

    public DoubleSetting distance = new DoubleSetting("Distance", 10.0, -10.0, 50.0, this);

}
