package net.cloudedarctrooper.templar_addons_mod.datagen;

import net.cloudedarctrooper.templar_addons_mod.TemplarAddonsMod;
import net.cloudedarctrooper.templar_addons_mod.item.TKTAItems;
import net.cloudedarctrooper.templar_addons_mod.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends net.minecraft.data.tags.ItemTagsProvider {

    public ModItemTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pHolderLookup, CompletableFuture<TagLookup<Block>> pTagLookup, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pHolderLookup, pTagLookup, TemplarAddonsMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Items.TIER_1_GRIND_SURFACE)
                .add(
                        TKTAItems.GRIND_SURFACE_SAND.get(),
                        TKTAItems.GRIND_SURFACE_FLINT.get(),
                        TKTAItems.GRIND_SURFACE_BLAST_STONE.get(),
                        TKTAItems.GRIND_SURFACE_OBSIDIAN.get(),
                        TKTAItems.GRIND_SURFACE_NETHER.get(),
                        TKTAItems.GRIND_SURFACE_QUARTZ.get(),
                        TKTAItems.GRIND_SURFACE_BLAZED.get(),
                        TKTAItems.GRIND_SURFACE_PURPUR.get(),
                        TKTAItems.GRIND_SURFACE_NETHERITE.get()
                );
        this.tag(ModTags.Items.TIER_2_GRIND_SURFACE)
                .add(
                        TKTAItems.GRIND_SURFACE_BLAST_STONE.get(),
                        TKTAItems.GRIND_SURFACE_OBSIDIAN.get(),
                        TKTAItems.GRIND_SURFACE_NETHER.get(),
                        TKTAItems.GRIND_SURFACE_QUARTZ.get(),
                        TKTAItems.GRIND_SURFACE_BLAZED.get(),
                        TKTAItems.GRIND_SURFACE_PURPUR.get(),
                        TKTAItems.GRIND_SURFACE_NETHERITE.get()
                );
        this.tag(ModTags.Items.TIER_3_GRIND_SURFACE)
                .add(
                        TKTAItems.GRIND_SURFACE_QUARTZ.get(),
                        TKTAItems.GRIND_SURFACE_BLAZED.get(),
                        TKTAItems.GRIND_SURFACE_PURPUR.get(),
                        TKTAItems.GRIND_SURFACE_NETHERITE.get(),
                        TKTAItems.GRIND_SURFACE_ENDERITE.get()
                );
        this.tag(ModTags.Items.TIER_4_GRIND_SURFACE)
                .add(
                        TKTAItems.GRIND_SURFACE_PURPUR.get(),
                        TKTAItems.GRIND_SURFACE_NETHERITE.get(),
                        TKTAItems.GRIND_SURFACE_ENDERITE.get()
                );
        this.tag(ModTags.Items.BOOK_KEYSTONE)
                .add(
                        TKTAItems.CUT_MANA.get()
                );
    }
}
