package me.xss6.xsware.hack.hacks.combat;

import me.xss6.xsware.XSWARE;
import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.hack.HackPriority;
import me.xss6.xsware.util.EntityUtil;
import me.xss6.xsware.util.MathsUtil;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.util.math.Vec3d;


/**
 * @author XSS6
 * @since 05/05/2021
 */

@Hack.Registration(name = "Bow Aim", description = "Aimbot for minecraft", category = Hack.Category.COMBAT, priority = HackPriority.Lowest)
public class BowAim extends Hack {

    @Override
    public void onUpdate() {
        if (mc.player.getHeldItemMainhand().getItem() instanceof ItemBow && mc.player.isHandActive() && mc.player.getItemInUseMaxCount() >= 3) {
            EntityPlayer player = null;
            float tickDis = 100f;
            for (EntityPlayer p : mc.world.playerEntities) {
                if (p instanceof EntityPlayerSP || XSWARE.FRIEND_MANAGER.isFriend(p.getName())) continue;
                float dis = p.getDistance(mc.player);
                if (dis < tickDis) {
                    tickDis = dis;
                    player = p;
                }
            }
            if (player != null) {
                Vec3d pos = EntityUtil.getInterpolatedPos(player, mc.getRenderPartialTicks());
                float[] angels = MathsUtil.calcAngle(EntityUtil.getInterpolatedPos(mc.player, mc.getRenderPartialTicks()), pos);
                //angels[1] -=  calcPitch(tickDis);
                mc.player.rotationYaw = angels[0];
                mc.player.rotationPitch = angels[1];
            }
        }
    }

    /*
    private float calcPitch(float dis) {
        float a = 129.84f;
        float h = 1.32f;
    }

     */
}
