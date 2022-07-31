
package net.mcreator.earthcube.client.gui;

public class GuiImportantScreen extends AbstractContainerScreen<GuiImportantMenu> {

	private final static HashMap<String, Object> guistate = GuiImportantMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public GuiImportantScreen(GuiImportantMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("earthcube:textures/gui_important.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);

	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}

		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();

		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);

		this.addRenderableWidget(new Button(this.leftPos + 0, this.topPos + 0, 51, 20, new TextComponent("Spawn"), e -> {
			if (true) {
				EarthcubeMod.PACKET_HANDLER.sendToServer(new GuiImportantButtonMessage(0, x, y, z));
				GuiImportantButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 122, this.topPos + 0, 51, 20, new TextComponent("Craft"), e -> {
			if (true) {
				EarthcubeMod.PACKET_HANDLER.sendToServer(new GuiImportantButtonMessage(1, x, y, z));
				GuiImportantButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 65, this.topPos + 0, 46, 20, new TextComponent("Vote"), e -> {
			if (true) {
				EarthcubeMod.PACKET_HANDLER.sendToServer(new GuiImportantButtonMessage(2, x, y, z));
				GuiImportantButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 0, this.topPos + 38, 67, 20, new TextComponent("SellHead"), e -> {
			if (true) {
				EarthcubeMod.PACKET_HANDLER.sendToServer(new GuiImportantButtonMessage(3, x, y, z));
				GuiImportantButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 122, this.topPos + 38, 51, 20, new TextComponent("Money"), e -> {
			if (true) {
				EarthcubeMod.PACKET_HANDLER.sendToServer(new GuiImportantButtonMessage(4, x, y, z));
				GuiImportantButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 68, this.topPos + 38, 51, 20, new TextComponent("Level"), e -> {
			if (true) {
				EarthcubeMod.PACKET_HANDLER.sendToServer(new GuiImportantButtonMessage(5, x, y, z));
				GuiImportantButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 64, this.topPos + 69, 46, 20, new TextComponent("Jobs"), e -> {
			if (true) {
				EarthcubeMod.PACKET_HANDLER.sendToServer(new GuiImportantButtonMessage(6, x, y, z));
				GuiImportantButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 0, this.topPos + 69, 40, 20, new TextComponent("HDV"), e -> {
			if (true) {
				EarthcubeMod.PACKET_HANDLER.sendToServer(new GuiImportantButtonMessage(7, x, y, z));
				GuiImportantButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 127, this.topPos + 69, 46, 20, new TextComponent("Shop"), e -> {
			if (true) {
				EarthcubeMod.PACKET_HANDLER.sendToServer(new GuiImportantButtonMessage(8, x, y, z));
				GuiImportantButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}));
	}

}
