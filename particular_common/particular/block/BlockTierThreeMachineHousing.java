package particular.block;

import net.minecraft.block.material.Material;
import particular.lib.Strings;

public class BlockTierThreeMachineHousing extends BlockParticular {

	public BlockTierThreeMachineHousing(int id) {
		super(id, Material.iron);
		this.setUnlocalizedName(Strings.TIER_THREE_MACHINE_HOUSING_NAME);
		this.setHardness(3F);
	}

}
