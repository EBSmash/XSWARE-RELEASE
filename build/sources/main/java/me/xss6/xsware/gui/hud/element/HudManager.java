package me.xss6.xsware.gui.hud.element;

import me.xss6.xsware.event.events.Render2DEvent;
import me.xss6.xsware.util.ReflectionUtil;

import java.util.ArrayList;

/**
 * @author XSS6
 * @since 17/06/2021
 */

public final class HudManager {
    ArrayList<HudElement> hudElements;

    public HudManager(){
        hudElements = new ArrayList<>();
        try {
            ArrayList<Class<?>> modClasses = ReflectionUtil.getClassesForPackage("me.xss6.xsware.gui.hud.element.elements");
            modClasses.spliterator().forEachRemaining(aClass -> {
                if(HudElement.class.isAssignableFrom(aClass)) {
                    try {
                        HudElement module = (HudElement) aClass.getConstructor().newInstance();
                        hudElements.add(module);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<HudElement> getHudElements() {
        return hudElements;
    }

    public HudElement getElementByName(String name) {
        for (HudElement element : hudElements) {
            if (element.getName().equalsIgnoreCase(name)) {
                return element;
            }
        }
        return null;
    }

    public final void onRender2D(Render2DEvent event) {
        this.hudElements.stream().filter(HudElement::isEnabled).spliterator().forEachRemaining(hack -> hack.onRender2D(event));
    }
}
