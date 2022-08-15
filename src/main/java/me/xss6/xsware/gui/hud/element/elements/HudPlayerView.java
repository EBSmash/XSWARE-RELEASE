package me.xss6.xsware.gui.hud.element.elements;

import me.xss6.xsware.event.events.Render2DEvent;
import me.xss6.xsware.gui.hud.element.HudElement;
import me.xss6.xsware.util.RenderUtil2D;

@HudElement.Element(name = "Player View", posY = 100, posX = 100)
public class HudPlayerView extends HudElement{

    @Override
    public int getHeight(){
        return 80;
    }

    @Override
    public int getWidth(){
        return 40;
    }

    @Override
    public void onRender2D(Render2DEvent event){
        RenderUtil2D.drawEntityOnScreen(getX() + (getWidth() / 2f), getY() + getHeight(), 40, mc.player);
    }
}
