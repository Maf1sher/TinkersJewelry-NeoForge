package dev.ferriarnus.tinkersjewelry.tools.hooks;

import com.google.common.collect.HashMultimap;
import dev.ferriarnus.tinkersjewelry.TinkersJewelry;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.module.ModuleHook;

public class CuriosModifierHooks {

    public static final ModuleHook<AttributeModifierHook> ATTRIBUTE = ModifierHooks.register(ResourceLocation.parse(TinkersJewelry.MODID + ":attribute"), AttributeModifierHook.class, AttributeModifierHook.AllMerger::new, (slotContext, uuid, stack, modifier) -> HashMultimap.create());
    public static final ModuleHook<CuriosEquipHook> EQUIP = ModifierHooks.register(ResourceLocation.parse(TinkersJewelry.MODID + ":equip"), CuriosEquipHook.class, CuriosEquipHook.AllMerger::new, new CuriosEquipHook() {});
    public static final ModuleHook<CuriosTickHook> TICK = ModifierHooks.register(ResourceLocation.parse(TinkersJewelry.MODID + ":tick"), CuriosTickHook.class, CuriosTickHook.AllMerger::new, (slotContext, stack, modifier) -> {});
    public static final ModuleHook<HurtEnemyHook> HURT_ENEMY_HOOK = ModifierHooks.register(ResourceLocation.parse(TinkersJewelry.MODID + ":hurt_enemy"), HurtEnemyHook.class, HurtEnemyHook.AllMerger::new, (stack, source, damage, defender, attacker, modifier) -> {});
    public static final ModuleHook<HurtUserHook> HURT_USER_HOOK = ModifierHooks.register(ResourceLocation.parse(TinkersJewelry.MODID + ":hurt_user"), HurtUserHook.class, HurtUserHook.AllMerger::new, (stack, source, damage, defender, attacker, modifier) -> {});
    public static final ModuleHook<BlockBreakHook> BLOCK_BREAK = ModifierHooks.register(ResourceLocation.parse(TinkersJewelry.MODID + ":block_break"), BlockBreakHook.class, BlockBreakHook.AllMerger::new, (player, stackInSlot, pos, state, modifier) -> {});

    public static void init() {

    }
}
