package me.xss6.xsware.mixin.mixins;

import me.xss6.xsware.XSWARE;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiTextField;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @author XSS6
 * @since 07/11/2021
 */

@Mixin(GuiTextField.class)
public abstract class MixinGuiTextField extends Gui {

    @Shadow
    public abstract String getText();

    @Inject(method = "textboxKeyTyped", at=@At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiTextField;writeText(Ljava/lang/String;)V"))
    private void typed(char typedChar, int keyCode, CallbackInfoReturnable<Boolean> cir){
        String text = getText();
        if(text.startsWith(XSWARE.COMMANDS.getPrefix())) {
            text = text.replace(XSWARE.COMMANDS.getPrefix(), "");
            //xsware.COMMANDS.getNextArgument(text.split(" "));
        }
    }

    @Inject(method = "drawTextBox", at=@At(value = "RETURN"))
    private void renderBox(CallbackInfo ci){

    }
}
