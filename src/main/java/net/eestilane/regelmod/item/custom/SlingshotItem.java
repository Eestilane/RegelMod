package net.eestilane.regelmod.item.custom;

import net.eestilane.regelmod.item.ModItems;
import net.eestilane.regelmod.util.ModTags;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

public class SlingshotItem extends ProjectileWeaponItem implements Vanishable {
    public static final int MAX_DRAW_DURATION = 1200;
    public static final int DEFAULT_RANGE = 10;

    public static final Predicate<ItemStack> PEBBLE_ONLY = (pItemStack) -> {
        return pItemStack.is(ModTags.Items.PEBBLE);
    };

    public SlingshotItem(Item.Properties pProperties) {
        super(pProperties);
    }

    public void releaseUsing(ItemStack pItemStack, Level pLevel, LivingEntity pLivingEntity, int remainingUseTicks) {
        if (pLivingEntity instanceof Player player) {
            boolean flag = player.getAbilities().instabuild;
            ItemStack itemstack = player.getProjectile(pItemStack);

            int chargeTime = this.getUseDuration(pItemStack) - remainingUseTicks;
            chargeTime = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(pItemStack, pLevel, player, chargeTime, !itemstack.isEmpty() || flag);
            if (chargeTime < 0) return;

            if (!itemstack.isEmpty() || flag) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(ModItems.PEBBLE.get());
                }

                float powerForTime = getPowerForTime(chargeTime);
                if (!((double) powerForTime < 0.1D)) {
                    boolean flag1 = player.getAbilities().instabuild;
                    if (!pLevel.isClientSide) {
                        PebbleItem pebbleItem = (PebbleItem) (itemstack.getItem() instanceof PebbleItem ? itemstack.getItem() : Items.SNOWBALL);
                        ThrowableItemProjectile pebble = pebbleItem.createPebble(pLevel, itemstack, player);
                        pebble.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, powerForTime * 3.0F, 1.0F);
                        pItemStack.hurtAndBreak(1, player, (p_289501_) -> {
                            p_289501_.broadcastBreakEvent(player.getUsedItemHand());
                        });

                        pLevel.addFreshEntity(pebble);
                    }

                    pLevel.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (pLevel.getRandom().nextFloat() * 0.4F + 1.2F) + powerForTime * 0.5F);
                    if (!flag1 && !player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            player.getInventory().removeItem(itemstack);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public static float getPowerForTime(int pPowerForTime) {
        float f = (float) pPowerForTime / 10.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    public int getUseDuration(ItemStack pItemStack) {
        return MAX_DRAW_DURATION;
    }

    public UseAnim getUseAnimation(ItemStack pItemStack) {
        return UseAnim.BOW;
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pInteractionHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pInteractionHand);
        boolean flag = !pPlayer.getProjectile(itemstack).isEmpty();

        InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, pLevel, pPlayer, pInteractionHand, flag);
        if (ret != null) return ret;

        if (!pPlayer.getAbilities().instabuild && !flag) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            pPlayer.startUsingItem(pInteractionHand);
            return InteractionResultHolder.consume(itemstack);
        }
    }

    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return PEBBLE_ONLY;
    }

    public int getDefaultProjectileRange() {
        return DEFAULT_RANGE;
    }
}