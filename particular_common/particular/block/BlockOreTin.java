package particular.block;

import particular.lib.Strings;
import net.minecraft.block.material.Material;

public class BlockOreTin extends BlockParticular{

	public BlockOreTin(int id, Material material) {
		super(id, material.iron);
		this.setUnlocalizedName(Strings.BLOCK_ORE_TIN_NAME);
		this.setHardness(1.5F);
	}

}
