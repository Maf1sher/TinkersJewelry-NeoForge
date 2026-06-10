package dev.ferriarnus.tinkersjewelry.book;

import dev.ferriarnus.tinkersjewelry.TinkersJewelry;
import dev.ferriarnus.tinkersjewelry.tools.stats.BlankBandMaterialStats;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.client.book.content.AbstractMaterialContent;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.materials.definition.MaterialVariantId;
import slimeknights.tconstruct.library.materials.stats.MaterialStatsId;

import javax.annotation.Nullable;

public class BlankBandMaterialContent extends AbstractMaterialContent {
    public static final ResourceLocation ID = ResourceLocation.parse(TinkersJewelry.MODID + ":blank_band_material");

    public BlankBandMaterialContent(MaterialVariantId materialVariant, boolean detailed) {
        super(materialVariant, detailed);
    }

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Nullable
    @Override
    protected MaterialStatsId getStatType(int i) {
        if (i == 0) {
            return BlankBandMaterialStats.ID;
        }
        return null;
    }

    @Override
    protected String getTextKey(MaterialId materialId) {
        return "plain_ring";
    }

    @Override
    protected boolean supportsStatType(MaterialStatsId materialStatsId) {
        return materialStatsId.equals(BlankBandMaterialStats.ID);
    }
}
