package dev.ferriarnus.tinkersjewelry.network;

import dev.ferriarnus.tinkersjewelry.TinkersJewelry;
import dev.ferriarnus.tinkersjewelry.menu.SubSpaceMenu;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleMenuProvider;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record SubSpacePacket() implements CustomPacketPayload {

    public static final Type<SubSpacePacket> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(TinkersJewelry.MODID, "subspace"));

    public static final StreamCodec<RegistryFriendlyByteBuf, SubSpacePacket> STREAM_CODEC =
            StreamCodec.unit(new SubSpacePacket());

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(SubSpacePacket packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            ServerPlayer serverPlayer = (ServerPlayer) context.player();
            serverPlayer.openMenu(new SimpleMenuProvider(
                    (id, inventory, player) -> new SubSpaceMenu(id, inventory),
                    Component.translatable("gui.tinkersjewelry.subspace")
            ));
        });
    }
}
