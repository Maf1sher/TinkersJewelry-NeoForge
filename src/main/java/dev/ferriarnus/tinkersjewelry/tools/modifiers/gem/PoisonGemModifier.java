package dev.ferriarnus.tinkersjewelry.tools.modifiers.gem;

import net.minecraft.resources.ResourceLocation;

import dev.ferriarnus.tinkersjewelry.tools.modifiers.JewelryModifiers;
import dev.ferriarnus.tinkersjewelry.tools.stats.JewelryToolStats;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
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
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import javax.annotation.Nullable;
import java.util.List;

public class PoisonGemModifier extends AbstractGemModifier{

    @Override
    public void hurtEnemy(ItemStack stack, DamageSource source, double damage, @Nullable LivingEntity defender, @Nullable LivingEntity attacker, ModifierEntry modifier) {
        if (defender == null || defender.hasEffect(MobEffects.POISON)) {
            return;
        }
        ToolStack tool = ToolStack.from(stack);
        float amp = tool.getStats().get(JewelryToolStats.AMPLIFICATION);
        int level = tool.getModifierLevel(JewelryModifiers.POISON_GEM);
        defender.addEffect(new MobEffectInstance(MobEffects.POISON, Mth.floor(100 * level * amp)));
        damageTool(stack, 1, attacker);
    }

    @Override
    public void addTooltip(IToolStackView iToolStackView, ModifierEntry modifierEntry, @Nullable Player player, List<Component> list, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
//        foltip.add(addloat amp = tool.getMultiplier(JewelryToolStats.AMPLIFICATION);
////        double effect = 1 * amp * 3;
////        toDiscription(TranslationKeys.POISON, effect+"s"));
    }
}
