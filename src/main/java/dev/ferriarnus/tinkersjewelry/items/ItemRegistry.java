package dev.ferriarnus.tinkersjewelry.items;

import java.util.function.Consumer;
import java.util.function.Supplier;

import dev.ferriarnus.tinkersjewelry.TinkersJewelry;
import dev.ferriarnus.tinkersjewelry.tools.JewelryDefinitions;
import dev.ferriarnus.tinkersjewelry.tools.stats.GemMaterialStats;
import dev.ferriarnus.tinkersjewelry.tools.stats.BlankBandMaterialStats;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import slimeknights.mantle.item.tooltip.TooltipItem;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.tconstruct.common.registration.CastItemObject;
import slimeknights.tconstruct.common.registration.ItemDeferredRegisterExtension;
import slimeknights.tconstruct.library.materials.MaterialRegistry;
import slimeknights.tconstruct.library.materials.definition.MaterialVariantId;
import slimeknights.tconstruct.library.tools.helper.ToolBuildHandler;
import slimeknights.tconstruct.library.tools.item.IModifiable;
import slimeknights.tconstruct.library.tools.part.IMaterialItem;
import slimeknights.tconstruct.library.tools.part.ToolPartItem;
import slimeknights.tconstruct.tables.TinkerTables;

public class ItemRegistry {

	protected static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TinkersJewelry.MODID);

	private static final Item.Properties PARTS_PROPS = new Item.Properties();
	
	private static final ItemDeferredRegisterExtension ITEMS = new ItemDeferredRegisterExtension(TinkersJewelry.MODID);
	
	
	public static void register(IEventBus modEventBus) {
		CREATIVE_TABS.register(modEventBus);
		ITEMS.register(modEventBus);
	}

	//Materials
	public static final ItemObject<Item, TooltipItem> EUDIALYTE = new ItemObject<>(ITEMS.register("eudialyte", () -> new TooltipItem(new Item.Properties())));
	public static final ItemObject<Item, TooltipItem> FIRE_OPAL = new ItemObject<>(ITEMS.register("fire_opal", () -> new TooltipItem(new Item.Properties())));
	public static final ItemObject<Item, TooltipItem> MALACHITE = new ItemObject<>(ITEMS.register("malachite", () -> new TooltipItem(new Item.Properties())));
	public static final ItemObject<Item, TooltipItem> CALCITE = new ItemObject<>(ITEMS.register("calcite", () -> new TooltipItem(new Item.Properties())));
	public static final ItemObject<Item, TooltipItem> MILKY_QUARTZ = new ItemObject<>(ITEMS.register("milky_quartz", () -> new TooltipItem(new Item.Properties())));
	public static final ItemObject<Item, TooltipItem> MERLINITE = new ItemObject<>(ITEMS.register("merlinite", () -> new TooltipItem(new Item.Properties())));
	public static final ItemObject<Item, TooltipItem> PREHNITE = new ItemObject<>(ITEMS.register("prehnite", () -> new TooltipItem(new Item.Properties())));
	public static final ItemObject<Item, TooltipItem> RUBELLITE = new ItemObject<>(ITEMS.register("rubellite", () -> new TooltipItem(new Item.Properties())));

	//Toolparts
	private static final DeferredItem<ToolPartItem> PLAIN_RING_ITEM = ITEMS.register("plain_ring", () -> new ToolPartItem(PARTS_PROPS, BlankBandMaterialStats.ID));
	public static final ItemObject<Item, ToolPartItem> PLAIN_RING = new ItemObject<>(PLAIN_RING_ITEM);
	public static final ItemObject<Item, ToolPartItem> GEM = new ItemObject<>(ITEMS.register("gem", () -> new ToolPartItem(PARTS_PROPS, GemMaterialStats.ID)));

	//Casts
	public static final CastItemObject PLAIN_RING_CAST = ITEMS.registerCast(PLAIN_RING_ITEM, PARTS_PROPS);

	//Tools
	public static final ItemObject<Item, CuriosRingItem> RING = new ItemObject<>(ITEMS.register("ring", () -> new CuriosRingItem(PARTS_PROPS, JewelryDefinitions.RING)));

	public static final ItemObject<Item, JewelryBookItem> BOOK  = new ItemObject<>(ITEMS.register("book", () -> new JewelryBookItem(new Item.Properties().stacksTo(1))));

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> tabTools = CREATIVE_TABS.register(
			"tools", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup." + TinkersJewelry.MODID + ".all"))
					.icon(() -> {
						MaterialVariantId material;
						if (MaterialRegistry.isFullyLoaded()) {
							material = ToolBuildHandler.RANDOM.getMaterial(GemMaterialStats.ID, RandomSource.create());
						} else {
							material = ToolBuildHandler.getRenderMaterial(0);
						}
						return GEM.get().withMaterialForDisplay(material);
					})
					.displayItems(ItemRegistry::addTabItems)
					.withTabsBefore(TinkerTables.tabTables.getId())
					.build());

	private static void addTabItems(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output tab) {
		Consumer<ItemStack> output = tab::accept;
		output.accept(new ItemStack(BOOK));
		acceptTool(output, RING);
		accept(output, PLAIN_RING);
		accept(output, GEM);
		output.accept(new ItemStack(EUDIALYTE.get()));
		output.accept(new ItemStack(FIRE_OPAL.get()));
		output.accept(new ItemStack(MALACHITE.get()));
		output.accept(new ItemStack(CALCITE.get()));
		output.accept(new ItemStack(MILKY_QUARTZ.get()));
		output.accept(new ItemStack(MERLINITE.get()));
		output.accept(new ItemStack(PREHNITE.get()));
		output.accept(new ItemStack(RUBELLITE.get()));
		output.accept(new ItemStack(PLAIN_RING_CAST.get()));
		output.accept(new ItemStack(PLAIN_RING_CAST.getSand()));
		output.accept(new ItemStack(PLAIN_RING_CAST.getRedSand()));
	}

	private static void acceptTool(Consumer<ItemStack> output, Supplier<? extends IModifiable> tool) {
		ToolBuildHandler.addVariants(output, tool.get(), "");
	}

	private static void accept(Consumer<ItemStack> output, Supplier<? extends IMaterialItem> item) {
		item.get().addVariants(output, "");
	}
}
