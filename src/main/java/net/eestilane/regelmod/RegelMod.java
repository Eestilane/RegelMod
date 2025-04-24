package net.eestilane.regelmod;

import com.mojang.logging.LogUtils;
import net.eestilane.regelmod.entity.ModEntityType;
import net.eestilane.regelmod.item.ModItemModelProperties;
import net.eestilane.regelmod.item.ModItems;
import net.eestilane.regelmod.particle.ModParticles;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(RegelMod.MOD_ID)
public class RegelMod
{
    public static final String MOD_ID = "regelmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RegelMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ModEntityType.register(modEventBus);
        ModItems.register(modEventBus);
        ModParticles.register(modEventBus);

        ModCreativeModTabs.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(this);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntityType.PEBBLE.get(), ThrownItemRenderer::new);
        }

//        @SubscribeEvent
//        public static void registerParticleProvider(RegisterParticleProvidersEvent event) {
//            event.registerSpriteSet(ModParticleTypes.PEBBLE_PARTICLE.get());
//        }

        @SubscribeEvent
        public static void setupCommon(final FMLCommonSetupEvent event) {
            event.enqueueWork(ModItemModelProperties::addItemProperties);
        }
    }
}
