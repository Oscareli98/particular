package particular.block;

import net.minecraft.block.material.Material;
import particular.lib.Strings;

public class BlockAluminum extends BlockParticular{

	public BlockAluminum(int id) {
		super(id, Material.iron);
		this.setUnlocalizedName(Strings.BLOCK_ALUMINUM_NAME);
		this.setHardness(2.5f);
	}

}
