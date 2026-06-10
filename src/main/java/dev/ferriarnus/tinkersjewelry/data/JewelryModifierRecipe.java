package dev.ferriarnus.tinkersjewelry.data;

import dev.ferriarnus.tinkersjewelry.TinkersJewelry;
import dev.ferriarnus.tinkersjewelry.items.ItemRegistry;
import dev.ferriarnus.tinkersjewelry.tools.modifiers.JewelryModifiers;
import dev.ferriarnus.tinkersjewelry.tools.stats.JewelryToolStats;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.concurrent.CompletableFuture;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import slimeknights.mantle.recipe.data.IRecipeHelper;
import slimeknights.mantle.registration.deferred.ItemDeferredRegister;
import slimeknights.tconstruct.library.recipe.modifiers.adding.ModifierRecipeBuilder;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.tools.TinkerModifiers;

public class JewelryModifierRecipe extends RecipeProvider implements IConditionBuilder, IRecipeHelper {

    public JewelryModifierRecipe(PackOutput generator, CompletableFuture<HolderLookup.Provider> registries) {
        super(generator, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput consumer) {

        String upgradeFolder = "tools/modifiers/upgrade/";
        String abilityFolder = "tools/modifiers/ability/";
        String slotlessFolder = "tools/modifiers/slotless/";
        String upgradeSalvage = "tools/modifiers/salvage/upgrade/";
        String abilitySalvage = "tools/modifiers/salvage/ability/";
        String defenseFolder = "tools/modifiers/defense/";
        String defenseSalvage = "tools/modifiers/salvage/defense/";
        String compatFolder = "tools/modifiers/compat/";
        String compatSalvage = "tools/modifiers/salvage/compat/";
        String worktableFolder = "tools/modifiers/worktable/";

        ModifierRecipeBuilder.modifier(JewelryModifiers.POLISH)
                .setTools(Ingredient.of(TinkersJewelry.JEWELRY))
                .addInput(Items.CHARCOAL)
                .addInput(Items.HONEYCOMB)
                .addInput(Items.GLOWSTONE_DUST)
                .addInput(ItemTags.SAND)
                .addInput(TinkerModifiers.silkyCloth)
                .setMaxLevel(1).checkTraitLevel()
                .save(consumer, prefix(JewelryModifiers.POLISH.location(), slotlessFolder));

        ModifierRecipeBuilder.modifier(JewelryModifiers.UNDYING)
                .setTools(Ingredient.of(TinkersJewelry.JEWELRY))
                .addInput(Items.TOTEM_OF_UNDYING)
                .setSlots(SlotType.ABILITY, 1)
                .setMaxLevel(1).checkTraitLevel()
                .saveSalvage(consumer, prefix(JewelryModifiers.UNDYING.getId(), abilitySalvage))
                .save(consumer, prefix(JewelryModifiers.UNDYING.getId(), abilityFolder));

        ModifierRecipeBuilder.modifier(JewelryModifiers.SUBSPACE)
                .setTools(Ingredient.of(TinkersJewelry.JEWELRY))
                .addInput(Items.ENDER_CHEST)
                .setSlots(SlotType.ABILITY, 1)
                .setMaxLevel(1).checkTraitLevel()
                .saveSalvage(consumer, prefix(JewelryModifiers.SUBSPACE.location(), abilitySalvage))
                .save(consumer, prefix(JewelryModifiers.SUBSPACE.location(), abilityFolder));

        ModifierRecipeBuilder.modifier(JewelryModifiers.GLOWING_GEM)
                .setTools(Ingredient.of(TinkersJewelry.JEWELRY))
                .addInput(Items.GLOWSTONE_DUST, 20)
                .setSlots(SlotType.ABILITY, 1)
                .setMaxLevel(1).checkTraitLevel()
                .saveSalvage(consumer, prefix(JewelryModifiers.GLOWING_GEM.location(), upgradeSalvage))
                .save(consumer, prefix(JewelryModifiers.GLOWING_GEM.location(), upgradeFolder));

        ModifierRecipeBuilder.modifier(JewelryModifiers.MAGNETIC)
                .setTools(Ingredient.of(TinkersJewelry.JEWELRY))
                .addInput(Items.COMPASS)
                .setSlots(SlotType.UPGRADE, 1)
                .setMaxLevel(1).checkTraitLevel()
                .save(consumer, prefix(JewelryModifiers.MAGNETIC.location(), upgradeFolder));
    }

    @Override
    public String getModId() {
        return TinkersJewelry.MODID;
    }
}
