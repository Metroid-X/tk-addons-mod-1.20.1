package net.cloudedarctrooper.templar_addons_mod.item.books;

import net.cloudedarctrooper.templar_addons_mod.utils.ModTags;
import net.minecraft.ChatFormatting;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.WrittenBookItem;
import net.minecraft.world.level.Level;
import vazkii.patchouli.api.PatchouliAPI;
import vazkii.patchouli.common.base.PatchouliSounds;
import vazkii.patchouli.common.book.Book;
import vazkii.patchouli.common.item.ItemModBook;

import java.util.List;

public class GuideBook extends ItemModBook {

    public GuideBook() {
        super();
    }



    public void unlockBook(Player player, ItemStack stack) {
        CompoundTag tag = new CompoundTag();
        tag.putString("patchouli:book", "templar_addons:templars_handbook");
        tag.putBoolean("is_open", false);
        stack.setTag(tag);
    }

    private InteractionResult handleBookUse(Player player, ItemStack stack, InteractionHand hand) {
        Book book = getBook(stack);

        player.getTags();

        if (true) {
            player.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
//            stack.getOrCreateTag().putBoolean("is_open", true);
//        } else {
//            stack.getOrCreateTag().putBoolean("is_open", true);
        }


        if (book == null) {
            return InteractionResult.FAIL;
        } else {
            if (player instanceof ServerPlayer) {
                PatchouliAPI.get().openBookGUI((ServerPlayer)player, book.id);
                SoundEvent sfx = PatchouliSounds.getSound(book.openSound, PatchouliSounds.BOOK_OPEN);
                player.playSound(sfx, 1.0F, (float)(0.7 + Math.random() * 0.4));
            }

            return InteractionResult.SUCCESS;
        }
    }

    private static ResourceLocation getBookId(ItemStack stack) {
        if (stack.hasTag() && stack.getTag().contains("patchouli:book")) {
            String bookStr = stack.getTag().getString("patchouli:book");
            return ResourceLocation.tryParse(bookStr);
        } else {
            return null;
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        ResourceLocation rl = getBookId(stack);


        CompoundTag tag = new CompoundTag();
        tag.putString("patchouli:book", "templar_addons:templars_handbook");
        tag.putBoolean("is_open", false);
        stack.setTag(tag);


        if (flagIn.isAdvanced()) {
            tooltip.add(Component.literal("Book ID: " + rl).withStyle(ChatFormatting.GRAY));
        }

        Book book = getBook(stack);
        if (book != null && !book.getContents().isErrored()) {
            tooltip.add(book.getSubtitle().withStyle(ChatFormatting.GRAY));
        } else if (book == null) {
            if (rl == null) {
                tooltip.add(Component.translatable("item.patchouli.guide_book.undefined").withStyle(ChatFormatting.DARK_GRAY));
            } else {
                tooltip.add(Component.translatable("item.patchouli.guide_book.invalid", new Object[]{rl}).withStyle(ChatFormatting.DARK_GRAY));
            }
        }

        Component name = tooltip.get(0);
        tooltip.clear();
        tooltip.add(name);

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player playerFor, InteractionHand handFor) {
        ItemStack itemstack = playerFor.getItemInHand(handFor);


        InteractionHand otherHand = handFor == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
        ItemStack itemInOtherHand = playerFor.getItemInHand(otherHand);

        if (!itemstack.getOrCreateTag().contains("patchouli:book")) {

            if (itemInOtherHand.is(ModTags.Items.BOOK_KEYSTONE)) {

                itemInOtherHand.shrink(1);
                playerFor.playSound(SoundEvents.ENCHANTMENT_TABLE_USE, 1.0F, 1.0F);
                this.unlockBook(playerFor,itemstack);
                return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
            } else {
                return new InteractionResultHolder<>(InteractionResult.FAIL, itemstack);
            }

        } else {
            return new InteractionResultHolder<>(
                    handleBookUse(
                            playerFor,itemstack,playerFor.getUsedItemHand()
                    ), itemstack);
        }
    }
}
