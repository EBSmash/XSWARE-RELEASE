package me.xss6.xsware.util;

import java.lang.reflect.Field;
import java.util.List;
 
import com.mojang.authlib.GameProfile;
 
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.renderer.RenderHelper;
 
 
public class Invoker {


    public static void setMotionX(double x){
        Minecraft.getMinecraft().player.motionX = x;
    }
    
    public static void setMotionY(double y){
        Minecraft.getMinecraft().player.motionY = y;
    }
    
    public static void setMotionZ(double z){
        Minecraft.getMinecraft().player.motionZ = z;
    }

    public static double getMotionX(){
        return Minecraft.getMinecraft().player.motionX;
    }

    public static double getMotionY(){
        return Minecraft.getMinecraft().player.motionY;
    }

    public static double getMotionZ(){
        return Minecraft.getMinecraft().player.motionZ;
    }

    
}