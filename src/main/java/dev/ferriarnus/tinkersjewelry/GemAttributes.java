package dev.ferriarnus.tinkersjewelry;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = TinkersJewelry.MODID)
public class GemAttributes {

    private static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(Registries.ATTRIBUTE, TinkersJewelry.MODID);

    public static void register(IEventBus modEventBus) {
        ATTRIBUTES.register(modEventBus);
    }

    public static final DeferredHolder<Attribute, Attribute> FORTUNE = ATTRIBUTES.register("fortune", () -> new RangedAttribute("tinkersjewelry:fortune", 0.0d, 0.0d, 10.0d).setSyncable(true));
    public static final DeferredHolder<Attribute, Attribute> SILK = ATTRIBUTES.register("silk", () -> new RangedAttribute("tinkersjewelry:silk", 0.0d, 0.0d, 10.0d).setSyncable(true));
    public static final DeferredHolder<Attribute, Attribute> TRADE = ATTRIBUTES.register("trade", () -> new RangedAttribute("tinkersjewelry:trade", 0.0d, 0.0d, 100.0d).setSyncable(true));
    public static final DeferredHolder<Attribute, Attribute> SUBSPACE = ATTRIBUTES.register("subspace", () -> new RangedAttribute("tinkersjewelry:subspace", 0.0d, 0.0d, 6.0d));

    @SubscribeEvent
    static void registerAttributes(EntityAttributeModificationEvent event) {
        event.getTypes().forEach(type -> {
            event.add(type, GemAttributes.FORTUNE);
            event.add(type, GemAttributes.TRADE);
            event.add(type, GemAttributes.SILK);
            event.add(type, GemAttributes.SUBSPACE);
        });
    }
}
