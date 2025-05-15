package net.cloudedarctrooper.templar_addons_mod.block.entity;

import net.cloudedarctrooper.templar_addons_mod.TemplarAddonsMod;
import net.cloudedarctrooper.templar_addons_mod.block.TKTABlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TemplarAddonsMod.MODID);


    public static final RegistryObject<BlockEntityType<ManaInfusionStationBlockEntity>> MANA_INFUSION_BE =
            BLOCK_ENTITIES.register("mana_infusion_be", () ->
                    BlockEntityType.Builder.of(ManaInfusionStationBlockEntity::new,
                            TKTABlocks.MANA_INFUSION_BENCH.get()).build(null));








    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
