package net.eestilane.regelmod.particle;

import com.mojang.serialization.Codec;
import net.eestilane.regelmod.RegelMod;
import net.minecraft.core.particles.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.core.particles.BlockParticleOption.DESERIALIZER;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, RegelMod.MOD_ID);

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }

    public static final RegistryObject<SimpleParticleType> PEBBLE_PARTICLE =
            PARTICLE_TYPES.register("pebble_particle", () -> new SimpleParticleType(true));
}
