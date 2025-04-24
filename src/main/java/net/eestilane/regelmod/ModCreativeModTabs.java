package net.eestilane.regelmod;

import net.eestilane.regelmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RegelMod.MOD_ID);

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    public static final RegistryObject<CreativeModeTab> REGEL_TAB = CREATIVE_MODE_TABS.register("regel_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.SLINGSHOT.get()))
                    .title(Component.translatable("creativetab.regel_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ENCHANTED_BRANCH.get());
                        pOutput.accept(ModItems.BRANCH.get());
                        pOutput.accept(ModItems.SLINGSHOT.get());
                        pOutput.accept(ModItems.PEBBLE.get());
                        pOutput.accept(ModItems.IRON_ROD.get());
                        pOutput.accept(ModItems.DIAMOND_BATTLE_AXE.get());
                        pOutput.accept(ModItems.DIAMOND_PICKAXE_AXE.get());
                        pOutput.accept(ModItems.LENS.get());
                        pOutput.accept(ModItems.GLASS_JAR.get());
                        pOutput.accept(ModItems.BLUEBERRY.get());
                    })
                    .build());
}
