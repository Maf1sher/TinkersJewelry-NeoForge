package dev.ferriarnus.tinkersjewelry;

import dev.ferriarnus.tinkersjewelry.tools.modules.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import dummy.remove;
import dummy.remove;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.RegisterEvent;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;
import slimeknights.tconstruct.library.tools.definition.module.ToolModule;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = TinkersJewelry.MODID)
public class ModEvents {

    @SubscribeEvent
    static void register(RegisterEvent event) {
        if (event.getRegistryKey() == Registries.RECIPE_SERIALIZER) {
            ToolModule.LOADER.register(new ResourceLocation(TinkersJewelry.MODID, "overslime_debuf"), OverSlimeDebufModule.LOADER);

            ModifierModule.LOADER.register(new ResourceLocation(TinkersJewelry.MODID, "attribute_modifier"), AttributeModifierModule.LOADER);
            ModifierModule.LOADER.register(new ResourceLocation(TinkersJewelry.MODID, "hurt_enemy"), HurtEnemyModule.LOADER);
            ModifierModule.LOADER.register(new ResourceLocation(TinkersJewelry.MODID, "hurt_user"), HurtUserModule.LOADER);
            ModifierModule.LOADER.register(new ResourceLocation(TinkersJewelry.MODID, "block_break"), BlockBreakModule.LOADER);
            ModifierModule.LOADER.register(new ResourceLocation(TinkersJewelry.MODID, "enemy_effect"), EnemyEffectModule.LOADER);
            ModifierModule.LOADER.register(new ResourceLocation(TinkersJewelry.MODID, "self_effect"), SelfEffectModule.LOADER);
        }
    }


}
