package net.eestilane.regelmod.util;

import net.eestilane.regelmod.item.custom.Pebble;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.flag.FeatureElement;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.entity.EntityTypeTest;
import org.jetbrains.annotations.Nullable;

public class ModEntityType<T extends Entity> implements FeatureElement, EntityTypeTest<Entity, T> {

    public static final EntityType<Pebble> PEBBLE = register("pebble", EntityType.Builder.<Pebble>of(Pebble::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10));

    private static <T extends Entity> EntityType<T> register(String p_20635_, EntityType.Builder<T> p_20636_) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, p_20635_, p_20636_.build(p_20635_));
    }

    @Override
    public FeatureFlagSet requiredFeatures() {
        return null;
    }

    @Override
    public @Nullable T tryCast(Entity p_156918_) {
        return null;
    }

    @Override
    public Class<? extends Entity> getBaseClass() {
        return null;
    }

    public interface EntityFactory<T extends Entity> {
        T create(ModEntityType<T> p_20722_, Level p_20723_);
    }
}
