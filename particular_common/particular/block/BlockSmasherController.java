package particular.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import particular.Particular;
import particular.lib.BlockIds;
import particular.lib.Reference;
import particular.lib.Strings;
import particular.tileentity.TileSmasherController;

public class BlockSmasherController extends BlockContainerParticular {

	public BlockSmasherController(int id) {
		super(id, Material.iron);
		setHardness(3.0f);
		setResistance(6.28318530718f);
		setUnlocalizedName(Strings.SMASHER_CONTROLLER_NAME);
	}

	@SideOnly(Side.CLIENT) 
	protected Icon bottom;    
	@SideOnly(Side.CLIENT) 
	protected Icon front;

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		System.out.println();
		this.front = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
		this.blockIcon = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), "tierOneMachineHousing"));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		return side == 1 ? this.blockIcon : (side == 0 ? this.blockIcon : (side != meta ? this.blockIcon : this.front));
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float a, float b, float c) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (checkMultiBlock(world, x, y, z, player, metadata, a, b, c) == true) {
			if(tileEntity == null || player.isSneaking()){
				return false;
			}
			player.openGui(Particular.instance, 0, world, x, y, z);
			return true;
		} else {
			return false;
		}
	}

	public boolean checkMultiBlock(World world, int x, int y, int z, EntityPlayer player, int metadata, float a, float b, float c) {
		boolean allLayersTrue = true;
		int xcheck = x;
		int ycheck = y;
		int zcheck = z;
		int checkBlock;
		int tierOne = BlockIds.TIER_ONE_MACHINE_HOUSING;
		int numOfThis = 0;

		if (world.getBlockId(x, y, z - 1) == tierOne && world.getBlockId(x , y + 1, z - 1) == 0) {
			xcheck--;
			System.out.println("z--");
		} else if (world.getBlockId(x, y, z + 1 ) == tierOne && world.getBlockId(x , y + 1, z + 1) == 0) {
			zcheck = zcheck - 2;
			xcheck--;
			System.out.println("z++");
		} else if (world.getBlockId(x + 1, y, z) == tierOne && world.getBlockId(x + 1, y + 1, z) == 0) {
			xcheck = xcheck - 2;
			zcheck--;
			System.out.println("x++");
		} else if (world.getBlockId(x - 1, y, z) == tierOne && world.getBlockId(x - 1, y + 1, z) == 0) {
			zcheck--;
			System.out.println("x--");
		}

		for (int i = 0; i < 4; i++) {  // starts on the zero layer and works up to the top, there are nine statements below to check the nine blocks
			ycheck = y + i;
			for (int j = 0; j < 3; j++) {
				xcheck = x + j;
				for (int k = 0; k < 3; k++) {
					zcheck = z + k;
					checkBlock = world.getBlockId(xcheck, ycheck, zcheck);
					switch(checkBlock) {
						case 0:
							if ((i == 2 || i == 3) && j == 2 && z == 2) {
								// leave blank
							} else {
								allLayersTrue = false;
							}
							break;
						default:
							if (checkBlock == tierOne) {
								break;
							} else if (checkBlock == BlockIds.SMASHER_CONTROLLER) {
								numOfThis++;
								break;
							} else {
								allLayersTrue = false;
								break;
							}
					}
				}
			}

			if (numOfThis < 1) {
				allLayersTrue = false;
			}

			//			if (!(world.getBlockId(xcheck, ycheck, zcheck) == tierOne || world.getBlockId(xcheck, ycheck, zcheck) == 0)) {
			//				// error
			//			} else {
			//				// do 
			//			
			//				System.out.println("nope not working");
			//				allLayersTrue = false;
			//				System.out.println(i);
			//			}
		}

		return allLayersTrue;
	}




	@Override
	public void breakBlock(World world, int x, int y, int z, int a, int b) {
		dropItems(world, x, y, z);
		super.breakBlock(world, x, y, z, a, b);
	}

	public void dropItems(World world, int x, int y, int z) {
		Random rand  = new Random();

		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(!(tileEntity instanceof IInventory)){
			return;
		}
		IInventory inventory  = (IInventory)tileEntity;
		for(int i = 0; i<inventory.getSizeInventory(); i++){
			ItemStack item = inventory.getStackInSlot(i);

			if(item != null && item.stackSize > 0){
				float rx = rand.nextFloat() * 0.8F + 0.1F;
				float ry = rand.nextFloat() * 0.8F + 0.1F;
				float rz = rand.nextFloat() * 0.8F + 0.1F;

				EntityItem entityItem = new EntityItem(world, x+rx, y+ry, z+rz, new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

				if(item.hasTagCompound()){
					entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
				}
				float factor = 0.5f;
				entityItem.motionX = rand.nextGaussian() * factor;
				entityItem.motionY = rand.nextGaussian() * factor;
				entityItem.motionZ = rand.nextGaussian() * factor;
				world.spawnEntityInWorld(entityItem);
				item.stackSize = 0;
			}
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileSmasherController();
	}
}
