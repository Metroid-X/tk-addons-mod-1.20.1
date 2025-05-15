package net.cloudedarctrooper.templar_addons_mod.recipe;

import net.cloudedarctrooper.templar_addons_mod.TemplarAddonsMod;
import net.cloudedarctrooper.templar_addons_mod.recipe.handlers.ManaInfusionRecipeSerializer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModRecipes {
    private ModRecipes() {
    }

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, TemplarAddonsMod.MODID);

    public static final RegistryObject<RecipeSerializer<ManaInfusionRecipe>> MANA_INFUSION_SERIALIZER =
            SERIALIZERS.register("mana_infusion", () -> ManaInfusionRecipeSerializer.INSTANCE);

    public static void register(IEventBus bus) {
        SERIALIZERS.register(bus);
    }


    public static final DeferredRegister<RecipeType<?>> DR = DeferredRegister
            .create(Registries.RECIPE_TYPE, TemplarAddonsMod.MODID);

    public static final RecipeType<ManaInfusionRecipe> INFUSION = register("mana_infusion");

    private static <T extends Recipe<?>> RecipeType<T> register(String id) {
        RecipeType<T> type = RecipeType.simple(new ResourceLocation(TemplarAddonsMod.MODID, id));
        DR.register(id, () -> type);
        return type;
    }
}
