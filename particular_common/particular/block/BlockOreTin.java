package particular.block;

import particular.lib.Strings;
import net.minecraft.block.material.Material;

public class BlockOreTin extends BlockParticular{

	public BlockOreTin(int id) {
		super(id, Material.rock);
		this.setUnlocalizedName(Strings.ORE_TIN_NAME);
		this.setHardness(1.5F);
	}

}
