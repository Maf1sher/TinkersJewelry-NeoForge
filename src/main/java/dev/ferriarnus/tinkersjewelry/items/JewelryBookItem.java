package dev.ferriarnus.tinkersjewelry.items;

import dev.ferriarnus.tinkersjewelry.book.JewerlyBook;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slimeknights.mantle.item.book.LecternBookItem;

public class JewelryBookItem extends LecternBookItem {

    public JewelryBookItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (world.isClientSide) {
            JewerlyBook.JEWELRY_BOOK.openGui(hand, stack);
        }
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
    }

    @Override
    public void openLecternScreenClient(BlockPos pos, ItemStack stack) {
        JewerlyBook.JEWELRY_BOOK.openGui(pos, stack);
    }
}
