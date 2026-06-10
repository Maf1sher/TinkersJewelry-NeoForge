package dev.ferriarnus.tinkersjewelry.menu;

import dev.ferriarnus.tinkersjewelry.TinkersJewelry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class JewelryMenus {

    private static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, TinkersJewelry.MODID);

    public static void register(IEventBus modEventBus) {
        MENUS.register(modEventBus);
    }

    public static final DeferredHolder<MenuType<?>, MenuType<SubSpaceMenu>> SUB_SPACE_MENU = MENUS.register("subspace", () -> IMenuTypeExtension.create((id, inv, data) -> new SubSpaceMenu(id, inv)));
}
