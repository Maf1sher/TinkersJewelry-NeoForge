package dev.ferriarnus.tinkersjewelry.mixin;

import dev.ferriarnus.tinkersjewelry.GemAttributes;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Villager.class)
public class MixinVillager {

    @Inject(method = "getPlayerReputation", at = @At("RETURN"), cancellable = true)
    private void tradeAttribute(Player player, CallbackInfoReturnable<Integer> cir) {
        double playerRep = player.getAttributeValue(GemAttributes.TRADE);
        cir.setReturnValue((int) Mth.clamp(cir.getReturnValue() + playerRep, -30, 30));
    }
}
