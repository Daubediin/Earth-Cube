package net.mcreator.earthcube.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class BalanceProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null)
				_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4), "balance");
		}
	}
}
