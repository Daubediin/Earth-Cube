
package net.mcreator.earthcube.network;

import net.mcreator.earthcube.EarthcubeMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LesCommandesUtilesMessage {

	int type, pressedms;

	public LesCommandesUtilesMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public LesCommandesUtilesMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(LesCommandesUtilesMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(LesCommandesUtilesMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			pressAction(context.getSender(), message.type, message.pressedms);
		});
		context.setPacketHandled(true);
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;

		if (type == 0) {

			CommandesUtilesProcedure.execute(world, x, y, z, entity);
		}

	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		EarthcubeMod.addNetworkMessage(LesCommandesUtilesMessage.class, LesCommandesUtilesMessage::buffer, LesCommandesUtilesMessage::new,
				LesCommandesUtilesMessage::handler);
	}

}
