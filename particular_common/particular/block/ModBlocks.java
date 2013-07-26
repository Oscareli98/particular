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
	public static Block hypersonicPiston;
	public static Block blockCopper;
	public static Block blockTin;
	public static Block blockAluminum;
	
	//Ore Instances
	public static Block oreCopper;
	public static Block oreTin;
	public static Block oreAluminum;

	public static void init(){
		//Blocks
		TierOneMachineHousing = new BlockTierOneMachineHousing(BlockIds.TIER_ONE_MACHINE_HOUSING);
		tierTwoMachineHousing = new BlockTierTwoMachineHousing(BlockIds.TIER_TWO_MACHINE_HOUSING);
		tierThreeMachineHousing = new BlockTierThreeMachineHousing(BlockIds.TIER_THREE_MACHINE_HOUSING);
		hypersonicPiston = new BlockHypersonicPiston(BlockIds.HYPERSONIC_PISTION);
		blockCopper = new BlockCopper(BlockIds.BLOCK_COPPER);

		GameRegistry.registerBlock(TierOneMachineHousing, Strings.TIER_ONE_MACHINE_HOUSING_NAME);
		GameRegistry.registerBlock(tierTwoMachineHousing, Strings.TIER_TWO_MACHINE_HOUSING_NAME);
		GameRegistry.registerBlock(tierThreeMachineHousing, Strings.TIER_THREE_MACHINE_HOUSING_NAME);
		GameRegistry.registerBlock(hypersonicPiston, Strings.HYPERSONIC_PISTON_NAME);
		GameRegistry.registerBlock(blockCopper, Strings.BLOCK_COPPER_NAME);


		LanguageRegistry.addName(TierOneMachineHousing, "Machine Housing 1");
		LanguageRegistry.addName(tierTwoMachineHousing, "Machine Housing 2");
		LanguageRegistry.addName(tierThreeMachineHousing, "Machine Housing 3");
		LanguageRegistry.addName(hypersonicPiston, "Hypersonic Piston");
		LanguageRegistry.addName(blockCopper, "Copper Block");

		MinecraftForge.setBlockHarvestLevel(TierOneMachineHousing, "Pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(tierTwoMachineHousing, "Pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(tierThreeMachineHousing, "Pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(hypersonicPiston, "Pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(blockCopper, "Pickaxe", 2);

		//Ore
		oreCopper = new BlockOreCopper(BlockIds.ORE_COPPER);
		oreTin = new BlockOreTin(BlockIds.ORE_TIN);
		oreAluminum = new BlockOreAluminum(BlockIds.ORE_ALUMINUM);
		
		GameRegistry.registerBlock(oreCopper, Strings.ORE_COPPER_NAME);
		GameRegistry.registerBlock(oreTin, Strings.ORE_TIN_NAME);
		GameRegistry.registerBlock(oreAluminum, Strings.ORE_ALUMINUM_NAME);
		
		LanguageRegistry.addName(oreCopper, "Copper Ore");
		LanguageRegistry.addName(oreTin, "Tin Ore");
		LanguageRegistry.addName(oreAluminum, "Aluminum Ore");
		
		MinecraftForge.setBlockHarvestLevel(oreCopper, "Pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(oreTin, "Pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(oreAluminum, "Pickaxe", 2);
		

		initBlockRecipies();
	}

	public static void initBlockRecipies(){
		GameRegistry.addRecipe(new ItemStack(TierOneMachineHousing), new Object[] { "iii", "d d", "iii", Character.valueOf('d'), Block.dirt, Character.valueOf('i'), Item.ingotIron});
	}

}
