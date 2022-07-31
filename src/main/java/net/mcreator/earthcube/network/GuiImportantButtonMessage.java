
package net.mcreator.earthcube.network;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GuiImportantButtonMessage {

	private final int buttonID, x, y, z;

	public GuiImportantButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public GuiImportantButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(GuiImportantButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(GuiImportantButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;

			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = GuiImportantMenu.guistate;

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;

		if (buttonID == 0) {

			SpawnProcedure.execute();
		}
		if (buttonID == 1) {

			CraftProcedure.execute(entity);
		}
		if (buttonID == 2) {

			VoteProcedure.execute(entity);
		}
		if (buttonID == 3) {

			SellheadProcedure.execute();
		}
		if (buttonID == 4) {

			BalanceProcedure.execute();
		}
		if (buttonID == 5) {

			LevelProcedure.execute();
		}
		if (buttonID == 6) {

			JobsProcedure.execute();
		}
		if (buttonID == 7) {

			AhProcedure.execute(entity);
		}
		if (buttonID == 8) {

			ShopProcedure.execute();
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		EarthcubeMod.addNetworkMessage(GuiImportantButtonMessage.class, GuiImportantButtonMessage::buffer, GuiImportantButtonMessage::new,
				GuiImportantButtonMessage::handler);
	}

}
