package net.cloudedarctrooper.templar_addons_mod.screen;

import net.cloudedarctrooper.templar_addons_mod.TemplarAddonsMod;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, TemplarAddonsMod.MODID);

    public static final RegistryObject<MenuType<ManaInfusionStationMenu>> MANA_INFUSION_MENU =
            registerMenuType("mana_infusion_menu", ManaInfusionStationMenu::new);

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>>
    registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }


    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
