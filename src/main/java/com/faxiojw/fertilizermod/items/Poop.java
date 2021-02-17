package com.faxiojw.fertilizermod.items;

import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;

public class Poop extends Item {
    public Poop(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(BoneMealItem.useOnFertilizable(context.getStack(), context.getWorld(), context.getBlockPos())) {
            int maxTimes = 2;

            while(maxTimes > 1) {
                --maxTimes;
                BoneMealItem.useOnFertilizable(new ItemStack(Items.BONE_MEAL), context.getWorld(), context.getBlockPos());
            }

            if(context.getWorld().isClient) BoneMealItem.createParticles(context.getWorld(), context.getBlockPos(), 10);
            return ActionResult.SUCCESS;
        }

        return ActionResult.FAIL;
    }
}
