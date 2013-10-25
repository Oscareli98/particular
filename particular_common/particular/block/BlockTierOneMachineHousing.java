package particular.block;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.SwingConstants;

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
	
	@SideOnly(Side.CLIENT)
	public boolean a;
	@SideOnly(Side.CLIENT) 
	protected Icon front;

	public BlockTierOneMachineHousing(int id) {
		super(id, Material.iron);
		this.setUnlocalizedName(Strings.TIER_ONE_MACHINE_HOUSING_NAME);
		this.setHardness(1.5F);

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
		this.front = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
		func_111022_d(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
	}

	public Icon getIcon(int side, int meta) {
		//int k = getOrientation(meta);
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
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("tierOneMachineHousing2.png"));
		    for (int i = 0; i != 16; i++) {
		    	for (int j = 0; j != 16; j++) {
		    		if (i < 8) {
		    			if (j < 8) {
		    				img.setRGB(i, j, img.getRGB(i, j) -(j*3));
			    		} else {
			    			img.setRGB(i, j, img.getRGB(i, j) + (j*3));
			    		}
		    		} else {
		    			if (j < 8) {
		    				img.setRGB(i, j, img.getRGB(i, j) -(j*3));
			    		} else {
			    			img.setRGB(i, j, img.getRGB(i, j) + (j*3));
			    		}
		    		}
		    	}
		    }
		    File outputfile = new File("tierOneMachineHousing.png");
		    ImageIO.write(img, "png", outputfile);
		} catch (IOException e) {
			img = null;
		}
		
	}

	public void onNeighborBlockChange(World par1World, int x, int y, int z, int meta) {
		determineIcons(par1World, x, y, z, meta);
		super.onNeighborBlockChange(par1World, x, y, z, meta);
	}

	public static int getOrientation(int par0) {
		return par0 & 7;
	}
}
