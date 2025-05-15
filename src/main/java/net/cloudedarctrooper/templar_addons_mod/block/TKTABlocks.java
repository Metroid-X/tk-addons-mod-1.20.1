package net.cloudedarctrooper.templar_addons_mod.block;

import net.cloudedarctrooper.templar_addons_mod.TemplarAddonsMod;
import net.cloudedarctrooper.templar_addons_mod.block.custom.ManaInfusionStationBlock;
import net.cloudedarctrooper.templar_addons_mod.item.TKTAItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class TKTABlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TemplarAddonsMod.MODID);

    public static final RegistryObject<Block> MANA_SHARD_BLOCK = registerBlock("mana_shard_block",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.TUFF)
                    .mapColor(MapColor.COLOR_CYAN)
            ));

    public static final RegistryObject<Block> MANA_CRYSTAL_BLOCK = registerBlock("mana_crystal_block",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .mapColor(MapColor.LAPIS)
            ));

    public static final RegistryObject<Block> BLACK_MANA_BLOCK = registerBlock("black_mana_crystal_block",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .mapColor(MapColor.COLOR_BLACK)
            ));

    public static final RegistryObject<Block> END_MANA_BLOCK = registerBlock("end_mana_crystal_block",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .mapColor(MapColor.WARPED_NYLIUM)
            ));

    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.IRON_BLOCK)
                    .mapColor(MapColor.CLAY)
            ));

    public static final RegistryObject<Block> RAW_SILVER_BLOCK = registerBlock("raw_silver_block",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.RAW_IRON_BLOCK)
                    .mapColor(MapColor.CLAY)
            ));

    public static final RegistryObject<Block> ELECTRUM_BLOCK = registerBlock("electrum_block",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.GOLD_BLOCK)
            ));

    public static final RegistryObject<Block> RAW_ELECTRUM_BLOCK = registerBlock("raw_electrum_block",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.RAW_GOLD_BLOCK)
            ));

    public static final RegistryObject<Block> BLASTED_SMOOTH_STONE = registerBlock("blasted_smooth_stone",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.POLISHED_DEEPSLATE)
                    .sound(SoundType.STONE)
            ));

    // ORES

    public static final RegistryObject<Block> MANA_CRYSTAL_ORE = registerBlock("mana_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties
                    .copy(Blocks.IRON_ORE)
                    .requiresCorrectToolForDrops()
                    .strength(3F)
                    .lightLevel(blockState -> 4)
                    , UniformInt.of(1, 5)
            ));

    public static final RegistryObject<Block> DEEPSLATE_MANA_CRYSTAL_ORE = registerBlock("deepslate_mana_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties
                    .copy(Blocks.DEEPSLATE_IRON_ORE)
                    .requiresCorrectToolForDrops()
                    .strength(3F)
                    .lightLevel(blockState -> 4)
                    , UniformInt.of(2, 7)
            ));

    public static final RegistryObject<Block> SILVER_ORE = registerBlock("silver_ore",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.IRON_ORE)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.DEEPSLATE_IRON_ORE)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> ELECTRIC_AMALGAM_ORE = registerBlock("electric_amalgam_ore",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.GOLD_ORE)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> DEEPSLATE_ELECTRIC_AMALGAM_ORE = registerBlock("deepslate_electric_amalgam_ore",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.DEEPSLATE_GOLD_ORE)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> ELECTRUM_ORE = registerBlock("electrum_ore",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.NETHER)
                    .sound(SoundType.NETHER_GOLD_ORE)
            ));

    public static final RegistryObject<Block> NETHER_MANA_ORE = registerBlock("nether_mana_ore",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.NETHER)
                    .sound(SoundType.NETHER_ORE)
            ));

    public static final RegistryObject<Block> ENDMANA_ORE = registerBlock("endmana_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties
                    .copy(Blocks.DIAMOND_ORE)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.SAND)
                    .sound(SoundType.STONE)
                    , UniformInt.of(8, 25)
            ));

    // SPECIAL BLOCKS


    // BLOCK ENTITIES

    public static final RegistryObject<Block> MANA_INFUSION_BENCH = registerBlock("mana_infusion_bench",
            () -> new ManaInfusionStationBlock(
                    BlockBehaviour.Properties
                            .copy(Blocks.IRON_BLOCK)
                            .sound(SoundType.STONE)
                            .noOcclusion()
            ));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        TKTAItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
