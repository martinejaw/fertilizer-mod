package com.faxiojw.fertilizermod.config;

import me.shedaniel.autoconfig.AutoConfig;

public class Config {
    public static ModConfig config;

    public static int minPoopTime;
    public static int maxPoopTime;
    public static float chancePoop;

    public static int minFertilizeTime;
    public static int maxFertilizeTime;

    public static int poopFuelTime;
    public static int poopBlockFuelTime;

    public static float poopComposteChance = 10;
    public static float poopBlockComposteChance = 100;

    public static void initConfig() {
        config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

        minPoopTime = config.minPoopTime * 20;  // Multiply by 20 ticks/sec
        maxPoopTime = config.maxPoopTime * 20;
        chancePoop = (float) config.chancePoop / (float) 100;   // % to 0-1 range

        minFertilizeTime = config.minFertilizeTime * 20;
        maxFertilizeTime = config.maxFertilizeTime * 20;

        poopFuelTime = config.poopFuelTime;
        poopBlockFuelTime =config.poopBlockFuelTime;

        poopComposteChance = (float) config.poopComposteChance / (float) 100; // % to 0-1 range
        poopBlockComposteChance = (float) config.poopBlockComposteChance / (float) 100;
    }
}
