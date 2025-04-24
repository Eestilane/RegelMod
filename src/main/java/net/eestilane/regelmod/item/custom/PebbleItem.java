package net.eestilane.regelmod.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PebbleItem extends Item {
    public PebbleItem(Item.Properties pProperties) {
        super(pProperties);
    }

    public ThrowableItemProjectile createPebble(Level pLevel, ItemStack pItemStack, LivingEntity pLivingEntity) {
        Pebble pebble = new Pebble(pLevel, pLivingEntity);
        pebble.setItem(pItemStack);
        pebble.setDamage(4.0F);
        return pebble;
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pInteractionHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pInteractionHand);
        pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClientSide) {
            Pebble pebble = new Pebble(pLevel, pPlayer);
            pebble.setItem(itemstack);
            pebble.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(pebble);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }

}
