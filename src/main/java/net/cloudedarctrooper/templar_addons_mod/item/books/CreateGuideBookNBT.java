package net.cloudedarctrooper.templar_addons_mod.item.books;

import net.cloudedarctrooper.templar_addons_mod.item.TKTAItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CreateGuideBookNBT {

    public static ItemStack guideBookStackItem = new ItemStack(TKTAItems.GUIDE_BOOK.get());

    public static CompoundTag guideBookTag() {
        CompoundTag tag = new CompoundTag();
        tag.putString("patchouli:book", "templar_addons:templars_handbook");
        return tag;
    }

    public static Item guideBook(ItemStack stack, CompoundTag tag) {
        stack.setTag(tag);
        return stack.getItem();
    }

    public static final Item GUIDE = guideBook(guideBookStackItem, guideBookTag());
}
