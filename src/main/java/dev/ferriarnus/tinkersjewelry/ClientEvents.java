package dev.ferriarnus.tinkersjewelry;

import dev.ferriarnus.tinkersjewelry.network.JewelryNetwork;
import dev.ferriarnus.tinkersjewelry.network.SubSpacePacket;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    static void playerTick(net.neoforged.neoforge.event.TickEvent.PlayerTickEvent event) {
        if (ModClientEvents.SUBSPACE.isDown() && event.player.getAttribute(GemAttributes.SUBSPACE.get()).getValue() >= 1) {
            JewelryNetwork.getInstance().sendToServer(new SubSpacePacket());
        }
    }
}
