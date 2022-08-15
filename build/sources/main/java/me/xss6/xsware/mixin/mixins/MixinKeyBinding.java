package me.xss6.xsware.mixin.mixins;

import me.xss6.xsware.XSWARE;
import me.xss6.xsware.event.events.KeyEvent;
import net.minecraft.client.settings.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={KeyBinding.class})
public class MixinKeyBinding {
    @Shadow
    private boolean pressed;

    @Inject(method={"isKeyDown"}, at={@At(value="RETURN")}, cancellable=true)
    private void isKeyDown(CallbackInfoReturnable<Boolean> info) {
        KeyEvent event = new KeyEvent(0, info.getReturnValue(), this.pressed);
        XSWARE.EVENT_PROCESSOR.postEvent(event);
        info.setReturnValue(event.info);
    }
}

