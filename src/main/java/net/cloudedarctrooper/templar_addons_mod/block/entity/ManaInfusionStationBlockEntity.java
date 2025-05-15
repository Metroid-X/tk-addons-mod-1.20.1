package net.cloudedarctrooper.templar_addons_mod.block.entity;

import net.cloudedarctrooper.templar_addons_mod.core.TKTAItemDefs;
import net.cloudedarctrooper.templar_addons_mod.item.TKTAItems;
import net.cloudedarctrooper.templar_addons_mod.recipe.ManaInfusionRecipe;
import net.cloudedarctrooper.templar_addons_mod.screen.ManaInfusionStationMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.checkerframework.checker.units.qual.C;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ManaInfusionStationBlockEntity extends BlockEntity implements MenuProvider, TKTAItemDefs {
    private final ItemStackHandler itemHandler = new ItemStackHandler(25);


    //      INPUT SLOT POSITIONED AT THE CENTER; THIS IS BOTH FOR INPUT AND STORING AUGMENT ITEMS THAT WILL BE CHANGED BY RECIPES
    private static final int INPUT_SLOT = MIStationSlots.INPUT_SLOT;

    //  ADDITION SLOTS ARE 2X2 GRIDS IN EACH CORNER

    //  GRID 1 - TOP LEFT
    private static final int ADD1_SLOT1 = MIStationSlots.ADD1_SLOT1;
    private static final int ADD1_SLOT2 = MIStationSlots.ADD1_SLOT2;
    private static final int ADD1_SLOT3 = MIStationSlots.ADD1_SLOT3;
    private static final int ADD1_SLOT4 = MIStationSlots.ADD1_SLOT4;

    //  GRID 2 - TOP RIGHT
    private static final int ADD2_SLOT1 = MIStationSlots.ADD2_SLOT1;
    private static final int ADD2_SLOT2 = MIStationSlots.ADD2_SLOT2;
    private static final int ADD2_SLOT3 = MIStationSlots.ADD2_SLOT3;
    private static final int ADD2_SLOT4 = MIStationSlots.ADD2_SLOT4;

    //  GRID 3 - BOTTOM LEFT
    private static final int ADD3_SLOT1 = MIStationSlots.ADD3_SLOT1;
    private static final int ADD3_SLOT2 = MIStationSlots.ADD3_SLOT2;
    private static final int ADD3_SLOT3 = MIStationSlots.ADD3_SLOT3;
    private static final int ADD3_SLOT4 = MIStationSlots.ADD3_SLOT4;

    //  GRID 4 - BOTTOM RIGHT
    private static final int ADD4_SLOT1 = MIStationSlots.ADD4_SLOT1;
    private static final int ADD4_SLOT2 = MIStationSlots.ADD4_SLOT2;
    private static final int ADD4_SLOT3 = MIStationSlots.ADD4_SLOT3;
    private static final int ADD4_SLOT4 = MIStationSlots.ADD4_SLOT4;

    //      ELEMENT SLOTS ARE ON EACH CARDINAL DIRECTION
    private static final int ELEM_SLOT_1 = MIStationSlots.ELEM_SLOT_1;
    private static final int ELEM_SLOT_2 = MIStationSlots.ELEM_SLOT_2;
    private static final int ELEM_SLOT_3 = MIStationSlots.ELEM_SLOT_3;
    private static final int ELEM_SLOT_4 = MIStationSlots.ELEM_SLOT_4;

    //      EACH MANA SLOT IS FOR A DIFFERENT GRADE OF MANA; THESE COUNT AS INGREDIENTS *AND* FUEL FOR THE STATION
    private static final int LV1_MANA_SLOT = MIStationSlots.LV1_MANA_SLOT;
    private static final int LV2_MANA_SLOT = MIStationSlots.LV2_MANA_SLOT;
    private static final int LV3_MANA_SLOT = MIStationSlots.LV3_MANA_SLOT;

    private static final int OUTPUT_SLOT = MIStationSlots.OUTPUT_SLOT;



    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 240;
    private boolean isActive = true;
    private boolean makeOne = true;

    private int t1Mana = 0;
    private int t2Mana = 0;
    private int t3Mana = 0;

    private int manaCap = 128;

    private boolean lv1ManaAvailable = false;
    private boolean lv2ManaAvailable = false;
    private boolean lv3ManaAvailable = false;


    public ManaInfusionStationBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.MANA_INFUSION_BE.get(), pPos, pBlockState);

        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> ManaInfusionStationBlockEntity.this.progress;
                    case 1 -> ManaInfusionStationBlockEntity.this.maxProgress;
                    case 2 -> ManaInfusionStationBlockEntity.this.t1Mana;
                    case 3 -> ManaInfusionStationBlockEntity.this.t2Mana;
                    case 4 -> ManaInfusionStationBlockEntity.this.t3Mana;
                    case 5 -> ManaInfusionStationBlockEntity.this.manaCap;
                    default -> 0;
                };
            }



            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> ManaInfusionStationBlockEntity.this.progress = pValue;
                    case 1 -> ManaInfusionStationBlockEntity.this.maxProgress = pValue;
                    case 2 -> ManaInfusionStationBlockEntity.this.t1Mana = pValue;
                    case 3 -> ManaInfusionStationBlockEntity.this.t2Mana = pValue;
                    case 4 -> ManaInfusionStationBlockEntity.this.t3Mana = pValue;
                    case 5 -> ManaInfusionStationBlockEntity.this.manaCap = pValue;
                }
            }

            @Override
            public int getCount() {
                return 8;
            }

        };

    }

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();



    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.templar_addons.mana_infusion_station");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player player) {
        return new ManaInfusionStationMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory",itemHandler.serializeNBT());
        pTag.putInt("mana_infusion_station.progress", progress);
        pTag.putBoolean("mana_infusion_station.active", isActive);
        pTag.putBoolean("mana_infusion_station.make_one", makeOne);
        pTag.putInt("mana_infusion_station.lv1_mana", t1Mana);
        pTag.putInt("mana_infusion_station.lv2_mana", t2Mana);
        pTag.putInt("mana_infusion_station.lv3_mana", t3Mana);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("mana_infusion_station.progress");
        isActive = pTag.getBoolean("mana_infusion_station.active");
        makeOne = pTag.getBoolean("mana_infusion_station.make_one");
        t1Mana = pTag.getInt("mana_infusion_station.lv1_mana");
        t2Mana = pTag.getInt("mana_infusion_station.lv2_mana");
        t3Mana = pTag.getInt("mana_infusion_station.lv3_mana");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        ItemStack mana1Slot = itemHandler.getStackInSlot(LV1_MANA_SLOT);
        ItemStack mana2Slot = itemHandler.getStackInSlot(LV2_MANA_SLOT);
        ItemStack mana3Slot = itemHandler.getStackInSlot(LV3_MANA_SLOT);

        if(isCorrectManaType(TKTAItemDefs.CRUDE_MANA, mana1Slot)) {
            if(!isMana1Full()) {
                increaseMana1(mana1Slot);
                setChanged(pLevel, pPos, pState);
            }
        }

        if(isCorrectManaType(TKTAItemDefs.CUT_MANA, mana2Slot)) {
            if(!isMana2Full()) {
                increaseMana2(mana2Slot);
                setChanged(pLevel, pPos, pState);
            }
        }

        if(isCorrectManaType(TKTAItemDefs.FLAWLESS_MANA, mana3Slot)) {
            if(!isMana3Full()) {
                increaseMana3(mana3Slot);
                setChanged(pLevel, pPos, pState);
            }
        }

//        if(isActive) {
            if (hasRecipe()) {
                increaseCraftingProgress();
                setChanged(pLevel, pPos, pState);

                if (hasProgressFinished()) {
                    craftItem();
                    resetProgress();
                    if(makeOne) {
                        resetProgress();
//                        setDeactivated();
                    }
                }
            } else {
                resetProgress();
//                setDeactivated();
            }
//        }
    }

    private void setDeactivated() {
        isActive = true;
    }

    private void resetProgress() {
        progress = 0;
    }


    private void craftItem() {
        Optional<ManaInfusionRecipe> recipe = getCurrentRecipe();
        ItemStack result = recipe.get().getResultItem(null);

        this.itemHandler.extractItem(INPUT_SLOT, 1, false);

        decreaseMana1(recipe.get().getMana1Cost());
        decreaseMana2(recipe.get().getMana2Cost());
        decreaseMana3(recipe.get().getMana3Cost());


        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
    }


    private boolean hasRecipe() {
        Optional<ManaInfusionRecipe> recipe = getCurrentRecipe();

        if(recipe.isPresent()) {
            return false;
        }

        ItemStack result = recipe.get().getResultItem(null);

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private Optional<ManaInfusionRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());

        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        return this.level.getRecipeManager().getRecipeFor(ManaInfusionRecipe.TYPE, inventory, level);
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }

    private boolean isMana1Full() {
        return this.t1Mana >= manaCap;
    }

    private boolean isMana2Full() {
        return this.t2Mana >= manaCap;
    }

    private boolean isMana3Full() {
        return this.t3Mana >= manaCap;
    }

    private void increaseMana1(ItemStack stack) {
        int countLeft = stack.getCount()-1;
        if(countLeft >= 0) {
            t1Mana+=1;
            stack.setCount(countLeft);
        }
    }

    private void increaseMana2(ItemStack stack) {
        int countLeft = stack.getCount()-1;
        if(countLeft >= 0) {
            t2Mana+=1;
            stack.setCount(countLeft);
        }
    }

    private void increaseMana3(ItemStack stack) {
        int countLeft = stack.getCount()-1;
        if(countLeft >= 0) {
            t3Mana+=1;
            stack.setCount(countLeft);
        }
    }

    private void decreaseMana1(int n) {
        t1Mana-=n;
    }

    private void decreaseMana2(int n) {
        t2Mana-=n;
    }

    private void decreaseMana3(int n) {
        t3Mana-=n;
    }

    private boolean isCorrectManaType(Item item, ItemStack stack) {
        return stack.getItem() == item;
    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress ++;
    }

    private void setActive() {
        isActive = true;
    }


}
