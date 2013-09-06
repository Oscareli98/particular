package particular.item;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import particular.lib.Strings;



public class ItemStickWelder extends ItemParticular {

	public ItemStickWelder(int id) {
		super(id);
		this.setUnlocalizedName(Strings.STICK_WELDER_NAME);
		this.setMaxDamage(10);
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int sideHit, float hitVecX, float hitVecY, float hitVecZ) {

		if(itemStack.getItemDamage() >= 10){
			itemStack.damageItem(1, entityPlayer);
			itemStack = null; 
			
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.emptyStickWelder, 1));
			//entityPlayer.inventory.setInventorySlotContents(0, new ItemStack(ModItems.emptyStickWelder, 1);
			Random r = new Random();
			if(r.nextInt(1000000) == 1234 ){
				entityPlayer.addVelocity(1, 1, 1);
			}
		}
		else{
			itemStack.damageItem(1, entityPlayer);
		}



		return true;
	}


}
