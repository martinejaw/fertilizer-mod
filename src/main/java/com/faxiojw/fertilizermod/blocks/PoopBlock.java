package com.faxiojw.fertilizermod.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class PoopBlock extends Block  implements BlockEntityProvider {

    public PoopBlock(FabricBlockSettings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new PoopBlockEntity();
    }

}
