package net.eestilane.regelmod.item;

import net.eestilane.regelmod.RegelMod;
import net.eestilane.regelmod.item.custom.PebbleItem;
import net.eestilane.regelmod.item.custom.PickaxeAxeItem;
import net.eestilane.regelmod.item.custom.SlingshotItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RegelMod.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry",
            () -> new Item(new Item.Properties().food(ModFoods.BLUEBERRY)));
    public static final RegistryObject<Item> BRANCH = ITEMS.register("branch",
            () -> new SwordItem(ModToolTiers.BRANCH, 1, -2.0F, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_BATTLE_AXE = ITEMS.register("diamond_battle_axe",
            () -> new AxeItem(Tiers.DIAMOND, 7, -3.2F, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_PICKAXE_AXE = ITEMS.register("diamond_pickaxe_axe",
            () -> new PickaxeAxeItem(Tiers.DIAMOND, 4, -2.9F, new Item.Properties()));
    public static final RegistryObject<Item> DILDO = ITEMS.register("dildo",
            () -> new SwordItem(ModToolTiers.SUPER_ITEM, 60, -3.5F, new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> GLASS_JAR = ITEMS.register("glass_jar",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_ROD = ITEMS.register("iron_rod",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LENS = ITEMS.register("lens",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PEBBLE = ITEMS.register("pebble",
            () -> new PebbleItem(new Item.Properties()));
    public static final RegistryObject<Item> SLINGSHOT = ITEMS.register("slingshot",
            () -> new SlingshotItem(new Item.Properties()));

}

