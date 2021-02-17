package com.faxiojw.fertilizermod.registry;

import com.faxiojw.fertilizermod.ModInitialize;
import com.faxiojw.fertilizermod.config.Config;
import com.faxiojw.fertilizermod.items.Poop;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    // Items
    public static final Item POOP = new Poop(new Item.Settings().group(ModInitialize.ITEM_GROUP));

    // Block Items
    public static final BlockItem POOP_BLOCK = new BlockItem(ModBlocks.POOP_BLOCK, new Item.Settings().group(ModInitialize.ITEM_GROUP));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(ModInitialize.MOD_ID, "poop"), POOP);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(POOP, Config.poopComposteChance);
        FuelRegistry.INSTANCE.add(POOP, Config.poopFuelTime);
        
        Registry.register(Registry.ITEM, new Identifier(ModInitialize.MOD_ID, "poop_block"), POOP_BLOCK);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(POOP_BLOCK, Config.poopBlockComposteChance);
        FuelRegistry.INSTANCE.add(POOP_BLOCK, Config.poopBlockFuelTime);
    }
}
