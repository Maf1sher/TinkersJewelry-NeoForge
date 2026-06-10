package dev.ferriarnus.tinkersjewelry.tools.modifiers.gem;

import net.minecraft.resources.ResourceLocation;

import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nullable;
import java.util.List;

public class DarknessGemModifier extends AbstractGemModifier {

    @Override
    public void hurtEnemy(ItemStack stack, DamageSource source, double damage, @Nullable LivingEntity defender, @Nullable LivingEntity attacker, ModifierEntry modifier) {
        if (defender == null || defender.hasEffect(MobEffects.DARKNESS)) {
            return;
        }
        defender.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 200));
        damageTool(stack, 1, attacker);
    }

    @Override
    public void addTooltip(IToolStackView iToolStackView, ModifierEntry modifierEntry, @Nullable Player player, List<Component> list, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {

    }
}
