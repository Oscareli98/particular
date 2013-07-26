package particular.block;

import net.minecraft.block.material.Material;
import particular.lib.Strings;

public class BlockCopper extends BlockParticular {

	public BlockCopper(int id) {
		super(id, Material.iron);
		this.setUnlocalizedName(Strings.BLOCK_COPPER_NAME);
		this.setHardness(2.5f);
	}

}
