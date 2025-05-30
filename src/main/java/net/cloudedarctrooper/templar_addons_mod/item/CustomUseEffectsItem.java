package net.cloudedarctrooper.templar_addons_mod.item;

import net.cloudedarctrooper.templar_addons_mod.utils.TriState;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
/**
 * Disclaimer: I may have plucked this code from the Create Mod ¯\_(ツ)_/¯
 */
public interface CustomUseEffectsItem {
    /**
     * Called to determine if use effects should be applied for this item.
     *
     * @param stack  The ItemStack being used.
     * @param entity The LivingEntity using the item.
     * @return {@link TriState#DEFAULT} for default behavior, or {@link TriState#TRUE}/{@link TriState#FALSE} to override default behavior
     */
    default TriState shouldTriggerUseEffects(ItemStack stack, LivingEntity entity) {
        return TriState.DEFAULT;
    }

    /**
     * Called when use effects should be applied for this item.
     *
     * @param stack  The ItemStack being used.
     * @param entity The LivingEntity using the item.
     * @param count  The amount of times effects should be applied. Can safely be ignored.
     * @param random The LivingEntity's RandomSource.
     * @return if the default behavior should be cancelled or not
     */
    boolean triggerUseEffects(ItemStack stack, LivingEntity entity, int count, RandomSource random);
}
