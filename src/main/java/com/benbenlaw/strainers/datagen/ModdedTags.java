package com.benbenlaw.strainers.datagen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.Objects;

public class ModdedTags {

    public static TagKey<Item> tinNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/tin")))));

    public static TagKey<Item> copperNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/copper")))));

    public static TagKey<Item> aluminumNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/aluminum")))));

    public static TagKey<Item> zincNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/zinc")))));

    public static TagKey<Item> osmiumNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/osmium")))));

    public static TagKey<Item> silverNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/silver")))));

    public static TagKey<Item> leadNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/lead")))));

    public static TagKey<Item> nickelNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/nickel")))));

    public static TagKey<Item> platinumNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/platinum")))));

    public static TagKey<Item> goldNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/gold")))));

    public static TagKey<Item> ironNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/iron")))));

    public static TagKey<Item> uraniumNuggetTag = ItemTags.create(Objects.requireNonNull(ResourceLocation.tryParse(
            String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "nuggets/uranium")))));






}
