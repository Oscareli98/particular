package particular.item;

import particular.lib.Strings;



public class ItemStickWelder extends ParticularItems {

	public ItemStickWelder(int id) {
		super(id);
		this.setUnlocalizedName(Strings.STICK_WELDER_NAME);
		this.setMaxDamage(10);
	}
}
