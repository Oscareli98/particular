package particular.block;

import particular.lib.Strings;
import net.minecraft.block.material.Material;

public class BlockTin extends BlockParticular {

	public BlockTin(int id) {
		super(id, Material.iron);
		this.setUnlocalizedName(Strings.BLOCK_TIN_NAME);
		this.setHardness(2.5f);
	}

}
