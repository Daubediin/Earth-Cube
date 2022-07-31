
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.earthcube.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.earthcube.network.LesCommandesUtilesMessage;
import net.mcreator.earthcube.EarthcubeMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class EarthcubeModKeyMappings {
	public static final KeyMapping LES_COMMANDES_UTILES = new KeyMapping("key.earthcube.les_commandes_utiles", GLFW.GLFW_KEY_K,
			"key.categories.misc");

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(LES_COMMANDES_UTILES);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == LES_COMMANDES_UTILES.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						EarthcubeMod.PACKET_HANDLER.sendToServer(new LesCommandesUtilesMessage(0, 0));
						LesCommandesUtilesMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
