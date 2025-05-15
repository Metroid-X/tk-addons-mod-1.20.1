package net.cloudedarctrooper.templar_addons_mod.datagen;

import net.cloudedarctrooper.templar_addons_mod.TemplarAddonsMod;
import net.cloudedarctrooper.templar_addons_mod.block.TKTABlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends net.minecraftforge.common.data.BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TemplarAddonsMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        TKTABlocks.MANA_SHARD_BLOCK.get(),
                        TKTABlocks.MANA_CRYSTAL_BLOCK.get(),

                        TKTABlocks.BLASTED_SMOOTH_STONE.get(),

                        TKTABlocks.MANA_CRYSTAL_ORE.get(),
                        TKTABlocks.DEEPSLATE_MANA_CRYSTAL_ORE.get(),

                        TKTABlocks.SILVER_ORE.get(),
                        TKTABlocks.DEEPSLATE_SILVER_ORE.get(),
                        TKTABlocks.RAW_SILVER_BLOCK.get(),
                        TKTABlocks.SILVER_BLOCK.get(),

                        TKTABlocks.ELECTRIC_AMALGAM_ORE.get(),
                        TKTABlocks.DEEPSLATE_ELECTRIC_AMALGAM_ORE.get(),

                        TKTABlocks.NETHER_MANA_ORE.get(),
                        TKTABlocks.BLACK_MANA_BLOCK.get(),

                        TKTABlocks.ELECTRUM_ORE.get(),
                        TKTABlocks.RAW_ELECTRUM_BLOCK.get(),
                        TKTABlocks.ELECTRUM_BLOCK.get(),

                        TKTABlocks.ENDMANA_ORE.get(),
                        TKTABlocks.END_MANA_BLOCK.get()
                );

        this.tag(Tags.Blocks.ORES)
                .add(
                        TKTABlocks.MANA_CRYSTAL_ORE.get(),
                        TKTABlocks.DEEPSLATE_MANA_CRYSTAL_ORE.get(),
                        TKTABlocks.SILVER_ORE.get(),
                        TKTABlocks.DEEPSLATE_SILVER_ORE.get(),
                        TKTABlocks.ELECTRIC_AMALGAM_ORE.get(),
                        TKTABlocks.DEEPSLATE_ELECTRIC_AMALGAM_ORE.get(),
                        TKTABlocks.ELECTRUM_ORE.get(),
                        TKTABlocks.NETHER_MANA_ORE.get(),
                        TKTABlocks.ENDMANA_ORE.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        TKTABlocks.RAW_ELECTRUM_BLOCK.get(),
                        TKTABlocks.ELECTRUM_BLOCK.get(),
                        TKTABlocks.BLACK_MANA_BLOCK.get(),

                        TKTABlocks.SILVER_ORE.get(),
                        TKTABlocks.DEEPSLATE_SILVER_ORE.get(),
                        TKTABlocks.RAW_SILVER_BLOCK.get(),
                        TKTABlocks.SILVER_BLOCK.get(),

                        TKTABlocks.MANA_CRYSTAL_ORE.get(),
                        TKTABlocks.DEEPSLATE_MANA_CRYSTAL_ORE.get(),

                        TKTABlocks.BLASTED_SMOOTH_STONE.get()
                );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(
                        TKTABlocks.ELECTRUM_ORE.get(),
                        TKTABlocks.NETHER_MANA_ORE.get(),

                        TKTABlocks.END_MANA_BLOCK.get()
                );

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(
                        TKTABlocks.ENDMANA_ORE.get()
                );
    }
}
