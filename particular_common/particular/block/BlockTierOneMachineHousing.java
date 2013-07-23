package particular.block;


import java.awt.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import particular.Particular;
import particular.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTierOneMachineHousing extends BlockParticular {

	public BlockTierOneMachineHousing(int id) {
		super(id, Material.iron);
		this.setUnlocalizedName(Strings.TIER_ONE_MACHINE_HOUSING_NAME);
        this.setCreativeTab(Particular.tabsParticular);
        this.setHardness(1.5F);
	}

}
