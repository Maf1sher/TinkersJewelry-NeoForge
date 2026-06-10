package dev.ferriarnus.tinkersjewelry.data;

import dev.ferriarnus.tinkersjewelry.TinkersJewelry;
import dev.ferriarnus.tinkersjewelry.items.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.concurrent.CompletableFuture;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.recipe.ISmelteryRecipeHelper;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.casting.ItemCastingRecipeBuilder;

public class JewelrySmeltryRecipe extends RecipeProvider implements ISmelteryRecipeHelper {
    public JewelrySmeltryRecipe(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public void buildRecipes(RecipeOutput consumer) {
        castingRecipes(consumer);
    }

    public void castingRecipes(RecipeOutput consumer) {
        String folder = "smeltery/casting/";
        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.EUDIALYTE)
                .setFluidAndTime(TinkerFluids.meatSoup, FluidValues.BOWL)
                .setCast(Items.DIAMOND, true)
                .save(consumer, location(folder + "blood/bloodgem"));

        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.FIRE_OPAL)
                .setFluidAndTime(TinkerFluids.blazingBlood, FluidValues.GEM)
                .setCast(Items.GLOWSTONE_DUST, true)
                .save(consumer, location(folder + "blazingblood/blazinggem"));

        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.MALACHITE)
                .setFluidAndTime(TinkerFluids.venom, FluidValues.GEM)
                .setCast(Items.EMERALD, true)
                .save(consumer, location(folder + "venom/spidergem"));

        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.CALCITE)
                .setFluidAndTime(TinkerFluids.honey, FluidValues.GEM)
                .setCast(Items.SUGAR, true)
                .save(consumer, location(folder + "honey/speedgem"));

        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.MILKY_QUARTZ)
                .setFluidAndTime(new FluidStack(NeoForgeMod.MILK.get(), FluidType.BUCKET_VOLUME))
                .setCast(Items.QUARTZ, true)
                .save(consumer, location(folder + "milk/cleansegem"));

        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.MERLINITE)
                .setFluidAndTime(TinkerFluids.moltenObsidian, FluidValues.GLASS_BLOCK)
                .setCast(Items.GLOWSTONE_DUST, true)
                .save(consumer, location(folder + "obsidian/nightvisiongem"));

        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.PREHNITE)
                .setFluidAndTime(TinkerFluids.moltenEmerald, FluidValues.GEM)
                .setCast(Items.EXPERIENCE_BOTTLE, true)
                .save(consumer, location(folder + "moltenemerald/expgem"));

        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.RUBELLITE)
                .setFluidAndTime(TinkerFluids.beetrootSoup, FluidValues.BOWL)
                .setCast(Items.APPLE, true)
                .save(consumer, location(folder + "beetrootsoup/healthgem"));
    }

    @Override
    public String getModId() {
        return TinkersJewelry.MODID;
    }
}
