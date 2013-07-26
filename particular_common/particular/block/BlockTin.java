package particular.block;

import net.minecraft.block.material.Material;
import particular.lib.Strings;

public class BlockTin extends BlockParticular {

	public BlockTin(int id) {
		super(id, Material.iron);
		this.setUnlocalizedName(Strings.BLOCK_TIN_NAME);
		this.setHardness(2.5f);
	}

}
