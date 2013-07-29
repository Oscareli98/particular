package particular.core.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import particular.client.gui.inventory.GuiSmasherController;
import particular.inventory.ContainerSmasherController;
import particular.lib.Strings;
import particular.tileentity.TileSmasherController;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy implements IGuiHandler{

	 public void registerKeyBindingHandler() {

	    }

	    public void registerRenderTickHandler() {

	    }

	    public void registerDrawBlockHighlightHandler() {

	    }

	    public void setKeyBinding(String name, int value) {

	    }

	    public void registerSoundHandler() {

	    }

	    public void initRenderingAndTextures() {

	    }

	    public void registerTileEntities() {

	        GameRegistry.registerTileEntity(TileSmasherController.class, Strings.SMASHER_CONTROLLER_NAME);
	    }

	    public void transmuteBlock(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int sideHit) {

	    }

	    public void sendRequestEventPacket(byte eventType, int originX, int originY, int originZ, byte sideHit, byte rangeX, byte rangeY, byte rangeZ, String data) {

	    }

	    public void handleTileEntityPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName) {

	    }

	    public void handleTileWithItemPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName, int itemID, int metaData, int stackSize, int color) {

	    }

	    @Override
	    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	        if (ID == 0) {
	            TileSmasherController tileSmasherController = (TileSmasherController) world.getBlockTileEntity(x, y, z);
	            return new ContainerSmasherController(player.inventory, tileSmasherController);
	        }
	      
	        return null;
	    }

	    @Override
	    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	        if (ID == 0) {
	            TileSmasherController tileSmasherController = (TileSmasherController) world.getBlockTileEntity(x, y, z);
	            return new GuiSmasherController(player.inventory, tileSmasherController);
	        }
	        return null;
	    }


}
