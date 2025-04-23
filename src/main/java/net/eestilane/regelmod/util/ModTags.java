package net.eestilane.regelmod.util;

import net.eestilane.regelmod.RegelMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NULL = tag("null");
        public static final TagKey<Block> FOR_SPECIAL_ITEMS = tag("for_special_items");
        public static final TagKey<Block> PICKAXE_AXE_BREAKABLE = tag("pickaxe_axe_breakable");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(RegelMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BRANCH = tag("branch");
        public static final TagKey<Item> PEBBLE = tag("pebble");
        public static final TagKey<Item> SPECIAL_ITEMS = tag("special_items");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(RegelMod.MOD_ID, name));
        }
    }
}
