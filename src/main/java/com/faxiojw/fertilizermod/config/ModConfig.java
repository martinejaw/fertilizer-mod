package com.faxiojw.fertilizermod.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "tutorial")
public class ModConfig implements ConfigData {
    
    @Comment(value = "The minimum and maximum time a pig can produce poop (in seconds)")
    int minPoopTime = 30;
    int maxPoopTime = 60;

    @ConfigEntry.BoundedDiscrete(max = 100)
    @Comment(value = "The chance of the animal pooping after being fed (in %)")
    int chancePoop = 70;

    @Comment(value = "The minimum and maximum time a poop block will fertilize a crop (in seconds)")
    int minFertilizeTime = 30;
    int maxFertilizeTime = 60;

    @Comment(value = "Fuel time of the fertilizers (in ticks)")
    int poopFuelTime = 80;
    int poopBlockFuelTime = 800;

    @Comment(value = "Chance of increase a level in composter block (in %)")
    int poopComposteChance = 10;
    int poopBlockComposteChance = 100;
}