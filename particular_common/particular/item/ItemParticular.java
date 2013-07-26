package particular.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import particular.Particular;
import particular.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemParticular extends Item {

    public ItemParticular(int id) {

        super(id - Reference.SHIFTED_ID_RANGE_CORRECTION);
        this.setMaxStackSize(64);
        this.setCreativeTab(Particular.tabsParticular);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {

        itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
    
    
    
}