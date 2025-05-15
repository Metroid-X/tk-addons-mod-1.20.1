package net.cloudedarctrooper.templar_addons_mod.recipe.handlers;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.cloudedarctrooper.templar_addons_mod.TemplarAddonsMod;
import net.cloudedarctrooper.templar_addons_mod.recipe.ManaInfusionRecipe;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Set;

public class ManaInfusionRecipeSerializer implements RecipeSerializer<ManaInfusionRecipe> {

    public static final ManaInfusionRecipeSerializer INSTANCE = new ManaInfusionRecipeSerializer();

    private ManaInfusionRecipeSerializer() {}

    @Override
    public ManaInfusionRecipe fromJson(ResourceLocation recipeId, JsonObject json) {

        String s = GsonHelper.getAsString(json, "group", "");
        CraftingBookCategory craftingBookCategory = (CraftingBookCategory) CraftingBookCategory.CODEC.byName(GsonHelper.getAsString(json, "category", (String) null), CraftingBookCategory.MISC);

        JsonObject ingredients = GsonHelper.getAsJsonObject(json, "ingredients");

        JsonObject components = GsonHelper.getAsJsonObject(ingredients, "components");

        JsonObject componentNW = GsonHelper.getAsJsonObject(components, "NW");
        Map<String, Ingredient> mapNW = keyFromJson(GsonHelper.getAsJsonObject(componentNW,"keyNW"));
        String[] astringNW = shrink(patternFromJson(GsonHelper.getAsJsonArray(componentNW, "patternNW")));
        int i_nw = astringNW[0].length();
        int j_nw = astringNW.length;
        NonNullList<Ingredient> itemsListNW = dissolvePattern(astringNW, mapNW, i_nw, j_nw);

        JsonObject componentNE = GsonHelper.getAsJsonObject(components, "NE");
        Map<String, Ingredient> mapNE = keyFromJson(GsonHelper.getAsJsonObject(componentNE,"keyNE"));
        String[] astringNE = shrink(patternFromJson(GsonHelper.getAsJsonArray(componentNE, "patternNE")));
        int i_ne = astringNE[0].length();
        int j_ne = astringNE.length;
        NonNullList<Ingredient> itemsListNE = dissolvePattern(astringNE, mapNE, i_ne, j_ne);

        JsonObject componentSW = GsonHelper.getAsJsonObject(components, "SW");
        Map<String, Ingredient> mapSW = keyFromJson(GsonHelper.getAsJsonObject(componentSW,"keySW"));
        String[] astringSW = shrink(patternFromJson(GsonHelper.getAsJsonArray(componentSW, "patternSW")));
        int i_sw = astringSW[0].length();
        int j_sw = astringSW.length;
        NonNullList<Ingredient> itemsListSW = dissolvePattern(astringSW, mapSW, i_sw, j_sw);

        JsonObject componentSE = GsonHelper.getAsJsonObject(components, "SE");
        Map<String, Ingredient> mapSE = keyFromJson(GsonHelper.getAsJsonObject(componentSE,"keySE"));
        String[] astringSE = shrink(patternFromJson(GsonHelper.getAsJsonArray(componentSE, "patternSE")));
        int i_se = astringSE[0].length();
        int j_se = astringSE.length;
        NonNullList<Ingredient> itemsListSE = dissolvePattern(astringSE, mapSE, i_se, j_se);

        JsonObject elements = GsonHelper.getAsJsonObject(ingredients, "elements");

        Ingredient westElem = Ingredient.EMPTY;
        if (elements.has("west")) {
            westElem = Ingredient.fromJson(elements.get("west"));
        }

        Ingredient northElem = Ingredient.EMPTY;
        if (elements.has("north")) {
            northElem = Ingredient.fromJson(elements.get("north"));
        }

        Ingredient eastElem = Ingredient.EMPTY;
        if (elements.has("east")) {
            eastElem = Ingredient.fromJson(elements.get("east"));
        }

        Ingredient southElem = Ingredient.EMPTY;
        if (elements.has("south")) {
            southElem = Ingredient.fromJson(elements.get("south"));
        }

        Ingredient mainIngredient = Ingredient.fromJson(ingredients.get("main"));

        int m1Cost = GsonHelper.getAsInt(json, "m1Cost", 0);
        int m2Cost = GsonHelper.getAsInt(json, "m2Cost", 0);
        int m3Cost = GsonHelper.getAsInt(json, "m3Cost", 0);

        ItemStack resultStack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
        boolean show_notif = GsonHelper.getAsBoolean(json, "show_notif", true);
        return new ManaInfusionRecipe(
                recipeId,s,craftingBookCategory,
                i_nw, j_nw, itemsListNW, i_ne, j_ne, itemsListNE,
                i_sw, j_sw, itemsListSW, i_se, j_se, itemsListSE,
                westElem, northElem, eastElem, southElem,
                mainIngredient, m1Cost, m2Cost, m3Cost,
                resultStack, show_notif
                );
    }


    @Nullable
    @Override
    public ManaInfusionRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
        String s = buffer.readUtf(32767);
        CraftingBookCategory category = CraftingBookCategory.values()[buffer.readVarInt()];
        int i_nw = buffer.readVarInt();
        int j_nw = buffer.readVarInt();
        NonNullList<Ingredient> itemsListNW = NonNullList.create();
        int i_ne = buffer.readVarInt();
        int j_ne = buffer.readVarInt();
        NonNullList<Ingredient> itemsListNE = NonNullList.create();
        int i_se = buffer.readVarInt();
        int j_se = buffer.readVarInt();
        NonNullList<Ingredient> itemsListSE = NonNullList.create();
        int i_sw = buffer.readVarInt();
        int j_sw = buffer.readVarInt();
        NonNullList<Ingredient> itemsListSW = NonNullList.create();
        Ingredient westElem = Ingredient.fromNetwork(buffer);
        Ingredient northElem = Ingredient.fromNetwork(buffer);
        Ingredient eastElem = Ingredient.fromNetwork(buffer);
        Ingredient southElem = Ingredient.fromNetwork(buffer);
        Ingredient mainIngredient = Ingredient.fromNetwork(buffer);
        int m1Cost = buffer.readVarInt();
        int m2Cost = buffer.readVarInt();
        int m3Cost = buffer.readVarInt();
        ItemStack resultStack = buffer.readItem();
        boolean show_notif = buffer.readBoolean();
        return new ManaInfusionRecipe(recipeId,s,category,
                i_nw, j_nw, itemsListNW, i_ne, j_ne, itemsListNE,
                i_sw, j_sw, itemsListSW, i_se, j_se, itemsListSE,
                westElem, northElem, eastElem, southElem,
                mainIngredient, m1Cost, m2Cost, m3Cost,
                resultStack, show_notif
        );
    }

    @Override
    public void toNetwork(FriendlyByteBuf buffer, ManaInfusionRecipe recipe) {


        buffer.writeUtf(recipe.getGroup());
        buffer.writeEnum(recipe.category());

        buffer.writeVarInt(ManaInfusionRecipe.COMPONENTS_MAX_WIDTH);
        buffer.writeVarInt(ManaInfusionRecipe.COMPONENTS_MAX_HEIGHT);
        for (Ingredient ingredient : recipe.getIngredientsNW()) {
            ingredient.toNetwork(buffer);
        }
        buffer.writeVarInt(ManaInfusionRecipe.COMPONENTS_MAX_WIDTH);
        buffer.writeVarInt(ManaInfusionRecipe.COMPONENTS_MAX_HEIGHT);
        for (Ingredient ingredient : recipe.getIngredientsNE()) {
            ingredient.toNetwork(buffer);
        }
        buffer.writeVarInt(ManaInfusionRecipe.COMPONENTS_MAX_WIDTH);
        buffer.writeVarInt(ManaInfusionRecipe.COMPONENTS_MAX_HEIGHT);
        for (Ingredient ingredient : recipe.getIngredientsSE()) {
            ingredient.toNetwork(buffer);
        }
        buffer.writeVarInt(ManaInfusionRecipe.COMPONENTS_MAX_WIDTH);
        buffer.writeVarInt(ManaInfusionRecipe.COMPONENTS_MAX_HEIGHT);
        for (Ingredient ingredient : recipe.getIngredientsSW()) {
            ingredient.toNetwork(buffer);
        }

        buffer.writeVarInt(recipe.getMana1Cost());
        buffer.writeVarInt(recipe.getMana2Cost());
        buffer.writeVarInt(recipe.getMana3Cost());

        recipe.getWestElement().toNetwork(buffer);
        recipe.getNorthElement().toNetwork(buffer);
        recipe.getEastElement().toNetwork(buffer);
        recipe.getSouthElement().toNetwork(buffer);
        recipe.getMainIngredient().toNetwork(buffer);




        buffer.writeItem(recipe.getResultItem());
        buffer.writeBoolean(recipe.showNotification());
    }


    protected static NonNullList<Ingredient> dissolvePattern(String[] p_44203_, Map<String, Ingredient> p_44204_, int p_44205_, int p_44206_) {
        NonNullList<Ingredient> nonnulllist = NonNullList.withSize(p_44205_ * p_44206_, Ingredient.EMPTY);
        Set<String> set = Sets.newHashSet(p_44204_.keySet());
        set.remove(" ");

        for(int i = 0; i < p_44203_.length; ++i) {
            for(int j = 0; j < p_44203_[i].length(); ++j) {
                String s = p_44203_[i].substring(j, j + 1);
                Ingredient ingredient = (Ingredient)p_44204_.get(s);
                if (ingredient == null) {
                    throw new JsonSyntaxException("Pattern references symbol '" + s + "' but it's not defined in the key");
                }

                set.remove(s);
                nonnulllist.set(j + p_44205_ * i, ingredient);
            }
        }

        if (!set.isEmpty()) {
            throw new JsonSyntaxException("Key defines symbols that aren't used in pattern: " + String.valueOf(set));
        } else {
            return nonnulllist;
        }
    }

    @VisibleForTesting
    protected static String[] shrink(String... p_44187_) {
        int i = Integer.MAX_VALUE;
        int j = 0;
        int k = 0;
        int l = 0;

        for(int i1 = 0; i1 < p_44187_.length; ++i1) {
            String s = p_44187_[i1];
            i = Math.min(i, firstNonSpace(s));
            int j1 = lastNonSpace(s);
            j = Math.max(j, j1);
            if (j1 < 0) {
                if (k == i1) {
                    ++k;
                }

                ++l;
            } else {
                l = 0;
            }
        }

        if (p_44187_.length == l) {
            return new String[0];
        } else {
            String[] astring = new String[p_44187_.length - l - k];

            for(int k1 = 0; k1 < astring.length; ++k1) {
                astring[k1] = p_44187_[k1 + k].substring(i, j + 1);
            }

            return astring;
        }
    }

    private static int firstNonSpace(String p_44185_) {
        int i;
        for(i = 0; i < p_44185_.length() && p_44185_.charAt(i) == ' '; ++i) {
        }

        return i;
    }

    private static int lastNonSpace(String p_44201_) {
        int i;
        for(i = p_44201_.length() - 1; i >= 0 && p_44201_.charAt(i) == ' '; --i) {
        }

        return i;
    }

    protected static String[] patternFromJson(JsonArray p_44197_) {
        String[] astring = new String[p_44197_.size()];
        if (astring.length > ManaInfusionRecipe.COMPONENTS_MAX_HEIGHT) {
            throw new JsonSyntaxException("Invalid pattern: too many rows, " + ManaInfusionRecipe.COMPONENTS_MAX_HEIGHT + " is maximum");
        } else if (astring.length == 0) {
            throw new JsonSyntaxException("Invalid pattern: empty pattern not allowed");
        } else {
            for(int i = 0; i < astring.length; ++i) {
                String s = GsonHelper.convertToString(p_44197_.get(i), "pattern[" + i + "]");
                if (s.length() > ManaInfusionRecipe.COMPONENTS_MAX_WIDTH) {
                    throw new JsonSyntaxException("Invalid pattern: too many columns, " + ManaInfusionRecipe.COMPONENTS_MAX_WIDTH + " is maximum");
                }

                if (i > 0 && astring[0].length() != s.length()) {
                    throw new JsonSyntaxException("Invalid pattern: each row must be the same width");
                }

                astring[i] = s;
            }

            return astring;
        }
    }

    protected static Map<String, Ingredient> keyFromJson(JsonObject p_44211_) {
        Map<String, Ingredient> map = Maps.newHashMap();

        for(Map.Entry<String, JsonElement> entry : p_44211_.entrySet()) {
            if (((String)entry.getKey()).length() != 1) {
                throw new JsonSyntaxException("Invalid key entry: '" + (String)entry.getKey() + "' is an invalid symbol (must be 1 character only).");
            }

            if (" ".equals(entry.getKey())) {
                throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
            }

            map.put((String)entry.getKey(), Ingredient.fromJson((JsonElement)entry.getValue(), false));
        }

        map.put(" ", Ingredient.EMPTY);
        return map;
    }

}
