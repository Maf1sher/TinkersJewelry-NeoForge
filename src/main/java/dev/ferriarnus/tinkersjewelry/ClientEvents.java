package dev.ferriarnus.tinkersjewelry;

import dev.ferriarnus.tinkersjewelry.network.SubSpacePacket;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.PacketDistributor;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    static void playerTick(net.neoforged.neoforge.event.tick.PlayerTickEvent.Pre event) {
        if (ModClientEvents.SUBSPACE.isDown() && event.getEntity().getAttribute(GemAttributes.SUBSPACE).getValue() >= 1) {
            PacketDistributor.sendToServer(new SubSpacePacket());
        }
    }
}
