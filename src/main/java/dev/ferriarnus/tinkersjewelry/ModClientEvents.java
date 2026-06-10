package dev.ferriarnus.tinkersjewelry;

import dev.ferriarnus.tinkersjewelry.book.JewerlyBook;
import dev.ferriarnus.tinkersjewelry.client.SubSpaceScreen;
import dev.ferriarnus.tinkersjewelry.menu.JewelryMenus;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.MenuScreens;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = TinkersJewelry.MODID, value = Dist.CLIENT)
public class ModClientEvents {

    static {
        JewerlyBook.initBook();
    }

    public static final KeyMapping SUBSPACE = new KeyMapping("key.tinkersjewelry.subspace", GLFW.GLFW_KEY_K, "key.categories.tinkersjewelry");

    @SubscribeEvent
    static void setupClient(final RegisterMenuScreensEvent event) {
        event.register(JewelryMenus.SUB_SPACE_MENU.get(), SubSpaceScreen::new);
    }

    @SubscribeEvent
    static void registerKeyBinding(RegisterKeyMappingsEvent event) {
        event.register(SUBSPACE);
    }
}
