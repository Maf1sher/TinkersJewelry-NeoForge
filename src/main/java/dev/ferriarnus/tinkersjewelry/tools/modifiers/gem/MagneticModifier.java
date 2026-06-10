package dev.ferriarnus.tinkersjewelry.tools.modifiers.gem;

import net.minecraft.resources.ResourceLocation;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.tools.TinkerModifiers;
import top.theillusivec4.curios.api.SlotContext;

import javax.annotation.Nullable;
import java.util.List;

public class MagneticModifier extends AbstractGemModifier {

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack, ModifierEntry entry) {
        LivingEntity entity = slotContext.entity();
        if (!entity.hasEffect(TinkerModifiers.magneticEffect.get())) {
            entity.addEffect(new MobEffectInstance(TinkerModifiers.magneticEffect.get(), 200, 0, false, false));
        }
    }

    @Override
    public void addTooltip(IToolStackView iToolStackView, ModifierEntry modifierEntry, @Nullable Player player, List<Component> list, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {

    }
}
