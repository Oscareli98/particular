package particular.block;


import net.minecraft.block.material.Material;
import particular.lib.Strings;

public class BlockTierTwoMachineHousing extends BlockParticular {

	public BlockTierTwoMachineHousing(int id){
		super(id, Material.iron);
		this.setUnlocalizedName(Strings.TIER_TWO_MACHINE_HOUSING_NAME);
        this.setHardness(2F);
	}

}
