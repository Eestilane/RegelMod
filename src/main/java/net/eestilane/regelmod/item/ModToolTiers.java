package net.eestilane.regelmod.item;

import net.eestilane.regelmod.RegelMod;
import net.eestilane.regelmod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier BRANCH = TierSortingRegistry.registerTier(
            new ForgeTier(0, 34, 0.0F, 0.0F, 15,
                    ModTags.Blocks.FOR_SPECIAL_ITEMS, () -> Ingredient.of(ModItems.BRANCH.get())),
            new ResourceLocation(RegelMod.MOD_ID, "branch"), List.of(Tiers.WOOD), List.of());
    public static final Tier SUPER_ITEM = TierSortingRegistry.registerTier(
            new ForgeTier(5, 3999, 8.0F, 0.0F, 15,
                    ModTags.Blocks.FOR_SPECIAL_ITEMS, () -> Ingredient.of(ModItems.DILDO.get())),
            new ResourceLocation(RegelMod.MOD_ID, "super_item"), List.of(Tiers.NETHERITE), List.of());
}
