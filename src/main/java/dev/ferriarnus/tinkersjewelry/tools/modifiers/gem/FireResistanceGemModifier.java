package dev.ferriarnus.tinkersjewelry.tools.modifiers.gem;

import net.minecraft.resources.ResourceLocation;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;

public class FireResistanceGemModifier extends AbstractGemModifier{

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack, ModifierEntry entry) {
        LivingEntity entity = slotContext.entity();
        if (entity.isOnFire() && !entity.hasEffect(MobEffects.FIRE_RESISTANCE)) {
            entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0, false, false));
            damageTool(stack, 1, entity);
        }
    }

    @Override
    public void addTooltip(IToolStackView iToolStackView, ModifierEntry modifierEntry, @javax.annotation.Nullable Player player, List<Component> list, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
//        float amp = iToolStackView.getMultiplier(JewelryToolStats.AMPLIFICATION);
//        int effect = (int) (1 * amp);
//        list.add(addDiscription(TranslationKeys.FIRERESISTANCE, effect));
    }
}
