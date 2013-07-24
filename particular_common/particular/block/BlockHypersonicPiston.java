package particular.block;


import net.minecraft.block.material.Material;
import particular.lib.Strings;

public class BlockHypersonicPiston extends BlockParticular {

	public BlockHypersonicPiston(int id){
		super(id, Material.rock);
		this.setUnlocalizedName(Strings.HYPERSONIC_PISTON_NAME);
        this.setHardness(2F);
	}

}
