package particular.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import particular.lib.BlockIds;
import particular.lib.Strings;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {

	//Mod Block Instances
	public static Block TierOneMachineHousing;
	
	public static void init(){
		TierOneMachineHousing = new BlockTierOneMachineHousing(BlockIds.TIER_ONE_MACHINE_HOUSING);
		
		GameRegistry.registerBlock(TierOneMachineHousing, Strings.TIER_ONE_MACHINE_HOUSING_NAME);
		
		LanguageRegistry.addName(TierOneMachineHousing, "Machine Housing");
		
		MinecraftForge.setBlockHarvestLevel(TierOneMachineHousing, "Pickaxe", 2);
		
		initBlockRecipies();
	}
	
	public static void initBlockRecipies(){
		GameRegistry.addRecipe(new ItemStack(TierOneMachineHousing), new Object[] { "ddd", "d d", "ddd", Character.valueOf('d'), Block.dirt });
	}

}
