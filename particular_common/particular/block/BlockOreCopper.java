package particular.block;

import particular.lib.Strings;
import net.minecraft.block.material.Material;

public class BlockOreCopper extends BlockParticular{

	public BlockOreCopper(int id) {
		super(id, Material.rock);
		this.setUnlocalizedName(Strings.ORE_COPPER_NAME);
		this.setHardness(1.5F);
	}
	
}
