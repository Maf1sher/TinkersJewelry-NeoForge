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

import javax.annotation.Nullable;
import java.util.List;

public class WaterBreathingGemModifier extends AbstractGemModifier{

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack, ModifierEntry entry) {
        LivingEntity entity = slotContext.entity();
        if (entity.isUnderWater() && !entity.hasEffect(MobEffects.WATER_BREATHING)) {
            entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0, false, false));
            damageTool(stack, 1, entity);
        }
    }

    @Override
    public void addTooltip(IToolStackView iToolStackView, ModifierEntry modifierEntry, @Nullable Player player, List<Component> list, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
//        float amp = tool.getMultiplier(JewelryToolStats.AMPLIFICATION);
//        double effect = level * amp;
//        tooltip.add(addDiscription(TranslationKeys.WATERBREATHING, effect));
    }

}
