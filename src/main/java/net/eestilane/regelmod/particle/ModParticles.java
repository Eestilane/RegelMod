package net.eestilane.regelmod.particle;

import net.eestilane.regelmod.RegelMod;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, RegelMod.MOD_ID);

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }

    public static final RegistryObject<SimpleParticleType> PEBBLE_PARTICLE =
            PARTICLE_TYPES.register("pebble_particle", () -> new SimpleParticleType(true));
//    public static final RegistryObject<ParticleType<ItemParticleOption>> ITEM =
//            PARTICLE_TYPES.register("item", () -> new ItemParticleOption(ItemParticleOption.DESERIALIZER, true));

}
