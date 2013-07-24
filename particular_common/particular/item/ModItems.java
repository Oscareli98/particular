package particular.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import particular.lib.ItemIds;
import particular.lib.Strings;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {
	
	//Mod Item Instances
	public static Item emptyStickWelder;
	public static Item stickWelder;
	public static Item scientificJournal;
	
	public static void init() {
		emptyStickWelder = new ItemEmptyStickWelder(ItemIds.EMPTY_STICK_WELDER);
		stickWelder = new ItemStickWelder(ItemIds.STICK_WELDER);
		scientificJournal = new ItemScientificJournal(ItemIds.SCIENTIFIC_JOURNAL);
		
		GameRegistry.registerItem(emptyStickWelder, Strings.EMPTY_STICK_WELDER_NAME);
		GameRegistry.registerItem(stickWelder, Strings.STICK_WELDER_NAME);
		GameRegistry.registerItem(scientificJournal, Strings.SCIENTIFIC_JOURNAL_NAME);
		
		LanguageRegistry.addName(emptyStickWelder, "Stick Welder (Empty)");
		LanguageRegistry.addName(stickWelder, "Stick Welder (Full)");
		LanguageRegistry.addName(scientificJournal, "Scientific Journal");
		
		initItemRecipies();
	}
	public static void initItemRecipies(){
		GameRegistry.addRecipe(new ItemStack(emptyStickWelder), new Object[] { "i  ", "   ", "   ", Character.valueOf('d'), Block.dirt, Character.valueOf('i'), Item.ingotIron});
	}
}
