package net.cloudedarctrooper.templar_addons_mod;

import com.mojang.logging.LogUtils;
import net.cloudedarctrooper.templar_addons_mod.block.TKTABlocks;
import net.cloudedarctrooper.templar_addons_mod.block.entity.ModBlockEntities;
import net.cloudedarctrooper.templar_addons_mod.item.ModCreativeModeTabs;
import net.cloudedarctrooper.templar_addons_mod.item.TKTAItems;
import net.cloudedarctrooper.templar_addons_mod.screen.ManaInfusionStationScreen;
import net.cloudedarctrooper.templar_addons_mod.screen.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TemplarAddonsMod.MODID)
public class TemplarAddonsMod {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "templar_addons";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public TemplarAddonsMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        TKTAItems.register(modEventBus);
        TKTABlocks.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
//            event.accept(ModItems.MANA_SHARDS);
            event.accept(TKTAItems.RAW_MANA);
            event.accept(TKTAItems.CUT_MANA);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {


            MenuScreens.register(ModMenuTypes.MANA_INFUSION_MENU.get(), ManaInfusionStationScreen::new);
        }
    }
}
