package com.faxiojw.fertilizermod.blocks;

import java.util.Random;

import com.faxiojw.fertilizermod.config.Config;
import com.faxiojw.fertilizermod.registry.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;

public class PoopBlockEntity extends BlockEntity implements Tickable {
    public PoopBlockEntity() {
       super(ModBlocks.POOP_BLOCK_ENTITY);
    }

    private Random rand = new Random();
    private int timeNextGrow = this.rand.nextInt(Config.maxFertilizeTime - Config.minFertilizeTime) + Config.minFertilizeTime;

    @Override
    public void tick() {
        if(!this.getWorld().isClient()){
            this.timeNextGrow--;
            if(timeNextGrow == 0) {
                this.growSomething();
                timeNextGrow = this.rand.nextInt(Config.maxFertilizeTime - Config.minFertilizeTime) + Config.minFertilizeTime;
            }
        }
    }

    public void growSomething() {
        BlockPos pos = this.getPos();
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        
        Iterable<BlockPos> iter = BlockPos.iterateRandomly(rand, 9, x-1, y+2, z-1, x+1, y+2, z+1);

        for (BlockPos p : iter) {
            Block block = this.getWorld().getBlockState(p).getBlock();
            if (block instanceof CropBlock) {
                CropBlock crop = (CropBlock) block;
                BlockState state = this.getWorld().getBlockState(p);
                if(!crop.isMature(state)) {
                    crop.applyGrowth(this.getWorld(), p, state);
                    return;
                }
            }
        }
    }
 }