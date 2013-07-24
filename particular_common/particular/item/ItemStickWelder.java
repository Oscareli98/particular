package particular.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
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

	        if (world.isRemote) {
	        	ModLoader.getMinecraftInstance().thePlayer.addChatMessage("IT WORKS");
	        	itemStack.damageItem(1, entityPlayer);
	        	
	        }
	        return true;
	    }
}
