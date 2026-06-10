package dev.ferriarnus.tinkersjewelry.mixin;

import dev.ferriarnus.tinkersjewelry.GemAttributes;
import dev.ferriarnus.tinkersjewelry.IEntityAwarePredicate;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import javax.annotation.Nullable;

@Mixin(ItemPredicate.class)
public class MixinItemPredicate implements IEntityAwarePredicate {

    @Nullable
    @Unique
    private LivingEntity entity;

    @Override
    public void setEntity(LivingEntity entity) {
        this.entity = entity;
    }

    @WrapOperation(method = "matches", at = @At(value = "INVOKE", target = "Lnet/minecraft/advancements/critereon/EnchantmentPredicate;containedIn(Lnet/minecraft/world/item/enchantment/ItemEnchantments;)Z"))
    public boolean matchEnchantment(EnchantmentPredicate instance, ItemEnchantments enchantments, Operation<Boolean> original) {
        if (entity == null) {
            return original.call(instance, enchantments);
        }
        double value = 0;
        if (instance.enchantment != null && instance.enchantment.is(Enchantments.FORTUNE)) {
            value = entity.getAttributeValue(GemAttributes.FORTUNE);
        }
        if (instance.enchantment != null && instance.enchantment.is(Enchantments.SILK_TOUCH)) {
            value = entity.getAttributeValue(GemAttributes.SILK);
        }
        return original.call(instance, enchantments) || value > 0;
    }
}
