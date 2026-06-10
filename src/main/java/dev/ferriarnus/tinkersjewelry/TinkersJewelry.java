package dev.ferriarnus.tinkersjewelry;

import dev.ferriarnus.tinkersjewelry.capability.SubSpaceCapability;
import dev.ferriarnus.tinkersjewelry.data.*;
import dev.ferriarnus.tinkersjewelry.menu.JewelryMenus;
import dev.ferriarnus.tinkersjewelry.tools.hooks.CuriosModifierHooks;
import dev.ferriarnus.tinkersjewelry.tools.stats.JewelryToolStats;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.slf4j.Logger;

import dev.ferriarnus.tinkersjewelry.items.ItemRegistry;
import dev.ferriarnus.tinkersjewelry.tools.modifiers.JewelryModifiers;
import dev.ferriarnus.tinkersjewelry.tools.stats.GemMaterialStats;
import dev.ferriarnus.tinkersjewelry.tools.stats.BlankBandMaterialStats;
import com.mojang.logging.LogUtils;

import net.minecraft.data.DataGenerator;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import slimeknights.tconstruct.library.client.data.material.GeneratorPartTextureJsonGenerator;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.library.materials.MaterialRegistry;
import slimeknights.tconstruct.tools.data.material.MaterialIds;
import slimeknights.tconstruct.tools.data.sprite.TinkerMaterialSpriteProvider;

@Mod(TinkersJewelry.MODID)
public class TinkersJewelry {
	// Directly reference a slf4j logger
	private static final Logger LOGGER = LogUtils.getLogger();
	public static final String MODID = "tinkersjewelry";
	public static final TagKey<Item> JEWELRY = ItemTags.create(ResourceLocation.parse(MODID + ":modifiable/jewelry"));


	public TinkersJewelry(IEventBus modEventBus) { 
		
        modEventBus.addListener(EventPriority.LOWEST, this::gatherData);

		CuriosModifierHooks.init();

		JewelryToolStats.register();

		MaterialRegistry.getInstance().registerStatType(BlankBandMaterialStats.TYPE);
		MaterialRegistry.getInstance().registerStatType(GemMaterialStats.TYPE);
		
		ItemRegistry.register(modEventBus);
		JewelryModifiers.register(modEventBus);
		GemAttributes.register(modEventBus);
		SubSpaceCapability.ATTACHMENTS.register(modEventBus);
		JewelryMenus.register(modEventBus);
	}

	public void gatherData(final GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		boolean server = event.includeServer();
		boolean client = event.includeClient();
		generator.addProvider(server, new JewelryToolsRecipe(generator.getPackOutput(), event.getLookupProvider()));
		generator.addProvider(server, new JewelryMaterialRecipe(generator.getPackOutput(), event.getLookupProvider()));
		generator.addProvider(server, new JewelrySmeltryRecipe(generator.getPackOutput(), event.getLookupProvider()));
		JewelryMaterialData newMaterials = new JewelryMaterialData(generator.getPackOutput());
		generator.addProvider(server, newMaterials);
		generator.addProvider(server, new JewelryMaterialStatsData(generator.getPackOutput(), newMaterials));
		generator.addProvider(server, new JewelryMaterialTraitData(generator.getPackOutput(), newMaterials));
		generator.addProvider(server, new JewelryToolDefinitionData(generator.getPackOutput()));
		generator.addProvider(server, new JewelryStationSlotLayout(generator.getPackOutput()));
		generator.addProvider(server, new JewelryModifierProvider(generator.getPackOutput()));
		generator.addProvider(server, new JewelryModifierRecipe(generator.getPackOutput(), event.getLookupProvider()));

		TinkerMaterialSpriteProvider materialSprites = new TinkerMaterialSpriteProvider();
		JewelryMaterialSprite newMaterialSprites = new JewelryMaterialSprite();
		JewelryPartSprite partSprites = new JewelryPartSprite();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

		GeneratorPartTextureJsonGenerator.StatOverride.Builder builder = new GeneratorPartTextureJsonGenerator.StatOverride.Builder();
		builder.add(BlankBandMaterialStats.ID, MaterialIds.copper.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.iron.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.gold.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.osmium.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.tungsten.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.platinum.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.silver.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.lead.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.slimesteel.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.amethystBronze.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.nahuatl.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.pigIron.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.roseGold.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.steel.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.bronze.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.constantan.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.invar.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.electrum.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.platedSlimewood.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.manyullyn.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.cinderslime.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.queensSlime.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.cobalt.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.hepatizon.getId());

		builder.add(BlankBandMaterialStats.ID, JewelryMaterials.hematite);

		builder.add(GemMaterialStats.ID, MaterialIds.rock.getId());
		builder.add(GemMaterialStats.ID, MaterialIds.flint.getId());
		builder.add(GemMaterialStats.ID, MaterialIds.obsidian.getId());
		builder.add(GemMaterialStats.ID, MaterialIds.necroticBone.getId());
		builder.add(GemMaterialStats.ID, MaterialIds.bone.getId());
		builder.add(GemMaterialStats.ID, MaterialIds.blazingBone.getId());
		builder.add(GemMaterialStats.ID, MaterialIds.venombone.getId());
		builder.add(GemMaterialStats.ID, MaterialIds.scorchedStone.getId());
		builder.add(GemMaterialStats.ID, MaterialIds.searedStone.getId());
		builder.add(GemMaterialStats.ID, MaterialIds.enderPearl.getId());
		builder.add(GemMaterialStats.ID, MaterialIds.whitestone.getId());
		builder.add(GemMaterialStats.ID, MaterialIds.necronium.getId());

		GeneratorPartTextureJsonGenerator.StatOverride overrides = builder.build();

		generator.addProvider(client, new JewelryMaterialRenderInfo(generator.getPackOutput(), newMaterialSprites, existingFileHelper));
		generator.addProvider(client, new GeneratorPartTextureJsonGenerator(generator.getPackOutput(), TinkersJewelry.MODID, partSprites, overrides));
		generator.addProvider(client, new MaterialPartTextureGenerator(generator.getPackOutput(), existingFileHelper, partSprites, overrides, materialSprites, newMaterialSprites));
	}
	
}
