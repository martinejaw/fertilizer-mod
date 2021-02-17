package com.faxiojw.fertilizermod.mixin;

import java.util.Random;

import com.faxiojw.fertilizermod.config.Config;
import com.faxiojw.fertilizermod.registry.ModItems;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

@Mixin(AnimalEntity.class)
public abstract class AnimalEntityMixin extends Entity {

    public AnimalEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow
    public boolean isBreedingItem(ItemStack itemStack) {return true;}
    
    @Shadow
    public boolean canEat() {return true;}

    private int poopTime = -1;
    private Random rand = new Random();

    @Inject(method = "mobTick", at = @At("HEAD"))
    protected void mobTick(CallbackInfo info){
        this.poopTime--;
        if(this.poopTime == 0) {
            this.playSound(SoundEvents.BLOCK_HONEY_BLOCK_BREAK, 1F, 1F);
            // SoundEvents.BLOCK_BEEHIVE_DRIP
            // SoundEvents.BLOCK_BEEHIVE_EXIT
            super.dropItem(ModItems.POOP);
        }
    }

    @Inject(method = "interactMob", at = @At("HEAD"))
    public void interactMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> info) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (this.isGoingToPoop() && this.isBreedingItem(itemStack) && !this.world.isClient && this.canEat()) {
            this.nextPoopTime();
        }
    }

    public void nextPoopTime() {
        poopTime = this.rand.nextInt(Config.maxPoopTime - Config.minPoopTime) + Config.minPoopTime;
    }

    public boolean isGoingToPoop() {
        return (this.rand.nextDouble() < Config.chancePoop) ? true : false;
    }
}
