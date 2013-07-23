package particular.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import particular.lib.BlockIds;
import particular.lib.Strings;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {

	//Mod Block Instances
	public static Block TierOneMachineHousing;
	public static Block tierTwoMachineHousing;
	public static Block tierThreeMachineHousing;
	
	public static void init(){
		TierOneMachineHousing = new BlockTierOneMachineHousing(BlockIds.TIER_ONE_MACHINE_HOUSING);
		tierTwoMachineHousing = new BlockTierTwoMachineHousing(BlockIds.TIER_TWO_MACHINE_HOUSING);
		tierThreeMachineHousing = new BlockTierThreeMachineHousing(BlockIds.TIER_THREE_MACHINE_HOUSING);
		
		GameRegistry.registerBlock(TierOneMachineHousing, Strings.TIER_ONE_MACHINE_HOUSING_NAME);
		GameRegistry.registerBlock(tierTwoMachineHousing, Strings.TIER_TWO_MACHINE_HOUSING_NAME);
		GameRegistry.registerBlock(tierThreeMachineHousing, Strings.TIER_THREE_MACHINE_HOUSING_NAME);
		
		LanguageRegistry.addName(TierOneMachineHousing, "Machine Housing 1");
		LanguageRegistry.addName(tierTwoMachineHousing, "Machine Housing 2");
		LanguageRegistry.addName(tierThreeMachineHousing, "Machine Housing 3");
		
		MinecraftForge.setBlockHarvestLevel(TierOneMachineHousing, "Pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(tierTwoMachineHousing, "Pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(tierThreeMachineHousing, "Pickaxe", 3);
		
		initBlockRecipies();
	}
	
	public static void initBlockRecipies(){
		GameRegistry.addRecipe(new ItemStack(TierOneMachineHousing), new Object[] { "iii", "d d", "iii", Character.valueOf('d'), Block.dirt, Character.valueOf('i'), Item.ingotIron});
	}

}
