package dev.ferriarnus.tinkersjewelry.capability;

import dev.ferriarnus.tinkersjewelry.TinkersJewelry;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class SubSpaceCapability {

    public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS =
            DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, TinkersJewelry.MODID);

    public static final Supplier<AttachmentType<ItemStackHandler>> SUBSPACE =
            ATTACHMENTS.register("subspace", () ->
                    AttachmentType.builder(() -> new ItemStackHandler(6 * 9))
                            .serialize(ItemStackHandler::serializeNBT)
                            .deserialize((handler, tag) -> handler.deserializeNBT(tag))
                            .copyOnDeath()
                            .build()
            );
}
