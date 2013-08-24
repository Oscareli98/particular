package particular.block;

import java.util.Random;

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
import particular.lib.Reference;
import particular.lib.Strings;
import particular.tileentity.TileSmasherController;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
		if(tileEntity == null || player.isSneaking()){
			return false;
		}
		player.openGui(Particular.instance, 0, world, x, y, z);
		return true;
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
