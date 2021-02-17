package com.faxiojw.fertilizermod.registry;

import com.faxiojw.fertilizermod.ModInitialize;
import com.faxiojw.fertilizermod.blocks.PoopBlock;
import com.faxiojw.fertilizermod.blocks.PoopBlockEntity;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.BlockSoundGroup;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    
    public static final Block POOP_BLOCK = new PoopBlock(FabricBlockSettings
    .of(Material.ORGANIC_PRODUCT)
    .breakByTool(FabricToolTags.SHOVELS, 0)
    .requiresTool()
    .strength(0.5f, 0.5f)
    .sounds(BlockSoundGroup.FUNGUS)
    );

    public static BlockEntityType<PoopBlockEntity> POOP_BLOCK_ENTITY;

    public static void registryBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(ModInitialize.MOD_ID, "poop_block"), POOP_BLOCK);

        POOP_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "fertilizermod:poop_block_entity", BlockEntityType.Builder.create(PoopBlockEntity::new, POOP_BLOCK).build(null)); 
    }

  
}
