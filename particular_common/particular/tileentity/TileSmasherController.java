package particular.tileentity;


import particular.lib.Strings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class TileSmasherController extends TileParticular implements IInventory{

	private ItemStack inv[];
	
	public TileSmasherController() {
		inv = new ItemStack[9];
	}

	@Override
	public int getSizeInventory() {
		return inv.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inv[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amt) {
		ItemStack stack = getStackInSlot(slot);
		if(stack != null){
			if(stack.stackSize <= amt){
				setInventorySlotContents(slot, null);
			}
			else{
				stack = stack.splitStack(amt);
				if(stack.stackSize == 0){
					setInventorySlotContents(slot, null);
				}
			}
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		if(stack != null){
			setInventorySlotContents(slot, null);
		}
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inv[slot] = stack;
		if(stack != null && stack.stackSize > getInventoryStackLimit()){
			stack.stackSize = getInventoryStackLimit();
		}
		
	}

	@Override
	public String getInvName() {
		return this.hasCustomName() ? this.getCustomName() : Strings.CONTAINER_SMASHER_CONTROLLER_NAME;
	}

	@Override
	public boolean isInvNameLocalized() {
		return this.hasCustomName();
	}

	@Override
	public int getInventoryStackLimit() {
		return 65000;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		 return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
	}

}
