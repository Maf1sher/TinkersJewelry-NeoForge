package dev.ferriarnus.tinkersjewelry.data;

import dev.ferriarnus.tinkersjewelry.TinkersJewelry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.concurrent.CompletableFuture;

public class JewelryRecipeProvider extends RecipeProvider {

    private final JewelryToolsRecipe toolsRecipe;
    private final JewelryMaterialRecipe materialRecipe;
    private final JewelrySmeltryRecipe smeltryRecipe;
    private final JewelryModifierRecipe modifierRecipe;

    public JewelryRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
        this.toolsRecipe = new JewelryToolsRecipe(output, registries);
        this.materialRecipe = new JewelryMaterialRecipe(output, registries);
        this.smeltryRecipe = new JewelrySmeltryRecipe(output, registries);
        this.modifierRecipe = new JewelryModifierRecipe(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput consumer) {
        toolsRecipe.buildRecipes(consumer);
        materialRecipe.buildRecipes(consumer);
        smeltryRecipe.buildRecipes(consumer);
        modifierRecipe.buildRecipes(consumer);
    }
}
