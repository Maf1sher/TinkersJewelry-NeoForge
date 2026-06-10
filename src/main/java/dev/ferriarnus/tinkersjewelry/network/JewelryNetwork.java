package dev.ferriarnus.tinkersjewelry.network;

import dev.ferriarnus.tinkersjewelry.TinkersJewelry;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = TinkersJewelry.MODID, bus = EventBusSubscriber.Bus.MOD)
public class JewelryNetwork {

    private static final String VERSION = "1";

    @SubscribeEvent
    public static void registerPayloads(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(VERSION);
        registrar.playToServer(
                SubSpacePacket.TYPE,
                SubSpacePacket.STREAM_CODEC,
                SubSpacePacket::handle
        );
    }
}
