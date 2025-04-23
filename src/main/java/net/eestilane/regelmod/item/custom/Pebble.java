package net.eestilane.regelmod.item.custom;

import net.eestilane.regelmod.item.ModItems;
import net.eestilane.regelmod.util.ModEntityType;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class Pebble extends ThrowableItemProjectile {
    public Pebble(EntityType<? extends Pebble> pPebble, Level pLevel) {
        super(pPebble, pLevel);
    }

    public Pebble(Level pLevel, LivingEntity pLivingEntity) {
        super(EntityType.SNOWBALL, pLivingEntity, pLevel);
    }

    public Pebble(Level pLevel, double p_37395_, double p_37396_, double p_37397_) {
        super(EntityType.SNOWBALL, p_37395_, p_37396_, p_37397_, pLevel);
    }

    protected Item getDefaultItem() {
        return Items.SNOWBALL;
    }

    private ParticleOptions getParticle() {
        ItemStack itemstack = this.getItemRaw();
        return (ParticleOptions)(itemstack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemParticleOption(ParticleTypes.ITEM, itemstack));
    }

    public void handleEntityEvent(byte p_37402_) {
        if (p_37402_ == 3) {
            ParticleOptions particleoptions = this.getParticle();

            for(int i = 0; i < 8; ++i) {
                this.level().addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    protected void onHitEntity(EntityHitResult pEntityHitResult) {
        super.onHitEntity(pEntityHitResult);
        Entity entity = pEntityHitResult.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 2.0F);
    }

    protected void onHit(HitResult pHitResult) {
        super.onHit(pHitResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }

    }
}
