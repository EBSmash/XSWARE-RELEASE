package me.xss6.xsware.mixin.mixins;

import me.xss6.xsware.gui.alt.defult.GuiAccountSelector;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author XSS6
 * @since 15/06/2021
 */
@Mixin(GuiMainMenu.class)
public abstract class MixinGuiMainMenu extends GuiScreen {

    @Inject(method = "actionPerformed", at = @At("HEAD"))
    public void actionPerformed(GuiButton button, CallbackInfo ci){
        if(button.id == 69){
            mc.displayGuiScreen(new GuiAccountSelector());
        }
    }
}
