package particular.block;

import net.minecraft.block.material.Material;
import particular.lib.Strings;

public class BlockOreAluminum extends BlockParticular{

	public BlockOreAluminum(int id) {
		super(id, Material.rock);
		this.setUnlocalizedName(Strings.ORE_ALUMINUM_NAME);
		this.setHardness(1.5F);
	}
	
}
