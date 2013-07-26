package particular.block;

import net.minecraft.block.material.Material;
import particular.lib.Strings;

public class BlockOreCopper extends BlockParticular{

	public BlockOreCopper(int id) {
		super(id, Material.rock);
		this.setUnlocalizedName(Strings.ORE_COPPER_NAME);
		this.setHardness(1.5F);
	}
	
}
