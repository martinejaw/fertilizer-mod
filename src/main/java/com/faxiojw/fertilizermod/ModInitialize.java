package com.faxiojw.fertilizermod;

import com.faxiojw.fertilizermod.registry.ModBlocks;
import com.faxiojw.fertilizermod.registry.ModItems;
import com.faxiojw.fertilizermod.config.*;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModInitialize implements ModInitializer {

    public static final String MOD_ID = "fertilizermod";

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder
    .create(new Identifier(MOD_ID, "general")) 
    .icon(() -> new ItemStack(ModItems.POOP))
    .build();

    @Override
    public void onInitialize() {
        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
		Config.initConfig();

        ModItems.registerItems();
        ModBlocks.registryBlocks();
    }

}