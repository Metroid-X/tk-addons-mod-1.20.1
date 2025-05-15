package net.cloudedarctrooper.templar_addons_mod.item;

import net.cloudedarctrooper.templar_addons_mod.TemplarAddonsMod;
import net.cloudedarctrooper.templar_addons_mod.block.TKTABlocks;
import net.cloudedarctrooper.templar_addons_mod.item.books.CreateGuideBookNBT;
import net.cloudedarctrooper.templar_addons_mod.item.books.GuideBook;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TemplarAddonsMod.MODID);


    public static final RegistryObject<CreativeModeTab> TEMPLAR_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("templar_items_tab",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(TKTAItems.CUT_MANA.get()))
                            .title(Component.translatable("creativetab.templar_items_tab"))
                            .displayItems((itemDisplayParameters, output) -> {
                                output.accept(TKTAItems.MANA_SHARDS.get());
                                output.accept(TKTAItems.RAW_MANA.get());
                                output.accept(TKTAItems.CRUDE_MANA.get());
                                output.accept(TKTAItems.CUT_MANA.get());
                                output.accept(TKTAItems.FLAWLESS_MANA.get());


                                output.accept(TKTAItems.CONCENTRATED_MANA_BUCKET.get());
                                output.accept(TKTAItems.RAW_SILVER.get());
                                output.accept(TKTAItems.SILVER_INGOT.get());
                                output.accept(TKTAItems.RAW_ELECTRIC_AMALGAM.get());
                                output.accept(TKTAItems.ELECTRUM_MIX.get());
                                output.accept(TKTAItems.RAW_ELECTRUM.get());
                                output.accept(TKTAItems.ELECTRUM_INGOT.get());

                                output.accept(TKTAItems.BLACK_MANA.get());
                                output.accept(TKTAItems.END_MANA.get());

                                output.accept(TKTAItems.LEATHER_TANNIN.get());
                                output.accept(TKTAItems.TOUGHENED_LEATHER.get());
                                output.accept(TKTAItems.CUT_LEATHER.get());
                                output.accept(TKTAItems.LEATHER_STRAP.get());
                                output.accept(TKTAItems.TOUGHENED_LEATHER_STRAP.get());

                                output.accept(TKTAItems.GRIND_SURFACE_SAND.get());
                                output.accept(TKTAItems.GRIND_SURFACE_FLINT.get());
                                output.accept(TKTAItems.GRIND_SURFACE_BLAST_STONE.get());
                                output.accept(TKTAItems.GRIND_SURFACE_OBSIDIAN.get());
                                output.accept(TKTAItems.GRIND_SURFACE_NETHER.get());
                                output.accept(TKTAItems.GRIND_SURFACE_QUARTZ.get());
                                output.accept(TKTAItems.GRIND_SURFACE_BLAZED.get());
                                output.accept(TKTAItems.GRIND_SURFACE_PURPUR.get());
                                output.accept(TKTAItems.GRIND_SURFACE_NETHERITE.get());
                                output.accept(TKTAItems.GRIND_SURFACE_ENDERITE.get());

                                output.accept(TKTAItems.LOCKED_STARTER_BOOK.get());
                                output.accept(CreateGuideBookNBT.GUIDE);
                            })
                            .build());



    public static final RegistryObject<CreativeModeTab> TEMPLAR_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("templar_blocks_tab",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(TKTABlocks.MANA_CRYSTAL_BLOCK.get()))
                            .title(Component.translatable("creativetab.templar_blocks_tab"))
                            .displayItems((itemDisplayParameters, output) -> {
                                output.accept(TKTABlocks.MANA_SHARD_BLOCK.get());
                                output.accept(TKTABlocks.MANA_CRYSTAL_BLOCK.get());

                                output.accept(TKTABlocks.RAW_SILVER_BLOCK.get());
                                output.accept(TKTABlocks.RAW_ELECTRUM_BLOCK.get());

                                output.accept(TKTABlocks.SILVER_BLOCK.get());
                                output.accept(TKTABlocks.ELECTRUM_BLOCK.get());

                                output.accept(TKTABlocks.MANA_CRYSTAL_ORE.get());
                                output.accept(TKTABlocks.DEEPSLATE_MANA_CRYSTAL_ORE.get());

                                output.accept(TKTABlocks.SILVER_ORE.get());
                                output.accept(TKTABlocks.DEEPSLATE_SILVER_ORE.get());

                                output.accept(TKTABlocks.ELECTRIC_AMALGAM_ORE.get());
                                output.accept(TKTABlocks.DEEPSLATE_ELECTRIC_AMALGAM_ORE.get());

                                output.accept(TKTABlocks.ELECTRUM_ORE.get());
                                output.accept(TKTABlocks.NETHER_MANA_ORE.get());
                                output.accept(TKTABlocks.BLACK_MANA_BLOCK.get());

                                output.accept(TKTABlocks.ENDMANA_ORE.get());
                                output.accept(TKTABlocks.END_MANA_BLOCK.get());

                                output.accept(TKTABlocks.BLASTED_SMOOTH_STONE.get());
                            })
                            .build());

    public static final RegistryObject<CreativeModeTab> TEMPLAR_MAGIC_TAB =
            CREATIVE_MODE_TABS.register("templar_magic_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(TKTAItems.GUIDE_BOOK.get()))
                    .title(Component.translatable("creativetab.templar_magic_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(CreateGuideBookNBT.GUIDE);
                        output.accept(TKTABlocks.MANA_INFUSION_BENCH.get());
                    })
                    .build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
