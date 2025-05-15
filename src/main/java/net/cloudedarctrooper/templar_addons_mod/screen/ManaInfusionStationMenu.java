package net.cloudedarctrooper.templar_addons_mod.screen;

import net.cloudedarctrooper.templar_addons_mod.block.TKTABlocks;
import net.cloudedarctrooper.templar_addons_mod.block.entity.MIStationSlots;
import net.cloudedarctrooper.templar_addons_mod.block.entity.ManaInfusionStationBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;

public class ManaInfusionStationMenu extends AbstractContainerMenu implements MIStationSlots {
    public final ManaInfusionStationBlockEntity parent;

    private static final int SLOT_Y_OFFSET = (245 - 166)/2;
    private static final int SLOT_X_OFFSET = (234 - 176)/2;

    private final Level level;
    private final ContainerData data;

    public ManaInfusionStationMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()),
                new SimpleContainerData(25));
    }


    public ManaInfusionStationMenu(int pContainerId, Inventory inv, BlockEntity pBlockEntity, ContainerData pData) {
        super(ModMenuTypes.MANA_INFUSION_MENU.get(), pContainerId);
        checkContainerSize(inv, 25);
        parent = ((ManaInfusionStationBlockEntity) pBlockEntity);
        this.level = inv.player.level();
        this.data = pData;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.parent.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(iItemHandler -> {
            this.addSlot(new SlotItemHandler(iItemHandler, INPUT_SLOT, 109-SLOT_X_OFFSET, 64-SLOT_Y_OFFSET));

            this.addSlot(new SlotItemHandler(iItemHandler, ADD1_SLOT1, 69-SLOT_X_OFFSET, 24-SLOT_Y_OFFSET));
            this.addSlot(new SlotItemHandler(iItemHandler, ADD1_SLOT2, 87-SLOT_X_OFFSET, 24-SLOT_Y_OFFSET));
            this.addSlot(new SlotItemHandler(iItemHandler, ADD1_SLOT3, 69-SLOT_X_OFFSET, 42-SLOT_Y_OFFSET));
            this.addSlot(new SlotItemHandler(iItemHandler, ADD1_SLOT4, 87-SLOT_X_OFFSET, 42-SLOT_Y_OFFSET));

            this.addSlot(new SlotItemHandler(iItemHandler, ADD2_SLOT1, 131-SLOT_X_OFFSET, 24-SLOT_Y_OFFSET));
            this.addSlot(new SlotItemHandler(iItemHandler, ADD2_SLOT2, 149-SLOT_X_OFFSET, 24-SLOT_Y_OFFSET));
            this.addSlot(new SlotItemHandler(iItemHandler, ADD2_SLOT3, 131-SLOT_X_OFFSET, 42-SLOT_Y_OFFSET));
            this.addSlot(new SlotItemHandler(iItemHandler, ADD2_SLOT4, 149-SLOT_X_OFFSET, 42-SLOT_Y_OFFSET));

            this.addSlot(new SlotItemHandler(iItemHandler, ADD3_SLOT1, 69-SLOT_X_OFFSET, 86-SLOT_Y_OFFSET));
            this.addSlot(new SlotItemHandler(iItemHandler, ADD3_SLOT2, 87-SLOT_X_OFFSET, 86-SLOT_Y_OFFSET));
            this.addSlot(new SlotItemHandler(iItemHandler, ADD3_SLOT3, 69-SLOT_X_OFFSET, 104-SLOT_Y_OFFSET));
            this.addSlot(new SlotItemHandler(iItemHandler, ADD3_SLOT4, 87-SLOT_X_OFFSET, 104-SLOT_Y_OFFSET));

            this.addSlot(new SlotItemHandler(iItemHandler, ADD4_SLOT1, 131-SLOT_X_OFFSET, 86-SLOT_Y_OFFSET));
            this.addSlot(new SlotItemHandler(iItemHandler, ADD4_SLOT2, 149-SLOT_X_OFFSET, 86-SLOT_Y_OFFSET));
            this.addSlot(new SlotItemHandler(iItemHandler, ADD4_SLOT3, 131-SLOT_X_OFFSET, 104-SLOT_Y_OFFSET));
            this.addSlot(new SlotItemHandler(iItemHandler, ADD4_SLOT4, 149-SLOT_X_OFFSET, 104-SLOT_Y_OFFSET));

            this.addSlot(new SlotItemHandler(iItemHandler, ELEM_SLOT_1, 78-SLOT_X_OFFSET, 64-SLOT_Y_OFFSET));
            this.addSlot(new SlotItemHandler(iItemHandler, ELEM_SLOT_2, 109-SLOT_X_OFFSET, 33-SLOT_Y_OFFSET));
            this.addSlot(new SlotItemHandler(iItemHandler, ELEM_SLOT_3, 140-SLOT_X_OFFSET, 64-SLOT_Y_OFFSET));
            this.addSlot(new SlotItemHandler(iItemHandler, ELEM_SLOT_4, 109-SLOT_X_OFFSET, 95-SLOT_Y_OFFSET));

            this.addSlot(new SlotItemHandler(iItemHandler, LV1_MANA_SLOT, 18-SLOT_X_OFFSET, 100-SLOT_Y_OFFSET));
            this.addSlot(new SlotItemHandler(iItemHandler, LV2_MANA_SLOT, 18-SLOT_X_OFFSET, 64-SLOT_Y_OFFSET));
            this.addSlot(new SlotItemHandler(iItemHandler, LV3_MANA_SLOT, 18-SLOT_X_OFFSET, 28-SLOT_Y_OFFSET));

            this.addSlot(new SlotItemHandler(iItemHandler, OUTPUT_SLOT, 109-SLOT_X_OFFSET, 125-SLOT_Y_OFFSET));

        });

        addDataSlots(pData);
    }


    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    public int getT1ManaLevel() {
        return this.data.get(2);
    }

    public int getScaledT1ManaLevel() {
        int mana1 = getT1ManaLevel();
        int manaCap = this.data.get(5);
        int manaBarSize = 40;

        return manaCap != 0 && mana1 != 0 ? mana1 * manaBarSize / manaCap : 0;

    }

    public int getT2ManaLevel() {
        return this.data.get(3);
    }

    public int getScaledT2ManaLevel() {
        int mana2 = getT2ManaLevel();
        int manaCap = this.data.get(5);
        int manaBarSize = 40;

        return manaCap != 0 && mana2 != 0 ? mana2 * manaBarSize / manaCap : 0;
    }

    public int getT3ManaLevel() {
        return this.data.get(4);
    }

    public int getScaledT3ManaLevel() {
        int mana3 = getT3ManaLevel();
        int manaCap = this.data.get(5);
        int manaBarSize = 40;

        return manaCap != 0 && mana3 != 0 ? mana3 * manaBarSize / manaCap : 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int progressBarSize = 40;

        return maxProgress != 0 && progress != 0 ? progress * progressBarSize / maxProgress : 0;
    }

    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
    private static final int TE_INVENTORY_SLOT_COUNT = 25;

    @Override
    public ItemStack quickMoveStack(Player player, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) {return ItemStack.EMPTY;}
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
            + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + pIndex);
            return ItemStack.EMPTY;
        }
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(player, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, parent.getBlockPos()),
                player, TKTABlocks.MANA_INFUSION_BENCH.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 37 + j * 18 - SLOT_X_OFFSET, 163 + i * 18 - SLOT_Y_OFFSET));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(playerInventory, i, 37 + i * 18 - SLOT_X_OFFSET, 221 - SLOT_Y_OFFSET));
        }
    }
}
