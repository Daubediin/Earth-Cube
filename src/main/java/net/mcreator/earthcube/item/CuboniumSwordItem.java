
package net.mcreator.earthcube.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class CuboniumSwordItem extends SwordItem {
	public CuboniumSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 1164;
			}

			public float getSpeed() {
				return 12f;
			}

			public float getAttackDamageBonus() {
				return 4f;
			}

			public int getLevel() {
				return 6;
			}

			public int getEnchantmentValue() {
				return 42;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(EarthcubeModItems.CUBONIUM.get()));
			}
		},

				3, -3f,

				new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
	}

}
