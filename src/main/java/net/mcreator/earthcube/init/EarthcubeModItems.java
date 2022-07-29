
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.earthcube.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.earthcube.item.MiningworldItem;
import net.mcreator.earthcube.item.CuboniumSwordItem;
import net.mcreator.earthcube.item.CuboniumShovelItem;
import net.mcreator.earthcube.item.CuboniumPickaxeItem;
import net.mcreator.earthcube.item.CuboniumItem;
import net.mcreator.earthcube.item.CuboniumHoeItem;
import net.mcreator.earthcube.item.CuboniumAxeItem;
import net.mcreator.earthcube.item.CuboniumArmorItem;
import net.mcreator.earthcube.EarthcubeMod;

public class EarthcubeModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, EarthcubeMod.MODID);
	public static final RegistryObject<Item> MININGWORLD = REGISTRY.register("miningworld", () -> new MiningworldItem());
	public static final RegistryObject<Item> PORTALBLOCK = block(EarthcubeModBlocks.PORTALBLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> CUBONIUM = REGISTRY.register("cubonium", () -> new CuboniumItem());
	public static final RegistryObject<Item> CUBONIUM_ORE = block(EarthcubeModBlocks.CUBONIUM_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> CUBONIUM_BLOCK = block(EarthcubeModBlocks.CUBONIUM_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> CUBONIUM_PICKAXE = REGISTRY.register("cubonium_pickaxe", () -> new CuboniumPickaxeItem());
	public static final RegistryObject<Item> CUBONIUM_AXE = REGISTRY.register("cubonium_axe", () -> new CuboniumAxeItem());
	public static final RegistryObject<Item> CUBONIUM_SWORD = REGISTRY.register("cubonium_sword", () -> new CuboniumSwordItem());
	public static final RegistryObject<Item> CUBONIUM_SHOVEL = REGISTRY.register("cubonium_shovel", () -> new CuboniumShovelItem());
	public static final RegistryObject<Item> CUBONIUM_HOE = REGISTRY.register("cubonium_hoe", () -> new CuboniumHoeItem());
	public static final RegistryObject<Item> CUBONIUM_ARMOR_HELMET = REGISTRY.register("cubonium_armor_helmet", () -> new CuboniumArmorItem.Helmet());
	public static final RegistryObject<Item> CUBONIUM_ARMOR_CHESTPLATE = REGISTRY.register("cubonium_armor_chestplate",
			() -> new CuboniumArmorItem.Chestplate());
	public static final RegistryObject<Item> CUBONIUM_ARMOR_LEGGINGS = REGISTRY.register("cubonium_armor_leggings",
			() -> new CuboniumArmorItem.Leggings());
	public static final RegistryObject<Item> CUBONIUM_ARMOR_BOOTS = REGISTRY.register("cubonium_armor_boots", () -> new CuboniumArmorItem.Boots());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
