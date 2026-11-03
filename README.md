# Tinkers' Jewelry

![LGPL-3.0](https://img.shields.io/badge/license-LGPL--3.0-blue.svg?longCache=true&style=flat)

Unofficial NeoForge 1.21.1 port of [Tinkers' Jewelry](https://github.com/ferriarnus/TinkersJewelry),
originally by [Ferri_Arnus](https://github.com/ferriarnus).

Tinkers' Jewelry is a [Tinkers' Construct](https://github.com/SlimeKnights/TinkersConstruct)
add-on that uses [Curios](https://github.com/TheIllusiveC4/Curios) to let you build
your own trinkets. A trinket is assembled from Tinkers' parts, so its effect and
durability come from the materials you pick. The mod requires Tinkers' Construct
and Curios; place their jars in the `mods` folder alongside this one.

## Trinkets

Jewelry consists of a gem that provides the effect and a band that holds it,
provides durability, and may add **Amplification** to the gem effect.

### Ring

A simple trinket that fits the Curios ring slot. It has two parts:

- **Gem** — holds the special effect
- **Band** — provides durability and amplification of the gem effect

A few gems also grant abilities beyond attributes: flight, the subspace
inventory (open with `K`), enderclearance teleportation, and cleansing.

## Gems

Gems determine the trinket's effect. The full list is in the in-game book; the
signature materials are:

| Gem material | Effect | Damages the trinket on |
|--------------|--------|------------------------|
| Redstone | Rage — attack speed | damaging an entity |
| Eudialyte | Life Steal | damaging an entity |
| Malachite | Poison and Anti-Heal | damaging an entity |
| Fire Opal | Flame | damaging an entity |
| Flint | Piercing | damaging an entity |
| Quartz | Piercing | damaging an entity |
| Obsidian | Armor and Piercing | damaging an entity |
| Rock | Armor | damaging the user |
| Diamond | Armor | damaging the user |
| Amethyst | Silk Touch | mining a block |
| Lapis | Fortune | mining a block |
| Emerald | Trade — better prices | — |
| Scute | Water Breathing | the effect ticking |
| Netherstar | Flight | starting flight |
| Calcite | Speed | damaging an entity |
| Merlinite | Night Vision | the effect ticking |
| Milky Quartz | Cleanse — removes harmful effects | clearing an effect |
| Prehnite | Experience | damaging an entity |
| Rubellite | Health | damaging the user |
| Prismarine | Swim Speed | damaging the user |
| Heart of the Sea | Conduit Power | the effect ticking |
| Ender Eye | Enderclearance teleport | taking damage |
| Echo Shard | Darkness and Soulbound | damaging an entity |
| Earth Crystal | Overslime and Resistance | the effect ticking |
| Sky Crystal | Overslime and Gravity | damaging the user |
| Ender Crystal | Overslime and Reach | damaging an entity |
| Ichor Crystal | Overslime and Fire Resistance | the effect ticking |

Compatibility gems (`ruby`, `peridot`, `sapphire`, `cinnabar`, `fluorite`, and the
five `xychorium_gem_*` colors) only load when their `c:gems/<name>` tag is filled
or Tinkers' `force_integration_materials` config is enabled.

## Bands

The band decides durability and which upgrade trait the ring starts with:

| Band material | Trait |
|---------------|-------|
| Gold, silver, platinum, electrum, amethyst bronze, rose gold | Precious |
| Iron | Magnetic |
| Copper, steel | Ductile |
| Bronze | Maintained |
| Constantan | Temperate |
| Invar | Invariant |
| Osmium, lead | Dense |
| Slimesteel | Overcast and Overslime |
| Pig Iron | Tasty |

## Requirements

- Minecraft 1.21.1 with NeoForge 21.1.264 or newer.
- Tinkers' Construct 3.12 or newer; Mantle 1.12 or newer comes with it.
- Curios 9.5.1 or newer.
- Apothic Attributes 2.11 or newer; Placebo comes with it.

## Building

Requires JDK 21. The project builds against Mantle and Tinkers' Construct, so
clone all three repositories into the same folder:

- [Mantle-NeoForge](https://github.com/Maf1sher/Mantle-NeoForge)
- [TinkersConstruct-NeoForge](https://github.com/Maf1sher/TinkersConstruct-NeoForge)
- this repository

Then build them in order, starting from that folder.

Linux / macOS:

```bash
cd Mantle-NeoForge && ./gradlew build
cd ../TinkersConstruct-NeoForge && ./gradlew build
cd ../TinkersJewelry-NeoForge && ./gradlew build
```

Windows (Command Prompt or PowerShell):

```bat
cd Mantle-NeoForge && gradlew.bat build
cd ..\TinkersConstruct-NeoForge && gradlew.bat build
cd ..\TinkersJewelry-NeoForge && gradlew.bat build
```

The jar is written to `build/libs/TinkersJewelry-1.21.1-*.jar`.

## Credits

- Original mod and author: [Ferri_Arnus](https://github.com/ferriarnus/TinkersJewelry)
- NeoForge 1.21.1 port: [Maf1sher/TinkersJewelry-NeoForge](https://github.com/Maf1sher/TinkersJewelry-NeoForge)
- License: LGPL-3.0 (see [LICENSE](LICENSE))
