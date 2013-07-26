package particular.block;

import net.minecraft.block.material.Material;
import particular.lib.Strings;

public class BlockOreTin extends BlockParticular{

	public BlockOreTin(int id) {
		super(id, Material.rock);
		this.setUnlocalizedName(Strings.ORE_TIN_NAME);
		this.setHardness(1.5F);
	}

}
