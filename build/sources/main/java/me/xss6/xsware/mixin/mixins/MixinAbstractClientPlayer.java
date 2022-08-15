package me.xss6.xsware.mixin.mixins;

import me.xss6.xsware.XSWARE;
import me.xss6.xsware.command.commands.DebugCommand;
import me.xss6.xsware.util.SkinStorageManipulationer;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;
import java.awt.image.BufferedImage;
import java.util.Objects;
import java.util.UUID;

@Mixin(value={AbstractClientPlayer.class})
public abstract class MixinAbstractClientPlayer {

    @Shadow
    @Nullable
    protected abstract NetworkPlayerInfo getPlayerInfo();

    @Inject(method = "getLocationCape", at = @At("HEAD"), cancellable = true)
    public void getLocationCape(CallbackInfoReturnable<ResourceLocation> callbackInfoReturnable) {
        UUID uuid = Objects.requireNonNull(getPlayerInfo()).getGameProfile().getId();
        if(!DebugCommand.INSTANCE.capes)return;

        if (XSWARE.CAPE_MANAGER.isOg(uuid)) {
            // callbackInfoReturnable.setReturnValue(new ResourceLocation("textures/cape-old.png"));
            callbackInfoReturnable.setReturnValue(XSWARE.CAPE_MANAGER.getOgCape());
        }

        if (XSWARE.CAPE_MANAGER.isContributor(uuid)) {
            callbackInfoReturnable.setReturnValue(new ResourceLocation("textures/cape-dev.png"));
        }

        if (XSWARE.CAPE_MANAGER.isCool(uuid)) {
            // callbackInfoReturnable.setReturnValue(new ResourceLocation("textures/cape-cool.png"));
            callbackInfoReturnable.setReturnValue(XSWARE.CAPE_MANAGER.getCoolCape());
        }

        if (XSWARE.CAPE_MANAGER.isDonator(uuid)) {
            try {
                BufferedImage image = XSWARE.CAPE_MANAGER.getCapeFromDonor(uuid);
                DynamicTexture texture = new DynamicTexture(image);
                SkinStorageManipulationer.WrappedResource wr = new SkinStorageManipulationer.WrappedResource(
                        FMLClientHandler.instance().getClient().getTextureManager().getDynamicTextureLocation(uuid.toString(), texture)
                );
                callbackInfoReturnable.setReturnValue(new ResourceLocation(wr.location.toString()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
