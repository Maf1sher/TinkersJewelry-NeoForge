package dev.ferriarnus.tinkersjewelry.network;

import dev.ferriarnus.tinkersjewelry.menu.SubSpaceMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleMenuProvider;
import net.neoforged.neoforge.network.NetworkEvent;
import net.neoforged.neoforge.network.NetworkHooks;
import slimeknights.mantle.network.packet.IThreadsafePacket;

public class SubSpacePacket implements IThreadsafePacket {

    public SubSpacePacket() {

    }

    public SubSpacePacket(FriendlyByteBuf buf) {

    }

    @Override
    public void handleThreadsafe(NetworkEvent.Context context) {
        ServerPlayer serverPlayer = context.getSender();
        NetworkHooks.openScreen(serverPlayer, new SimpleMenuProvider(
                (id, inventory, p) -> new SubSpaceMenu(id, inventory),
                Component.translatable("gui.tinkersjewelry.subspace")),
                (buf) -> {});
    }

    @Override
    public void encode(FriendlyByteBuf friendlyByteBuf) {

    }
}
