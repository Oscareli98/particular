package particular.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Facing;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import particular.lib.BlockIds;
import particular.lib.Reference;
import particular.lib.Strings;
import net.minecraft.world.World;

public class BlockTierOneMachineHousing extends BlockParticular {

	public boolean neighborBlockChange;
	int blockSurfaces;

	public BlockTierOneMachineHousing(int id) {
		super(id, Material.iron);
		this.setUnlocalizedName(Strings.TIER_ONE_MACHINE_HOUSING_NAME);
		this.setHardness(1.5F);

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {

		blockIcon = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
		func_111022_d(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
	}

	public Icon getIcon(int side, int meta) {
		int k = getOrientation(meta);
		//		if (meta == 0 && side == 0)
		//			return bottom;
		//		if (meta == 1 && side == 1)
		//			return top;
		//		//		if (side == 2)
		//		//			return North;
		//		//		if (side == 3)
		//		//			return South;
		//		//		if (side == 4)
		//		//			return West;
		//		//		if (side == 5)
		//		//			return East;
		//		if (meta == 3 && side == 3)
		//			return South;
		//		if (meta == 2 && side == 2)
		//			return North;
		//		if (meta == 4 && side == 4)
		//			return West;
		//		if (meta == 5 && side == 5)
		//			return East;


		return blockIcon;

	}

	public void determineIcons(World world, int x, int y, int z, int meta) {

		if (world.getBlockId(x + 1, y, z) == BlockIds.TIER_ONE_MACHINE_HOUSING || world.getBlockId(x - 1, y, z) == BlockIds.TIER_ONE_MACHINE_HOUSING) {
			System.out.println("x");
		}
		if (world.getBlockId(x, y + 1, z) == BlockIds.TIER_ONE_MACHINE_HOUSING || world.getBlockId(x, y - 1, z) == BlockIds.TIER_ONE_MACHINE_HOUSING) {
			System.out.println("y");
		}
		if (world.getBlockId(x, y, z + 1) == BlockIds.TIER_ONE_MACHINE_HOUSING || world.getBlockId(x, y, z - 1) == BlockIds.TIER_ONE_MACHINE_HOUSING) {
			System.out.println("z");
		}
		blockSurfaces = 1;
	}


	public void onNeighborBlockChange(World par1World, int x, int y, int z, int meta) {
		determineIcons(par1World, x, y, z, meta);
		super.onNeighborBlockChange(par1World, x, y, z, meta);
	}

	public void onBlockAdded(World par1World, int x, int y, int z, int meta) {
		determineIcons(par1World, x, y, z, meta);
		super.onBlockAdded(par1World, x, y, z);
	}

	public static int getOrientation(int par0) {
		return par0 & 7;
	}
}
