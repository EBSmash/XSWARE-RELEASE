package me.xss6.xsware.util;

import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;


public class SkinStorageManipulationer {
    public static ResourceLocation getTexture() {
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new File("xsware/tmp/skin.png"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        DynamicTexture texture = new DynamicTexture(bufferedImage);
        WrappedResource wr = new WrappedResource(FMLClientHandler.instance().getClient().getTextureManager().getDynamicTextureLocation("skin.png", texture));
        return wr.location;
    }

    public static class WrappedResource {
        public final ResourceLocation location;

        public WrappedResource(ResourceLocation location) {
            this.location = location;
        }
    }
}
