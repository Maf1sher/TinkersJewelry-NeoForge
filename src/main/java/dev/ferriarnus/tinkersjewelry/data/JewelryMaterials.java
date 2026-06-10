package dev.ferriarnus.tinkersjewelry.data;

import dev.ferriarnus.tinkersjewelry.TinkersJewelry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

public class JewelryMaterials {
	
	public static final MaterialId redstone = id("redstone");
	public static final MaterialId lapis = id("lapis");
	public static final MaterialId netherstar = id("netherstar");
	public static final MaterialId scute = id("scute");
	public static final MaterialId diamond = id("diamond");
	public static final MaterialId quartz = id("quartz");
	public static final MaterialId amethyst = id("amethyst");
	public static final MaterialId emerald = id("emerald");
	public static final MaterialId prismarine = id("prismarine");
	public static final MaterialId heart_of_the_sea = id("heart_of_the_sea");
	public static final MaterialId ender_eye = id("ender_eye");
	public static final MaterialId echo_shard = id("echo_shard");
	public static final MaterialId glowstone = id("glowstone");
	public static final MaterialId prismarine_crystal = id("prismarine_crystal");
	public static final MaterialId purpur = id("purpur");

	public static final MaterialId earth_crystal = id("earth_crystal");
	public static final MaterialId sky_crystal = id("sky_crystal");
	public static final MaterialId ender_crystal = id("ender_crystal");
	public static final MaterialId ichor_crystal = id("ichor_crystal");

	public static final MaterialId eudialyte = id("eudialyte");
	public static final MaterialId fire_opal = id("fire_opal");
	public static final MaterialId malachite = id("malachite");
	public static final MaterialId calcite = id("calcite");
	public static final MaterialId milky_quartz = id("milky_quartz");
	public static final MaterialId merlinite = id("merlinite");
	public static final MaterialId prehnite = id("prehnite");
	public static final MaterialId rubellite = id("rubellite");

	public static final MaterialId ruby = id("ruby");
	public static final MaterialId peridot = id("peridot");
	public static final MaterialId sapphire = id("sapphire");
	public static final MaterialId cinnabar = id("cinnabar");
	public static final MaterialId fluorite = id("fluorite");
	public static final MaterialId topaz = id("topaz");
	public static final MaterialId rose_quartz = id("rose_quartz");
	public static final MaterialId apatite = id("apatite");
	public static final MaterialId jade = id("jade");
	public static final MaterialId bloodstone = id("bloodstone");
	public static final MaterialId bismuth = id("bismuth");
	public static final MaterialId opal = id("opal");
	public static final MaterialId garnet = id("garnet");
	public static final MaterialId moonstone = id("moonstone");
	public static final MaterialId onyx = id("onyx");

	public static final MaterialId celestigem = id("celestigem");
	public static final MaterialId certus_quartz_crystal = id("certus_quartz_crystal");
	public static final MaterialId charged_certus_quartz_crystal = id("charged_certus_quartz_crystal");
	public static final MaterialId fluix_crystal = id("fluix_crystal");
	public static final MaterialId source_gem = id("source_gem");
	public static final MaterialId xychorium_gem_blue = id("xychorium_gem_blue");
	public static final MaterialId xychorium_gem_red = id("xychorium_gem_red");
	public static final MaterialId xychorium_gem_green = id("xychorium_gem_green");
	public static final MaterialId xychorium_gem_dark = id("xychorium_gem_dark");
	public static final MaterialId xychorium_gem_light = id("xychorium_gem_light");

	public static final MaterialId hematite = new MaterialId("tinkers_things", "hematite");

	private static MaterialId id(String name) {
	    return new MaterialId(TinkersJewelry.MODID, name);
	}

	static class Tags {

		public static TagKey<Item> RUBY_GEM = tag("gems/ruby");
		public static TagKey<Item> PERIDOT_GEM = tag("gems/peridot");
		public static TagKey<Item> SAPPHIRE_GEM = tag("gems/sapphire");
		public static TagKey<Item> CINNABAR_GEM = tag("gems/cinnabar");
		public static TagKey<Item> FLUORITE_GEM = tag("gems/fluorite");

		public static TagKey<Item> RED_XYCHORIUM = tag("gems/xychorium_gem_red");
		public static TagKey<Item> BLUE_XYCHORIUM = tag("gems/xychorium_gem_blue");
		public static TagKey<Item> GREEN_XYCHORIUM = tag("gems/xychorium_gem_green");
		public static TagKey<Item> DARK_XYCHORIUM = tag("gems/xychorium_gem_dark");
		public static TagKey<Item> LIGHT_XYCHORIUM = tag("gems/xychorium_gem_light");

		private static TagKey<Item> tag(String name) {
			return ItemTags.create(ResourceLocation.parse("c:" + name));
		}
	}
}
