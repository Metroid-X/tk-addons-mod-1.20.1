package net.cloudedarctrooper.templar_addons_mod.item;

import net.cloudedarctrooper.templar_addons_mod.TemplarAddonsMod;
import net.cloudedarctrooper.templar_addons_mod.item.books.GuideBook;
import net.cloudedarctrooper.templar_addons_mod.item.books.StarterBook;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vazkii.patchouli.common.item.ItemModBook;

public class TKTAItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TemplarAddonsMod.MODID);

    public static final RegistryObject<Item> MANA_SHARDS = ITEMS.register("mana_shards",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
            ));

    public static final RegistryObject<Item> RAW_MANA = ITEMS.register("raw_mana_crystal",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<Item> CRUDE_MANA = ITEMS.register("crude_mana_crystal",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<Item> CUT_MANA = ITEMS.register("cut_mana_crystal",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.UNCOMMON)
            ));

    public static final RegistryObject<Item> FLAWLESS_MANA = ITEMS.register("flawless_mana_crystal",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.RARE)
            ));

    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
            ));

    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
            ));

    public static final RegistryObject<Item> INFUSED_SILVER_INGOT = ITEMS.register("infused_silver_ingot",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.UNCOMMON)
            ));

    public static final RegistryObject<Item> RAW_ELECTRIC_AMALGAM = ITEMS.register("raw_electric_amalgam",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
            ));

    public static final RegistryObject<Item> ELECTRUM_MIX = ITEMS.register("electrum_mix",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
            ));

    public static final RegistryObject<Item> RAW_ELECTRUM = ITEMS.register("raw_electrum",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
            ));

    public static final RegistryObject<Item> ELECTRUM_INGOT = ITEMS.register("electrum_ingot",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
            ));

    public static final RegistryObject<Item> INFUSED_ELECTRUM_INGOT = ITEMS.register("infused_electrum_ingot",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.UNCOMMON)
            ));

    public static final RegistryObject<Item> BLACK_MANA = ITEMS.register("black_mana_crystal",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.EPIC)
            ));

    public static final RegistryObject<Item> END_MANA = ITEMS.register("end_mana_crystal",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.EPIC)
            ));

    public static final RegistryObject<Item> CONCENTRATED_MANA_BUCKET = ITEMS.register("concentrated_mana_bucket",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.RARE)
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
            ));

    public static final RegistryObject<Item> LEATHER_TANNIN = ITEMS.register("bottle_of_tannin",
            () -> new Item(new Item.Properties()
                    .stacksTo(32)
            ));

    public static final RegistryObject<Item> TOUGHENED_LEATHER = ITEMS.register("toughened_leather",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
            ));

    public static final RegistryObject<Item> CUT_LEATHER = ITEMS.register("cut_leather",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
            ));

    public static final RegistryObject<Item> LEATHER_STRAP = ITEMS.register("leather_strap",
            () -> new Item(new Item.Properties()
                    .stacksTo(32)
            ));

    public static final RegistryObject<Item> TOUGHENED_LEATHER_STRAP = ITEMS.register("toughened_leather_strap",
            () -> new Item(new Item.Properties()
                    .stacksTo(32)
            ));

    public static final RegistryObject<Item> GRIND_SURFACE_SAND = ITEMS.register("grind_surface_sand",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .durability(32)
                    .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<Item> GRIND_SURFACE_FLINT = ITEMS.register("grind_surface_flint",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .durability(64)
                    .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<Item> GRIND_SURFACE_BLAST_STONE = ITEMS.register("grind_surface_blasted",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .durability(96)
                    .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<Item> GRIND_SURFACE_OBSIDIAN = ITEMS.register("grind_surface_obsidian",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .durability(128)
                    .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<Item> GRIND_SURFACE_NETHER = ITEMS.register("grind_surface_nether",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .durability(192)
                    .rarity(Rarity.UNCOMMON)
            ));

    public static final RegistryObject<Item> GRIND_SURFACE_QUARTZ = ITEMS.register("grind_surface_quartz",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .durability(256)
                    .rarity(Rarity.UNCOMMON)
            ));

    public static final RegistryObject<Item> GRIND_SURFACE_BLAZED = ITEMS.register("grind_surface_blazed",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .durability(320)
                    .rarity(Rarity.RARE)
            ));

    public static final RegistryObject<Item> GRIND_SURFACE_PURPUR = ITEMS.register("grind_surface_purpur",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .durability(512)
                    .rarity(Rarity.RARE)
            ));

    public static final RegistryObject<Item> GRIND_SURFACE_NETHERITE = ITEMS.register("grind_surface_netherite",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .durability(1024)
                    .rarity(Rarity.RARE)
            ));

    public static final RegistryObject<Item> GRIND_SURFACE_ENDERITE = ITEMS.register("grind_surface_enderite",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .durability(2048)
                    .rarity(Rarity.EPIC)
            ));

    public static final RegistryObject<Item> LOCKED_STARTER_BOOK = ITEMS.register("curious_templar_journal",
            () -> new StarterBook(new Item.Properties()
                    .stacksTo(1)
            ));

    public static final RegistryObject<Item> GUIDE_BOOK = ITEMS.register("guide_book",
            GuideBook::new);



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
