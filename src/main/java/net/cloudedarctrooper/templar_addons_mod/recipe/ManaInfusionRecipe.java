package net.cloudedarctrooper.templar_addons_mod.recipe;

import net.cloudedarctrooper.templar_addons_mod.TemplarAddonsMod;
import net.cloudedarctrooper.templar_addons_mod.block.entity.MIStationSlots;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class ManaInfusionRecipe implements Recipe<SimpleContainer> {

    public static int COMPONENTS_MAX_WIDTH = 2;
    public static int COMPONENTS_MAX_HEIGHT = 2;

    //  [][]┌┐[][]
    //  [][]└┘[][]
    //   [] [] []
    //  [][]┌┐[][]
    //  [][]└┘[][]
    //    ↪ [] ↩


    public static final ResourceLocation TYPE_ID =
            new ResourceLocation(TemplarAddonsMod.MODID, "mana_infusion");

    public static final RecipeType<ManaInfusionRecipe> TYPE = ModRecipes.INFUSION;

    final int widthNW;
    final int heightNW;
    final NonNullList<Ingredient> recipeItemsNW;
    final int widthNE;
    final int heightNE;
    final NonNullList<Ingredient> recipeItemsNE;
    final int widthSW;
    final int heightSW;
    final NonNullList<Ingredient> recipeItemsSW;
    final int widthSE;
    final int heightSE;
    final NonNullList<Ingredient> recipeItemsSE;



    private final Ingredient westElement;
    private final Ingredient northElement;
    private final Ingredient eastElement;
    private final Ingredient southElement;

    private final Ingredient mainIngredient;

    final int mana1Cost;
    final int mana2Cost;
    final int mana3Cost;

    final ItemStack result;
    final ResourceLocation id;
    final String group;
    final CraftingBookCategory category;
    final boolean showNotification;


    public static void setComponentSize(int width, int height){
        if(COMPONENTS_MAX_WIDTH < width) {
            COMPONENTS_MAX_WIDTH = width;
        }
        if(COMPONENTS_MAX_HEIGHT < height) {
            COMPONENTS_MAX_HEIGHT = height;
        }
    }

    public ManaInfusionRecipe(
            ResourceLocation id, String group,
            CraftingBookCategory category,
            int widthNW, int heightNW, NonNullList recipeItemsNW,
            int widthNE, int heightNE, NonNullList recipeItemsNE,
            int widthSW, int heightSW, NonNullList recipeItemsSW,
            int widthSE, int heightSE, NonNullList recipeItemsSE,
            Ingredient westElement, Ingredient northElement,
            Ingredient eastElement, Ingredient southElement,
            Ingredient mainIngredient,
            int mana1Cost, int mana2Cost, int mana3Cost,
            ItemStack result, boolean showNotification
    ){
        this.widthNW = widthNW;
        this.heightNW = heightNW;
        this.recipeItemsNW = recipeItemsNW;
        this.widthNE = widthNE;
        this.heightNE = heightNE;
        this.recipeItemsNE = recipeItemsNE;
        this.widthSW = widthSW;
        this.heightSW = heightSW;
        this.recipeItemsSW = recipeItemsSW;
        this.widthSE = widthSE;
        this.heightSE = heightSE;
        this.recipeItemsSE = recipeItemsSE;
        this.westElement = westElement;
        this.northElement = northElement;
        this.eastElement = eastElement;
        this.southElement = southElement;
        this.mainIngredient = mainIngredient;
        this.mana1Cost = mana1Cost;
        this.mana2Cost = mana2Cost;
        this.mana3Cost = mana3Cost;
        this.result = result;
        this.id = id;
        this.group = group;
        this.category = category;
        this.showNotification = showNotification;
    }

    @Override
    public boolean matches(SimpleContainer simpleContainer, Level level) {
        return false;
    }

    @Override
    public ItemStack assemble(SimpleContainer simpleContainer, RegistryAccess registryAccess) {
        return getResultItem(registryAccess).copy();
    }

    @Override
    public boolean canCraftInDimensions(
            int width, int height
    ){
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess){
        return getResultItem();
    }

    public String getGroup() {
        return this.group;
    }

    public CraftingBookCategory category() {
        return this.category;
    }

    public ItemStack getResultItem() {
        return this.result;
    }

    @Override
    public ResourceLocation getId(){
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer(){
        return null;
    }

    @Override
    public RecipeType<?> getType(){
        return TYPE;
    }

    @Override
    public NonNullList<Ingredient> getIngredients(){
        NonNullList<Ingredient> ingredients = NonNullList.create();
        ingredients.addAll(recipeItemsNW);
        ingredients.addAll(recipeItemsNE);
        ingredients.addAll(recipeItemsSW);
        ingredients.addAll(recipeItemsSE);
        ingredients.add(westElement);
        ingredients.add(northElement);
        ingredients.add(eastElement);
        ingredients.add(southElement);
        ingredients.add(mainIngredient);
        return ingredients;
    }

    public NonNullList<Ingredient> getIngredientsNW() {
        return recipeItemsNW;
    }

    public NonNullList<Ingredient> getIngredientsNE() {
        return recipeItemsNE;
    }

    public NonNullList<Ingredient> getIngredientsSW() {
        return recipeItemsSW;
    }

    public NonNullList<Ingredient> getIngredientsSE() {
        return recipeItemsSE;
    }

    public Ingredient getWestElement() {
        return westElement;
    }

    public Ingredient getNorthElement() {
        return northElement;
    }

    public Ingredient getEastElement() {
        return eastElement;
    }

    public Ingredient getSouthElement() {
        return southElement;
    }

    public Ingredient getMainIngredient() {
        return mainIngredient;
    }

    public int getMana1Cost() {
        return mana1Cost;
    }

    public int getMana2Cost() {
        return mana2Cost;
    }

    public int getMana3Cost() {
        return mana3Cost;
    }


    public boolean showNotification() {
        return this.showNotification;
    }



    @Override
    public boolean isSpecial() {
        return true;
    }
}
