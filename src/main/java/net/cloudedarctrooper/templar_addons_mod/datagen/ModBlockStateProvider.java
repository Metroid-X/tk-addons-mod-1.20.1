package net.cloudedarctrooper.templar_addons_mod.datagen;

import net.cloudedarctrooper.templar_addons_mod.TemplarAddonsMod;
import net.cloudedarctrooper.templar_addons_mod.block.TKTABlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TemplarAddonsMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(TKTABlocks.MANA_SHARD_BLOCK);
        blockWithItem(TKTABlocks.MANA_CRYSTAL_BLOCK);
        blockWithItem(TKTABlocks.BLACK_MANA_BLOCK);
        blockWithItem(TKTABlocks.END_MANA_BLOCK);

        blockWithItem(TKTABlocks.RAW_SILVER_BLOCK);
        blockWithItem(TKTABlocks.RAW_ELECTRUM_BLOCK);

        blockWithItem(TKTABlocks.SILVER_BLOCK);
        blockWithItem(TKTABlocks.ELECTRUM_BLOCK);

        blockWithItem(TKTABlocks.MANA_CRYSTAL_ORE);
        blockWithItem(TKTABlocks.DEEPSLATE_MANA_CRYSTAL_ORE);

        blockWithItem(TKTABlocks.SILVER_ORE);
        blockWithItem(TKTABlocks.DEEPSLATE_SILVER_ORE);

        blockWithItem(TKTABlocks.ELECTRIC_AMALGAM_ORE);
        blockWithItem(TKTABlocks.DEEPSLATE_ELECTRIC_AMALGAM_ORE);

        blockWithItem(TKTABlocks.ELECTRUM_ORE);
        blockWithItem(TKTABlocks.NETHER_MANA_ORE);

        blockWithItem(TKTABlocks.ENDMANA_ORE);

        blockWithItem(TKTABlocks.BLASTED_SMOOTH_STONE);

        simpleBlockWithItem(TKTABlocks.MANA_INFUSION_BENCH.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/mana_infusion_station")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
