package net.cloudedarctrooper.templar_addons_mod.block.entity;


public interface MIStationSlots {


    enum EnumMIStationSlots {

        //      INPUT SLOT POSITIONED AT THE CENTER; THIS IS BOTH FOR INPUT AND STORING AUGMENT ITEMS THAT WILL BE CHANGED BY RECIPES
        INPUT_SLOT,

        //  GRID 1 - TOP LEFT
        ADD1_SLOT1,
        ADD1_SLOT2,
        ADD1_SLOT3,
        ADD1_SLOT4,

        //  GRID 2 - TOP RIGHT
        ADD2_SLOT1,
        ADD2_SLOT2,
        ADD2_SLOT3,
        ADD2_SLOT4,

        //  GRID 3 - BOTTOM LEFT
        ADD3_SLOT_C1,
        ADD3_SLOT_C2,
        ADD3_SLOT_C3,
        ADD3_SLOT_C4,

        //  GRID 4 - BOTTOM RIGHT
        ADD4_SLOT_D1,
        ADD4_SLOT_D2,
        ADD4_SLOT_D3,
        ADD4_SLOT_D4,

        //      ELEMENT SLOTS ARE ON EACH CARDINAL DIRECTION
        ELEM_SLOT_1,
        ELEM_SLOT_2,
        ELEM_SLOT_3,
        ELEM_SLOT_4,

        //      EACH MANA SLOT IS FOR A DIFFERENT GRADE OF MANA; THESE COUNT AS INGREDIENTS *AND* FUEL FOR THE STATION
        LV1_MANA_SLOT,
        LV2_MANA_SLOT,
        LV3_MANA_SLOT,

        OUTPUT_SLOT;

        public int getSlot(EnumMIStationSlots slot) {
            return slot.ordinal();
        }
    }

    //      INPUT SLOT POSITIONED AT THE CENTER; THIS IS BOTH FOR INPUT AND STORING AUGMENT ITEMS THAT WILL BE CHANGED BY RECIPES
    int INPUT_SLOT = 0;

    //  GRID 1 - TOP LEFT
    int ADD1_SLOT1 = 1;
    int ADD1_SLOT2 = 2;
    int ADD1_SLOT3 = 3;
    int ADD1_SLOT4 = 4;

    //  GRID 2 - TOP RIGHT
    int ADD2_SLOT1 = 5;
    int ADD2_SLOT2 = 6;
    int ADD2_SLOT3 = 7;
    int ADD2_SLOT4 = 8;

    //  GRID 3 - BOTTOM LEFT
    int ADD3_SLOT1 = 9;
    int ADD3_SLOT2 = 10;
    int ADD3_SLOT3 = 11;
    int ADD3_SLOT4 = 12;

    //  GRID 4 - BOTTOM RIGHT
    int ADD4_SLOT1 = 13;
    int ADD4_SLOT2 = 14;
    int ADD4_SLOT3 = 15;
    int ADD4_SLOT4 = 16;

    //      ELEMENT SLOTS ARE ON EACH CARDINAL DIRECTION
    int ELEM_SLOT_1 = 17;
    int ELEM_SLOT_2 = 18;
    int ELEM_SLOT_3 = 19;
    int ELEM_SLOT_4 = 20;

    //      EACH MANA SLOT IS FOR A DIFFERENT GRADE OF MANA; THESE COUNT AS INGREDIENTS *AND* FUEL FOR THE STATION
    int LV1_MANA_SLOT = 21;
    int LV2_MANA_SLOT = 22;
    int LV3_MANA_SLOT = 23;

    int OUTPUT_SLOT = 24;

}