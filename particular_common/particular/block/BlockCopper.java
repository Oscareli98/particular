package particular.block;

import particular.lib.Strings;
import net.minecraft.block.material.Material;

public class BlockCopper extends BlockParticular {

	public BlockCopper(int id) {
		super(id, Material.iron);
		this.setUnlocalizedName(Strings.BLOCK_COPPER_NAME);
		this.setHardness(2.5f);
	}

}
