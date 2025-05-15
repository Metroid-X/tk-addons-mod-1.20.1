package net.cloudedarctrooper.templar_addons_mod.datagen;

import net.cloudedarctrooper.templar_addons_mod.TemplarAddonsMod;
import net.cloudedarctrooper.templar_addons_mod.item.TKTAItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TemplarAddonsMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(TKTAItems.MANA_SHARDS);
        simpleItem(TKTAItems.RAW_MANA);
        simpleItem(TKTAItems.CRUDE_MANA);
        simpleItem(TKTAItems.BLACK_MANA);
        simpleItem(TKTAItems.END_MANA);
        simpleItem(TKTAItems.CUT_MANA);
        simpleItem(TKTAItems.FLAWLESS_MANA);
        simpleItem(TKTAItems.RAW_SILVER);
        simpleItem(TKTAItems.RAW_ELECTRUM);
        simpleItem(TKTAItems.RAW_ELECTRIC_AMALGAM);
        simpleItem(TKTAItems.ELECTRUM_MIX);

        simpleItem(TKTAItems.SILVER_INGOT);
        simpleItem(TKTAItems.ELECTRUM_INGOT);

        simpleItem(TKTAItems.INFUSED_SILVER_INGOT);
        simpleItem(TKTAItems.INFUSED_ELECTRUM_INGOT);

        simpleItem(TKTAItems.LEATHER_TANNIN);
        simpleItem(TKTAItems.TOUGHENED_LEATHER);
        simpleItem(TKTAItems.CUT_LEATHER);
        simpleItem(TKTAItems.LEATHER_STRAP);
        simpleItem(TKTAItems.TOUGHENED_LEATHER_STRAP);

        simpleItem(TKTAItems.GRIND_SURFACE_SAND);
        simpleItem(TKTAItems.GRIND_SURFACE_FLINT);
        simpleItem(TKTAItems.GRIND_SURFACE_BLAST_STONE);
        simpleItem(TKTAItems.GRIND_SURFACE_OBSIDIAN);
        simpleItem(TKTAItems.GRIND_SURFACE_NETHER);
        simpleItem(TKTAItems.GRIND_SURFACE_QUARTZ);
        simpleItem(TKTAItems.GRIND_SURFACE_BLAZED);
        simpleItem(TKTAItems.GRIND_SURFACE_PURPUR);
        simpleItem(TKTAItems.GRIND_SURFACE_NETHERITE);
        simpleItem(TKTAItems.GRIND_SURFACE_ENDERITE);

        simpleItem(TKTAItems.CONCENTRATED_MANA_BUCKET);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TemplarAddonsMod.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleCuriousItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0",
                new ResourceLocation(TemplarAddonsMod.MODID,"item/" + item.getId().getPath()))
                .texture("layer1",
                new ResourceLocation(TemplarAddonsMod.MODID,"item/curiosity"));
    }
}
