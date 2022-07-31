
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.earthcube.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.earthcube.block.PortalblockBlock;
import net.mcreator.earthcube.block.MiningworldPortalBlock;
import net.mcreator.earthcube.EarthcubeMod;

public class EarthcubeModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, EarthcubeMod.MODID);
	public static final RegistryObject<Block> MININGWORLD_PORTAL = REGISTRY.register("miningworld_portal", () -> new MiningworldPortalBlock());
	public static final RegistryObject<Block> PORTALBLOCK = REGISTRY.register("portalblock", () -> new PortalblockBlock());
}
