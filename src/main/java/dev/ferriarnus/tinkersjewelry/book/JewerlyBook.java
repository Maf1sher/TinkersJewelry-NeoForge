package dev.ferriarnus.tinkersjewelry.book;

import dev.ferriarnus.tinkersjewelry.TinkersJewelry;
import dev.ferriarnus.tinkersjewelry.tools.stats.BlankBandMaterialStats;
import dev.ferriarnus.tinkersjewelry.tools.stats.GemMaterialStats;
import net.minecraft.resources.ResourceLocation;
import slimeknights.mantle.client.book.BookLoader;
import slimeknights.mantle.client.book.data.BookData;
import slimeknights.mantle.client.book.repository.FileRepository;
import slimeknights.mantle.client.book.transformer.BookTransformer;
import slimeknights.tconstruct.library.client.book.sectiontransformer.ModifierTagInjectorTransformer;
import slimeknights.tconstruct.library.client.book.sectiontransformer.ToolTagInjectorTransformer;
import slimeknights.tconstruct.library.client.book.sectiontransformer.materials.TierRangeMaterialSectionTransformer;
import slimeknights.tconstruct.shared.CommonsClientEvents;

public class JewerlyBook {
    private static final ResourceLocation JEWELRY_BOOK_RL = ResourceLocation.parse(TinkersJewelry.MODID + ":jewelry");
    public static final ResourceLocation PLAIN_RING = ResourceLocation.parse(TinkersJewelry.MODID + ":plain_ring");
    public static final ResourceLocation GEM = ResourceLocation.parse(TinkersJewelry.MODID + ":gem");
    public static final BookData JEWELRY_BOOK = BookLoader.registerBook(JEWELRY_BOOK_RL, false, false);

    public static void initBook() {
        BookLoader.registerPageType(GemMaterialContent.ID, GemMaterialContent.class);
        BookLoader.registerPageType(BlankBandMaterialContent.ID, BlankBandMaterialContent.class);

        JEWELRY_BOOK.fontRenderer = CommonsClientEvents.unicodeFontRender();

        TierRangeMaterialSectionTransformer.registerMaterialType(PLAIN_RING, BlankBandMaterialContent::new, BlankBandMaterialStats.ID);
        TierRangeMaterialSectionTransformer.registerMaterialType(GEM, GemMaterialContent::new, GemMaterialStats.ID);

        JEWELRY_BOOK.addTransformer(ToolTagInjectorTransformer.INSTANCE);
        JEWELRY_BOOK.addTransformer(ModifierTagInjectorTransformer.INSTANCE);

        JEWELRY_BOOK.addRepository(new FileRepository(ResourceLocation.parse(TinkersJewelry.MODID + ":book/jewelry")));
        JEWELRY_BOOK.addTransformer(BookTransformer.indexTranformer());
        JEWELRY_BOOK.addTransformer(TierRangeMaterialSectionTransformer.INSTANCE);
        // padding needs to be last to ensure page counts are right
        JEWELRY_BOOK.addTransformer(BookTransformer.paddingTransformer());
    }

}
