package particular.block;

import particular.lib.Strings;
import net.minecraft.block.material.Material;

public class BlockOreCopper extends BlockParticular{

	public BlockOreCopper(int id, Material material) {
		super(id, material);
		this.setUnlocalizedName(Strings.BLOCK_ORE_COPPER_NAME);
		this.setHardness(1.5F);
	}
	
}
