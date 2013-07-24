package particular.block;

import particular.lib.Strings;
import net.minecraft.block.material.Material;

public class BlockOreAluminum extends BlockParticular{

	public BlockOreAluminum(int id, Material material) {
		super(id, material);
		this.setUnlocalizedName(Strings.BLOCK_ORE_ALUMINUM_NAME);
		this.setHardness(1.5F);
	}
	
}
