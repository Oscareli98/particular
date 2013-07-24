package particular.block;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import particular.lib.Reference;
import particular.lib.Strings;

public class BlockHypersonicPiston extends BlockParticular {

	public BlockHypersonicPiston(int id){
		super(id, Material.rock);
		this.setUnlocalizedName(Strings.HYPERSONIC_PISTON_NAME);
		this.setHardness(2F);

	}

	@SideOnly(Side.CLIENT) 
	protected Icon bottom;    
	@SideOnly(Side.CLIENT) 
	protected Icon top;
	@SideOnly(Side.CLIENT) 
	protected Icon North;
	@SideOnly(Side.CLIENT) 
	protected Icon South;
	@SideOnly(Side.CLIENT)
	protected Icon West;
	@SideOnly(Side.CLIENT)
	protected Icon East;

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		System.out.println();
		this.blockIcon = iconRegister.registerIcon("stonebrick");
		this.bottom = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), "0" + getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
		this.top = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), "1" + getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
		this.North = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), "2" + getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
		this.South = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), "3" + getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
		this.West = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), "4" + getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
		this.East = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), "5" + getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta)
	{
		//    	if (meta == 0 && side == 3)
		//    		return faceIcon;
		//    	if (meta == 2 && side == 2)
		//    		return faceIcon;
		//    	if (meta == 1 && side == 4)
		//    		return faceIcon;
		//    	if (meta == 3 && side == 5)
		//    		return faceIcon;
		if (side == 0)
			return bottom;
		if (side == 1)
			return top;
		if (side == 2)
			return North;
		if (side == 3)
			return South;
		if (side == 4)
			return West;
		if (side == 5)
			return East;
		return blockIcon;
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityliving)
	{
	System.out.println("onBlockPlaced is Working");
	int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;

	switch (l)
	{
	case 0:
	world.setBlockMetadataWithNotify(x, y, z, 2, 2);
	System.out.println("case 0" + l);
	break;

	case 1:
	world.setBlockMetadataWithNotify(x, y, z, 5, 2);
	System.out.println("case 1" + l);
	break;

	case 2:
	world.setBlockMetadataWithNotify(x, y, z, 3, 2);
	System.out.println("case 2" + l);
	break;

	case 3:
	world.setBlockMetadataWithNotify(x, y, z, 4, 2);
	System.out.println("case 3" + l);
	break;
	}
	}
	
	
}
