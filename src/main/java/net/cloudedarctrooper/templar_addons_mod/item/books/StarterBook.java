package net.cloudedarctrooper.templar_addons_mod.item.books;

import net.cloudedarctrooper.templar_addons_mod.utils.ModTags;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vazkii.patchouli.common.item.PatchouliItems;

public class StarterBook extends Item {

    public StarterBook(Item.Properties pProperties) {
        super(pProperties
        );
    }

    public static ItemStack starterBookItem() {
        ItemStack starterBook = PatchouliItems.BOOK.getDefaultInstance();
        CompoundTag starterBookTag = new CompoundTag();
        starterBookTag.putString("patchouli:book", "templar_addons:templars_handbook");
        starterBook.setTag(starterBookTag);

        return starterBook;
    }

    public void unlockBook(LivingEntity entityLiving) {
        entityLiving.setItemInHand(entityLiving.getUsedItemHand(), starterBookItem());
    }

    @Override
    public InteractionResultHolder<ItemStack> use( Level world, Player playerFor, InteractionHand handFor) {
        ItemStack itemstack = playerFor.getItemInHand(handFor);


        InteractionHand otherHand = handFor == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
        ItemStack itemInOtherHand = playerFor.getItemInHand(otherHand);

        if (itemInOtherHand.is(ModTags.Items.BOOK_KEYSTONE)) {
            itemInOtherHand.shrink(1);
            playerFor.playSound(SoundEvents.ARMOR_EQUIP_LEATHER, 1.0F, 1.0F);
            this.unlockBook(playerFor);
            return new InteractionResultHolder<>(InteractionResult.CONSUME, itemstack);
        } else {
            return new InteractionResultHolder<>(InteractionResult.FAIL, itemstack);
        }
    }
}
