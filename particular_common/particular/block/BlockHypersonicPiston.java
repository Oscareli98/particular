package particular.block;


import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import particular.lib.Reference;
import particular.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHypersonicPiston extends BlockParticular {

	public BlockHypersonicPiston(int id) {
		super(id, Material.rock);
		this.setUnlocalizedName(Strings.HYPERSONIC_PISTON_NAME);
		this.setHardness(2F);

	}

	public static int determineOrientation(World par0World, int par1, int par2, int par3, EntityLivingBase par4EntityLivingBase) {
		if (MathHelper.abs((float)par4EntityLivingBase.posX - (float)par1) < 2.0F && MathHelper.abs((float)par4EntityLivingBase.posZ - (float)par3) < 2.0F)
		{
			double d0 = par4EntityLivingBase.posY + 1.82D - (double)par4EntityLivingBase.yOffset;

			if (d0 - (double)par2 > 2.0D)
			{
				return 1;
			}

			if ((double)par2 - d0 > 0.0D) {
				return 0;
			}
		}
		int l = MathHelper.floor_double((double)(par4EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		return l == 0 ? 2 : (l == 1 ? 5 : (l == 2 ? 3 : (l == 3 ? 4 : 0)));
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
	public void registerIcons(IconRegister iconRegister) {
		System.out.println();
		this.blockIcon = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
		this.bottom = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), "0" + getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
		this.top = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), "1" + getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
		this.North = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), "2" + getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
		this.South = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), "3" + getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
		this.West = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), "4" + getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
		this.East = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), "5" + getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		if (meta == 0 && side == 0)
			return bottom;
		if (meta == 1 && side == 1)
			return top;
		//		if (side == 2)
		//			return North;
		//		if (side == 3)
		//			return South;
		//		if (side == 4)
		//			return West;
		//		if (side == 5)
		//			return East;
		if (meta == 3 && side == 3)
			return South;
		if (meta == 2 && side == 2)
			return North;
		if (meta == 4 && side == 4)
			return West;
		if (meta == 5 && side == 5)
			return East;
		return blockIcon;
	}


	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		int l = determineOrientation(par1World, par2, par3, par4, par5EntityLivingBase);
		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);


	}

}
