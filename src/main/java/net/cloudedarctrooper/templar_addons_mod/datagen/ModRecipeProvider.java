package net.cloudedarctrooper.templar_addons_mod.datagen;

import net.cloudedarctrooper.templar_addons_mod.TemplarAddonsMod;
import net.cloudedarctrooper.templar_addons_mod.block.TKTABlocks;
import net.cloudedarctrooper.templar_addons_mod.item.TKTAItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> MANA_SMELTABLES = List.of(
            TKTABlocks.MANA_CRYSTAL_ORE.get(),
            TKTABlocks.DEEPSLATE_MANA_CRYSTAL_ORE.get()
    );

    private static final List<ItemLike> SILVER_SMELTABLES = List.of(
            TKTAItems.RAW_SILVER.get(),
            TKTABlocks.SILVER_ORE.get(),
            TKTABlocks.DEEPSLATE_SILVER_ORE.get()
    );

    private static final List<ItemLike> ELECTRUM_SMELTABLES = List.of(
            TKTAItems.RAW_ELECTRUM.get(),
            TKTAItems.ELECTRUM_MIX.get(),
            TKTABlocks.ELECTRUM_ORE.get()
    );

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, MANA_SMELTABLES, RecipeCategory.MISC, TKTAItems.RAW_MANA.get(), 0.25f,200,"raw_mana");
        oreBlasting(pWriter, MANA_SMELTABLES, RecipeCategory.MISC, TKTAItems.RAW_MANA.get(), 0.25f,100,"raw_mana");

        oreSmelting(pWriter, SILVER_SMELTABLES, RecipeCategory.MISC, TKTAItems.SILVER_INGOT.get(), 0.5f,200,"silver_ingot");
        oreBlasting(pWriter, SILVER_SMELTABLES, RecipeCategory.MISC, TKTAItems.SILVER_INGOT.get(), 0.5f,100,"silver_ingot");

        oreSmelting(pWriter, ELECTRUM_SMELTABLES, RecipeCategory.MISC, TKTAItems.ELECTRUM_INGOT.get(), 0.625f,200,"electrum_ingot");
        oreBlasting(pWriter, ELECTRUM_SMELTABLES, RecipeCategory.MISC, TKTAItems.ELECTRUM_INGOT.get(), 0.625f,100,"electrum_ingot");

        // Shaped
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TKTABlocks.MANA_SHARD_BLOCK.get())
                .pattern("sss")
                .pattern("sss")
                .pattern("sss")
                .define('s', TKTAItems.MANA_SHARDS.get())
                .unlockedBy(getHasName(TKTAItems.MANA_SHARDS.get()), has(TKTAItems.MANA_SHARDS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TKTABlocks.MANA_CRYSTAL_BLOCK.get())
                .pattern("mmm")
                .pattern("mmm")
                .pattern("mmm")
                .define('m', TKTAItems.RAW_MANA.get())
                .unlockedBy(getHasName(TKTAItems.RAW_MANA.get()), has(TKTAItems.RAW_MANA.get()))
                .save(pWriter);

        // Shapeless
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TKTAItems.RAW_MANA.get(), 9)
                .requires(TKTABlocks.MANA_CRYSTAL_BLOCK.get())
                .unlockedBy(getHasName(TKTABlocks.MANA_CRYSTAL_BLOCK.get()), has(TKTABlocks.MANA_CRYSTAL_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TKTAItems.RAW_ELECTRIC_AMALGAM.get(), 2)
                .requires(TKTAItems.RAW_SILVER.get())
                .requires(TKTAItems.RAW_SILVER.get())
                .requires(Items.RAW_GOLD)
                .requires(Items.RAW_GOLD)
                .requires(Items.RAW_COPPER)
                .unlockedBy(getHasName(TKTAItems.RAW_ELECTRIC_AMALGAM.get()), has(TKTAItems.RAW_ELECTRIC_AMALGAM.get()))
                .save(pWriter);

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, TemplarAddonsMod.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }


}
