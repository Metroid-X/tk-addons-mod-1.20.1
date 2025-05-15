package net.cloudedarctrooper.templar_addons_mod.datagen.loot;

import net.cloudedarctrooper.templar_addons_mod.block.TKTABlocks;
import net.cloudedarctrooper.templar_addons_mod.item.TKTAItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(TKTABlocks.MANA_SHARD_BLOCK.get());
        this.dropSelf(TKTABlocks.MANA_CRYSTAL_BLOCK.get());
        this.dropSelf(TKTABlocks.BLACK_MANA_BLOCK.get());
        this.dropSelf(TKTABlocks.END_MANA_BLOCK.get());
        this.dropSelf(TKTABlocks.SILVER_BLOCK.get());
        this.dropSelf(TKTABlocks.ELECTRUM_BLOCK.get());
        this.dropSelf(TKTABlocks.BLASTED_SMOOTH_STONE.get());
        this.dropSelf(TKTABlocks.RAW_SILVER_BLOCK.get());
        this.dropSelf(TKTABlocks.RAW_ELECTRUM_BLOCK.get());
        this.dropSelf(TKTABlocks.MANA_INFUSION_BENCH.get());

        this.add(TKTABlocks.MANA_CRYSTAL_ORE.get(),
                block -> createManaCrystalLikeOreDrops(
                        TKTABlocks.MANA_CRYSTAL_ORE.get(),
                        TKTAItems.MANA_SHARDS.get(),
                        TKTAItems.RAW_MANA.get(),
                        LootItemRandomChanceCondition.randomChance(0.875F),
                        1.0F
                ));

        this.add(TKTABlocks.DEEPSLATE_MANA_CRYSTAL_ORE.get(),
                block -> createManaCrystalLikeOreDrops(
                        TKTABlocks.MANA_CRYSTAL_ORE.get(),
                        TKTAItems.MANA_SHARDS.get(),
                        TKTAItems.RAW_MANA.get(),
                        LootItemRandomChanceCondition.randomChance(0.875F),
                        1.125F
                ));

        this.add(TKTABlocks.NETHER_MANA_ORE.get(),
                block -> createManaCrystalLikeOreDrops(
                        TKTABlocks.NETHER_MANA_ORE.get(),
                        TKTAItems.BLACK_MANA.get(),
                        TKTAItems.RAW_MANA.get(),
                        LootItemRandomChanceCondition.randomChance(0.5F),
                        1.75F
                ));

        this.add(TKTABlocks.SILVER_ORE.get(),
                block -> createElectrumOreDrops(
                        TKTABlocks.SILVER_ORE.get(),
                        TKTAItems.RAW_SILVER.get()
                ));

        this.add(TKTABlocks.DEEPSLATE_SILVER_ORE.get(),
                block -> createElectrumOreDrops(
                        TKTABlocks.DEEPSLATE_SILVER_ORE.get(),
                        TKTAItems.RAW_SILVER.get()
                ));

        this.add(TKTABlocks.ELECTRIC_AMALGAM_ORE.get(),
                block -> createAmalgamOreDrops(
                        TKTABlocks.ELECTRIC_AMALGAM_ORE.get(),
                        TKTAItems.RAW_ELECTRIC_AMALGAM.get()
                ));

        this.add(TKTABlocks.DEEPSLATE_ELECTRIC_AMALGAM_ORE.get(),
                block -> createAmalgamOreDrops(
                        TKTABlocks.DEEPSLATE_ELECTRIC_AMALGAM_ORE.get(),
                        TKTAItems.RAW_ELECTRIC_AMALGAM.get()
                ));

        this.add(TKTABlocks.ELECTRUM_ORE.get(),
                block -> createElectrumOreDrops(
                        TKTABlocks.ELECTRUM_ORE.get(),
                        TKTAItems.RAW_ELECTRUM.get()
                ));

        this.add(TKTABlocks.ENDMANA_ORE.get(),
                block -> createManaCrystalLikeOreDrops(
                        TKTABlocks.ENDMANA_ORE.get(),
                        TKTAItems.BLACK_MANA.get(),
                        TKTAItems.END_MANA.get(),
                        LootItemRandomChanceCondition.randomChance(0.875F),
                        1.25F
                ));

    }

    protected LootTable.Builder createManaCrystalLikeOreDrops(Block pBlock, Item item1, Item item2, LootItemCondition.Builder pCondition, Float pChance) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F * pChance, 3.0F * pChance)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))

        )).withPool((LootPool.lootPool()
                .add((LootItem
                        .lootTableItem(item1)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))
                .add((LootItem
                        .lootTableItem(item2)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F * pChance, 2.0F * pChance)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                        .when(pCondition)))

        ));
    }


    protected LootTable.Builder createElectrumOreDrops(Block pBlock, Item pItem) {
        return createSilkTouchDispatchTable(pBlock,
                        this.applyExplosionDecay(pBlock,
                                LootItem.lootTableItem(pItem)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createAmalgamOreDrops(Block pBlock, Item pItem) {
        return createSilkTouchDispatchTable(pBlock,
                        this.applyExplosionDecay(pBlock,
                                LootItem.lootTableItem(pItem)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.25F, 2.5F)))
                                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))
                ;
    }

    protected LootTable.Builder createModCropDrops(Block pCropBlock, Item pGrownCropItem, Item pSeedsItem, LootItemCondition.Builder pDropGrownCropCondition) {
        return this.applyExplosionDecay(pCropBlock,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add((LootItem
                                        .lootTableItem(pGrownCropItem)
                                        .when(pDropGrownCropCondition))
                                        .otherwise(LootItem.lootTableItem(pSeedsItem))))
                        .withPool(LootPool.lootPool()
                                .when(pDropGrownCropCondition)
                                .add(LootItem.lootTableItem(pSeedsItem)
                                        .apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3)))));
    }




    @Override
    protected Iterable<Block> getKnownBlocks() {
        return TKTABlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
