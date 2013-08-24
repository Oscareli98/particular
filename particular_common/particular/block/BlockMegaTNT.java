package particular.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import particular.lib.Strings;

public class BlockMegaTNT extends BlockParticular{

	public BlockMegaTNT(int id) {
		super(id, Material.tnt);
		this.setUnlocalizedName(Strings.MEGA_TNT_NAME);
		this.setHardness(1.5F);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float a, float b, float c) {
		world.createExplosion(player, x, y, z, 100, true);
		return true;
	}
}
