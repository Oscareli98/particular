package particular.block;

import net.minecraft.block.material.Material;
import particular.lib.Strings;

public class BlockTierOneMachineHousing extends BlockParticular {

	public BlockTierOneMachineHousing(int id) {
		super(id, Material.iron);
		this.setUnlocalizedName(Strings.TIER_ONE_MACHINE_HOUSING_NAME);
        this.setHardness(1.5F);

	}

}
