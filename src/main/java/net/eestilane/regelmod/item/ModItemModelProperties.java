package net.eestilane.regelmod.item;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class ModItemModelProperties {
    public static void addItemProperties() {
        ItemProperties.register(ModItems.SLINGSHOT.get(),
                new ResourceLocation("pull"),
                (itemStack, clientLevel, livingEntity, seed) -> {
                    if (livingEntity == null) {
                        return 0.0F;
                    }
                    return livingEntity.getUseItem() != itemStack ? 0.0F
                            : (float) (itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / 10.0F;
                });

        ItemProperties.register(ModItems.SLINGSHOT.get(),
                new ResourceLocation("pulling"),
                (itemStack, clientLevel, livingEntity, seed) -> {
                    return livingEntity != null
                            && livingEntity.isUsingItem()
                            && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F;
                });
    }
}
