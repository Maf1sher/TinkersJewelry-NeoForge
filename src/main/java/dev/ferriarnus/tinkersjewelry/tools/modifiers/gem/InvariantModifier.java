package dev.ferriarnus.tinkersjewelry.tools.modifiers.gem;

import net.minecraft.resources.ResourceLocation;

import dev.ferriarnus.tinkersjewelry.TinkersJewelry;
import dev.ferriarnus.tinkersjewelry.tools.stats.JewelryToolStats;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ConditionalStatModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.display.TooltipModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;

import javax.annotation.Nullable;
import java.util.List;

public class InvariantModifier extends Modifier implements ConditionalStatModifierHook, TooltipModifierHook {
    private static final float BASELINE_TEMPERATURE = 0.75f;
    private static final float MAX_TEMPERATURE = 1.25f;
    private static final float AMPLIFICATION = 0.15f / MAX_TEMPERATURE;

    /** Gets the bonus for this modifier */
    private static float getBonus(LivingEntity living) {
        // temperature ranges from 0 to 1.25. multiplication makes it go from 0 to 2.5
        BlockPos pos = living.blockPosition();
        return (MAX_TEMPERATURE - Math.abs(BASELINE_TEMPERATURE - living.level().getBiome(pos).value().getTemperature(pos)));
    }

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this, ModifierHooks.CONDITIONAL_STAT, ModifierHooks.TOOLTIP);
    }

    @Override
    public float modifyStat(IToolStackView tool, ModifierEntry modifier, LivingEntity living, FloatToolStat stat, float baseValue, float multiplier) {
        if (stat == JewelryToolStats.AMPLIFICATION) {
            return baseValue + getBonus(living) * modifier.getEffectiveLevel() * AMPLIFICATION * multiplier;
        }
        return baseValue;
    }

    @Override
    public void addTooltip(IToolStackView tool, ModifierEntry modifier, @Nullable Player player, List<Component> tooltip, TooltipKey key, TooltipFlag tooltipFlag) {
        float bonus = modifier.getEffectiveLevel();
        if (player != null && key == TooltipKey.SHIFT) {
            bonus *= getBonus(player);
        } else {
            bonus *= MAX_TEMPERATURE;
        }
        if (bonus > 0.01f) {
            if (tool.hasTag(TinkersJewelry.JEWELRY)) {
                TooltipModifierHook.addStatBoost(tool, this, JewelryToolStats.AMPLIFICATION, TinkersJewelry.JEWELRY, bonus * AMPLIFICATION, tooltip);
            }
        }
    }
}
