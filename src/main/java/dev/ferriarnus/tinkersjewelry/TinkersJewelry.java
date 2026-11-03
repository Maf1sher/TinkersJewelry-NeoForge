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
import net.neoforged.neoforge.registries.DeferredRegister;
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

		ItemRegistry.register(modEventBus);
		JewelryModifiers.register(modEventBus);
		GemAttributes.register(modEventBus);
		SubSpaceCapability.ATTACHMENTS.register(modEventBus);
		JewelryMenus.register(modEventBus);

		CuriosModifierHooks.init();
		JewelryToolStats.register();

		MaterialRegistry.getInstance().registerStatType(BlankBandMaterialStats.TYPE);
		MaterialRegistry.getInstance().registerStatType(GemMaterialStats.TYPE);

        modEventBus.addListener(EventPriority.LOWEST, this::gatherData);
	}

	public void gatherData(final GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		boolean server = event.includeServer();
		boolean client = event.includeClient();
		generator.addProvider(server, new JewelryRecipeProvider(generator.getPackOutput(), event.getLookupProvider()));
		JewelryMaterialData newMaterials = new JewelryMaterialData(generator.getPackOutput());
		generator.addProvider(server, newMaterials);
		generator.addProvider(server, new JewelryMaterialStatsData(generator.getPackOutput(), newMaterials));
		generator.addProvider(server, new JewelryMaterialTraitData(generator.getPackOutput(), newMaterials));
		generator.addProvider(server, new JewelryToolDefinitionData(generator.getPackOutput()));
		generator.addProvider(server, new JewelryStationSlotLayout(generator.getPackOutput()));
		generator.addProvider(server, new JewelryModifierProvider(generator.getPackOutput()));

		TinkerMaterialSpriteProvider materialSprites = new TinkerMaterialSpriteProvider();
		JewelryMaterialSprite newMaterialSprites = new JewelryMaterialSprite();
		JewelryPartSprite partSprites = new JewelryPartSprite();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

		GeneratorPartTextureJsonGenerator.StatOverride.Builder builder = new GeneratorPartTextureJsonGenerator.StatOverride.Builder();
		builder.add(BlankBandMaterialStats.ID, MaterialIds.copper.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.iron.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.gold.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.osmium.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.tungsten.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.platinum.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.silver.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.lead.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.slimesteel.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.amethystBronze.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.nahuatl.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.pigIron.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.roseGold.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.steel.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.bronze.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.constantan.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.invar.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.electrum.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.platedSlimewood.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.manyullyn.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.cinderslime.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.queensSlime.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.cobalt.getLocation());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.hepatizon.getLocation());

		builder.add(BlankBandMaterialStats.ID, JewelryMaterials.hematite.getLocation());

		builder.add(GemMaterialStats.ID, MaterialIds.rock.getLocation());
		builder.add(GemMaterialStats.ID, MaterialIds.flint.getLocation());
		builder.add(GemMaterialStats.ID, MaterialIds.obsidian.getLocation());
		builder.add(GemMaterialStats.ID, MaterialIds.necroticBone.getLocation());
		builder.add(GemMaterialStats.ID, MaterialIds.bone.getLocation());
		builder.add(GemMaterialStats.ID, MaterialIds.blazingBone.getLocation());
		builder.add(GemMaterialStats.ID, MaterialIds.venombone.getLocation());
		builder.add(GemMaterialStats.ID, MaterialIds.scorchedStone.getLocation());
		builder.add(GemMaterialStats.ID, MaterialIds.searedStone.getLocation());
		builder.add(GemMaterialStats.ID, MaterialIds.enderPearl.getLocation());
		builder.add(GemMaterialStats.ID, MaterialIds.whitestone.getLocation());
		builder.add(GemMaterialStats.ID, MaterialIds.necronium.getLocation());

		GeneratorPartTextureJsonGenerator.StatOverride overrides = builder.build();

		generator.addProvider(client, new JewelryMaterialRenderInfo(generator.getPackOutput(), newMaterialSprites, existingFileHelper));
		generator.addProvider(client, new GeneratorPartTextureJsonGenerator(generator.getPackOutput(), TinkersJewelry.MODID, partSprites, overrides));
		generator.addProvider(client, new MaterialPartTextureGenerator(generator.getPackOutput(), existingFileHelper, partSprites, overrides, materialSprites, newMaterialSprites));
	}
	
}
