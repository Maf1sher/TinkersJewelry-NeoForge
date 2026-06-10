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

public class NightVisionGemModifier extends AbstractGemModifier{

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack, ModifierEntry entry) {
        LivingEntity entity = slotContext.entity();
        if (!entity.hasEffect(MobEffects.NIGHT_VISION) || entity.getEffect(MobEffects.NIGHT_VISION).getDuration() < 220) {
            entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, false, false));
            damageTool(stack, 10, entity);
        }
    }

    @Override
    public void addTooltip(IToolStackView iToolStackView, ModifierEntry modifierEntry, @javax.annotation.Nullable Player player, List<Component> list, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
//        float amp = tool.getMultiplier(JewelryToolStats.AMPLIFICATION);
//        int effect = (int) (1 * amp);
//        tooltip.add(addDiscription(TranslationKeys.NIGHTVISION, ""));
    }

    @Override
    public Component getDisplayName(int level) {
        // display name without the level
        return super.getDisplayName();
    }
}
